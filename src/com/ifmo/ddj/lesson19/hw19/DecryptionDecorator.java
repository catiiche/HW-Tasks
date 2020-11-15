package com.ifmo.ddj.lesson19.hw19;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptionDecorator extends FilterInputStream {
    protected DecryptionDecorator(InputStream in) {
        super(in);
    }

    @Override
    public int read(byte[] b) throws IOException {
        return in.read(b);
    }

    public byte[] decrypt(byte[] b) {
        byte[] result = new byte[b.length];

        for (int i = 0; i < b.length; i++) {
            result[i] = (byte) (b[i] ^ 1);
        }
        return result;
    }
}


