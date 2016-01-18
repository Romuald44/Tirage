package tirage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
 
public class Fenetre extends JFrame {
    JButton button = new JButton ("Tirage");
    JButton stats = new JButton ("Stats");
    JButton stats_total = new JButton ("Stats Total");
    JButton b_anim = new JButton ("Animateur");
    JButton b_secre = new JButton ("Secretaire");
    JButton b_scrib = new JButton ("Scribe");
    JButton b_gest = new JButton ("Gestionnaire");
    JButton b_valide = new JButton ("Valider");
    JTextArea reponse = new JTextArea();
    XML iofile;
    
    private static BarChart_Total chart_total;
    private static BarChart_AWT chart;
    
    public Fenetre() {
        this.setTitle("Tirage");
        this.setSize(350, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        iofile = new XML();

        JPanel top = new JPanel();
        JPanel content = new JPanel();

        Font font = new Font("Verdana", Font.BOLD, 14);
        reponse.setFont(font);

        top.add(button);
        top.add(stats);
        top.add(stats_total);
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
        this.getContentPane().add(b_valide, BorderLayout.SOUTH);
        this.setVisible(true);

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                reponse.setText(Tirage.selection());
            }
        });

        stats.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                chart = new BarChart_AWT("Statistiques" , iofile.nb_to_name(0), 0);
                chart.pack();
                chart.setLocationRelativeTo(null);
                chart.setVisible( true );
            }
        });
        
        stats_total.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                chart_total = new BarChart_Total("Statistiques" , "Fréquence Animateur", 0);
                chart_total.pack();
                chart_total.setLocationRelativeTo(null);
                chart_total.setVisible( true );
            }
        });

        b_anim.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                reponse.setText(Tirage.animateur());
            }
        });

        b_secre.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                reponse.setText(Tirage.secretaire());
            }
        });

        b_scrib.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                reponse.setText(Tirage.scribe());
            }
        });

        b_gest.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                reponse.setText(Tirage.gestionnaire());
            }
        });
        
        b_valide.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                iofile.read();
                iofile.save_tab();
                
                String[] receive = null;
                receive = iofile.last_nb_save_tab().split(",");
                
                if(Integer.parseInt(receive[0]) != Tirage.getanimateur() && Integer.parseInt(receive[1]) != Tirage.getsecretaire() &&
                        Integer.parseInt(receive[2]) != Tirage.getscribe() && Integer.parseInt(receive[3]) != Tirage.getgestionnaire()) {
                    iofile.add(iofile.nb_to_name(Tirage.getanimateur()), iofile.nb_to_name(Tirage.getsecretaire()),
                            iofile.nb_to_name(Tirage.getscribe()), iofile.nb_to_name(Tirage.getgestionnaire()));
                }
            }
        });
    }
}