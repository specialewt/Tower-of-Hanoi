package testing;


import org.junit.*;
import static org.junit.Assert.*;


public class ScoreSaverTest
{
    @Test
    public void ConstructorTestFileExistsEqualsTrue()
    {
        
        assertEquals("isEquilateral() "+t, true, result);
    }
    
    @Test
    public void ConstructorTestFileExistsEqualsFalse()
    {
        Triangle t = new Triangle(10,10,10);
        boolean result = t.isEquilateral();
        assertEquals("isEquilateral() "+t, true, result);
    }
}
