package pl.agh.edu.dp.builder;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Room;

//  --- 4.1.6 ---
public class CountingMazeBuilder implements MazeBuilder {

    private int allElements = 0;

    public int getCounts(){
        return this.allElements;
    }

    @Override
    public void reset() {
        this.allElements = 0;
    }

    @Override
    public void addRoom(Room room) {
        this.allElements += 5;
    }

    @Override
    public void addDoor(Room r1, Room r2) throws Exception {
        this.allElements += 1;
    }

    @Override
    public void addWall(Direction roomDirection, Room r1, Room r2) throws Exception {
        this.allElements -= 1;
    }
}
