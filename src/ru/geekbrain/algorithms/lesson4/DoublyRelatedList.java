package ru.geekbrain.algorithms.lesson4;

public class DoublyRelatedList {
    private static class Node {
        Cat c;
        Node next;
        Node previous;
        public Node(Cat c) {
            this.c = c;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return c.equals(node.c);
        }
        @Override
        public String toString() {
            return c.toString();
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyRelatedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertBegin(Cat c) {
        Node temp = new Node(c);
        if (head == null) {
            head = temp;
            tail = head;
        } else {
            temp.next = head;
            head.previous = temp;
            head = temp;
        }
        size++;
    }

    public void insertEnd(Cat c) {
        Node temp = new Node(c);
        if (head == null) {
            head = temp;
            tail = head;
        } else {
            tail.next = temp;
            temp.previous = tail;
            tail = temp;
        }
        size++;
    }

    public Cat remove() {
        if (isEmpty()) {
            return null;
        }
        Cat c = head.c;
        head = head.next;
        head.previous = null;
        size--;
        return c;
    }

    public Cat removeEnd() {
        if (isEmpty()) {
            return null;
        }
        Cat c = tail.c;
        tail = tail.previous;
        tail.next = null;
        size--;
        return c;
    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder sb = new StringBuilder("[ ");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? " ]" : ", ");
        }
        return sb.toString();
    }

    public boolean contains(Cat c) {
        if (isEmpty()) {
            return false;
        }
        Node current = head;
        while (!current.c.equals(c)) {
            if (current.next == null)
                return false;
            else
                current = current.next;
        }
        return true;
    }

    public boolean delete(Cat c) {
        Node n = new Node(c);
        Node current = head;
        Node previous = head;
        while (!current.equals(n)) {
            if (current.next == null)
                return false;
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) {
            head = head.next;
        } else {
            previous.next = current.next;
        }
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    public LinkInterator getIterator(){
        return new LinkInterator(this);
    }


    static class LinkInterator{
        private Node current;
        private Node previous;
        private DoublyRelatedList list;

        public LinkInterator(DoublyRelatedList list){
            this.list = list;
            current = null;
            previous = null;
            this.reset();
        }

        public void reset(){
            current = list.getHead();
            previous = null;
        }

        public boolean atEnd(){
            return (current.next == null);
        }

        public void nextLink(){
            previous = current;
            current = current.next;
        }

        public Cat getCurrent(){
            return current.c;
        }

        public void insertAfter(Cat c){
            Node temp = new Node(c);
            if (list.isEmpty()){
                list.setHead(temp);
                current = temp;
            } else {
                temp.next = current.next;
                current.next = temp;
                nextLink();
            }
        }

        public void insertBefore(Cat c){
            Node temp = new Node(c);
            if(previous == null){
                temp.next = list.getHead();
                list.setHead(temp);
                reset();
            }
            else{
                temp.next = previous.next;
                previous.next = temp;
                current = temp;
            }
        }

        public String deleteCurrent(){
            String name = current.c.getName();
            if (previous == null){
                list.setHead(current.next);
                reset();
            } else {
                previous.next = current.next;
                if (atEnd()){
                    reset();
                } else {
                    current = current.next;
                }
            }

            return name;
        }

    }
}
