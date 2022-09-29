package com.dsapr.nio02;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestNIO3 {
    public static void main(String[] args) {
        try (FileChannel channel = FileChannel.open(Paths.get("C:\\home\\my-project\\Netty-study\\Netty-basic-01\\data.txt"),  StandardOpenOption.READ);) {
            ByteBuffer buffer = ByteBuffer.allocate(10);

            while (channel.read(buffer) != -1) {
                buffer.flip();

                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    System.out.println("(char)b = " + (char) b);
                }

                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }
}
