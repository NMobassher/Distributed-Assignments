/*
 * Nafis Mobassher 100587562
 */
import java.net.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.io.*;
/*
 * This is the server class where the server computes for the timezone of what the user wants
 */
public class Server {
/*
 * The server is set up using the class serverWorker
 */
    public static void main(String[] args) {
        Server es = new Server();
        es.run(1200);
    }
    public void run(int portNumber) {
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while (true) {
                Socket client = serverSocket.accept();
                serverWorker sw = new serverWorker(client);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
/*
 * The serverWorker class includes how the the timezone is computed by the server
 */
class serverWorker extends Thread {
    Socket client;
    PrintWriter out;
    DataInputStream x;
    DataOutputStream y;
	String time;
  	 String timezone = "";

    /*
     * Constructors
     */
    public serverWorker(Socket s) {
        client = s;


        try {;
            x = new DataInputStream(s.getInputStream());
            y = new DataOutputStream(s.getOutputStream());
        } catch (IOException e) {
            try {
                client.close();
            } catch (IOException ex) {
                System.out.println("Error" + ex);
            }
            return;
        }
        this.start(); // Thread starts here...this start() will call run()
    }

/*
 * In this method the server is reading what the user is inputting and printing out the appropriate timezone.
 * We have select cases here so that whatever the user inputs matches the timezone
 */
    public void run() {
        try {
            String timezoneConverter;
            //Date Format is how the date is formatted in the output
            	 DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");
             	Date today = Calendar.getInstance().getTime();  
                 String timezone = "";
                 time = x.readUTF();
                 System.out.println(time);

                 switch (time) {
                 	case "bdt": 
                 		TimeZone.setDefault(TimeZone.getTimeZone("BST"));
              		 	timezone = df.format(today);
              		 	break;
              		 	
                 	case "eet":
                 		TimeZone.setDefault(TimeZone.getTimeZone("EET"));           
             		 	timezone = df.format(today);
             		 	break;
             		 	
                 	case "cst":
                 		TimeZone.setDefault(TimeZone.getTimeZone("CST"));           		       
              		 	timezone = df.format(today);
              		 	break;
                 	case "sbt":
                 		TimeZone.setDefault(TimeZone.getTimeZone("SST"));          		       
              		 	timezone = df.format(today);
              		 	break;
                 	case "utc":
                 		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));          		       
              		 	timezone = df.format(today);
              		 	break;
                 	case "pdt":
                 		TimeZone.setDefault(TimeZone.getTimeZone("PST"));          		       
              		 	timezone = df.format(today);
              		 	break;
                 	case "amt":
                 		TimeZone.setDefault(TimeZone.getTimeZone("NET"));          		       
              		 	timezone = df.format(today);
              		 	break;
                 	case "mst":
                 		TimeZone.setDefault(TimeZone.getTimeZone("MST"));          		       
              		 	timezone = df.format(today);
              		 	break;
                 	case "akdt":
                 		TimeZone.setDefault(TimeZone.getTimeZone("AST"));          		       
              		 	timezone = df.format(today);
              		 	break;
                 	case "asct":
                 		TimeZone.setDefault(TimeZone.getTimeZone("ACT"));          		       
              		 	timezone = df.format(today);
              		 	break;
                 	case "cat":
                 		TimeZone.setDefault(TimeZone.getTimeZone("CAT"));          		       
              		 	timezone = df.format(today);
              		 	break;
                 	case "japan":
                 		TimeZone.setDefault(TimeZone.getTimeZone("Japan"));          		       
              		 	timezone = df.format(today);
              		 	break;
                 	case "sgt":
                 		TimeZone.setDefault(TimeZone.getTimeZone("Singapore"));          		       
              		 	timezone = df.format(today);
              		 	break;
                 	case "eat":
                 		TimeZone.setDefault(TimeZone.getTimeZone("EAT"));          		       
              		 	timezone = df.format(today);
              		 	break;
                 	case "jst":
                 		TimeZone.setDefault(TimeZone.getTimeZone("JST"));          		       
              		 	timezone = df.format(today);
              		 	break;
                 	case "idt":
                 		TimeZone.setDefault(TimeZone.getTimeZone("Israel"));          		       
              		 	timezone = df.format(today);
              		 	break;
                 	case "est":
                 		TimeZone.setDefault(TimeZone.getTimeZone("EST"));          		       
              		 	timezone = df.format(today);
              		 	break;
                 	case "edt":
                 		TimeZone.setDefault(TimeZone.getTimeZone("EST5EDT"));          		       
              		 	timezone = df.format(today);
              		 	break;
                 	case "cdt":
                 		TimeZone.setDefault(TimeZone.getTimeZone("CST"));          		       
              		 	timezone = df.format(today);
              		 	break;
                 	case "eest":
                 		TimeZone.setDefault(TimeZone.getTimeZone("EEST"));          		       
              		 	timezone = df.format(today);
              		 	break;
                 }
             	
                 System.out.println("the Time is: " + timezone);
                 //The timezone is sent to the client
                 y.writeUTF(timezone);
                 y.flush();
                 
                 client.close();
           
           
        } catch (IOException e) {
            System.out.println("Exception caught...");
            System.out.println(e.getMessage());
        }
    }
}