package main.assignment3.impl;

public class MapEntryImpl<K, V> {

    private K key;
    private V value;
    private boolean isActive;

    public MapEntryImpl(K key, V value, boolean isActive) {
	this.key = key;
	this.value = value;
	this.isActive = isActive;
    }

    public K getKey() {
	return key;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean bool) {
        this.isActive = bool;
    }

    public void setKey(K key) {
	this.key = key;
    }

    public V getValue() {
	return value;
    }

    public void setValue(V value) {
	this.value = value;
    }
}
