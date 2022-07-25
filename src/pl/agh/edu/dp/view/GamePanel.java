package pl.agh.edu.dp.view;

import pl.agh.edu.dp.labirynth.MazeGame;
import pl.agh.edu.dp.player.Player;
import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.Wall;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

//  --- 4.5 ---
public class GamePanel extends JPanel {

    Maze maze;
    Player player;
    int maze_width, maze_height;
    int maze_span = 45;
    int wall_thickness = 2;
    GameFrame gameFrame;
    List<Integer> roomsNum;

    public GamePanel(Maze maze, Player player, GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        this.player = player;
        this.maze = maze;
        this.maze_height = gameFrame.getHeight();
        this.maze_width = gameFrame.getWidth();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setSize(gameFrame.getWidth(),gameFrame.getHeight());
        this.setBackground(Color.CYAN);

        roomsNum = new ArrayList<>(maze.getRooms().size());
        drawMaze(g,350, 100, maze.getFirstRooom());

        g.setColor(Color.DARK_GRAY);
        g.drawString(MazeGame.getInstance().getInfo(),20,300);
        g.drawString(MazeGame.getInstance().getPoints(),20,330);

    }

    public void drawMaze(Graphics g, int x, int y, Room room1){
        if(roomsNum.contains(room1.getRoomNumber())) return;
        drawRoom(x, y, g, room1);
        roomsNum.add(room1.getRoomNumber());
        for(Direction direction: Direction.values()){
            for (Room r2 : maze.getRooms()) {
                if (room1.getSide(direction) == r2.getSide(Direction.opposite(direction))) {
                    int new_x = direction.equals(Direction.West) ? x - maze_span : (direction.equals(Direction.East) ? x + maze_span : x);
                    int new_y = direction.equals(Direction.North) ? y - maze_span : (direction.equals(Direction.South) ? y + maze_span : y);
                    drawMaze(g, new_x, new_y, r2);
                }
            }
        }
    }
    public void drawPlayer(Graphics point, int weight, int height){
        point.setColor(Color.YELLOW);

        int[] posX;
        int[] posY;

        int w1 = weight + maze_span / 2;
        int w2 = weight + 2 * wall_thickness;
        int w3 = weight + maze_span - 2 * wall_thickness;

        int h1 = height + maze_span / 2;
        int h2 = height + 2 * wall_thickness;
        int h3 = height + maze_span - 2 * wall_thickness;

        Direction direction = player.getDirection();

        if(direction.equals(Direction.West)){
            posX = new int[]{w2, w3, w3, w3};
            posY = new int[]{h1, h2, h1, h3};
        } else if (direction.equals(Direction.North)){
            posX = new int[]{w1, w2, w1, w3};
            posY = new int[]{h2, h3, h3, h3};
        } else if(direction.equals(Direction.East)){
            posX = new int[]{w3, w2, w2, w2};
            posY = new int[]{h1, h2, h1, h3};
        } else if(direction.equals(Direction.South)){
            posX = new int[]{w1, w2, w1, w3};
            posY = new int[]{h3, h2, h2, h2};
        } else {
            posX = new int[4];
            posY = new int[4];
        }

        point.fillPolygon(posX, posY,4);
    }

    public void drawField(Graphics field, Room room){
        if(maze.getFirstRooom() == room)
            field.setColor(Color.RED);
        else if(maze.getLastRoom() == room)
            field.setColor(Color.GRAY);
        else field.setColor(Color.GREEN);
    }

    public void drawWall(Direction d, Graphics field, Room room){
        if(room.getSide(d) instanceof Wall){
            field.setColor(Color.white);
        } else if(room.getSide(d) instanceof Door){
            field.setColor(Color.green);
        }
    }
    public void drawRoom(int weight, int height, Graphics field, Room room){

        drawField(field, room);
        field.fillRect(weight, height, maze_span, maze_span);

        for(Direction d: Direction.values()){
            drawWall(d, field, room);

            int w = d.equals(Direction.East) ? weight + maze_span - wall_thickness : weight;
            int h = d.equals(Direction.North) ? height : (d.equals(Direction.South) ? height + maze_span - wall_thickness : height+ wall_thickness);
            int b, y;
            if (d.equals(Direction.West) || d.equals(Direction.East)){
                b = wall_thickness;
                y = maze_span - wall_thickness;
            } else{
                b = maze_span;
                y = wall_thickness;
            }

            field.fillRect(w, h, b, y);

            if(player.getRoom() == room){
                drawPlayer(field, weight, height);
            }
        }

    }
}
