package model;

import java.util.ArrayList;
import java.util.Scanner;

public class BestScores
{
    private int level;
    private int numLevels;
    private int score;
    private String name;
    private ScoreSaver scoreSaver;
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<Integer> scores = new ArrayList<Integer>(); 

    public BestScores(int level, int numLevels, int score, String userName, String filename)
    {
        this.level = level;
        this.numLevels = numLevels;
        this.score = score;
        this.name = userName;

        this.scoreSaver = new ScoreSaver(filename);

        ArrayList<String> namesAndScores = this.scoreSaver.getScores();

        if (namesAndScores.size() == 0)
        {
            for (int i = 0; i < this.numLevels; i++)
            {
                this.names.add("");
                this.scores.add(0);
            }
        }
        else
        {
	    for (int i = 0; i < this.numLevels; i++)
	    {
		String[] levelInfo = namesAndScores.get(i).split(",");
		this.names.add(levelInfo[1]);
		this.scores.add(Integer.parseInt(levelInfo[2])); 
	    }
        }
    }

    private void updateScores()
    {
        ArrayList<String> namesAndScores = new ArrayList<String>();
	for (int i = 0; i < this.numLevels; i++)
	{
	    String levelInfo = "LEVEL_" + Integer.toString(i + 1) + "," + this.names.get(i) + "," + Integer.toString(this.scores.get(i));
	    namesAndScores.add(levelInfo);
	} 
	this.scoreSaver.saveScores(namesAndScores);
    } 

    public boolean checkBestScore()
    {
        int bestscore = scores.get(level - 1);

        if (this.score < bestscore || bestscore == 0)
        {
//            Scanner s = new Scanner(System.in);
//            System.out.println("Enter name: ");
//            String name = s.nextLine();
//            s.close();
            this.names.set(level - 1, this.name);
	    this.scores.set(level - 1, this.score);
	    this.updateScores();
	    return true;
        }
	else
	{
 	    this.updateScores();
	    return false;
	}
    }
}
