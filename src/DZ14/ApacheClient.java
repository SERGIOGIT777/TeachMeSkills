package DZ14;

import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleHttpRequests;
import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.Future;


public class ApacheClient {
    public static void main(String[] args) throws Exception {
        CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
        httpclient.start();
        SimpleHttpRequest request1 = SimpleHttpRequests.get("http://localhost:8082");
        Future<SimpleHttpResponse> future = httpclient.execute(request1, null);

        SimpleHttpResponse response1 = future.get();
        System.out.println(request1.getRequestUri() + "->" + response1.getCode());
//        System.out.println(response1.getBodyText());
        var body = response1.getBodyText();
        File f1 = new File("./report.html");
        if (!f1.exists()) {
            File f = new File("./report.html");
            FileWriter writer = new FileWriter(f, true);
            writer.write(body);
            System.out.println("File create is this location : " + f.getAbsolutePath());
            writer.close();
            File htmlFile = new File("./report.html");
            Desktop.getDesktop().browse(htmlFile.toURI());
        } else {
            f1.delete();
            File f = new File("./report.html");
            FileWriter writer = new FileWriter(f, true);
            writer.write(body);
            System.out.println("File create is this location : " + f.getAbsolutePath());
            writer.close();
            File htmlFile = new File("./report.html");
            Desktop.getDesktop().browse(htmlFile.toURI());
        }

//        CountDownLatch latch1 = new CountDownLatch(1);
//        SimpleHttpRequest request2 = SimpleHttpRequests.get("http://localhost:8082");
//        httpclient.execute(request2, new FutureCallback<SimpleHttpResponse>() {
//
//            @Override
//            public void completed(SimpleHttpResponse response2) {
//                latch1.countDown();
//                System.out.println(request2.getRequestUri() + "->" + response2.getCode());
//            }
//
//            @Override
//            public void failed(Exception ex) {
//                latch1.countDown();
//                System.out.println(request2.getRequestUri() + "->" + ex);
//            }
//
//            @Override
//            public void cancelled() {
//                latch1.countDown();
//                System.out.println(request2.getRequestUri() + " cancelled");
//            }
//
//        });
//        latch1.await();

//        var body = response1.getBody();
//        System.out.println(body.getBodyText());


//        CountDownLatch latch2 = new CountDownLatch(1);
//        AsyncRequestProducer producer3 = AsyncRequestBuilder.get("http://localhost:8082").build();
//        AbstractCharResponseConsumer<HttpResponse> consumer3 = new AbstractCharResponseConsumer<HttpResponse>() {
//
//            HttpResponse response;
//
//            @Override
//            protected void start(HttpResponse response, ContentType contentType) throws HttpException, IOException {
//                this.response = response;
//            }
//
//            @Override
//            protected int capacityIncrement() {
//                return Integer.MAX_VALUE;
//            }
//
//            @Override
//            protected void data(CharBuffer data, boolean endOfStream) throws IOException {
//                // Do something useful
//            }
//
//            @Override
//            protected HttpResponse buildResult() throws IOException {
//                return response;
//            }
//
//            @Override
//            public void releaseResources() {
//            }
//
//        };
//        httpclient.execute(producer3, consumer3, new FutureCallback<HttpResponse>() {
//
//            @Override
//            public void completed(HttpResponse response3) {
//                latch2.countDown();
//                System.out.println(request2.getRequestUri() + "->" + response3.getCode());
//            }
//
//            @Override
//            public void failed(Exception ex) {
//                latch2.countDown();
//                System.out.println(request2.getRequestUri() + "->" + ex);
//            }
//
//            @Override
//            public void cancelled() {
//                latch2.countDown();
//                System.out.println(request2.getRequestUri() + " cancelled");
//            }
//
//        });
//        latch2.await();

    }
}
