package model;
import java.util.EmptyStackException;
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
        try {
//            Ring topRing = new Ring(this.post.peek());
//
//            if (topRing == null || topRing.getSize() > newRing.getSize()) {
//                this.post.push(newRing);
//                return true;
//
//            } else {
//                return false;
//            }

            // idk abt this
            if (this.viewTop() == null || this.viewTop().getSize() > newRing.getSize()) {
                this.post.push(newRing);
                return true;
            }
            else {
                return false;
            }

        } catch (EmptyStackException e) {
            this.post.push(newRing);
            return true;
        }

    }
    
    //Returns null if post is empty - added a try/catch block
    public Ring remove()
    {
        try {
            return this.post.pop();
        } catch (EmptyStackException e) {
            return null;
        }
    }

    //Returns null if post is empty with try/catch block
    public Ring viewTop()
    {
        try {
            return this.post.peek();
        } catch (EmptyStackException e) {
            return null;
        }
    }
    
    public boolean isEmpty()
    {
        return this.post.empty();
    }
    
    public boolean isComplete(int maxRings)
    {
        return (this.post.size()==maxRings);
    }

    // for terminal version
    public Stack<Ring> getRings() {
        return this.post;
    }

    // edited for terminal version
    public String toString()
    {
        if (this.isEmpty()) {
            return "| |";
        } else {
            return (this.post.toString());
        }
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
