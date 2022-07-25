package pl.agh.edu.dp.labirynth;

import java.util.Vector;

public class Maze {
    private Vector<Room> rooms;

    public Vector<Room> getRooms() {
        return rooms;
    }

    public Room getFirstRooom() {
        return firstRoom;
    }

    public void setFirstRooom(Room startRooom) {
        this.firstRoom = startRooom;
    }

    public Room getLastRoom() {
        return lastRoom;
    }

    public void setLastRoom(Room lastRoom) {
        this.lastRoom = lastRoom;
    }

    private Room firstRoom;
    private Room lastRoom;

    public Maze() {
        this.rooms = new Vector<Room>();
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void setRooms(Vector<Room> rooms) {
        this.rooms = rooms;
    }

    public int getRoomNumbers()
    {
        return rooms.size();
    }
}
