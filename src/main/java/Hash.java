package io.github.nebubit.hashimage;

import java.math.BigInteger;

public class Hash {
    private BigInteger value;

    public Hash(BigInteger value) {
        this.value = value;
    }

    public Hash(boolean[] imageValues) {
        String str = "";

        for(boolean value : imageValues) {
            str += value ? 1 : 0;
        }

        this.value = new BigInteger(str, 2);
    }

    public String toString() {
        return this.value.toString(16);
    }

    public BigInteger toBigInteger() {
        return this.value;
    }

    public int distance(Hash hash) {
        return this.value.xor(hash.toBigInteger()).bitCount();
    }
}