/*
 * Nafis Mobassher 100587562
 */
import java.io.*;
import java.net.*;
/*
 * This is the Client Handler Class
 */
public class EchoClient {

    private String timeZone;
	String time;
    Socket sock;
    DataInputStream dis;
    DataOutputStream dos;

    public EchoClient(String timeZone) {

        this.timeZone = timeZone;
    }

    public String gettime() {
        return time;
    }
    /*
     * Makes the connection by using the Data Input/Output Stream and prints out the time in the Client command line.
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