/**
 * Домашняя работа к уроку 1 "Java 3"
 *
 * @author Андрей Семенюк
 * @version 06.09.2019
 */

/*

1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);

2. Написать метод, который преобразует массив в ArrayList;

3. Большая задача:

   a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)

   b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку
   нельзя сложить и яблоки, и апельсины;

   c. Для хранения фруктов внутри коробки можете использовать ArrayList;

   d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
   (вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);

   e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут
   в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем
   сравнивать с коробками с апельсинами);

   f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку
   фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в
   другую перекидываются объекты, которые были в этой коробке;

   g. Не забываем про метод добавления фрукта в коробку.

* */

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String str[] = {"A", "B", "C", "D", "E"};
        Integer i[] = {1, 2, 3, 4, 5};
        SwapElements<String> swStr = new SwapElements<>(str);
        SwapElements<Integer> swInt = new SwapElements<>(i);

        System.out.println(Arrays.toString(swStr.getArray()));
        swStr.swap(1, 4);
        System.out.println(Arrays.toString(swStr.getArray()));

        System.out.println(Arrays.toString(swInt.getArray()));
        swInt.swap(1, 4);
        System.out.println(Arrays.toString(swInt.getArray()));

        Integer ints[] = {1, 2, 3, 4, 5};
        Double dbls[] = {1.1, 2.2, 3.3, 4.4, 5.5};

        ArrayToArrayList<Integer> intToList = new ArrayToArrayList<>(ints);
        ArrayToArrayList<Double> dblsToList = new ArrayToArrayList<>(dbls);
        System.out.println();
        System.out.println(intToList.convert());
        System.out.println(intToList.getArray().getClass());
        System.out.println(dblsToList.convert());
        System.out.println(dblsToList.getArray().getClass());

        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Apple> appleBox3 = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        for (int j = 0; j < 10; j++) {
            appleBox.add(new Apple());
            appleBox2.add(new Apple());
            appleBox3.add(new Apple());
            orangeBox.add(new Orange());
        }

        System.out.println();
        System.out.println("Weight of apple box1: " + appleBox.getWeight());
        System.out.println("Weight of apple box2: " + appleBox.getWeight());
        System.out.println("Weight of apple box3: " + appleBox.getWeight());
        System.out.println("Weight of orange box: " + orangeBox.getWeight());

        System.out.println(appleBox.compareWeight(orangeBox));
        System.out.println(appleBox.compareWeight(appleBox));

        appleBox3.moveFrom(appleBox2);
        appleBox.moveFrom(appleBox2);
        System.out.println("Weight of apple box1: " + appleBox.getWeight());
        System.out.println("Weight of apple box2: " + appleBox2.getWeight());
        System.out.println("Weight of apple box3: " + appleBox3.getWeight());
    }

}
