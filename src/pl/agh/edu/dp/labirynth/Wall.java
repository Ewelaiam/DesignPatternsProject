package pl.agh.edu.dp.labirynth;

public class Wall extends MapSite {

    public Wall(){

    }
    @Override
    public void Enter(){
        MazeGame.getInstance().setInfo("Wall");
    }
}
