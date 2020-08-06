package com.dreamcoffee.spring.boot.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * MySocketServer
 *
 * @author Administrator
 * @date 2019/11/7
 */
public class MySocketServer {
    public static void main(String[] args) throws IOException {
        try (
                ServerSocket serverSocket = new ServerSocket(8989);
                // 获取连接的客户端的socket
                Socket accept = serverSocket.accept();
                // 获取服务器端的输入流对象
                BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()))
        ) {
            // 读取数据
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
