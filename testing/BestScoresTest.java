package model;

import java.io.File;
import static org.junit.Assert.*;

import org.junit.Test;

public class BestScoresTest {

    @Test
    public void testUpdateScoresExpectTrue()
    {
    	File file = new File("./test.txt");
    	file.delete();
    	BestScores bestScores = new BestScores(1, 5, 7, "name", "test.txt");
    	boolean result = bestScores.checkHighScore(); // 7 > 0
    	assertEquals("checkHighScore()", true, result);
    }
    
    @Test
    public void testUpdateScoresExpectTrue2()
    {
    	File file = new File("./test.txt");
    	file.delete();
    	BestScores bestScores = new BestScores(1, 5, 8, "name", "test.txt");
    	bestScores.checkHighScore();
    	BestScores bestScores2 = new BestScores(1, 5, 7, "name", "test.txt");
    	boolean result = bestScores2.checkHighScore(); // 8 > 7
    	assertEquals("checkHighScore()", true, result);
    } 
    
    @Test
    public void testUpdateScoresExpectFalse()
    {
    	File file = new File("./test.txt");
    	file.delete();
    	BestScores bestScores = new BestScores(1, 5, 7, "name", "test.txt");
    	bestScores.checkHighScore();
    	BestScores bestScores2 = new BestScores(1, 5, 8, "name", "test.txt");
    	boolean result = bestScores2.checkHighScore(); // 7 !< 8
    	assertEquals("checkHighScore()", false, result);
    }
    
    @Test
    public void testUpdateScoresExpectFalse2()
    {
    	File file = new File("./test.txt");
    	file.delete();
    	BestScores bestScores = new BestScores(1, 5, 7, "name", "test.txt");
    	bestScores.checkHighScore();
    	BestScores bestScores2 = new BestScores(1, 5, 7, "name", "test.txt");
    	boolean result = bestScores2.checkHighScore(); // 7 !< 7
    	assertEquals("checkHighScore()", false, result);
    }
}