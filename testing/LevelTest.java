package testing;

import model.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class LevelTest {

    @Test
    public void testMoveExpectTrue()
    {
        Level level = new Level(1);
        boolean result = level.move(0, 1); // move ring to empty post
        assertEquals("move()", true, result);
    }
    
    @Test
    public void testMoveExpectTrue2()
    {
        Level level = new Level(1);
        level.move(0, 1); // move ring to empty post
        level.move(0, 2); // move ring to empty post
        boolean result = level.move(1, 2); // move smaller ring on top of larger ring
        assertEquals("move()", true, result);
    }
    
    @Test
    public void testMoveExpectFalse()
    {
        Level level = new Level(1);
        level.move(0, 1); // move ring to empty post
        boolean result = level.move(0, 1); // attempt to move larger ring on top of smaller ring
        assertEquals("move()", false, result);
    }
    
    @Test
    public void testMoveExpectFalse2()
    {
        Level level = new Level(1);
        boolean result = level.move(1, 0); // attempt to move ring from an empty post
        assertEquals("move()", false, result);
    }
    
    @Test
    public void testMoveExpectFalse3()
    {
        Level level = new Level(1);
        boolean result = level.move(0, 0); // attempt to move ring to its starting post
        assertEquals("move()", false, result);
    }
    
    @Test
    public void testIsEndExpectTrue()
    {
    	Level level = new Level(1);
    	level.move(0, 2);
    	level.move(0, 1);
    	level.move(2, 1);
    	level.move(0, 2);
    	level.move(1, 0);
    	level.move(1, 2);
    	level.move(0, 2); // level completed in 7 moves
    	boolean result = level.isEnd();
    	assertEquals("isEnd()", true, result);
    }
    
    @Test
    public void testIsEndExpectFalse()
    {
    	Level level = new Level(1);
    	boolean result = level.isEnd();
    	assertEquals("isEnd()", false, result);
    }
}
