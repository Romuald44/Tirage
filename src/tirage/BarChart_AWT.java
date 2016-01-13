package tirage;
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
    
    public BarChart_AWT( String applicationTitle , String chartTitle )
    {
       super( applicationTitle );        
       JFreeChart barChart = ChartFactory.createBarChart(
          chartTitle,           
          "Category",            
          "Score",            
          createDataset(),          
          PlotOrientation.VERTICAL,           
          true, true, false);

       ChartPanel chartPanel = new ChartPanel( barChart );        
       chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
       setContentPane( chartPanel ); 
    }
   
    private CategoryDataset createDataset( )
    {
         final String animateur = "Animateur";        
         final String secretaire = "Secretaire";        
         final String scribe = "Scribe";        
         final String gestionnaire = "Gestionnaire";
         final String frequence = "Fréquence";  
         final DefaultCategoryDataset dataset = 
         new DefaultCategoryDataset( );

         dataset.addValue( iofile.freq("Romuald") , animateur , frequence );
         dataset.addValue( 1.0 , secretaire , frequence );
         dataset.addValue( 1.0 , scribe , frequence );
         dataset.addValue( 1.0 , gestionnaire , frequence );

         return dataset;
    }
}