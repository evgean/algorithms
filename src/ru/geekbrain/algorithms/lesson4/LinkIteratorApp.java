package ru.geekbrain.algorithms.lesson4;

public class LinkIteratorApp {

    public static void main(String[] args) {
        DoublyRelatedList list = new DoublyRelatedList();

        DoublyRelatedList.LinkInterator itr = new DoublyRelatedList.LinkInterator(list);

        itr.insertAfter(new Cat (1, "cat-1"));
        itr.insertBefore(new Cat (1, "cat-2"));

        System.out.println(list);
    }

}
