package testing;

import java.nio.file.*;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;

import model.ScoreSaver;


import org.junit.*;
import static org.junit.Assert.*;

// javac testing/ScoreSaverTest.java; java org.junit.runner.JUnitCore testing.ScoreSaverTest

public class ScoreSaverTest
{
    private void displayFileContents(String fileName)
    {
        try{
            Path tempPath = Paths.get(fileName);
            List<String> tempList = Files.readAllLines(tempPath,StandardCharsets.ISO_8859_1);
            for (String line : tempList)
            {
                System.out.println(line);
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }    
    }
    
    private void readFromFile(String pathString, ArrayList tempList)
    {
        
        Path tempPath = Paths.get(pathString);
        try
        {
            List<String> tempList2 = Files.readAllLines(tempPath,StandardCharsets.ISO_8859_1);
            for (String line : tempList2)
            {
                tempList.add(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void setUpAL(ArrayList temp)
    {
        temp.add("FIRST_LINE_OF_TEXT");
        temp.add("SECOND_LINE_OF_TEXT");
        temp.add("THIRD_LINE_OF_TEXT");
    }
    
    private void resetSaveFile(String pathName)
    {   
        try{
            String eString = "";
            Files.write(Paths.get(pathName),eString.getBytes());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @Test
    public void ReadScoresEqualsTrue()
    {
        ScoreSaver testSaver = new ScoreSaver("testing/.testFile_ThreeLines.txt");
        boolean tempBool = testSaver.readScores();
        System.out.println("TestSaver contains: "+testSaver.toString());
        assertEquals("readScores() "+ testSaver.toString(), true, tempBool);
    }
    
    @Test
    public void GetScoresEqualsTrue()
    {
        ScoreSaver testSaver = new ScoreSaver("testing/.testFile_ThreeLines.txt");
        
        ArrayList<String> tempArrayList = testSaver.getScores();
        
        boolean tempBool = tempArrayList.isEmpty();
        System.out.println("TestSaver contains: "+testSaver.toString());
        assertFalse("getScores() "+ testSaver.toString(),tempBool);
    }
    
    @Test
    public void WriteScoresEqualsTrue()
    {
        resetSaveFile("testing/.ScoreSaverTestFile.txt");
        ArrayList<String> tempList = new ArrayList<String>();
        setUpAL(tempList);
        ScoreSaver testSaver = new ScoreSaver("testing/.ScoreSaverTestFile.txt");
        testSaver.saveScores(tempList);
        boolean tempBool = testSaver.writeScores();
        System.out.println("TestSaver contains: "+testSaver.toString());
        assertEquals("writeScores() "+ testSaver.toString(),true,tempBool);
    }
}
