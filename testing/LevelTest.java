package model;

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
    
    @Test
    public void testGetLevelExpectTrue()
    {
    	Level level = new Level(1);
    	boolean result = (level.getLevel() == 1);
    	assertEquals("getLevel()", true, result);
    }
    
    @Test
    public void testGetMaxRingsExpectTrue()
    {
    	Level level = new Level(1);
    	boolean result = (level.getMaxRings() == 3);
    	assertEquals("getMaxRings()", true, result);
    }
    
    @Test
    public void testGetMinMovesExpectTrue()
    {
    	Level level = new Level(1);
    	boolean result = level.getMinMoves() == 7;
    	assertEquals("getMinMoves()", true, result);
    }
    
    @Test
    public void testGetMoveCounterExpectTrue()
    {
    	Level level = new Level(1);
    	boolean result = level.getMoveCounter() == 0;
    	assertEquals("getMoveCounter()", true, result);
    }
    
    @Test
    public void testGetMoveCounterExpectTrue2()
    {
    	Level level = new Level(1);
    	level.move(1, 0); // invalid move should not increase move counter
    	boolean result = level.getMoveCounter() == 0;
    	assertEquals("getMoveCounter()", true, result);
    }
    
    @Test
    public void testGetMoveCounterExpectTrue3()
    {
    	Level level = new Level(1);
    	level.move(0, 1); // valid move should increase move counter
    	boolean result = level.getMoveCounter() == 1;
    	assertEquals("getMoveCounter()", true, result);
    }
    
    @Test
    public void testGetPostExpectTrue()
    {
    	Level level = new Level(1);
    	Post post = new Post();
    	post.add(new Ring(3));
    	post.add(new Ring(2));
    	post.add(new Ring(1));
    	System.out.println(post);
    	boolean result = level.getPost(0).toString().equals(post.toString());
    	assertEquals("getPost()", true, result);
    }
    
    @Test
    public void testGetPostExpectTrue2()
    {
    	Level level = new Level(1);
    	Post post = new Post();
    	boolean result = level.getPost(1).toString().equals(post.toString());
    	assertEquals("getPost()", true, result);
    }
}
