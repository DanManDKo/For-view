package com.company.mylist.list;
import com.company.mylist.list.List.Node;
/**
 * Created by DanMan on 14.12.2016.
 */
public interface SimpleIterable<E> {
    boolean hasNext();
    boolean hasPrevious();
    E next();
    E back();
}
