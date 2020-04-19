package testing;

import model.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class LevelTest
{
    @Test
    public void testResetExpectTrue()
    {
        Level level = new Level(1);
        Post post = new Post();
		post.add(new Ring(3));
		post.add(new Ring(2));
		post.add(new Ring(1)); // after reset, left post should have 3 rings
		Post emptyPost = new Post(); // after reset, middle and right posts should be empty
		level.reset();
		boolean result = level.getPost(0).toString().equals(post.toString()) && level.getPost(1).toString().equals(emptyPost.toString()) && level.getPost(2).toString().equals(emptyPost.toString());
		assertEquals("reset()", true, result);    
    }
    
    @Test
    public void testResetExpectTrue2()
    {
    	Level level = new Level(1);
    	level.move(0, 1); // moves = 1
    	level.reset(); // after reset, moves = 0
    	boolean result = level.getMoveCounter() == 0;
    	assertEquals("reset()", true, result);
    }
    
    @Test
    public void testMoveExpectTrue()
    {
        Level level = new Level(1);
        boolean result = level.move(0, 1); // move ring to empty post
        assertEquals("move() ring to empty post", true, result);
    }
    
    @Test
    public void testMoveExpectTrue2()
    {
        Level level = new Level(1);
        level.move(0, 1); // move ring to empty post
        level.move(0, 2); // move ring to empty post
        boolean result = level.move(1, 2); // move smaller ring on top of larger ring
        assertEquals("move() smaller ring on top of larger ring", true, result);
    }
    
    @Test
    public void testMoveExpectFalse()
    {
        Level level = new Level(1);
        level.move(0, 1); // move ring to empty post
        boolean result = level.move(0, 1); // attempt to move larger ring on top of smaller ring
        assertEquals("move() larger ring on top of smaller ring", false, result);
    }
    
    @Test
    public void testMoveExpectFalse2()
    {
        Level level = new Level(1);
        boolean result = level.move(1, 0); // attempt to move ring from an empty post
        assertEquals("move() ring from an empty post", false, result);
    }
    
    @Test
    public void testMoveExpectFalse3()
    {
        Level level = new Level(1);
        boolean result = level.move(0, 0); // attempt to move ring to its starting post
        assertEquals("move() ring to its starting post", false, result);
    }
    
    @Test
    public void testGetLevelExpectTrue()
    {
    	Level level = new Level(1); // level = 1
    	boolean result = (level.getLevel() == 1); 
    	assertEquals("getLevel()", true, result);
    }
    
    @Test
    public void testGetPostExpectTrue()
    {
    	Level level = new Level(1);
    	Post post = new Post();
    	post.add(new Ring(3));
    	post.add(new Ring(2));
    	post.add(new Ring(1)); // post has 3 rings of sizes 3, 2, 1 (bottom -> top)
    	System.out.println(post);
    	boolean result = level.getPost(0).toString().equals(post.toString()); // left post has 3 rings of sizes 3, 2, 1 (bottom -> top) at the start of the game
    	assertEquals("getPost()", true, result);
    }
    
    @Test
    public void testGetPostExpectTrue2()
    {
    	Level level = new Level(1);
    	Post post = new Post(); // post has no rings (is empty)
    	boolean result = level.getPost(1).toString().equals(post.toString()); // middle post has no rings (is empty) at the start of the game
    	assertEquals("getPost()", true, result);
    }
    
    @Test
    public void testGetMaxRingsExpectTrue()
    {
    	Level level = new Level(1); // level = 1
    	boolean result = (level.getMaxRings() == 3); // maxRings = 1 + level = 1 + 2 = 3
    	assertEquals("getMaxRings()", true, result);
    }
    
    
    @Test
    public void testGetMoveCounterExpectTrue()
    {
    	Level level = new Level(1);
    	boolean result = level.getMoveCounter() == 0; // no rings moved
    	assertEquals("getMoveCounter() after no moves attempted (no rings moved)", true, result);
    }
    
    @Test
    public void testGetMoveCounterExpectTrue2()
    {
    	Level level = new Level(1);
    	level.move(1, 0); // invalid move should not increase move counter
    	boolean result = level.getMoveCounter() == 0; // no rings moved
    	assertEquals("getMoveCounter() after an invalid move (no rings moved)", true, result);
    }
    
    @Test
    public void testGetMoveCounterExpectTrue3()
    {
    	Level level = new Level(1);
    	level.move(0, 1); // valid move should increase move counter by 1
    	boolean result = level.getMoveCounter() == 1; // 1 ring moved
    	assertEquals("getMoveCounter() after a valid move (1 ring moved)", true, result);
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
    	assertEquals("isEnd() after game completed", true, result);
    }
    
    @Test
    public void testIsEndExpectFalse()
    {
    	Level level = new Level(1);
    	boolean result = level.isEnd(); // no rings moved so level not completed
    	assertEquals("isEnd() after no rings moved", false, result);
    }
    
    @Test
    public void testGetMinMovesExpectTrue()
    {
    	Level level = new Level(1); // level = 1, maxRings = 3
    	boolean result = level.getMinMoves() == 7; // minMoves = 2^maxRings - 1 = 2^3 - 1 = 8 - 1 = 7
    	assertEquals("getMinMoves()", true, result);
    }
}
