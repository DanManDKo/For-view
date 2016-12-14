package com.company.mylist;

import com.company.mylist.list.List;



/**
 * Created by DanMan on 13.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new List<>();
        List.Iterator iterator = list.getIterator();
        list.add(1);
        list.add(2);
        list.add(3);
        while (iterator.hasNext())
            System.out.println(iterator.next());
        System.out.println();
        while (iterator.hasPrevious())
            System.out.println(iterator.back());
        System.out.println();

    }
}
