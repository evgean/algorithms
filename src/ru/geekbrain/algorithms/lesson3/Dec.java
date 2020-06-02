package ru.geekbrain.algorithms.lesson3;

public class Dec {
    private int[] queue;
    private int head;
    private int tail;
    private int size;
    private int items;

    public Dec(int size) {
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
    public void insertTail(int i) {
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
    }

    public void insertHead(int i) {
        if (isFull()){
            size *= 2;
            int[] temp = new int[size];
            if (tail >= head) {
                System.arraycopy(queue, 0, temp, 0, queue.length + 1);
            } else {
                System.arraycopy(queue, 0, temp, 0, tail - 1);
                System.arraycopy(queue, head, temp,
                        size - (queue.length - head),
                        queue.length - head - 1);
                head = size - head - 1;
            }
            queue = temp;
        }
        if (head == 0) head = size;
        queue[--head] = i;
        items++;
    }

    public int removeHead() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        int temp = queue[head++];
        head %= size;
        items--;
        return temp;
    }

    public int removeTail() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        if(tail == -1) tail = size - 1;
        int temp = queue[tail--];
        items--;
        return temp;
    }

    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return queue[head];
    }
}
