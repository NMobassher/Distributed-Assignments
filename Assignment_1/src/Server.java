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

    public String timezoneConverter(String n) {
 	 /*
 	  * A format to create the date
 	  */
   	 DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");
   	 String timezone = "";
   	 
   	 //All the cases in which a user can type a timezone to get the appropriate one.
 	   if (n.equalsIgnoreCase("bst")){
 		 	TimeZone.setDefault(TimeZone.getTimeZone("BST"));
 		 	Date today = Calendar.getInstance().getTime();        
 		 	timezone = df.format(today);
  		}
 	   if (n.equalsIgnoreCase("eest")){
 	 		TimeZone.setDefault(TimeZone.getTimeZone("EET"));
 	 		Date today = Calendar.getInstance().getTime();        
 		 	timezone = df.format(today);
 		}	        	 
 	   if (n.equalsIgnoreCase("cest")){
 	        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Andorra"));
 	        Date today = Calendar.getInstance().getTime();        
 		 	timezone = df.format(today);
 	 	}
 	   if (n.equalsIgnoreCase("cdt")){
 	 		TimeZone.setDefault(TimeZone.getTimeZone("CST"));
 	 		Date today = Calendar.getInstance().getTime();        
 		 	timezone = df.format(today);
 		}	        	 
 	   if (n.equalsIgnoreCase("eat")){
         	TimeZone.setDefault(TimeZone.getTimeZone("EAT"));
         	Date today = Calendar.getInstance().getTime();        
 		 	timezone = df.format(today);
  		}
 	   if (n.equalsIgnoreCase("gst")){ //South Georgia Time
      		TimeZone.setDefault(TimeZone.getTimeZone("Atlantic/South_Georgia"));
      		Date today = Calendar.getInstance().getTime();        
 		 	timezone = df.format(today);
 		}
 	   if (n.equalsIgnoreCase("sgt")){
    			TimeZone.setDefault(TimeZone.getTimeZone("Singapore"));
    			Date today = Calendar.getInstance().getTime();        
 		 	timezone = df.format(today);
 		}  
 	   if (n.equalsIgnoreCase("edt")){
 	        TimeZone.setDefault(TimeZone.getTimeZone("EST5EDT")); 
 	        Date today = Calendar.getInstance().getTime();        
 		 	timezone = df.format(today);
 	 	}
 	   if (n.equalsIgnoreCase("est")){
 	        TimeZone.setDefault(TimeZone.getTimeZone("EST"));
 	        Date today = Calendar.getInstance().getTime();        
 		 	timezone = df.format(today);
 	 	}
 	   if (n.equalsIgnoreCase("idt")){ //Israel Time
       			TimeZone.setDefault(TimeZone.getTimeZone("Israel"));
       			Date today = Calendar.getInstance().getTime();        
     		 	timezone = df.format(today);
 			}
 	   if (n.equalsIgnoreCase("jst")){
 	 			TimeZone.setDefault(TimeZone.getTimeZone("JST"));
 	 			Date today = Calendar.getInstance().getTime();        
 			 	timezone = df.format(today);
 			}
 	   if (n.equalsIgnoreCase("ast")){
 	 			TimeZone.setDefault(TimeZone.getTimeZone("PRT"));
 	 			Date today = Calendar.getInstance().getTime();        
 			 	timezone = df.format(today);
 		} 	 
 	   if (n.equalsIgnoreCase("cat")){
 	 			TimeZone.setDefault(TimeZone.getTimeZone("CAT"));
 	 			Date today = Calendar.getInstance().getTime();        
 			 	timezone = df.format(today);
 		} 	 
 	   if (n.equalsIgnoreCase("acst")){
 	 			TimeZone.setDefault(TimeZone.getTimeZone("ACT"));
 	 			Date today = Calendar.getInstance().getTime();        
 			 	timezone = df.format(today);
 		} 	 
 	   if (n.equalsIgnoreCase("akdt")){
 	 			TimeZone.setDefault(TimeZone.getTimeZone("AST"));
 	 			Date today = Calendar.getInstance().getTime();        
 			 	timezone = df.format(today);
 		} 	 
 	   if (n.equalsIgnoreCase("mst")){
 	 			TimeZone.setDefault(TimeZone.getTimeZone("MST"));
 	 			Date today = Calendar.getInstance().getTime();        
 			 	timezone = df.format(today);
 		} 	 
 	   if (n.equalsIgnoreCase("amt")){//Armenia Time
 	 			TimeZone.setDefault(TimeZone.getTimeZone("NET"));
 	 			Date today = Calendar.getInstance().getTime();        
 			 	timezone = df.format(today);
 		} 	 
 	   if (n.equalsIgnoreCase("pdt")){
 	 			TimeZone.setDefault(TimeZone.getTimeZone("PST"));
 	 			Date today = Calendar.getInstance().getTime();        
 			 	timezone = df.format(today);
 		} 	 
 	   if (n.equalsIgnoreCase("utc")){
 	 			TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
 	 			Date today = Calendar.getInstance().getTime();        
 			 	timezone = df.format(today);
 		} 	 
 	   if (n.equalsIgnoreCase("sbt")){
 	 			TimeZone.setDefault(TimeZone.getTimeZone("SST"));
 	 			Date today = Calendar.getInstance().getTime();        
 			 	timezone = df.format(today);
 		}
 	   return timezone;
 	   }
/*
 * In this method the server is reading what the user is inputting and printing out the appropriate timezone.
 */
    public void run() {
        try {
            String timezoneConverter;
			String time;

            time = x.readUTF();
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");
            String timezone = "";
            if (time == "bst") {
            	TimeZone.setDefault(TimeZone.getTimeZone("BST"));
     		 	Date today = Calendar.getInstance().getTime();        
     		 	timezone = df.format(today);
            }
            System.out.println("the Time is: " + timezone);
			timezoneConverter = timezoneConverter(timezone);

            y.writeUTF((String) timezone);
            y.flush();
            
            client.close();
        } catch (IOException e) {
            System.out.println("Exception caught...");
            System.out.println(e.getMessage());
        }
    }
}