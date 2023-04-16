package org.example.homework1;

import java.util.Arrays;
import java.util.Random;

public class HW1 {
    public static void main(String[] args) {
        int i = rndNum(); // Задание 1
        print(String.format("Случайное целое число в диапазоне от 0 до 2000 → %d", i));

        int n = countMostSignificantBit(i); // Задание 2
        print(String.format("\nНомер старшего значащего бита выпавшего числа %d → %d", i, n));

        int[] m1 = findMultiples(n, i); // Задание 3
        String list1 = Arrays.toString(m1);
        print(String.format("\nВсе кратные числа в диапазоне от %d до %d → %s", i, Short.MAX_VALUE, list1));

        int[] m2 = findNotMultiples(n, i); // Задание 4
        String list2 = Arrays.toString(m2);
        print(String.format("\nВсе некратные числа в диапазоне от %d до %d → %s", Short.MIN_VALUE, i, list2));

    }

    static void print(String str) {
        System.out.println(str);
    }

    public static int rndNum() {
        Random rnd = new Random();
        return rnd.nextInt(2001);
    }

    public static int countMostSignificantBit(int num) {
        int n = 0;
        while (num > 0) {
            num /= 2;
            n++;
        }
        return n;
    }

    public static int[] findMultiples(int n, int i) {
        int[] m1 = new int[Short.MAX_VALUE - i];

        int index = 0;
        for (int j = i; j <= Short.MAX_VALUE; j++) {
            if (j % n == 0) {
                m1[index++] = j;
            }
        }

        int[] result = new int[index];
        System.arraycopy(m1, 0, result, 0, index);

        return result;
    }

    public static int[] findNotMultiples(int n, int i) {
        int maxNumNonMultiples = i - n + 1;
        int[] nonMultiples = new int[maxNumNonMultiples];

        int index = 0;
        for (int j = 1; j <= i; j++) {
            if (j % n != 0) {
                nonMultiples[index++] = j;
            }
        }

        int[] result = new int[index];
        System.arraycopy(nonMultiples, 0, result, 0, index);

        return result;
    }
}
