package core;

public class Origin {

    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.boot();
            server.repeat();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
