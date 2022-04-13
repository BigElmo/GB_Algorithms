package com.bigelmo.algorithms.lesson8;

import java.util.ArrayList;
import java.util.List;

public class MyHashTable<K, V> implements HashTable<K, V> {

    private final List<Item<K, V>>[] data;
    private int size;

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
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

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" + "key=" + key + ", value=" + value + '}';
        }
    }

    public MyHashTable(int initialCapacity) {
        this.data = new ArrayList[initialCapacity * 2];
    }

    public MyHashTable() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {
        if (size() == data.length) {
            return false;
        }

        int index = hashFunc(key);

        if (data[index] == null) {
            data[index] = new ArrayList<>();
            data[index].add(new Item<>(key, value));
            size++;
            return true;
        }

        for (Item<K, V> item : data[index]) {
            if (isKeysEquals(item, key)) {
                item.setValue(value);
                return true;
            }
        }

        data[index].add(new Item<>(key, value));
        size++;
        return true;
    }

    private boolean isKeysEquals(Item<K, V> item, K key) {
        return item.getKey().equals(key);
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);

        if (data[index] == null) {
            return null;
        }

        for (Item<K, V> item : data[index]) {
            if (isKeysEquals(item, key)) {
                return item.getValue();
            }
        }

        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);

        if (data[index] == null) {
            return null;
        }

        for (Item<K, V> item : data[index]) {
            if (isKeysEquals(item, key)) {
                Item<K, V> removed = item;
                data[index].remove(item);
                size--;
                if (data[index].isEmpty()) {
                    data[index] = null;
                }
                return removed.getValue();
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("%s = [%s]%n", i, data[i]));
        }
        return sb.toString();
    }
}
