package pl.agh.edu.dp.player;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Room;

public class Player {
    private Room room;
    private Direction direction;
    private int life;

    public Player(Direction direction, Room room, int life){
        this.direction = direction;
        this.room = room;
        this.life = life;
    }

    public int getLife() {
        return life;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void move(){
        room.getSide(direction).Enter();
    }
    public void turnLeft(){
        direction = Direction.previous(direction);
    }
    public void turnRight(){
        direction = Direction.next(direction);
    }


}
