package org.example.homework;

import java.util.*;

public class HW3 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 7, 3, 8, 4, 9, 1, 6));
        System.out.println("Исходный список: " + list);

        reverseSort(list);
        System.out.println("\nСписок в обратном порядке: " + list);

        removeEven(list);
        System.out.println("\nСписок без четных чисел: " + list);

        System.out.println("\nМинимум: " + findMin(list));
        System.out.println("Максимум: " + findMax(list));
        System.out.println("Среднее значение: " + findAverage(list));

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8));
        List<Integer> merged = mergeLists(list1, list2);
        System.out.println("\nОбъединенный список без дубликатов: " + merged);


        List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3));

        long startTimeArrayList = System.nanoTime();
        List<Integer> inArrayList = addTenThousandForList(list3);
        long endTimeArrayList = System.nanoTime();

        System.out.println("\nНулевым элементом в ArrayList добавлен ноль 10000 раз: " + inArrayList);
        System.out.println("Время выполнения ArrayList: " + (endTimeArrayList - startTimeArrayList) + " наносекунд");


        LinkedList<Integer> list4 = new LinkedList<>(Arrays.asList(1, 2, 3));

        long startTimeLinkedList = System.nanoTime();
        List<Integer> inLinkedList = addTenThousandForLinkedList(list4);
        long endTimeLinkedList = System.nanoTime();

        System.out.println("\nНулевым элементом в LinkedList добавлен ноль 10000 раз: " + inLinkedList);
        System.out.println("Время выполнения LinkedList: " + (endTimeLinkedList - startTimeLinkedList) + " наносекунд");


    }

    public static void reverseSort(List<Integer> list) {
        Collections.reverse(list);
    }

    public static void removeEven(List<Integer> list) {
        list.removeIf(n -> n % 2 == 0);
    }

    public static int findMin(List<Integer> list) {
        return Collections.min(list);
    }

    public static int findMax(List<Integer> list) {
        return Collections.max(list);
    }

    public static double findAverage(List<Integer> list) {
        int sum = 0;
        for (int number : list) {
            sum += number;
        }
        return (double) sum / list.size();
    }

    public static List<Integer> addTenThousandForList(List<Integer> list) {
        for (int i = 0; i < 10000; i++) {
            list.add(0, 0);
        }
        return list;
    }

    public static LinkedList<Integer> addTenThousandForLinkedList(LinkedList<Integer> list) {
        for (int i = 0; i < 10000; i++) {
            list.addFirst(0);
        }
        return list;
    }

    public static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set = new HashSet<>(list1);
        set.addAll(list2);
        return new ArrayList<>(set);
    }
}
