public class Driver
{
    public static void main(String[] args)
    {
        BubbleSorter b = new BubbleSorter(20);
        System.out.println(b.toString());
        b.sort();
        System.out.println(b.toString());
    }
}
