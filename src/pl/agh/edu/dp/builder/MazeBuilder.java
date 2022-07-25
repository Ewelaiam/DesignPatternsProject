package pl.agh.edu.dp.builder;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Room;

//  --- 4.1.1 ---
public interface MazeBuilder {

    void reset();
    void addRoom(Room room);
    void addDoor(Room room1, Room room2) throws Exception;
    void addWall(Direction roomDirection, Room room1, Room room2) throws Exception;
}
