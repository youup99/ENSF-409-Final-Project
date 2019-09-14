package Server;

import java.io.IOException;


/**
 * Server side of the program
 * @author Youup Kim
 */
public class Server {

    public static void main(String[] args) throws IOException{
        Shop shop = new Shop();
        System.out.println("Server is running");
        shop.start();
    }
}
