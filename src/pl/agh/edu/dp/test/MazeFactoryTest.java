package pl.agh.edu.dp.test;
import org.junit.jupiter.api.Test;
import pl.agh.edu.dp.factory.MazeFactory;

import static org.junit.Assert.assertEquals;

public class MazeFactoryTest {

    @Test
    void getInstance() {
        MazeFactory factory = MazeFactory.getInstance();

        assertEquals(factory, MazeFactory.getInstance());
        assertEquals(factory, MazeFactory.getInstance());

        MazeFactory factoryNew = MazeFactory.getInstance();

        assertEquals(factoryNew, MazeFactory.getInstance());
        assertEquals(factoryNew, MazeFactory.getInstance());

        assertEquals(factory, factoryNew);
    }

}
