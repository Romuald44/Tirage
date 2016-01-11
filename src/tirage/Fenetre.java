package tirage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import static javaprojet.JavaProjet.first_format;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
 
public class Fenetre extends JFrame {
    JButton button = new JButton ("Tirage");
    JTextArea reponse = new JTextArea();
  
  public Fenetre(){
    this.setTitle("Tirage");
    this.setSize(250, 160);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    
    JPanel top = new JPanel();
    JPanel content = new JPanel();
    
    button.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            reponse(Tirage.selection());
        }
    });
    
    Font font = new Font("Verdana", Font.BOLD, 14);
    reponse.setFont(font);
    
    top.add(button);
    content.add(reponse);
    content.setBackground(Color.WHITE);
    
    this.getContentPane().add(top, BorderLayout.NORTH);
    this.getContentPane().add(content, BorderLayout.CENTER);
    this.setVisible(true);
  }
  
  public void reponse(String rep) {
        reponse.setText(rep);
  }
}