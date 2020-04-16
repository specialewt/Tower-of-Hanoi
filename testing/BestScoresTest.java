package testing;

import model.*;
import java.io.File;
import static org.junit.Assert.*;
import org.junit.Test;

public class BestScoresTest {

    @Test
    public void testUpdateScoresExpectTrue()
    {
    	File file = new File("./test.txt");
    	file.delete();
    	BestScores bestScores = new BestScores(1, 5, 7, "name", "test.txt"); // no previous games so score should be new best score
    	boolean result = bestScores.checkBestScore(); // 7 > 0 (and bestscore == 0)
    	assertEquals("checkBestScore()", true, result);
    }
    
    @Test
    public void testUpdateScoresExpectTrue2()
    {
    	File file = new File("./test.txt");
    	file.delete();
    	BestScores bestScores = new BestScores(1, 5, 8, "name", "test.txt"); // previous best score is 8
    	bestScores.checkBestScore();
    	BestScores bestScores2 = new BestScores(1, 5, 7, "name", "test.txt"); // new score is 7, which is greater than previous best score
    	boolean result = bestScores2.checkBestScore(); // 8 > 7
    	assertEquals("checkBestScore()", true, result);
    } 
    
    @Test
    public void testUpdateScoresExpectFalse()
    {
    	File file = new File("./test.txt");
    	file.delete();
    	BestScores bestScores = new BestScores(1, 5, 7, "name", "test.txt"); // previous best score is 7
    	bestScores.checkBestScore();
    	BestScores bestScores2 = new BestScores(1, 5, 8, "name", "test.txt"); // new score is 8, which is not greater than previous best score
    	boolean result = bestScores2.checkBestScore(); // 7 !< 8
    	assertEquals("checkBestScore()", false, result);
    }
    
    @Test
    public void testUpdateScoresExpectFalse2()
    {
    	File file = new File("./test.txt");
    	file.delete();
    	BestScores bestScores = new BestScores(1, 5, 7, "name", "test.txt"); // previous best score is 7
    	bestScores.checkBestScore();
    	BestScores bestScores2 = new BestScores(1, 5, 7, "name", "test.txt"); // new score is 7, which is not greater than previous best score
    	boolean result = bestScores2.checkBestScore(); // 7 !< 7
    	assertEquals("checkBestScore()", false, result);
    }
}
