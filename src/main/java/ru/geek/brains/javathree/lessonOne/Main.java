package ru.geek.brains.javathree.lessonOne;

public class Main {
    public static void main(String[] args) {
        BoxGen<Integer> bg1 = new BoxGen<>(10);
        BoxGen<Integer> bg2 = new BoxGen<>(30);

        int sum = bg1.getObj() + bg2.getObj();
        System.out.println(sum);

    }

    private static void simpleBoxEx(){
        SimpleBox box1 = new SimpleBox(10);
        SimpleBox box2 = new SimpleBox(20);

        box1.setObj(100);

        if (box1.getObj() instanceof Integer && box2.getObj() instanceof Integer) {
            int sum = (int)box1.getObj() + (int)box2.getObj();
            System.out.println("summa: " + sum);
        }
    }
}
