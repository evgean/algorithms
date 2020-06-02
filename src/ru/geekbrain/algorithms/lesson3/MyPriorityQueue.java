package ru.geekbrain.algorithms.lesson3;

public class MyPriorityQueue {
    private int[] queue;
    private int head;
    private int tail;
    private int size;
    private int items;

    public MyPriorityQueue(int size) {
        this.size = size;
        this.queue = new int[size];
        head = 0;
        tail = -1;
        items = 0;
    }
    public boolean isEmpty() {
        return items == 0;
    }
    public boolean isFull() {
        return items == size;
    }
    public int length() {
        return items;
    }
    public void insert(int i) {
        if (isFull()) {
            size *= 2;
            int[] temp = new int[size];
            if (tail >= head) {
                System.arraycopy(queue, 0, temp, 0, queue.length);
            } else {
                System.arraycopy(queue, 0, temp, 0, tail - 1);
                System.arraycopy(queue, head, temp,
                        size - (queue.length - head),
                        queue.length - head - 1);
                head = size - head - 1;
            }
            queue = temp;
        }
        if (tail == size - 1)
            tail = -1;
        queue[++tail] = i;
        items++;

        //может награмоздил, но copyarray не сработал как мне хотелось
        int[] temp2 = new int[items];
        if (head < tail) {
            int counter = 0;
            for (int j = head; j <= tail; j++) {
                temp2[counter] = queue[j];
                counter++;
            }
            temp2 = sortSelect(temp2);
            counter = 0;
            for (int j = head; j <= tail; j++) {
                queue[j] = temp2[counter];
                counter++;
            }
        }

    }
    public int remove() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        int temp = queue[head++];
        head %= size;
        items--;
        return temp;
    }
    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return queue[head];
    }

    public int[] sortSelect(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

}
