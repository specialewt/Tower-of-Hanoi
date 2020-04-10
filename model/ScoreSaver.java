package model;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;

public class BestScoreSaver
{
    private Path scoreFilePath;
    private ArrayList<String> localScoreStringList;
    
    
    public BestScoreSaver(String passedFileName)
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
    
    protected String formatSaveString()
    {
        String saveString = new String();
        for (String temp : this.localScoreStringList)
        {
            saveString += temp;
            saveString = saveString.strip();
            saveString += "\n";
        }
        return saveString;
    
    }
    
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
    
    public void saveScores(ArrayList<String> passedScores)
    {
       this.localScoreStringList = passedScores;
       this.writeScores();
       
    }
    
    public String<ArrayList> getScores()
    {
        this.readScores();
        return this.localScoreStringList;
    }
    
    @Override
    public String toString()
    {
        return this.localScoreStringList.toString();
    }
      

}
