package com.dreamcoffee.spring.boot.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
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
        ServerSocket serverSocket = new ServerSocket(8989);

        //获取连接的客户端的socket
        Socket accept = serverSocket.accept();

        BufferedReader br = null;
        try {
            //获取服务器端的输入流对象
            br = new BufferedReader(new InputStreamReader(accept.getInputStream()));

            //读取数据
            String line ;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("网络出错");
            System.exit(-1);
        }finally {
            try {
                if (br != null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
