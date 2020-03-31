
package model;

import org.junit.*;
import static org.junit.Assert.*;

//javac ScoresReaderTest.java; java org.junit.runner.JUnitCore ScoresReaderTest

public class ScoresReaderTest
{
    //@Test
    //public void methodNameExpectBoolean()
    //{
    
    //    assertEquals("methodName() "+object, Boolean, testResult);
    //}
    
    //@Test
    //public void methodNameExpectBoolean()
    //{
    
    //    assertEquals("methodName() "+object, Boolean, testResult);
    //}
    
//     @Test
//     public void getFileNameExpectTrue()
//     {
//         ScoresReader testScoresReader = new ScoresReader(".saveStateTest.txt");
//         boolean testResult = ".saveStateTest.txt".equals(testScoresReader.getFileName());
//         assertEquals("getFileName() ", true, testResult);
//     }
//     @Test
//     public void getFileNameExpectFalse()
//     {
//         ScoresReader testScoresReader = new ScoresReader(".saveStateTest.txt");
//         boolean testResult = "nope.txt".equals(testScoresReader.getFileName());
//         assertEquals("getFileName() ", false, testResult);
//     }
    
    public static void main(String []args)
    {
        ScoresReader testScoresReader = new ScoresReader(".saveStateTest.txt");
        System.out.println(".saveStateTest.txt".equals(testScoresReader.getFileName()));
    
    }
    
    
    
}
