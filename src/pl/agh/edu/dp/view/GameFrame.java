package pl.agh.edu.dp.view;

import pl.agh.edu.dp.labirynth.MazeGame;
import pl.agh.edu.dp.player.Player;
import pl.agh.edu.dp.labirynth.Maze;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//  --- 4.5 ---
public class GameFrame extends JFrame implements ActionListener,KeyListener {

    JPanel panel;
    public GameFrame(Maze maze, Player player) {
         super("Labirynth");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setSize(700,700);

         panel = new GamePanel(maze, player,this);
         add(panel);

         addKeyListener(this);
         setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.panel.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT) {
            MazeGame.getInstance().turnLeft();
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            MazeGame.getInstance().turnRight();
        } else if (keyCode == KeyEvent.VK_UP) {
            MazeGame.getInstance().move();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}