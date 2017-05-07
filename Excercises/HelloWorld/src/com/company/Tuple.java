package com.company;

import java.util.Comparator;

public class Tuple<T,U> {
    protected T first;
    protected U second;

    public Tuple(T first, U second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public boolean equals(Object other){
        Tuple<T,U> tuple = (Tuple<T,U>)other;
        return getFirst().equals(((Tuple<T, U>) other).getFirst());
    }
}
