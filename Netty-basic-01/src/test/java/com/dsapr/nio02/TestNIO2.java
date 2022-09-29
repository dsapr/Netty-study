package com.dsapr.nio02;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestNIO2 {
    public static void main(String[] args) {


        try(FileChannel channel = new RandomAccessFile("C:\\home\\my-project\\Netty-study\\Netty-basic-01\\data.txt", "rw").getChannel();) {
            ByteBuffer buffer = ByteBuffer.allocate(10);

            while (channel.read(buffer) != -1) {
                buffer.flip();

                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    System.out.println("(char)b = " + (char) b);
                }

                buffer.clear();
            }
        } catch (Exception e) {

        }
    }
}
