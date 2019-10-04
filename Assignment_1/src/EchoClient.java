/*
 * Nafis Mobassher 100587562
 * This is the client handler class where the client receives the input of the text boxes from the Time class and sends it over to the Server side.
 * In this class the client also receives the output and prints out the timezone.
 */
import java.io.*;

import java.net.*;

public class EchoClient {

	DataInputStream dis;
    DataOutputStream dos;
    String timeZone;
	String time;
    Socket sock;

    public EchoClient(String timeZone) {

        this.timeZone = timeZone;
    }
//Method to get time from the Time class
    public String gettime() {
        return time;
    }
    /*
     * Makes the connection by using the Data Input/Output Stream and prints out the time in the Client command line.
     * Sends input to the server
     * Receives output from the server and prints it.
     */
    public void startClient() throws IOException {
        sock = new Socket("localhost", 1200);
        dis = new DataInputStream(sock.getInputStream());
        dos = new DataOutputStream(sock.getOutputStream());
        dos.writeUTF(timeZone);
        dos.flush();
        time = dis.readUTF();

        System.out.println("The Time is: " + time);
    }
}