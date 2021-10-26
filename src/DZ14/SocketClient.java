package DZ14;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws IOException {
            try {
                Socket client = new Socket("localhost", 8082);

                var inputstream = client.getInputStream();
                var outputstream = client.getOutputStream();
                var request = new StringBuilder();
                request.append("GET /src/DZ14 HTTP/1.1\r\n");
                request.append("Host: localhost\r\n");
                request.append("Content-type: text/html\r\n\r\n");


                outputstream.write(request.toString().getBytes());
                outputstream.flush();
                Thread.sleep(1000);
//                int i = 0;
                var response = new StringBuilder();
                var symbols = inputstream.readAllBytes();
                for (int i = 0; i<symbols.length; i++){
                    response.append((char) symbols[i]);
                }
//                while ((i = inputstream.read()) != -1) {
//                    response.append((char) i);
//                    System.out.println(i);
//
//
//                }
                System.out.println("this is response - " + response);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

}
