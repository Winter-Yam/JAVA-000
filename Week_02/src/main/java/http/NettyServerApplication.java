package http;


public class NettyServerApplication {

    public static void main(String[] args) {
        HttpServer server = new HttpServer(8801);
        try {
            server.start();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
