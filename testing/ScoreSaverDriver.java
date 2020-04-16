package testing;


import model.ScoreSaver;
import java.util.ArrayList;

public class ScoreSaverDriver
{
    public static void main(String[] args)
    {
        ScoreSaver testSaver = new ScoreSaver(".testFile_ThreeLines.txt");
//         System.out.println(testSaver);
//         ArrayList<String> sampleStringList = new ArrayList<String>();
//         sampleStringList.add("LEVEL_4,Tom,777\n");
//         sampleStringList.add("LEVEL_5,James,5192\n");
//         testSaver.saveScores(sampleStringList);
        System.out.println(testSaver);
    
    }



}
