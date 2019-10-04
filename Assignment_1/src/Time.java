/*
 * Nafis Mobassher 100587562
 */
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;


public class Time {

    private JFrame frame;
    private JTextField txttimeZone;
    String time;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Time window = new Time();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     This class creates the Java User Interface and creates constraints on them
     */
    public Time() {
        initialize();
    }
    /*
     * Initializes JFrame
     * */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(400, 400, 400, 580);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.red);
        frame.getContentPane().setLayout(null);
/*
 * Creating text boxes and the bounds for these text boxes 
 */
        txttimeZone = new JTextField();
        txttimeZone.addKeyListener(new KeyAdapter() {
        });
        txttimeZone.setBounds(120, 100, 100, 30);
        frame.getContentPane().add(txttimeZone);
        txttimeZone.setColumns(10);
       
        JLabel lbltimeZone = new JLabel("Enter Timezone:");
        lbltimeZone.setBounds(120, 30, 100, 40);
        frame.getContentPane().add(lbltimeZone);
/*
 * Creating a button that will compute the Time that is needed
 * Also creating an exit button for the user to exit the User Interface
 */
        JButton btngetTime = new JButton("Get time");
        btngetTime.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String timeZone = String.valueOf(txttimeZone.getText());
                EchoClient client = new EchoClient(timeZone);

                try {
                    client.startClient();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                time = client.gettime();
                JOptionPane.showMessageDialog(null, "The Time is: " + time, "Zones", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        btngetTime.setBounds(120, 220, 120, 30);
        frame.getContentPane().add(btngetTime);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        btnExit.setBounds(120, 280, 120, 30);
        frame.getContentPane().add(btnExit);
    }
}