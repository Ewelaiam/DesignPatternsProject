package pl.agh.edu.dp.labirynth;

public enum Direction {
    North, South, East, West;

    //    ----  4.1.4   ---
    public static Direction opposite(Direction direction){
        switch (direction){
            case East:
                return West;
            case West:
                return East;
            case North:
                return South;
            case South:
                return North;
        }
        return null;
    }

    public static Direction next(Direction direction){
        switch (direction){
            case East:
                return South;
            case West:
                return North;
            case North:
                return East;
            case South:
                return West;
        }
        return null;
    }

    public static Direction previous(Direction d){
        return  Direction.opposite(Direction.next(d));
    }
}