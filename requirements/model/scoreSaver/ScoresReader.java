package model;

import java.util.ArrayList;
import java.io.*;

public class ScoresReader
{
    private String fileName;
    private ArrayList<String[]> localScoreList;

    
    public ScoresReader(String fileName)
    {
        this.fileName = fileName;
        this.localScoreList = new ArrayList<String[]>();
    }
    
    private void readScoresFromFile()
    {
        this.localScoreList.clear();
        try 
        {
            
            String line = null; 
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null) 
            {
                this.localScoreList.add(line.split(","));
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) 
        {
            System.out.println(
                "Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) 
        {
            System.out.println(
                "Error reading file '"+ fileName + "'");                  
        }
    }
    
    public String getFileName()
    {
        return this.fileName;
    }
    
    public ArrayList<String> getBestScores()
    {
        ArrayList<String> bestScores = new ArrayList<String>();
        for (String[] line : this.localScoreList)
        {
            bestScores.add(line[2]);
        }
        return bestScores;
    }
    
    

}
