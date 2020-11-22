package VoIP.Server;
import java.net.serverSocket;
import java.util.Scanner;

public class Server extends Thread {
    boolean running;
    final int MAXCLIENTS = 5;
    ServerSocket serverSocket;

    public Server() {
        running = true;
        this.start();
    }

    public void run() {
        System.out.println("Server Thread has started!");
        new Quit().start();
        if (createServer()) {
            connections();
        }
        running = false;
        closeAll();
    }

    private boolean createServer() {
        try {
            serverSocket = new ServerSocket(60010);
            System.out.println("The server is created.");
            return true;
        } catch (java.net.BindException be) {
            System.out.println("This port is unavailable");
            System.out.println("Check if any other server is already open on this machine.");
        } catch (Exception e) {
            System.out.println("Could not create the server:" + e);
        }
        return false;
    }

    private void connections() {
        while (running) {
            Socket s = serverSocket.accept();
            ConnectClient cc = new ConnectClient(s);
        }
    }

    private void closeAll() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (Exception e) { }
    }

    class Quit extends Thread {
        public Quit() { }

        public void run() {
            Scanner scan = new Scanner(System.in);
            while (running) {
                String input = scan.nextLine();
                switch (input.trim().toLowerCase()) {
                    case "quit": running = false; break;
                    default: System.out.println("Error: Unknown Command");
                }
            }
        }
    }
}
