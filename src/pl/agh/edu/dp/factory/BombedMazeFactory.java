package pl.agh.edu.dp.factory;

import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.Wall;

//  --- 4.2.4 ---
public final class BombedMazeFactory extends MazeFactory {
//          --- 4.3 ---
//    public BombedMazeFactory(){
//        super();
//    }
    private static BombedMazeFactory instance;

    public static BombedMazeFactory getInstance(){
        if (instance == null){
            instance = new BombedMazeFactory();
        }
        return  instance;
    }

    @Override
    public Room createRoom(int number) {
        return new BombedMazeRoom(number);
    }

    @Override
    public Wall createWall() {
        return new BombedMazeWall();
    }

}
