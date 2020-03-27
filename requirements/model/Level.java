package model;

import java.util.ArrayList; 
 

public class Level
{
    private ArrayList<Post> localPosts;
    private int levelNumber;
    private int moveCounter;
    private ArrayList<Post> startingPosts;
    
    public Level(int levelNumber)
    {
        this.levelNumber = levelNumber;
        this.moveCounter = 0;
        
        this.localPosts = new ArrayList<Post>();
        
        for (int i=0; i<3;i++)
        {
            this.localPosts.add(new Post());
        }
        
        for (int i=levelNumber+2; i>0;i--)
        {
            this.localPosts.get(0).add(new Ring(i));
        }
        
        this.startingPosts = (ArrayList<Post>)this.localPosts.clone();
        
        
        
        System.out.println("Constructor");
    }
    
    public void reset()
    {
        System.out.println("restart");
        this.moveCounter = 0;
        this.localPosts = (ArrayList<Post>)this.startingPosts.clone();
    }
    
    public void move(int sendingPostNum, int receivingPostNum)
    {
        System.out.println("move");
        Ring movingRing = this.localPosts.get(sendingPostNum).viewTop();
        
        if (this.localPosts.get(receivingPostNum).add(movingRing))
        {
            this.moveCounter++;
            this.localPosts.get(sendingPostNum).remove();
            
        }else{
            System.out.println("Invalid move.");
        }
        
        
    }

}
