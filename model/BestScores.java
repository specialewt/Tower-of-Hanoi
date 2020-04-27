package model;

import java.util.ArrayList;
import java.util.Scanner;

public class BestScores
{
    private int numLevels;
    private ScoreSaver scoreSaver;
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<Integer> scores = new ArrayList<Integer>();
    private ArrayList<String> namesAndScores = new ArrayList<String>();

    public BestScores(int numLevels, String filename)
    {
        this.numLevels = numLevels;

        this.scoreSaver = new ScoreSaver(filename);

        ArrayList<String> namesAndScores = this.scoreSaver.getScores();

        if (namesAndScores.size() == 0)
        {
            for (int i = 0; i < this.numLevels; i++)
            {
                this.names.add("null");
                this.scores.add(0);
            }
        }
        else
        {
            for (int i = 0; i < this.numLevels; i++)
            {
                System.out.println(namesAndScores.get(i));
                
                String[] levelInfo = namesAndScores.get(i).split(",");
                this.names.add(levelInfo[1]);
                this.scores.add(Integer.parseInt(levelInfo[2])); 
            }
        }
        
        for (int i = 0; i < this.numLevels; i++)
        {
        	this.namesAndScores.add("");
        }
        this.updateScores();
    }

    private void updateScores()
    {
	for (int i = 0; i < this.numLevels; i++)
	{
	    String levelInfo = "LEVEL_" + Integer.toString(i + 1) + "," + this.names.get(i) + "," + Integer.toString(this.scores.get(i));
	    this.namesAndScores.set(i, levelInfo);
	} 
	this.scoreSaver.saveScores(this.namesAndScores);
    } 

    public boolean checkBestScore(int level, int score, String name)
    {
        int bestscore = scores.get(level - 1);

        if (score < bestscore || bestscore == 0)
        {
//            Scanner s = new Scanner(System.in);
//            System.out.println("Enter name: ");
//            String name = s.nextLine();
//            s.close();
            this.names.set(level - 1, name);
	    this.scores.set(level - 1, score);
	    this.updateScores();
	    return true;
	}
	else
	{
	    this.updateScores();
	    return false;
	}
    }
    
    public ArrayList<String> getNamesAndScores()
    {
    	return this.namesAndScores;
    }
}
