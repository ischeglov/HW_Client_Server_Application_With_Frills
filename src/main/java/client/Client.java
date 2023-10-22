package client;

import server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("netology.homework", Server.LOCALHOST_PORT);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            System.out.println(reader.readLine()); // читаем сообщение от сервера
            writer.println("Ivan"); // клиент отправляет ответ

            System.out.println(reader.readLine()); // читаем сообщение от сервера
            writer.println("yes"); // клиент отправляет ответ
            System.out.println(reader.readLine()); // читаем сообщение от сервера

//            writer.println("no");
//            System.out.println(reader.readLine());
        }
    }
}
