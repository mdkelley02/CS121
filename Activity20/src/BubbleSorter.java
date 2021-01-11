import java.util.Random;

public class BubbleSorter
{
    public static final int MAX_NUMBER = 25;

    private int[] numbers;

    public BubbleSorter (int size)
    {
        numbers = new int[size];

        Random r = new Random();

        for(int i = 0; i < numbers.length; i++)
        {
            numbers[i] = r.nextInt(MAX_NUMBER);
        }

    }

    public String toString()
    {
        String builtString = "";
        for(int i: numbers)
        {
            builtString += i + ", ";
        }
        return builtString;
    }

    private void swap(int indexOne, int indexTwo)
    {
        int temp = numbers[indexOne];
        numbers[indexOne] = numbers[indexTwo];
        numbers[indexTwo] = temp;
    }

    public void sort()
    {
        boolean done = false;

        while(!done)
        {
            done = true;
            for(int i = 1; i< numbers.length; i++)
            {
                if(numbers[i-1] > numbers[i])
                {
                    swap(i-1, i);
                    done = false;
                }
            }
        }

    }
}
