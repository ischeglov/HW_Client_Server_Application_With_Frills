package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final Integer LOCALHOST_PORT = 8088;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(LOCALHOST_PORT)) {
            System.out.println("Сервер стартанул");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter outWriter = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader inReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    outWriter.println("Write your name?"); // отправляем сообщение клиенту
                    String name = inReader.readLine();
                    System.out.println("Меня зовут : " + name); // читаем сообщение от клиента и выводим в консоль

                    outWriter.println("Are you child? (yes/no)"); // отправляем сообщение клиенту
                    String answer = inReader.readLine();
                    System.out.println(name + " ответил " + answer); // читаем сообщение от клиента и выводим в консоль

                    if (answer.equals("yes")) {
                        outWriter.println("Welcome to the kids area, " + name + " Let's play!");
                    } else {
                        outWriter.println("Welcome to the adult zone, " +  name + " Have a good rest, or a good working day!");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
