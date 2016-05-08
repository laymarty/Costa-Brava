package hotel.interfaz;
import java.awt.*;

import javax.swing.*;

import hotel.mundo.*;





public class DialogoAsignacion extends JDialog
{

	private Hotel hotel;
	
	private InterfazHotel Ventana;
	
	private PanelBotonesAsignacion panelBotones;
	   
	private PanelDatosAsignacion panelDatos;
	   
	   
	   public DialogoAsignacion( InterfazHotel laVentana, Hotel elHotel )
	    {

	
		   hotel = elHotel;

	       
		   Ventana = laVentana;

	       
	        setLayout( new BorderLayout( ) );

	    
	        panelDatos = new PanelDatosAsignacion( );
	        add( panelDatos, BorderLayout.CENTER );

	
	        panelBotones = new PanelBotonesAsignacion( this );
	        add( panelBotones, BorderLayout.SOUTH );

	        setTitle( "Registro de Huesped" );
	        pack( );
	  
	        setDefaultCloseOperation( DISPOSE_ON_CLOSE );

	    }
	   
	   public void registrar( )
	    {
	        int cedula, clase;
	        char ubicacion;
	        String nombre, sCedula;
	        Cliente huesped;

	        nombre = panelDatos.darNombre( );
	        sCedula = panelDatos.darCedula( );

	        if( sCedula == null || sCedula.equals( "" ) )
	        {
	            JOptionPane.showMessageDialog( this, "La cédula es requerida", "Registro", JOptionPane.ERROR_MESSAGE );
	            return;
	        }

	        try
	        {
	            cedula = Integer.parseInt( sCedula );
	        }
	        catch( Exception e )
	        {
	            JOptionPane.showMessageDialog( this, "La cédula es numérica", "Registro", JOptionPane.ERROR_MESSAGE );
	            return;
	        }

	        if( nombre == null || nombre.equals( "" ) )
	        {
	            JOptionPane.showMessageDialog( this, "El nombre es requerido", "Registro", JOptionPane.ERROR_MESSAGE );
	            return;
	        }

	
	        huesped = new huesped( cedula, nombre );

	
	        Habitacion Habitacion = hotel.buscarhuesped( huesped );

	        if( Habitacion != null )
	        {
	            JOptionPane.showMessageDialog( this, "El huesped ya tiene una Habitacion asignada", "Registro", JOptionPane.ERROR_MESSAGE );
	            return;
	        }

	      
	        clase = panelDatos.darClase( );
	        ubicacion = panelDatos.darUbicacion( );
	        Habitacion = hotel.asignarHabitacion( clase, ubicacion, huesped );

	        if( Habitacion == null )
	        {
	            JOptionPane.showMessageDialog( this, "No hay Habitaciones disponibles con dichas características", "Registro", JOptionPane.ERROR_MESSAGE );
	            return;
	        }
	        ventana.actualizar( );
	        dispose( );

	    }

	
	    public void cancelar( )
	    {
	        ventana.actualizar( );
	        dispose( );
	    }

}