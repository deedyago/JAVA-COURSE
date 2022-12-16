package main.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Homework3
{
    public static void main(String[] args) {
        // 1. Создать новый список, добавить несколько строк и вывести коллекцию на экран.
        ArrayList<String> list1 = new ArrayList<>();

        list1.add(0, "kek");
        list1.add(1, "cheburek");
        list1.forEach(n -> System.out.printf(n + " "));
        System.out.println();


        // 2. Итерация всех элементов списка цветов и добавления к каждому символа '!'.
        String[] colors = new String[]{"white", "black", "blue", "purple"};
        ArrayList<String> list2 = new ArrayList<>();

        for (int i = 0; i < colors.length; i++) {
            list2.add(colors[i] + "!");
        }
        list2.forEach(n -> System.out.printf("\n" + n + " "));
        System.out.println();


        // 3. Вставить элемент в список в первой позиции.
        list2.add(0, "orange");
        list2.forEach(n -> System.out.printf("\n" + n + " "));
        System.out.println();

        // 4. Извлечь элемент (по указанному индексу) из заданного списка.
        String black = list2.get(2);
        System.out.println("\n" + black);

        // 5. Обновить определенный элемент списка по заданному индексу.
        list2.set(0, "seroburomalinovi");
        list2.forEach(n -> System.out.printf("\n" + n + " "));
        System.out.println();

        // 6. Удалить третий элемент из списка.
        list2.remove(2);
        list2.forEach(n -> System.out.printf("\n" + n + " "));
        System.out.println();

        // 7. Поиска элемента в списке по строке.
        //if(list2.contains("seroburomalinovi")
        // {
        //  ...
        // }
        if(list2.indexOf("seroburomalinovi") != -1)
        {
            System.out.println("\n" + "Element is on " + list2.indexOf("seroburomalinovi") + " index");
        }
        else
        {
            System.out.println("\n" + "There is no such element");
        }

        // 8. Создать новый список и добавить в него несколько елементов первого списка.
        ArrayList<String> list3 = new ArrayList<>(list2.subList(1,3));
        list3.forEach(n -> System.out.printf("\n" + n + " "));
        System.out.println();

        // 9. Удалить из первого списка все элементы отсутствующие во втором списке.
        list2.removeAll(list3);
        list2.forEach(n -> System.out.printf("\n" + n + " "));
        System.out.println();

        // 10. *Сортировка списка.
        ArrayList<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            intList.add(new Random().nextInt(20));
        }

        intList.forEach(n -> System.out.printf("\n" + n + " "));
        System.out.println();
        Collections.sort(intList);
        intList.forEach(n -> System.out.printf("\n" + n + " "));
        System.out.println();

        // 11. *Сравнить время работы тысячи повторений пункта 3 для ArrayList и LinkedList.
        ArrayList<Integer> l = new ArrayList<>();
        LinkedList<Integer> ll = new LinkedList<>();
        l.add(0);
        ll.add(0);

        long time1 = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++)
        {
            l.add(0,new Random().nextInt(10));
        }

        long time2 = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++)
        {
            ll.add(0,new Random().nextInt(10));
        }

        long time3 = System.currentTimeMillis();
        System.out.println("List = " + (time2 - time1) + "\nLinkedList = " + (time3 - time2));
    }
}
