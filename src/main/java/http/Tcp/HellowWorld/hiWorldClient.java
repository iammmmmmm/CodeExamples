package http.Tcp.HellowWorld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * hi world client
 *
 * @author Iammm
 * @Time 2023/12/16 11:46
 */
public class hiWorldClient {
    private final Logger logger = LoggerFactory.getLogger(hiWorldClient.class);

    public static void main(String[] args) {
        new hiWorldClient().start();
    }

    private void start() {
        String ip = "127.0.0.1";
        try (Socket socket = new Socket(ip, 8869); InputStream msgIn = socket.getInputStream(); OutputStream msgOut = socket.getOutputStream()) {
            Thread msgInPut = new Thread(() -> {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(msgIn));
                while (true) {
                    try {
                        logger.info("Server:{}", bufferedReader.readLine());
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
