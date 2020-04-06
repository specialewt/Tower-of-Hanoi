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
//         "model/"+passedFileName;
        
        
        try
        {
            Path tempPath = Paths.get(passedFileName);
            
            if (Files.exists(tempPath)){
                this.scoreFilePath = tempPath;
                
            }else{
            
                Path tempFilePath = Files.createFile(tempPath);
                this.scoreFilePath = tempFilePath;
            }
            System.out.println("File Created.");
        
             
            this.localScoreStringList = new ArrayList<String>();
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    @Override
    public String toString()
    {
        return this.localScoreStringList.toString();
    }
    
    protected void readScores()
    {
//         ArrayList<String> rawScores = ArrayList<String>();
        try
        {
            List<String> tempList = Files.readAllLines(this.scoreFilePath,StandardCharsets.ISO_8859_1);
            for (String line : tempList)
            {
                this.localScoreStringList.add(line);
            }
        
        }catch(IOException e){
            e.printStackTrace();
        }
        
    
    }
    protected void writeScores()
    {
        
        try
        {
            Files.write(this.scoreFilePath,this.localScoreStringList.toString().getBytes());
            
        }catch(IOException e){
        
            e.printStackTrace();
        }
    }
    
//     public void writeScores(ArrayList<String[]> passedScores)
//     {
//         try
//         {
//             
//         }catch(IOException e){
//             System.out.println(e.getMessage());
//         }
//     }
    
//     private void clearFile()
//     {
//         
//     }
//     

    

}
