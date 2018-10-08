package ru.geekbrain.algorithms.lesson1;

public class Main {
    public static void main(String[] args) {
        //Возведение в степень используя и чётность степени
        //Сложность O(n)(линейная) у стандартного возведения. Возведений будет столько сколько указано
        //Используя четность сложность получается O(log n) т.к. мы будет сокращять степень столько сколько сможем.
        System.out.println(power(4,4));

        //Поиск минимального элемента в массиве
        //Сложность О(n) (линейная) т.к. сколько у нас элементов в массиве, сколько и сравниваем
        System.out.println(min(new int[]{2, 3, 7, 34, 4, 8}));

        //Нахождение среднего арифметического массива (взял инт, но нужно float, конечно)
        //Сложность О(n) (опять линейная) сколько у нас элементов в массиве, столько и сложений
        System.out.println(avarage(new int[]{2, 3, 8}));
    }

    static int power(int a, int n){
        int result = 1;
        if (a == 0) return -1;
        else if (a == 1) return result;
            //Возведение в степень используя чётность степени
        else if (n % 2 == 0) {
            int half = power(a, n/2);
            return half * 2;
        }
        else {
            for (int i = 1; i <= n; i++){
                result = result * a;
            }
        }
        return result;
    }

    static int min(int[] arr) {
        int min = arr[0];
        for(int i = 0; i != arr.length; i ++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    static int avarage(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++)
            result = result + arr[i];
        return result / arr.length;
    }

}