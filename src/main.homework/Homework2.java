package main.homework;
import java.util.*;

public class Homework2
{
    public static void main(String[] args)
    {
        // 1. Напишите программу, чтобы найти наименьшее окно в строке, содержащей все символы другой строки.
        String mainStr ="kekcheburek";
        String toFindStr ="chekk";
        System.out.print("Window is: " + Find(mainStr, toFindStr));

        // 2. Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга.
        String str1 ="ABCD";
        String str2 ="DABC";
        if (checkForRotation(str1, str2))
        {
            System.out.println("\nStrings are rotations of each other");
        }
        else
        {
            System.out.println("\nStrings are not rotations of each other");
        }

        // 3. *Напишите программу, чтобы перевернуть строку с помощью рекурсии.
        String str = "mammamia";
        String output = "";
        for (int i = 0; i < str.length(); i++)
        {
            output = PickChar(str, i) + output; // rekursia
        }
        System.out.println("Given string " + str);
        System.out.println("Reversed string " + output);

        // 4. Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
        int n1 = 3, n2 = 56;
        SB(n1, n2);
    }

    // 1. Напишите программу, чтобы найти наименьшее окно в строке, содержащей все символы другой строки.
    public static String Find(String mainStr, String toFindStr)
    {
        int mainStrChar [] = new int[256];
        int toFindStrChar [] = new int[256];
        for(int i = 0; i < toFindStr.length(); i++)
        {
            toFindStrChar[toFindStr.charAt(i)]++;
        }
        int ctr = 0, start = 0, start_index = - 1, min_length = Integer.MAX_VALUE;
        for(int j = 0; j < mainStr.length(); j++)
        {
            mainStrChar[mainStr.charAt(j)]++;
            if(toFindStrChar[mainStr.charAt(j)] != 0 && mainStrChar[mainStr.charAt(j)] <= toFindStrChar[mainStr.charAt(j)])
                ctr++;
            if(ctr == toFindStr.length())
            {
                while(mainStrChar[mainStr.charAt(start)] > toFindStrChar[mainStr.charAt(start)] || toFindStrChar[mainStr.charAt(start)] == 0)
                {
                    if(mainStrChar[mainStr.charAt(start)] > toFindStrChar[mainStr.charAt(start)] || toFindStrChar[mainStr.charAt(start)] == 0)
                        mainStrChar[mainStr.charAt(start)]--;
                    start++;
                }
                int length_window = j - start + 1;
                if(min_length > length_window)
                {
                    min_length = length_window;
                    start_index = start;
                }
            }
        }
        if(start_index == - 1)
        {
            System.out.println("No such window exists");
            return "";
        }
        return mainStr.substring(start_index,start_index + min_length);
    }

    // 2. Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга.
    static boolean checkForRotation(String str1, String str2)
    {
        return (str1.length() == str2.length()) && ((str1 + str1).indexOf(str2) != - 1);
    }

    // 3. *Напишите программу, чтобы перевернуть строку с помощью рекурсии.
    public static char PickChar(String str, int index)
    {
        char ch;
        ch = str.charAt(index);
        return ch;
    }

    // 4. Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
    public static void SB(int n1, int n2)
    {
        StringBuilder sb = new StringBuilder("");
        String output1 = sb.append(n1).append("+").append(n2).append("=").append(n1 + n2).toString();
        sb = sb.delete(0, sb.length());
        String output2 = sb.append(n1).append("-").append(n2).append("=").append(n1 - n2).toString();
        sb = sb.delete(0, sb.length());
        String output3 = sb.append(n1).append("*").append(n2).append("=").append(n1 * n2).toString();
        System.out.println(output1);
        System.out.println(output2);
        System.out.println(output3);

        // 5.Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
        sb.deleteCharAt(4);
        sb.insert(4," равно ");
        String output5 = sb.toString();
        System.out.println(output5);
        //
        // 6.*Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
        sb.replace(5,10, "равно");
        String output6 = sb.toString();
        System.out.println(output6);
        //

        // 7. **Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.
        StringBuilder sbBig = new StringBuilder("");
        for (int i = 0; i < 10000; i++)
        {
            sbBig.append("=");
        }
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10000; )
        {
            sbBig.replace(i,i+1, "равно");
            i+=5;
        }
        long sbTime = System.currentTimeMillis() - time;

        String string = "";
        for (int i = 0; i < 10000; i++)
        {
            string += "=";
        }
        time = System.currentTimeMillis();
        for (int i = 0; i < string.length(); i++)
        {
            string.replace("=","равно");
        }
        long stringTime = System.currentTimeMillis() - time;
        System.out.println("StringBuilder time is: " + sbTime + "\nString time is: " + stringTime);
    }



}
