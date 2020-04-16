
import org.junit.*;
import static org.junit.Assert.*;
import model.*;

public class PostTest {
    @Test
    public void addRingToEmptyExpectTrue() {
        Post p = new Post();
        Ring ring1 = new Ring(1);
        boolean result = p.add(ring1);

        assertEquals("add(ring) to empty post", true, result);
    }

    @Test
    public void addRingExpectTrue() {
        Post p = new Post();
        Ring ring1 = new Ring(1);
        Ring ring2 = new Ring(2);
        p.add(ring2);
        boolean result = p.add(ring1);

        assertEquals("add(ring) on top of larger ring", true, result);
    }

    @Test
    public void addRingExpectFalse() {
        Post p = new Post();
        Ring ring1 = new Ring(1);
        Ring ring2 = new Ring(2);
        p.add(ring1);
        boolean result = p.add(ring2);

        assertEquals("add(ring) on top of smaller ring", false, result);
    }

    @Test
    public void removeRingExpectNull() {
        Post p = new Post();
        Ring result = p.remove();

        assertEquals("remove() from empty Post", null, result);
    }

    @Test
    public void removeRingExpectEqual() {
        Post p = new Post();
        Ring r = new Ring(1);
        p.add(r);
        Ring result = p.remove();

        assertEquals("remove()", r, result);
    }

    @Test
    public void viewTopExpectEqual() {
        Post p = new Post();
        Ring ring1 = new Ring(1);
        Ring ring2 = new Ring(2);
        p.add(ring2);
        p.add(ring1);
        Ring result = p.viewTop();

        assertEquals("viewTop()", ring1, result);
    }

    @Test
    public void isEmptyExpectTrue() {
        Post p = new Post();
        boolean result = p.isEmpty();

        assertEquals("isEmpty()", true, result);
    }

    @Test
    public void isEmptyExpectFalse() {
        Post p = new Post();
        p.add(new Ring(1));
        boolean result = p.isEmpty();

        assertEquals("isEmpty()", false, result);
    }

    @Test
    public void isCompleteExpectTrue() {
        Post p = new Post();
        p.add(new Ring(3));
        p.add(new Ring(2));
        p.add(new Ring(1));
        boolean result = p.isComplete(3);

        assertEquals("isComplete()", true, result);
    }

    @Test
    public void isCompleteExpectFalse() {
        Post p = new Post();
        p.add(new Ring(3));
        p.add(new Ring(1));
        boolean result = p.isComplete(3);

        assertEquals("isComplete()", false, result);
    }
}
