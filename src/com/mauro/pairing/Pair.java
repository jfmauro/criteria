package com.mauro.pairing;

/**
 * Created by root on 19/11/16.
 */
public class Pair<K,V> implements  IPair<K,V>{
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}
