package ru.geekbrain.algorithms.lesson2;

public class Array {
    private int arr[];
    private int size;
    private boolean isSorted;

    private Array() {
        isSorted = false;
    }

    public Array(int size) {
        this();
        this.size = 0;
        this.arr = new int[size];
    }

    public Array(int... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    public int length() {
        return size;
    }

    public int get(int index) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    public void set(int index, int value) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;
        isSorted = false;
    }

    public void append(int value) {
        if (size >= arr.length) {
            int[] temp = arr;
            arr = new int[size * 2];
            System.arraycopy(temp, 0, arr, 0, size);
        }
        arr[size++] = value;
        isSorted = false;
    }

    /**
     * Deletes the last value in array
     */
    boolean delete() {
        if (size == 0) return false;
        size--;
        return true;
    }

    boolean delete(int index) { // by index
        if (size == 0) return false;
        size = index; // deleted include index
        return true;
    }

    boolean deleteAll(int value) { // by value
        if (size == 0) return false;
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) delete(i); //don't need others as we can't have "holes" in arr
        }
        return true;
    }

    void deleteAll() { // clear array
        size = 0;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder b = new StringBuilder("[");
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (i == size - 1)
                return b.append("]").toString();
            b.append(", ");
        }
    }

    /**
     * Search
     */
    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public boolean hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("Try the 'find' method");
        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            // n >> k == n / 2 ^ k
            m = (l + r) >> 1; // 8 = 00001000 >> 1 = 00000100 = 4
            if (value == arr[m])
                return true;
            else if (value < arr[m])
                r = m;
            else
                l = m + 1;
        }
        return false;
    }

    /**
     * Sort
     */
    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //Судя по каунтеру при худшем расладе количество операций примерно в 4 раза больше т.е. n^2 + n^2
    public void sortBubble() {
        int couter = 0;
        double in = System.currentTimeMillis();
        boolean swapped;
        for (int i = 0; i < size; i++) {
            swapped = false;
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                    swapped = true;
                    couter++;
                }
            }
            if (!swapped) break;
        }
        System.out.println(System.currentTimeMillis() - in);
        System.out.println("buuble counter: " + couter);
        isSorted = true;
    }

    //old version for comparison
    //Судя по каунтеру при худшем расладе количество операций примерно в 4 раза больше т.е. n^2 + n^2
    public void sortBubble2() {
        int couter = 0;
        double in = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                    couter++;
                }
            }
        }
        System.out.println(System.currentTimeMillis() - in);
        System.out.println("buuble2 counter: " + couter);
        isSorted = true;
    }

    //Судя по каунтеру при худшем расладе количество операций примерно в 2 раза больше т.е. n^2
    public void sortSelect() {
        int couter = 0;
        for (int flag = 0; flag < size; flag++) {
            int cMin = flag;
            for (int rem = flag + 1; rem < size; rem++) {
                if (arr[rem] < arr[cMin]) {
                    cMin = rem;
                    couter++;
                }
            }
            swap(flag, cMin);
        }
        System.out.println("sortSelect counter: " + couter);
        isSorted = true;
    }

    //Судя по каунтеру при худшем расладе количество операций примерно в 4 раза больше т.е. n^2 + n^2 
    public void sortInsert() {
        int couter = 0;
        int in;
        for (int out = 0; out < size; out++) {
            int temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
                couter++;
            }
            arr[in] = temp;
        }
        System.out.println("sortInsert counter: " + couter);
        isSorted = true;
    }

}
