package tirage;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart_Total extends JFrame
{
    XML iofile = new XML();
    JButton next = new JButton ("Next");
    JButton prec = new JButton ("Prec");
    BarChart_Total chart;
    JFreeChart barChart;
    String[] nom = new String[4];
    
    static int increment = 0;
    
    public BarChart_Total( String applicationTitle , String chartTitle, int freq )
    {
        nom[0] = "Fréquence Animateur";
        nom[1] = "Fréquence Secrétaire";
        nom[2] = "Fréquence Scribe";
        nom[3] = "Fréquence Gestionnaire";
        
        switch(freq) {
            case 0:
                barChart = ChartFactory.createBarChart(
                    chartTitle,
                    "Rôles",
                    "Fréquence",
                    anim(),
                    PlotOrientation.VERTICAL,
                    true, true, false);
                break;
            case 1:
                barChart = ChartFactory.createBarChart(
                    chartTitle,
                    "Rôles",
                    "Fréquence",
                    secret(),
                    PlotOrientation.VERTICAL,
                    true, true, false);
                break;
            case 2:
                barChart = ChartFactory.createBarChart(
                    chartTitle,
                    "Rôles",
                    "Fréquence",
                    scrib(),
                    PlotOrientation.VERTICAL,
                    true, true, false);
                break;
            case 3:
                barChart = ChartFactory.createBarChart(
                    chartTitle,
                    "Rôles",
                    "Fréquence",
                    gest(),
                    PlotOrientation.VERTICAL,
                    true, true, false);
                break;
        }
       

        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );  
        this.setTitle(applicationTitle);
        this.dispose();
                
        JPanel top = new JPanel();
        JPanel body = new JPanel();
        
        body.add(chartPanel);
        top.add(prec);
        top.add(next);
        
        this.getContentPane().add(top, BorderLayout.NORTH);
        this.getContentPane().add(body, BorderLayout.CENTER);
        
        prec.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(increment>0){increment--;}
                chart = new BarChart_Total("Statistiques", nom[increment], increment);
                chart.pack();
                chart.setLocationRelativeTo(null);
                hidden();
                chart.setVisible( true );
            }
        });
        
        next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(increment<4){increment++;}
                chart = new BarChart_Total("Statistiques", nom[increment], increment);
                chart.pack();
                chart.setLocationRelativeTo(null);
                hidden();
                chart.setVisible( true );
            }
        });
    }
    
    public void hidden() {
        this.dispose();
    }
    
    private CategoryDataset anim()
    {
         final String animateur = "Animateur";
         final DefaultCategoryDataset dataset = 
         new DefaultCategoryDataset( );
         
         for(int i=1;i<12;i++) {
            dataset.addValue( iofile.freq_anim(i) , iofile.nb_to_name(i) , animateur );
         }

         return dataset;
    }
    
    private CategoryDataset secret()
    {
         final String secretaire = "Secrétaire";
         final DefaultCategoryDataset dataset = 
         new DefaultCategoryDataset( );
         
         for(int i=1;i<12;i++) {
            dataset.addValue( iofile.freq_secret(i) , iofile.nb_to_name(i) , secretaire );
         }

         return dataset;
    }
    
    private CategoryDataset scrib()
    {
         final String scribe = "Scribe";
         final DefaultCategoryDataset dataset = 
         new DefaultCategoryDataset( );
         
         for(int i=1;i<12;i++) {
            dataset.addValue( iofile.freq_scribe(i) , iofile.nb_to_name(i) , scribe );
         }

         return dataset;
    }
    
    private CategoryDataset gest()
    {
         final String gestionnaire = "Gestionnaire";
         final DefaultCategoryDataset dataset = 
         new DefaultCategoryDataset( );
         
         for(int i=1;i<12;i++) {
            dataset.addValue( iofile.freq_gest(i) , iofile.nb_to_name(i) , gestionnaire );
         }

         return dataset;
    }
}