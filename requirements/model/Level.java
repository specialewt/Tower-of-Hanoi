package model;

import java.util.ArrayList;

public class Level
{
    private ArrayList<Post> localPosts;
    private int levelNumber;
    private int moveCounter;
    private ArrayList<Post> startingPosts;
    private int maxRings;   // need to pass to controller for isComplete()
    private boolean end;
    
    public Level(int levelNumber)
    {
        this.levelNumber = levelNumber;
        this.moveCounter = 0;
        
        this.localPosts = new ArrayList<Post>();
        
        for (int i=0; i<3;i++)
        {
            this.localPosts.add(new Post());
        }

        this.maxRings = levelNumber + 2;
        this.initialize();
//        for (int i=this.maxRings; i>0;i--)
//        {
//            this.localPosts.get(0).add(new Ring(i));
//        }
        
//        this.startingPosts = (ArrayList<Post>)this.localPosts.clone();
//        this.startingPosts = new ArrayList<Post>(this.localPosts);
//        this.startingPosts = new ArrayList<Post>();
        
//        System.out.println("Constructor");
    }

    private void initialize() {
        // remove all rings from array
        for (int i = 0; i < 3; i++) {
            while (!this.localPosts.get(i).isEmpty()) {
                this.localPosts.get(i).remove();
            }
        }

        for (int i=this.maxRings; i>0;i--)
        {
            this.localPosts.get(0).add(new Ring(i));
        }
    }

    public void reset()
    {
        System.out.println("restart");
        this.moveCounter = 0;
        this.setEnd(false);
        this.initialize();
//        this.localPosts = (ArrayList<Post>)this.startingPosts.clone();
//        this.localPosts = new ArrayList<Post>(this.startingPosts);
    }
    
    public boolean move(int sendingPostNum, int receivingPostNum)
    {
//        System.out.println("move");
        Ring movingRing = this.localPosts.get(sendingPostNum).viewTop();

        if (movingRing != null && this.localPosts.get(receivingPostNum).add(movingRing)) {
                this.moveCounter++;
                this.localPosts.get(sendingPostNum).remove();
                return true;
        } else {
            System.out.println("INVALID MOVE. TRY AGAIN.");
            return false;
        }

    }

    public int getLevel() {
        return levelNumber;
    }

    // added for the terminal version
    public Post getPost(int p) {
        return this.localPosts.get(p);
    }

    public int getMaxRings() {
        return this.maxRings;
    }

    public int getMoveCounter() {
        return this.moveCounter;
    }

    public boolean isEnd() {
        if (this.localPosts.get(2).isComplete(this.maxRings)) {
            return true;
        } else {
            return false;
        }
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

}
