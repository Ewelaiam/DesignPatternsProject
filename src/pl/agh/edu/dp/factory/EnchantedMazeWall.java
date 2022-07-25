package pl.agh.edu.dp.factory;

import pl.agh.edu.dp.labirynth.MazeGame;
import pl.agh.edu.dp.labirynth.Wall;

//  --- 4.2.3 ---
public class EnchantedMazeWall extends Wall {

    private boolean touchedWall = false;

    @Override
    public void Enter(){
        touchedWall = true;
        MazeGame.getInstance().setInfo("Magic wall");

        if(touchedWall){
            MazeGame.getInstance().setInfo("Hit magic wall");
            MazeGame.getInstance().updateLife(-2);
            MazeGame.getInstance().updatePoints();
        }
    }
}
