package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.builder.StandardBuilderMaze;
import pl.agh.edu.dp.factory.MazeFactory;
import pl.agh.edu.dp.player.Player;
import pl.agh.edu.dp.view.GameFrame;

import java.util.ArrayList;
import java.util.List;

public class MazeGame {
    private static MazeGame instance;
    private Player player;
    private String info = "";
    private String points = "";

    public static MazeGame getInstance(){
        if(instance == null){
            instance = new MazeGame();
        }
        return instance;
    }

    public String getInfo() {
        return info;
    }
    public void setInfo(String s){
        info = s;
    }

    public String getPoints() {
        return points;
    }
    public void updatePoints(){
        points = "Points: " + player.getLife();
    }

    public void createMaze(StandardBuilderMaze mazeBuilder, MazeFactory factory) throws Exception {

        List<Room> rooms = new ArrayList<>(100);

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 10; j++){
                Room room = factory.createRoom(10 * i + j);
                mazeBuilder.addRoom(room);
                rooms.add(room);
            }
        }

        for(int i = 0;i < 8; i++){
            for(int j = 0;j < 10; j++){
                mazeBuilder.addWall(Direction.South,rooms.get(10 * i + j),rooms.get(10 * (i + 1) + j));
            }
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                mazeBuilder.addWall(Direction.East,rooms.get(10 * i + j),rooms.get(10 * i + j + 1));
            }
        }

        mazeBuilder.createStartRoom(rooms.get(4));
        mazeBuilder.createEndRoom(rooms.get(89));

        mazeBuilder.addDoor(rooms.get(0),rooms.get(1));
        mazeBuilder.addDoor(rooms.get(1),rooms.get(2));

        for (int i = 0; i < 9; i++){
            if (i != 3){
                mazeBuilder.addDoor(rooms.get(i),rooms.get(i + 1));
            }
            if( i != 2 && i != 7){
                mazeBuilder.addDoor(rooms.get(i),rooms.get(10 + i));
            }
        }

        for (int i = 0; i < 9; i++){
            if (i != 2 && i != 5 && i != 6 && i != 8){
                mazeBuilder.addDoor(rooms.get(10 + i),rooms.get(10 + i + 1));
            }
            if( i != 0 && i != 1 && i != 3 && i != 5 && i != 8 ){
                mazeBuilder.addDoor(rooms.get(10 + i),rooms.get(20 + i));
            }
        }

        mazeBuilder.addDoor(rooms.get(19),rooms.get(29));

        for (int i = 0; i < 9; i++){
            if (i != 3 && i != 4 && i != 6){
                mazeBuilder.addDoor(rooms.get(20 + i),rooms.get(20 + i + 1));
            }
            if( i != 1 && i != 2 && i != 5 && i != 6 && i != 7 && i != 8 ){
                mazeBuilder.addDoor(rooms.get(20 + i),rooms.get(30 + i));
            }
        }

        for (int i = 0; i < 9; i++){
            if (i != 1 && i != 3 && i != 4 && i != 7 && i != 8){
                mazeBuilder.addDoor(rooms.get(30 + i),rooms.get(30 + i + 1));
            }
            if( i != 4 ){
                mazeBuilder.addDoor(rooms.get(30 + i),rooms.get(40 + i));
            }
        }

        for (int i = 0; i < 9; i++){
            if (i == 1 || i == 7){
                mazeBuilder.addDoor(rooms.get(40 + i),rooms.get(40 + i + 1));
            }
            if( i != 3 && i != 5 ){
                mazeBuilder.addDoor(rooms.get(40 + i),rooms.get(50 + i));
            }
        }

        for (int i = 0; i < 9; i++){
            if (i != 0 && i != 1 && i != 4 && i != 6 && i != 7){
                mazeBuilder.addDoor(rooms.get(50 + i),rooms.get(50 + i + 1));
            }
            if( i != 0 && i != 3 && i != 4 && i != 6 ){
                mazeBuilder.addDoor(rooms.get(50 + i),rooms.get(60 + i));
            }
        }
        mazeBuilder.addDoor(rooms.get(59),rooms.get(69));

        for (int i = 0; i < 9; i++){
            if (i != 1 && i != 2 && i != 5 && i != 7 && i != 8){
                mazeBuilder.addDoor(rooms.get(60 + i),rooms.get(60 + i + 1));
            }
            if( i != 1 && i != 4 && i != 5 && i != 7 ){
                mazeBuilder.addDoor(rooms.get(60 + i),rooms.get(70 + i));
            }
        }

        for (int i = 0; i < 9; i++){
            if (i != 0 && i != 2 && i != 3 && i != 6 && i != 7 && i != 8){
                mazeBuilder.addDoor(rooms.get(70 + i),rooms.get(70 + i + 1));
            }
            if( i != 1 && i != 3 && i != 5 && i != 6 ){
                mazeBuilder.addDoor(rooms.get(70 + i),rooms.get(80 + i));
            }
        }

        for (int i = 0; i < 9; i++){
            if (i != 1 && i != 6 ){
                mazeBuilder.addDoor(rooms.get(80 + i),rooms.get(80 + i + 1));
            }
        }
    }

    public void startGame(Maze maze){

        player = new Player(Direction.South, maze.getFirstRooom(),10);
        GameFrame frame = new GameFrame(maze, player);
        while(true){

            frame.actionPerformed(null);

            if(player.getRoom() == maze.getFirstRooom()){
                info =  "Go!";
                updatePoints();
            } else if(player.getRoom() == maze.getLastRoom()){
                info =  "Won!";
                updatePoints();
            } else if(player.getLife() <= 0){
                info =  "Game over!";
                updatePoints();
                break;
            }
        }
    }

    public void turnLeft(){
        player.turnLeft();
    }
    public void turnRight(){
        player.turnRight();
    }
    public void move(){
        player.move();
    }
    public void switchRoom(Room r1, Room r2){
        Room newRoom = player.getRoom() == r1 ? r2 : r1;
        player.setRoom(newRoom);
    }
    public void updateLife(int points){
        player.setLife(player.getLife() + points);
    }


    //    ---   FUNKCJA ORYGINALNA   ---
//    public Maze createMaze(){
//        Maze maze = new Maze();
//
//        Room r1 = new Room(1);
//        Room r2 = new Room(2);
//
//        Door door = new Door(r1, r2);
//
//        maze.addRoom(r1);
//        maze.addRoom(r2);
//
//        r1.setSide(Direction.North, new Wall());
//        r1.setSide(Direction.East, new Wall());
//        r1.setSide(Direction.South, new Wall());
//        r1.setSide(Direction.West, new Wall());
//
//        r2.setSide(Direction.North, new Wall());
//        r2.setSide(Direction.East, new Wall());
//        r2.setSide(Direction.South, new Wall());
//        r2.setSide(Direction.West, new Wall());
//
//        return maze;
//    }

//    ---   4.1.2  ---
//    ---   4.2.2 --- (dodanie parametru MazeFactory factory do funkcji createMaze)
//    public Maze createMaze(StandardBuilderMaze builder, MazeFactory factory) throws Exception {
//        Room r1 = new Room(1);
//        Room r2 = new Room(2);
//        builder.addRoom(r1);
//        builder.addRoom(r2);
//        builder.addWall(North, r1, r2);
//        builder.addDoor(r1, r2);
//        return builder.getCurrentMaze();
//    }
}
