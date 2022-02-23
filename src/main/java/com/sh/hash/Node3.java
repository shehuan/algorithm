package com.sh.hash;

public class Node3<T, V> {
    public T key;
    public V value;
    public Node3<T, V> prev;
    public Node3<T, V> next;

    public Node3() {
    }

    public Node3(T key, V value) {
        this.key = key;
        this.value = value;
    }
}
