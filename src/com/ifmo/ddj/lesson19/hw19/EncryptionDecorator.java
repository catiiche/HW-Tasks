package com.ifmo.ddj.lesson19.hw19;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryptionDecorator extends FilterOutputStream {
    public EncryptionDecorator(OutputStream out) {
        super(out);
    }

    @Override
    public void write(byte[] b) throws IOException {
        byte[] arrEncrypt = encrypt(b);
        out.write(arrEncrypt);
    }

    public byte[] encrypt(byte[] b) throws IOException {

        byte[] result = new byte[b.length];

        for (int i = 0; i < b.length; i++) {
            result[i] = (byte) (b[i] ^ 1);
        }
        return result;
    }
}






