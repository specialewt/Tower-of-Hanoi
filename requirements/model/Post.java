package model;
import java.util.Stack;

public class Post
{
    protected Stack<Ring> post;
    
    public Post()
    {
        this.post = new Stack<Ring>();
    }
    
    public boolean add(Ring newRing)
    {
        Ring topRing = new Ring(this.post.peek());
        
        if (topRing.getSize()>newRing.getSize())
        {
            this.post.push(newRing);
            return true;
            
        }else{
            return false;
        }
    }
    
    //Returns null if post is empty.
    public Ring remove()
    {
       return this.post.pop();
    }
    
    public Ring viewTop()
    {
        return this.post.peek();
    }
    
    public boolean isEmpty()
    {
        return this.post.empty();
    }
    
    public boolean isComplete(int maxRings)
    {
        return (this.post.size()==maxRings);
    }
    
    public String toString()
    {
        return (this.post.toString());
    }
    
}



// public class Post implements Iterable<Ring>
// {
// 
//     protected Ring []post;
//     protected int capacity;
//     protected int numRings;
//     
//     public Post(int maxRings)
//     {
//         this.numRings = 0;
//         this.capacity = maxRings;
//         this.post = new Ring[this.capacity];
//     }
//     
//     public void add(Ring newRing) throws SizeLimitExceededException
//     {
//         if (this.numRings < this.capacity)
//         {
//             this.post[this.numRings] = new Ring(newRing);
//             this.numRings++;
//             
//         }else{
//         
//             throw new SizeLimitExceededException("Too many rings!");
//             
//         }
//         
//     }
//     
//     public void remove() throws NoSuchElementException
//     {
//         if (!this.post.isEmpty())
//         {
//             this.post[this.numRings].
//         }
//     }
//     
//     
//     public Iterator<Ring> iterator()
//     {
//         return new PostIterator();
//     }
//     
//     private class PostIterator implements Iterator<Ring>
//     {
//         private int postIndex;
//         
//         public PostIterator()
//         {
//             postIndex = -1;
//         }
//         public boolean hasNext()
//         {
//             if (postIndex+1 < numRings)
//             {
//                 return true;
//             }
//             return false;
//         }
//         public Ring next() throws NoSuchElementException
//         {
//             if (hasNext())
//             {
//                 postIndex++;
//                 return post[postIndex];
//             }
//             throw new NoSuchElementException("No more rings left on the post.");
//         }
//     }
// 
// }
