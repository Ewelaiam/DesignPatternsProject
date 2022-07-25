package pl.agh.edu.dp.main;

import pl.agh.edu.dp.factory.MazeFactory;
import pl.agh.edu.dp.labirynth.MazeGame;
import pl.agh.edu.dp.factory.EnchantedMazeFactory;
import pl.agh.edu.dp.builder.StandardBuilderMaze;
import pl.agh.edu.dp.labirynth.Maze;

public class Main {

    public static void main(String[] args) throws Exception {

        MazeGame mazeGame = MazeGame.getInstance();
        MazeFactory factory = EnchantedMazeFactory.getInstance();
        StandardBuilderMaze standardBuilderMaze = new StandardBuilderMaze(factory);
        mazeGame.createMaze(standardBuilderMaze,factory);
        Maze maze = standardBuilderMaze.getCurrentMaze();

        mazeGame.startGame(maze);

    }
}

//        ORYGINAŁ:
//        MazeGame mazeGame = new MazeGame();
//        Maze maze = mazeGame.createMaze();
//
//        System.out.println(maze.getRoomNumbers());

//        ---   4.1.5   ---
//        MazeGame mazeGame = new MazeGame();
//        StandardBuilderMaze builder = new StandardBuilderMaze();
//        Maze maze = mazeGame.createMaze(builder);
//        System.out.println(maze.getRoomNumbers());

//        ---   4.2     ---
//        MazeGame mazeGame = new MazeGame();
//        MazeFactory mazeFactory = MazeFactory.getInstance();
//        StandardBuilderMaze builder = new StandardBuilderMaze(mazeFactory);
//        Maze maze = mazeGame.createMaze(builder, mazeFactory);
//        System.out.println(maze.getRoomNumbers());



