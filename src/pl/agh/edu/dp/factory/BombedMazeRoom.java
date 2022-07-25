package pl.agh.edu.dp.factory;

import pl.agh.edu.dp.labirynth.Room;

//  --- 4.2.4 ---

public class BombedMazeRoom extends Room {

    public BombedMazeRoom(int number) {
        super(number);
    }

    @Override
    public void Enter(){
        System.out.println("Bombed room!");
    }
}
