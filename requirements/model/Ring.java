package model;

public class Ring
{
    private int size;
    
    public Ring(int ringSize)
    {
        this.size = ringSize;
    }
    
    public int getSize()
    {
        return this.size;
    }
    
    public Ring(Ring r)
    {
        this.size = r.getSize();
    }
}
