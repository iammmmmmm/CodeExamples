package http.Tcp.HellowWorld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.util.Arrays;
import java.util.Scanner;

/**
 * hi world server
 *
 * @author Iammm
 * @Time 2023/12/16 11:46
 */
public class hiWorldServer {
    private final Logger logger = LoggerFactory.getLogger(hiWorldServer.class);

    public static void main(String[] args) {
        new hiWorldServer().start();
    }

    private void start() {
        logger.info("hi world server start");
        try  {
            java.net.Socket client;
            try (ServerSocket serverSocket = new ServerSocket(8869)) {
                client = serverSocket.accept();
            }
            InputStream msgIn =client.getInputStream();
            OutputStream msgOut=client.getOutputStream();
            Thread msgInPut = new Thread(() -> {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(msgIn));
                while (true) {
                    try {
                        logger.info("Client:{}", bufferedReader.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            msgInPut.start();
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String msg = scanner.nextLine();
                try {
                    msgOut.write(msg.getBytes());
                    msgOut.write("\r\n".getBytes());
                    msgOut.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }

    }
}
