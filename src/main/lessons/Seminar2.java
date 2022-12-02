package main.lessons;
import java.util.Arrays;
import java.util.Random;

public class Seminar2
{
    public static void main(String[] args)
    {
        int[] arr = new int[10];
        arr = RandomFunc(arr);
        //Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        arr = Reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
    static int[] RandomFunc(int[] arr2)
    {
        for (int i = 0; i < arr2.length - 1; i++)
        {
            arr2[i] = new Random().nextInt(100);
        }
        return arr2;
    }
    static int[] Reverse(int[] arr2)
    {
        int temp = 0;
        for (int i = 0; i < arr2.length/2; i++)
        {
            temp = arr2[i];
            arr2[i] = arr2[arr2.length-i-1];
            arr2[arr2.length-i-1] = temp;
        }
        return arr2;
    }

}
