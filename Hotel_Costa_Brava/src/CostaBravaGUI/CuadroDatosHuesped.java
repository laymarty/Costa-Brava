package CostaBravaGUI;

import java.awt.*;
import javax.swing.*;
import CostaBravaMUNDO.*;
import CostaBravaGUI.PanelDatosHuesped;
import CostaBravaMUNDO.Huesped;
import CostaBravaGUI.PanelDatosHuesped;
import CostaBravaMUNDO.Habitacion;
import CostaBravaMUNDO.Hotel;
import CostaBravaGUI.PanelBotonesDatosHuesped;

//FORMULARIO REGISTRO DEL HUÉSPED

public class CuadroDatosHuesped extends JFrame{
	
	//ATRIBUTOS DE INTERFAZ
	
	//Panel con los botones
	private PanelBotonesDatosHuesped panelBotones;
	
	//Panel datos del huesped
	 private PanelDatosHuesped panelDatosHuesped;
	 
	 //CONSTRUCTORES
	 
	 //Crea el panel de datos del huesped
	 public CuadroDatosHuesped( Habitacion habitacion )
	    {
	        Huesped huesped = habitacion.darHuesped( );
	        setLayout( new BorderLayout( ) );

	        //Crea el panel de datos del huesped
	        panelDatosHuesped = new PanelDatosHuesped ( huesped, habitacion );
	        add( panelDatosHuesped, BorderLayout.NORTH );

	        //Crea el panel de botones
	        panelBotones = new PanelBotonesDatosHuesped( this );
	        add( panelBotones, BorderLayout.SOUTH );

	        setTitle( "Datos registro del huesped" );
	        pack( );
	        setResizable( false );
	        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
	    }
	 
	 //MÉTODOS
	 
	 //Cierra el cuadro
	 public void aceptar( )
	    {
	        dispose( );
        }
}