package pl.agh.edu.dp.factory;

import pl.agh.edu.dp.labirynth.MazeGame;
import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;

//  --- 4.2.3 ---

public class EnchantedMazeDoor extends Door {

    public EnchantedMazeDoor(Room r1, Room r2) {
        super(r1, r2);
    }

    @Override
    public void Enter(){
        MazeGame.getInstance().setInfo("Magic door");
        MazeGame.getInstance().switchRoom(getRoom1(),getRoom2());
    }

}
