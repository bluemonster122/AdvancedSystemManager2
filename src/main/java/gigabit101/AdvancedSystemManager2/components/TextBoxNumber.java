package gigabit101.AdvancedSystemManager2.components;


public class TextBoxNumber
{
    private static final int TEXT_BOX_SIZE_W = 21;
    private static final int TEXT_BOX_SIZE_W_WIDE = 33;

    private int x;
    private int y;
    private int number;
    private int length;
    private boolean wide;

    public TextBoxNumber(int x, int y, int length, boolean wide)
    {
        this.x = x;
        this.y = y;
        number = 0;
        this.length = length;
        this.wide = wide;
    }

    public int getLength()
    {
        return length;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        int max = getMaxNumber();
        if (max != -1 && number > max)
        {
            number = max;
        }
        int min = getMinNumber();
        if (number < min)
        {
            number = min;
        }

        this.number = number;
    }

    public boolean isVisible()
    {
        return true;
    }

    public boolean isWide()
    {
        return wide;
    }

    public void onNumberChanged()
    {
    }

    public int getWidth()
    {
        return wide ? TEXT_BOX_SIZE_W_WIDE : TEXT_BOX_SIZE_W;
    }

    public int getMaxNumber()
    {
        return -1;
    }

    public int getMinNumber()
    {
        return 0;
    }

    public final boolean allowNegative()
    {
        return getMinNumber() < 0;
    }

    public float getTextSize()
    {
        return 1;
    }

    public int getTextY()
    {
        return 3;
    }
}
