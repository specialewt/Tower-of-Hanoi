package testing;

import model.Ring;

import org.junit.*;
import static org.junit.Assert.*;

// javac testing/RingTest.java; java org.junit.runner.JUnitCore testing.RingTest

public class RingTest
{
    @Test
    public void GetSizeExpectTrue()
    {
        int ringSize = 10;
        Ring testRing = new Ring(ringSize);
        boolean testBool = (ringSize == testRing.getSize());
        assertEquals("getSize() "+ringSize,true,testBool);
    }
    @Test
    public void StringRepresentationExpectTrue()
    {
        Ring testRing = new Ring(2);
        String testString = "[XX]";
        boolean testBool = testString.equals(testRing.toString());
        assertEquals("toString() "+testRing.toString(),true,testBool);   
    }

}
