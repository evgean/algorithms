package ru.geekbrain.algorithms.lesson3;


public class Main {
    public static void main(String[] args) {
//        //1 part of DZ
//        MyPriorityQueue pq = new MyPriorityQueue(10);
//        pq.insert(1);
//        pq.insert(6);
//        pq.insert(3);
//        pq.insert(4);
//        pq.insert(6);
//        pq.insert(44);
//        pq.insert(3);
//        pq.insert(2);
//        pq.insert(5);
//        while(!pq.isEmpty()) {
//            System.out.println(pq.remove());
//        }
//        System.out.println();
//
//        //2 part of DZ
//        readStringRtoL("subbordinacija");

        //3 part of DZ
        Dec dec = new Dec(10);
        dec.insertHead(1);
        dec.insertHead(2);
        dec.insertHead(3);
        dec.insertTail(11);
        dec.insertTail(12);
        dec.insertHead(4);
        dec.insertHead(5);
        dec.insertHead(6);
        while(!dec.isEmpty()) {
            System.out.println(dec.removeTail());
        }
        System.out.println();
    }

    public static void readStringRtoL(String text) {
        Stack stack = new Stack(text.length());
        for (int i = 0; i < text.length(); i++) {
            stack.insert((int)text.charAt(i));
        }
        while(!stack.isEmpty()) {
            System.out.print((char)stack.remove());
        }
        System.out.println();
    }

}
