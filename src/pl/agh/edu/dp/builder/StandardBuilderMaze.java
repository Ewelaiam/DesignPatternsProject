package pl.agh.edu.dp.builder;

import pl.agh.edu.dp.factory.MazeFactory;
import pl.agh.edu.dp.labirynth.*;

//  --- 4.1.4   ---
public class StandardBuilderMaze implements MazeBuilder {

    private Maze currentMaze;
    private MazeFactory factory;
    public StandardBuilderMaze(MazeFactory factory){
        this.currentMaze = new Maze();
        this.factory = factory;
    }

    public Maze getCurrentMaze(){
        return this.currentMaze;
    }

    private Direction commonWall(Room room1,Room room2){
        for (Direction direction : Direction.values()){
            if(room1.getSide(direction).equals(room2.getSide(Direction.opposite(direction)))){
                if(room1.getSide(direction) != null){
                    return direction;
                }
            }
        }
        return null;
    }

//    --- 4.5 ---
    public void createStartRoom(Room room) {
        currentMaze.setFirstRooom(room);
    }

    public void createEndRoom(Room room) {
        currentMaze.setLastRoom(room);
    }

    @Override
    public void reset(){
        this.currentMaze = new Maze();
    }

    @Override
    public void addRoom(Room room) {
        room.setSide(Direction.North, factory.createWall());
        room.setSide(Direction.East, factory.createWall());
        room.setSide(Direction.South, factory.createWall());
        room.setSide(Direction.West, factory.createWall());
        this.currentMaze.addRoom(room);
    }

    @Override
    public void addDoor(Room room1, Room room2) throws Exception {
        Direction direction = commonWall(room1,room2);
        if(direction == null){
            throw new Exception("No common wall!");
        }
//        Door door = new Door(room1,room2);
        Door door = factory.createDoor(room1, room2);
        room1.setSide(direction, door);
        room2.setSide(Direction.opposite(direction), door);
    }

    @Override
    public void addWall(Direction direction1, Room room1, Room room2) {
        if(room1.getSide(direction1) == null){
            room1.setSide(direction1,factory.createWall());
        }
        room2.setSide(Direction.opposite(direction1),room1.getSide(direction1));
    }

}
