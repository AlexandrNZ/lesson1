package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int i = new Random().nextInt(2001);
        int n = getMostSignificantBit(i);
        short[] m1 = findMultiples(n, i, Short.MAX_VALUE);
        short[] m2 = findNonMultiples(n, Short.MIN_VALUE, i);
        System.out.println("Выпавшее число: " + i);
        System.out.println("Номер старшего значащего бита: " + n);
        System.out.println("Кратные числа в диапазоне от " + i + " до " + Short.MAX_VALUE + ": " + Arrays.toString(m1));
        System.out.println("Некратные числа в диапазоне от " + Short.MIN_VALUE + " до " + i + ": " + Arrays.toString(m2));
    }

    public static int getMostSignificantBit(int num) {
        if (num == 0) {
            return 0;
        }
        int msb = 0;
        while (num > 0) {
            num = num >> 1;
            msb++;
        }
        return msb;
    }

    public static short[] findMultiples(int n, int start, int end) {
        List<Short> multiplesList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (i % Math.pow(2, n) == 0) {
                multiplesList.add((short) i);
            }
        }
        return listToArray(multiplesList);
    }

    public static short[] findNonMultiples(int n, int start, int end) {
        List<Short> nonMultiplesList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (i % Math.pow(2, n) != 0) {
                nonMultiplesList.add((short) i);
            }
        }
        return listToArray(nonMultiplesList);
    }

    public static short[] listToArray(List<Short> list) {
        short[] arr = new short[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}