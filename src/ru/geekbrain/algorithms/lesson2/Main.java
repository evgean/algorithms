package ru.geekbrain.algorithms.lesson2;

public class Main {
    public static void main(String[] args) {
        Array arr = new Array(1);
        for (int i = 9; i > -1; i--) {
            arr.append(i);
        }

        Array arr1 = new Array(1);
        for (int i = 9; i > -1; i--) {
            arr1.append(i);
        }

        Array arr2 = new Array(1);
        for (int i = 9; i > -1; i--) {
            arr2.append(i);
        }

        Array arr3 = new Array(1);
        for (int i = 9; i > -1; i--) {
            arr3.append(i);
        }

        arr.sortBubble();
        arr1.sortBubble2();
        arr2.sortSelect();
        arr3.sortInsert();
    }
}
