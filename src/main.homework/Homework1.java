package main.homework;

import java.util.Arrays;
import java.util.Random;

public class Homework1
{
    public static void main(String[] args)
    {
        // 1. Выбросить случайное целое число в диапазоне от -1000 до 1000 и сохранить в i
        int i = RandomFunc(-1000, 1000);
        System.out.println("Output is: " + i);

        //2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        int n = Bit(i);
        System.out.println("Bit is: " + n);

        // 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
        int[] m1 = new int[ArraySize(i)];
        m1 = Short(i,m1);
        System.out.println("Array created is :: "+ Arrays.toString(m1));

        //4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
        int[] m2 = new int[ArraySize2(i)];
        m2 = Short2(i,m2);
        System.out.println("Array created is :: "+ Arrays.toString(m2));
    }
    // 1. Выбросить случайное целое число в диапазоне от -1000 до 1000 и сохранить в i
    static int RandomFunc(int min, int max)
    {
        return new Random().nextInt(max-min) + min;
    }

    // 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
    static int Bit(int x)
    {
        x |= x >> 1;
        x |= x >> 2;
        x |= x >> 4;
        x |= x >> 8;
        x |= x >> 16;
        return x - (x >> 1);
    }

    // 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
    static int ArraySize(int n)
    {
        int size = 0;

        for (int i = 1; i < Short.MAX_VALUE; i++) {
            if (i % n == 0) {
                size++;
            }
        }
        return size;
    }
    static int[] Short(int n, int[] arrayTo)
    {
        int position = 0;
        for (int i = 1; i < Short.MAX_VALUE; i++)
        {
            if(i % n == 0)
            {
                arrayTo[position] = i;
                position++;
            }
        }
        return arrayTo;
    }

    //4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
    static int ArraySize2(int n)
    {
        int size = 0;

        for (int i = Short.MIN_VALUE; i <= n; i++) {
            if (i % n != 0) {
                size++;
            }
        }
        return size;
    }
    static int[] Short2(int n, int[] arrayTo)
    {
        int position = 0;
        for (int i = Short.MIN_VALUE; i <= n; i++)
        {
            if(i % n != 0)
            {
                arrayTo[position] = i;
                position++;
            }
        }
        return arrayTo;
    //работай пуш плез
    }

}