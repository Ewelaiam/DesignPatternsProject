package pl.agh.edu.dp.factory;

import pl.agh.edu.dp.labirynth.MazeGame;
import pl.agh.edu.dp.labirynth.Wall;

//  --- 4.2.4 ---

public class BombedMazeWall extends Wall {

    @Override
    public void Enter(){
        MazeGame.getInstance().setInfo("Bombed wall!");

    }
}
