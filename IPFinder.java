import javax.swing.*;
import java.awt.event.*;
import java.net.*;

public class IPFinder extends JFrame implements ActionListener {
  JLabel l;
  JTextField tf;
  JButton btn;

  // constructor
  IPFinder() {
    super("Public IP Finder");
    l = new JLabel("enter url:");
    l.setBounds(50, 70, 150, 20);
    tf = new JTextField();
    tf.setBounds(50, 100, 200, 20);

    btn = new JButton("Find IP");
    btn.setBounds(50, 150, 80, 30);
    btn.addActionListener(this);
    
    add(l);
    add(tf);
    add(btn);
    setSize(300, 300);
    setLayout(null);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    String url = tf.getText();
    try {
      InetAddress ia = InetAddress.getByName(url);
      String ip = ia.getHostAddress();
      JOptionPane.showMessageDialog(this, ip + " DDOSED!");
    } catch (UnknownHostException e1) {
      JOptionPane.showMessageDialog(this, e1.toString());
    }
  }

  public static void main(String[] args) {
    new IPFinder();
  }
}
