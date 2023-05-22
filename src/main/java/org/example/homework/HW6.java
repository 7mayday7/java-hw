package org.example.homework;

import java.util.*;

public class HW6 {
    public static void main(String[] args) {
        mySet mySet = new mySet();

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };

        myTreeSet myTreeSet = new myTreeSet(comparator);
        // mySet.add(7);
        for (int i = 0; i < 5; i++) {
            mySet.add(new Random().nextInt(10));
            myTreeSet.add(new Random().nextInt(10));
        }

        System.out.println(mySet.contains(7));
        System.out.println(Arrays.toString(mySet.toArray()));

        Iterator<Integer> iterator = myTreeSet.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();
        System.out.println(mySet.getItem( 3));
    }
}

class mySet {

    private static final Object OBJECT = new Object();
    private LinkedHashMap<Integer, Object> hashMap = new LinkedHashMap<>();


    public synchronized boolean add(int num) {
        return hashMap.put(num, OBJECT) == null;
    }


    public boolean contains(int num) {
        return hashMap.containsKey(num);
    }

    public Object[] toArray() {
        return hashMap.keySet().toArray();
    }

    public Iterator<Integer> iterator() {
        return hashMap.keySet().iterator();
    }

    public Integer getItem(int index){
        return (Integer) toArray()[index];
    }
}

class myTreeSet{
    private Comparator<Integer> comparator;
    public myTreeSet(Comparator<Integer> comp){
        comparator = comp;
    }
    private TreeMap<Integer, Object> treeMap = new TreeMap<>(comparator);
    //    private TreeMap<Integer, Object> treeMap = new TreeMap<>(comparator);
    private static final Object OBJECT = new Object();

    public synchronized boolean add(int num) {
        return treeMap.put(num, OBJECT) == null;
    }


    public boolean contains(int num) {
        return treeMap.containsKey(num);
    }

    public Object[] toArray() {
        return treeMap.keySet().toArray();
    }

    public Iterator<Integer> iterator() {
        return treeMap.keySet().iterator();
    }

    public Integer getItem(int index){
        return (Integer) toArray()[index];
    }
}


