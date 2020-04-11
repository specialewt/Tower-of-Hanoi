package model;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;

public class ScoreSaver
{
    private Path scoreFilePath;
    private ArrayList<String> localScoreStringList;
    
    /**
    * ScoreSaver constructor. Looks for a file to read scores from, 
    * and if there is no such file it creates one.
    *@param passedFileName : fileName.txt
    *@throws IOException : fileNotFound 
    */
    
    public ScoreSaver(String passedFileName)
    {
        try
        {
            Path tempPath = Paths.get(passedFileName);
            
            if (Files.exists(tempPath)){
                this.scoreFilePath = tempPath;
                System.out.println("File Exists.");
                this.localScoreStringList = new ArrayList<String>();
                this.readScores();
                
            }else{
            
                Path tempFilePath = Files.createFile(tempPath);
                this.scoreFilePath = tempFilePath;
                System.out.println("File Created.");
                this.localScoreStringList = new ArrayList<String>();
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /**
    * This method reads 
    *@param passedFileName : fileName.txt
    *@throws IOException : fileNotFound 
    */

    protected void readScores()
    {
        try
        {
            this.localScoreStringList.clear();
            List<String> tempList = Files.readAllLines(this.scoreFilePath,StandardCharsets.ISO_8859_1);
            for (String line : tempList)
            {
                this.localScoreStringList.add(line);
            }
        
        }catch(IOException e){
            e.printStackTrace();
        }
        
    
    }
    /**
    * Transforms the strings within this.localScoreStringList into a single string
    * for writing to file.
    *@return String: "formatted" string for writing to file. 
    */
    protected String formatSaveString()
    {
        String saveString = new String();
        for (String temp : this.localScoreStringList)
        {
            saveString += temp;
//             saveString = saveString.strip();
            saveString += "\n";
        }
        return saveString;
    
    }
    /**
    * Writes the names and scores to file.
    *@throws IOException : fileNotFound 
    */
    
    protected void writeScores()
    {
        
        try
        {
            String saveString = this.formatSaveString();
            Files.write(this.scoreFilePath,saveString.getBytes());
            
        }catch(IOException e){
        
            e.printStackTrace();
        }
    }
    
    /**
    * This is the public function used to "save" the scores/names
    *@param passedScores : An arraylist of the individual level scores & names
    *@see writeScores()
    */
    public void saveScores(ArrayList<String> passedScores)
    {
       this.localScoreStringList = passedScores;
       this.writeScores();
       
    }
    /**
    * Retrives the ArrayList of scores/names 
    * @return ArrayList<String> : ArrayList of formatted level strings
    */
    public ArrayList<String> getScores()
    {
        this.readScores();
        return this.localScoreStringList;
    }
    /**
    *@return String: returns the string equivalent of this class.
    */
    @Override
    public String toString()
    {
        return this.localScoreStringList.toString();
    }
      

}
