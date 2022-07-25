package pl.agh.edu.dp.factory;

import pl.agh.edu.dp.labirynth.Room;

//  --- 4.2.3 ---
public class EnchantedMazeRoom extends Room {

    public EnchantedMazeRoom(int number) {
        super(number);
    }

    @Override
    public void Enter(){
        System.out.println("Magic room");
    }
}
