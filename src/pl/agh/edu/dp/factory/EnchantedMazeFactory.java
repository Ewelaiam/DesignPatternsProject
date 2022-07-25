package pl.agh.edu.dp.factory;

import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.Wall;

//  --- 4.2.3 ---
public final class EnchantedMazeFactory extends MazeFactory {
//          --- 4.3 ---
//    public EnchantedMazeFactory(){
//        super();
//    }
    private static EnchantedMazeFactory instance;

    public static EnchantedMazeFactory getInstance(){
        if (instance == null){
            instance = new EnchantedMazeFactory();
        }
        return instance;
    }

    @Override
    public Room createRoom(int number) {
        return new EnchantedMazeRoom(number);
    }

    @Override
    public Wall createWall() {
        return new EnchantedMazeWall();
    }

    @Override
    public Door createDoor(Room r1,Room r2) {
        return new EnchantedMazeDoor(r1,r2);
    }

}
