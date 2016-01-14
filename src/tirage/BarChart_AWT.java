package tirage;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class BarChart_AWT extends ApplicationFrame
{
    Fichier iofile = new Fichier();
    JButton next = new JButton ("Next");
    JButton prec = new JButton ("Prec");
        
    public BarChart_AWT( String applicationTitle , String chartTitle , String pers )
    {
       super( applicationTitle );        
       JFreeChart barChart = ChartFactory.createBarChart(
          chartTitle,           
          "Rôles",            
          "Fréquence",            
          createDataset(pers),          
          PlotOrientation.VERTICAL,           
          true, true, false);

        ChartPanel chartPanel = new ChartPanel( barChart );        
        chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
        setContentPane( chartPanel );
        
        JPanel top = new JPanel();
        top.add(prec);
        top.add(next);
        this.getContentPane().add(top, BorderLayout.NORTH);
        
        next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                BarChart_AWT chart = new BarChart_AWT("Statistiques" ,"Meilleur animateur", "Romuald");
                chart.pack();
                chart.setVisible( true );
            }
        });
    }
   
    private CategoryDataset createDataset(String pers)
    {
         final String animateur = "Animateur";        
         final String secretaire = "Secretaire";        
         final String scribe = "Scribe";        
         final String gestionnaire = "Gestionnaire";
         final String frequence = "Fréquence";  
         final DefaultCategoryDataset dataset = 
         new DefaultCategoryDataset( );

         dataset.addValue( iofile.freq_anim(pers) , animateur , frequence );
         dataset.addValue( iofile.freq_secret(pers) , secretaire , frequence );
         dataset.addValue( iofile.freq_scribe(pers) , scribe , frequence );
         dataset.addValue( iofile.freq_gest(pers) , gestionnaire , frequence );

         return dataset;
    }
}