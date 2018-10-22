package ru.geekbrain.algorithms.lesson4;

import ru.geekbrain.algorithms.lesson2.Array;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DoublyRelatedList drl = new DoublyRelatedList();
        drl.insertBegin(new Cat(2, "cat-1"));
        drl.insertBegin(new Cat(2, "cat-2"));
        System.out.println(drl);
        drl.insertEnd(new Cat(2, "cat-3"));
        System.out.println(drl);
        drl.remove();
        System.out.println(drl);
        drl.insertBegin(new Cat(2, "cat-4"));
        System.out.println(drl);
        drl.delete(new Cat(2, "cat-1"));
        System.out.println(drl);
        System.out.println(drl.removeEnd());
        System.out.println(drl.contains(new Cat(2, "cat-4")));
    }
}
