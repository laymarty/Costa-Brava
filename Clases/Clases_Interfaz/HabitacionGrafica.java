package CostaBravaGUI;
			
import java.awt.*;
import javax.swing.*;
import CostaBravaGUI.*;
import CostaBravaMUNDO.Habitacion;

//Representación gráfica de una habitación del hotel

public class HabitacionGrafica extends JPanel {
		
	//ATRIBUTOS
	//imagen de la silla
	private ImageIcon imagen;
	
	//CONSTRUCTORES
	//Crea la imagen de la silla mostrando si está o no ocupada
	 public HabitacionGrafica( Habitacion habitacion )
	    {
	        super( new BorderLayout( ) );
	        JLabel lHabitacion = new JLabel( );
	        if( habitacion.darClase( ) == Habitacion.CLASE_SUITEPRESIDENCIAL && habitacion.habitacionAsignada( ) )
	            imagen = new ImageIcon( "Habitacion.gif" );
	        else if( habitacion.darClase( ) == Habitacion.CLASE_SUITEPRESIDENCIAL && !habitacion.habitacionAsignada( ) )
	            imagen = new ImageIcon( "Habitacion.gif" );
	        else if( habitacion.darClase( ) == Habitacion.CLASE_SUITEPRESIDENCIAL && habitacion.habitacionAsignada( ) )
	            imagen = new ImageIcon( "Habitacion.gif" );
	        else if( habitacion.darClase( ) == Habitacion.CLASE_SUITEPRESIDENCIAL && !habitacion.habitacionAsignada( ) )
	        {
	            imagen = new ImageIcon( "Habitacion.gif" );
	            lHabitacion.setForeground( Color.white );
	        }	
	        
	        setPreferredSize( new Dimension( imagen.getIconWidth( ), imagen.getIconHeight( ) ) );
	        setOpaque( false );
	        lHabitacion.setPreferredSize( new Dimension( imagen.getIconWidth( ), imagen.getIconHeight( ) ) );
	        lHabitacion.setText( "" + habitacion.darNumero( ) );
	        lHabitacion.setHorizontalAlignment( SwingConstants.CENTER );
	        add( lHabitacion );
	    }
	
	 //MÉTODOS
	 //Dibuja la imagen de la habitación
	 public void paint( Graphics grafica )
	    {
	        grafica.drawImage( imagen.getImage( ), 0, 0, null, null );
	        super.paint( grafica );
	    }
}
