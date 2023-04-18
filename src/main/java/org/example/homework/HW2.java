package org.example.homework;

public class HW2 {
    public static void main(String[] args) {
        long startTime1 = System.nanoTime();
        parseString("Основание -12б степень 7, результат");
        long endTime1 = System.nanoTime();
        long duration1 = (endTime1 - startTime1);
        System.out.println("Время выполнения: " + duration1 + " мс");

        long startTime2 = System.nanoTime();
        parseStringBuilder("Основание -12б степень 7, результат");
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2);
        System.out.println("Время выполнения: " + duration2 + " мс");
    }

    public static void parseString(String str) {
        String[] in_string = str.split(" ");
        int base = 0;
        int pow = 0;
        double prod;

        for (int i = 0; i < in_string.length; i++) {
            in_string[i] = in_string[i].replace(",", "");
            try {
                Integer.parseInt(in_string[i].replaceAll("[^\\d-]", ""));
                if (base == 0) {
                    base = Integer.parseInt(in_string[i].replaceAll("[^\\d-]", ""));
                } else {
                    pow = Integer.parseInt(in_string[i].replaceAll("[^\\d-]", ""));
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }

        prod = Math.pow(base, pow);
        System.out.println(str + " " + String.valueOf(prod));
    }

    private static void parseStringBuilder(String str) {
        StringBuilder sb = new StringBuilder(str);
        int base = 0;
        int pow = 0;
        double prod;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ',') {
                sb.deleteCharAt(i);
            }
        }

        String[] in_string = sb.toString().split(" ");

        for (int i = 0; i < in_string.length; i++) {
            try {
                Integer.parseInt(in_string[i].replaceAll("[^\\d-]", ""));
                if (base == 0) {
                    base = Integer.parseInt(in_string[i].replaceAll("[^\\d-]", ""));
                } else {
                    pow = Integer.parseInt(in_string[i].replaceAll("[^\\d-]", ""));
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }

        prod = Math.pow(base, pow);
        System.out.println(str + " " + String.valueOf(prod));
    }
}
