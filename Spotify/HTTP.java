package advisor;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

// Basic HTTP 

public class HTTP {
    public static void main(String[] args) {
        runHTTP();
    }

    private static void runHTTP() {
        try{
            HttpServer server = HttpServer.create();
            server.bind(new InetSocketAddress(8080), 0);
            server.createContext("/",
                    exchange -> {
                        String hello = "hello, world";
                        exchange.sendResponseHeaders(200, hello.length());
                        exchange.getResponseBody().write(hello.getBytes());
                        exchange.getResponseBody().close();
                    }
            );
            server.start();

        }catch (IOException e){
            System.out.println("Bye");
        }

    }
}
