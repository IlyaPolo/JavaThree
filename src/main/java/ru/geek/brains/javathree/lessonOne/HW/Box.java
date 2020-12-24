package ru.geek.brains.javathree.lessonOne.HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public Box() {
        list = new ArrayList<T>();
    }

    void add(T obj) {
        list.add(obj);
    }

    void info(){
        if (list.isEmpty()){
            System.out.println("Коробка пуста");
        } else {
            System.out.println("В коробке находятся " + list.get(0).toString() + " в количестве: " + list.size());
        }
    }

    float getWeight() {
        if (list.isEmpty()) {
            return 0;
        } else {
            return list.size()*list.get(0).getWeight();
        }
    }

    void fromTo(Box<T> box) {
        box.getList().addAll(list);
        list.clear();
    }

    boolean compare(Box<? extends Fruit> box) {
        return this.getWeight() == box.getWeight();
    }
}