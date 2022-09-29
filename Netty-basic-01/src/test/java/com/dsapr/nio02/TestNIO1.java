package com.dsapr.nio02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestNIO1 {
    public static void main(String[] args) throws IOException {
        // 1. 创建 Channel 通道 FileChannel
        FileChannel channel = new FileInputStream("C:\\home\\my-project\\Netty-study\\Netty-basic-01\\data.txt").getChannel();

        // 2. 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);

        // 3. 把通道内获取的文件数据，写入缓冲区
        while (channel.read(buffer) != -1) {
            // 4. 程序读取 buffer 内容，后续的操作。设置 buffer 为读模式。
            buffer.flip();

            // 5. 循环读取缓冲区中的数据
            while (buffer.hasRemaining()) {
                byte b = buffer.get();
                System.out.println("(char)b = " + (char)b);
            }

            // 6. 设置 buffer 的写模式
            buffer.clear();
        }

    }
}
