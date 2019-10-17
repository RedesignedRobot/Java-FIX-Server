package core;

public class Origin {

    public static void main(String[] args) {
        try {
            new Server().boot();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
