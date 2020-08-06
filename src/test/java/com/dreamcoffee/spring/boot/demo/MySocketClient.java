package com.dreamcoffee.spring.boot.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * MySocketClient
 *
 * @author Administrator
 * @date 2019/11/7
 */
public class MySocketClient {
    public static void main(String[] args) throws IOException {
        try (
                Socket socket = new Socket("127.0.0.1", 8989);
                //终端输入流
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                //socket输出流
                PrintStream ps = new PrintStream(socket.getOutputStream())
        ) {
            //读取终端的输入 将输入输出给服务器端
            String line;
            while ((line = br.readLine()) != null) {
                ps.println(line);
            }
        }
    }
}
