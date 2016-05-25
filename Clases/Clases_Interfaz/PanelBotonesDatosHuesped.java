package CostaBravaGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import CostaBravaGUI.CuadroDatosHuesped;

//PANEL DE BOTONES DEL CUADRO DE INFORMACI�N DEL HU�SPED
public class PanelBotonesDatosHuesped extends JPanel implements ActionListener {
	 
	// CONSTANTES
	
	//Opci�n Aceptar
    public final static String ACEPTAR = "ACEPTAR";

    // Atributos de interfaz
    //Ventana principal
    private CuadroDatosHuesped cuadro;

    //Bot�n aceptar
    private JButton botonAceptar;
    
    //CONSTRUCTORES
    //-----------------------------------------------------------------

    //Crea el panel de botones de la ventana de datos del pasajero
    public PanelBotonesDatosHuesped( CuadroDatosHuesped elCuadro )
    {
        setLayout( new GridLayout( 1, 2, 10, 1 ) );
        cuadro = elCuadro;

        //Aceptar
        botonAceptar = new JButton( );
        botonAceptar.setText( "Aceptar" );
        botonAceptar.setActionCommand( ACEPTAR );
        botonAceptar.addActionListener( this );
        add( botonAceptar );
    }
    
    //M�TODOS
    //Acciones de respuesta a los eventos de la interfaz
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( comando.equals( ACEPTAR ) )
        {
            cuadro.aceptar( );
        }
    }


}
