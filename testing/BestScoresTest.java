package testing;

import model.*;
import java.io.File;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class BestScoresTest
{

    @Test
    public void testCheckBestScoreExpectTrue()
    {
    	File file = new File("./test.txt");
    	file.delete();
    	BestScores bestScores = new BestScores(5, "test.txt"); // no previous games so score should be new best score
    	boolean result = bestScores.checkBestScore(1, 7, "testName"); // 7 > 0 (and bestscore == 0)
    	assertEquals("checkBestScore()", true, result);
    }
    
    @Test
    public void testCheckBestScoreExpectTrue2()
    {
    	File file = new File("./test.txt");
    	file.delete();
    	BestScores bestScores = new BestScores(5, "test.txt"); // previous best score is 8
    	bestScores.checkBestScore(1, 8, "testName");
    	boolean result = bestScores.checkBestScore(1, 7, "testName2"); // new score is 7, which is greater than previous best score
    	assertEquals("checkBestScore()", true, result);
    }
    
    @Test
    public void testCheckBestScoreExpectTrue3()
    {
    	File file = new File("./test.txt");
    	file.delete();
    	BestScores bestScores = new BestScores(5, "test.txt"); // previous best score is 8
    	bestScores.checkBestScore(1, 8, "testName");
    	BestScores bestScores2 = new BestScores(5, "test.txt");
    	boolean result = bestScores2.checkBestScore(1, 7, "testName2"); // new score is 7, which is greater than previous best score
    	assertEquals("checkBestScore()", true, result);
    } 
    
    @Test
    public void testCheckBestScoreExpectFalse()
    {
    	File file = new File("./test.txt");
    	file.delete();
    	BestScores bestScores = new BestScores(5, "test.txt"); // previous best score is 7
    	bestScores.checkBestScore(1, 7, "testName");
    	boolean result = bestScores.checkBestScore(1, 8, "testName2"); // new score is 8, which is not greater than previous best score
    	assertEquals("checkBestScore()", false, result);
    }
    
    @Test
    public void testCheckBestScoreExpectFalse2()
    {
    	File file = new File("./test.txt");
    	file.delete();
    	BestScores bestScores = new BestScores(5, "test.txt"); // previous best score is 7
    	bestScores.checkBestScore(1, 7, "testName");
    	boolean result = bestScores.checkBestScore(1, 7, "testName2"); // new score is 7, which is not greater than previous best score
    	assertEquals("checkBestScore()", false, result);
    }
    
    @Test
    public void testCheckBestScoresExpectFalse3()
    {
    	File file = new File("./test.txt");
    	file.delete();
    	BestScores bestScores = new BestScores(5, "test.txt");
    	bestScores.checkBestScore(2, 15, "testName");
    	bestScores.checkBestScore(1, 7, "testName2");
    	boolean result = bestScores.checkBestScore(1, 8, "testName3");
    	assertEquals("checkBestScore()", false, result);
    }
    
    @Test
    public void testGetNamesAndScoresExpectTrue()
    {
    	File file = new File("./test.txt");
    	file.delete();
    	BestScores bestScores = new BestScores(5, "test.txt");
    	bestScores.checkBestScore(1, 7, "testName");
    	bestScores.checkBestScore(3, 31, "testName2");
    	ArrayList<String> namesAndScores = new ArrayList<String>(
    			Arrays.asList("LEVEL_1,testName,7", "LEVEL_2,,0", "LEVEL_3,testName2,31", "LEVEL_4,,0", "LEVEL_5,,0"));
    	boolean result = bestScores.getNamesAndScores().equals(namesAndScores);
    	assertEquals("getNamesAndScores()", true, result);
    }
    
    @Test
    public void testGetNamesAndScoresExpectTrue2()
    {
    	File file = new File("./test.txt");
    	file.delete();
    	BestScores bestScores = new BestScores(5, "test.txt");
    	bestScores.checkBestScore(1, 7, "testName");
    	bestScores.checkBestScore(1, 7, "testName2");
    	ArrayList<String> namesAndScores = new ArrayList<String>(
    			Arrays.asList("LEVEL_1,testName,7", "LEVEL_2,,0", "LEVEL_3,,0", "LEVEL_4,,0", "LEVEL_5,,0"));
    	boolean result = bestScores.getNamesAndScores().equals(namesAndScores);
    	assertEquals("getNamesAndScores()", true, result);
    }
    
    @Test
    public void testGetNamesAndScoresExpectTrue3()
    {
    	File file = new File("./test.txt");
    	file.delete();
    	BestScores bestScores = new BestScores(5, "test.txt");
    	bestScores.checkBestScore(1, 8, "testName");
    	bestScores.checkBestScore(1, 7, "testName2");
    	ArrayList<String> namesAndScores = new ArrayList<String>(
    			Arrays.asList("LEVEL_1,testName2,7", "LEVEL_2,,0", "LEVEL_3,,0", "LEVEL_4,,0", "LEVEL_5,,0"));
    	boolean result = bestScores.getNamesAndScores().equals(namesAndScores);
    	assertEquals("getNamesAndScores()", true, result);
    }
    
    @Test
    public void testGetNamesAndScoresExpectTrue4()
    {
    	File file = new File("./test.txt");
    	file.delete();
    	BestScores bestScores = new BestScores(5, "test.txt");
    	bestScores.checkBestScore(1, 7, "testName");
    	BestScores bestScores2 = new BestScores(5, "test.txt");
    	bestScores2.checkBestScore(3, 31, "testName2");
    	ArrayList<String> namesAndScores = new ArrayList<String>(
    			Arrays.asList("LEVEL_1,testName,7", "LEVEL_2,,0", "LEVEL_3,testName2,31", "LEVEL_4,,0", "LEVEL_5,,0"));
    	boolean result = bestScores2.getNamesAndScores().equals(namesAndScores);
    	assertEquals("getNamesAndScores()", true, result);
    }
}
