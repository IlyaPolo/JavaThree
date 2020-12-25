package ru.geek.brains.javathree.lessonOne.HW;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[] arr = {"adaf", "111", "2222", "3333"};

        System.out.println("first: " + Arrays.toString(arr));
        swap(arr, 0,1);
        System.out.println("swap: " + Arrays.toString(arr));

        List<String> list = arrayToList(arr);
        System.out.println("second: " + list.getClass() + ":" + list);





// Задание 3. Коробки.

        Box<Orange> orangeBox = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox1 = new Box<>();

        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        //orangeBox1.add(new Apple());
        orangeBox1.add(new Orange());

        orangeBox.info();
        orangeBox1.info();


        Float orangeBoxWeight = orangeBox.getWeight();
        Float orangeBox1Weight = orangeBox1.getWeight();

        System.out.println(orangeBox1Weight);
        System.out.println(orangeBoxWeight);

        orangeBox.fromTo(orangeBox1);









    }

// Задание 1. Смена двух элементов массива местами.
    private static <T> void swap (T[] array, int i1, int i2) {
        T t1 = array[i1];
        array[i1] = array[i2];
        array[i2] = t1;
    }

// Задание 2. Преобразование массива в ArrayList.
    private static <E> List<E> arrayToList (E[] array) {
        return Arrays.asList(array);
    }
}




