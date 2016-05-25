package CostaBravaGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import CostaBravaGUI.DialogoAsignacion;

//PANEL DE BOTONES PARA EL DIALOGO DE ASIGNACI�N
public class PanelBotonesAsignacion extends JPanel implements ActionListener {
	
	//CONSTANTES
	
	//Opci�n Aceptar
	public final static String ACEPTAR = "ACEPTAR";
	
	//Opci�n Cancelar
    public final static String CANCELAR = "CANCELAR";
    
    //ATRIBUTOS DE INTERFAZ
    
    //Bot�n aceptar
    private JButton botonAceptar;

    //Bot�n cancelar
    private JButton botonCancelar;

    //Di�logo del que hace parte el panel
    private DialogoAsignacion dialogo;
    
    //CONSTRUCTORES
    
    //Crea el panel de botones para la asignaci�n de cupo en el HOTEL
    public PanelBotonesAsignacion( DialogoAsignacion elDialogo )
    {
        setLayout( new GridLayout( 1, 2, 8, 1 ) );
        dialogo = elDialogo;

        //Aceptar
        botonAceptar = new JButton( );
        botonAceptar.setText( "Aceptar" );
        botonAceptar.setActionCommand( ACEPTAR );
        botonAceptar.addActionListener( this );
        add( botonAceptar );

        //Cancelar
        botonCancelar = new JButton( );
        botonCancelar.setText( "Cancelar" );
        botonCancelar.setActionCommand( CANCELAR );
        botonCancelar.addActionListener( this );
        add( botonCancelar );
    }
    
    // M�TODOS
    
    //Acciones de respuesta a los eventos de la interfaz
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( comando.equals( ACEPTAR ) )
        {
            dialogo.registrar( );
        }
        else if( comando.equals( CANCELAR ) )
        {
            dialogo.cancelar( );
        }
    }
}
