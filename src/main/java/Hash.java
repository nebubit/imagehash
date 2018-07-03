package io.github.nebubit.hashimage;

public class Hash {
    private int value;

    public Hash(int value) {
    	this.value = value;
    }

    public Hash(boolean[][] value) {
    	this.value = Integer.parseInt(value.toString());
    }

    public int distance(Hash hash) {
    	return Long.bitCount(this.value ^ hash.value);
    }
}