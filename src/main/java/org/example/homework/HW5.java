package org.example.homework;

import java.util.*;

public class HW5 {
    public static void main(String[] args) {
        HashMap<Integer, String> firstSet = new HashMap<>();
        firstSet.put(1, "в");
        firstSet.put(2, "пять");
        firstSet.put(3, "минут");
        firstSet.put(4, "решают");
        firstSet.put(5, "люди");
        firstSet.put(6, "иногда");

        for (Integer key : firstSet.keySet()) {
            String value = firstSet.get(key);
            firstSet.put(key, value + "!");
        }

        for (Integer key : firstSet.keySet()) {
            String value = firstSet.get(key);
            firstSet.put(key, value + "!");
        }

        HashMap<Integer, String> secondSet = new HashMap<>();
        secondSet.put(2, "не");
        secondSet.put(3, "женисться");
        secondSet.put(5, "ни");
        secondSet.put(8, "за");
        secondSet.put(6, "что");
        secondSet.put(9, "и");
        secondSet.put(4, "никогда");


        for (Integer key : secondSet.keySet()) {
            if (firstSet.containsKey(key)) {
                String combinedValue = firstSet.get(key) + " " + secondSet.get(key);
                firstSet.put(key, combinedValue);
            } else {
                firstSet.put(key, secondSet.get(key));
            }
        }

        for (Integer key : firstSet.keySet()) {
            String value = firstSet.get(key);
            firstSet.put(key, value + "!");
        }

        System.out.println("Скомбинированные и обновленные значения первого набора: ");
        for (String value : firstSet.values()) {
            System.out.println(value);
        }
    }
}
