package model;

import java.io.File; 
import java.util.Scanner;

public class BestScoresSaver
{
    //private
    private ScoresReader localScoresReader;
    
    public BestScoresSaver()
    {
        this.localScoresReader = new ScoresReader("");
    }
    
    public BestScoresSaver(String saveFileName)
    {
        this.localScoresReader = new ScoresReader(saveFileName);
        //this.localScoresWriter = new ScoresWriter(saveFileName);
    
    }
    

}
