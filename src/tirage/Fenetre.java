package tirage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;

//import static javaprojet.JavaProjet.first_format;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
 
public class Fenetre extends JFrame {
    JButton button = new JButton ("Tirage");
    JButton stats = new JButton ("Stats");
    JButton b_anim = new JButton ("Animateur");
    JButton b_secre = new JButton ("Secretaire");
    JButton b_scrib = new JButton ("Scribe");
    JButton b_gest = new JButton ("Gestionnaire");
    JTextArea reponse = new JTextArea();
    
    private static BarChart_AWT chart;
    
  public Fenetre(){
    this.setTitle("Tirage");
    this.setSize(350, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    
    JPanel top = new JPanel();
    JPanel content = new JPanel();
    
    Font font = new Font("Verdana", Font.BOLD, 14);
    reponse.setFont(font);
    
    top.add(button);
    top.add(stats);
    content.add(reponse);
    content.setBackground(Color.WHITE);
    
    /******************/
    JPanel b1 = new JPanel();
    b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
    b1.add(b_anim);
    
    JPanel b2 = new JPanel();
    b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
    b2.add(b_secre);
    
    JPanel b3 = new JPanel();
    b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
    b3.add(b_scrib);
    
    JPanel b4 = new JPanel();
    b4.setLayout(new BoxLayout(b4, BoxLayout.LINE_AXIS));
    b4.add(b_gest);
    
    JPanel panel_button = new JPanel();
    panel_button.setLayout(new BoxLayout(panel_button, BoxLayout.PAGE_AXIS));
    panel_button.add(b1);
    panel_button.add(b2);
    panel_button.add(b3);
    panel_button.add(b4);
		
    
    /******************/
    this.getContentPane().add(top, BorderLayout.NORTH);
    this.getContentPane().add(content, BorderLayout.WEST);
    this.getContentPane().add(panel_button, BorderLayout.EAST);
    this.setVisible(true);
    
    button.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            reponse(Tirage.selection());
        }
    });
    
    stats.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            chart = new BarChart_AWT("Statistiques" ,"Meilleur animateur", "Fabien");
            chart.pack();
            chart.setVisible( true );
        }
    });
    
    b_anim.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            reponse(Tirage.animateur());
        }
    });
    
    b_secre.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            reponse(Tirage.secretaire());
        }
    });
    
    b_scrib.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            reponse(Tirage.scribe());
        }
    });
    
    b_gest.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            reponse(Tirage.gestionnaire());
        }
    });
  }
  
  public void reponse(String rep) {
        reponse.setText(rep);
  }
}