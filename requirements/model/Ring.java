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

    // for terminal version
    @Override
    public String toString() {
        char s[] = new char[size];
        for (int i = 0; i < size; i++) {
            s[i] = 'X';
        }

        return "[" + String.valueOf(s) + "]";
    }
}
