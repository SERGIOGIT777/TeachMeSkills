package DZ13_ServerFTP;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class SocketProcessor implements Runnable {
    private final InputStream inputStream;
    private final OutputStream outputStream;

    public SocketProcessor(Socket socket) throws IOException {
        this.inputStream = socket.getInputStream();
        this.outputStream = socket.getOutputStream();
    }

    @Override
    public void run() {
        try {
            File file0 = new File("./");
            File file = new File(file0, doRequest());
            if (file.exists()) {
                doResponse(file);
            }
        } catch (Throwable exception) {
            exception.printStackTrace();
        }
    }

    public String doRequest() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String result = reader.readLine();
        var res = result.split(" ");
        result = res[1].substring(1);
        return result;
    }

    public void doResponse(File file) throws Throwable {
        var builder = new StringBuilder();
        if (file.isDirectory()) {
            var listDirectory = file.listFiles();
            for (int i = 0; i < Objects.requireNonNull(listDirectory).length; i++) {
                builder.append("<a href =\"");
                builder.append(file.getName());
                builder.append(listDirectory[i].getAbsolutePath().replace(file.getAbsolutePath(), ""));
                builder.append("\">");
                builder.append(listDirectory[i].getName());
                builder.append("</a>");
                builder.append("<br>");
            }
           writeResponseForDirectory(builder.toString());
        } else {
            writeResponse(file);
//            var bufferedReader = new BufferedReader(new FileReader(file));
//            int x;
//            while ((x=bufferedReader.read())!=-1){
//                builder.append((char) x);
//            }
//            writeResponseForFile(builder.toString());
        }


    }

    private void writeResponseForDirectory(String s) throws Throwable {
        String response = "HTTP/1.1 200 OK\r\n" +
                "Server: YarServer/2009-09-09\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: " + s.length() + "\r\n" +
                "Connection: close\r\n\r\n";
        String result = response + s;
        outputStream.write(result.getBytes());
        outputStream.flush();
    }

//    private void writeResponseForFile(String s) throws Throwable {
//        String response = "HTTP/1.1 200 OK\r\n" +
//                "Server: YarServer/2009-09-09\r\n" +
////                "Content-Type: application/octet-stream\r\n" + // --- download file
//                "Content-Type: text/plain\r\n" +
//                "Content-Length: " + s.length() + "\r\n" +
//                "Connection: close\r\n\r\n";
//        String result = response + s;
//        outputStream.write(result.getBytes());
//        outputStream.flush();
//    }

    public void writeResponse(File file) throws IOException {
        String response = "HTTP/1.1 200 OK\r\n" +
                "Server: YarServer/2009-09-09\r\n" +
                getContentType(file) +
                "Content-Length: " + file.length() + "\r\n" +
                "Connection: close\r\n\r\n";

        outputStream.write(response.getBytes());
        outputStream.write(Files.readAllBytes(Paths.get(file.getPath())));
        outputStream.flush();
    }

    private String getContentType(File file) {
        System.out.println(file.getName());
        var fileNameWords = file.getName().split("\\.");
        var suffix = fileNameWords[fileNameWords.length - 1];
        switch (suffix) {
            case "txt", "java" -> {
                return "Content-Type: text/plain; charset=UTF-8\r\n";
            }
            case "png" -> {
                return "Content-Type: image/png\r\n";
            }
            default -> {
                return "Content-Type: application/octet-stream\r\n";
            }
        }
    }
}