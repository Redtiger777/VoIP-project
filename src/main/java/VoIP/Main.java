package VoIP;

import Client.*;
import VoIP.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean done = true;
        while (done) {
            System.out.println("Would you like to start:");
            System.out.println("1. the Server");
            System.out.println("2. the Client");
            System.out.println("3. both");
            Scanner s = new Scanner(System.in);
            String ans = s.nextLine();
            switch (ans) {
                case "1": Server server = new Server(); done = false; break;
                case "2": Client client = new Client(); done = false; break;
                case "3":
                Server server = new Server();
                Client client = new Client();
                done = false;
                break;
                default: System.out.println("Please reply with only 1,2 or 3.");

            }
        }
    }
}
