package CostaBravaGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import CostaBravaGUI.InterfazHotel;

//PANEL DE BOTONES DE INTERACCI�N CON EL PROGRAMA DEL HOTEL
public class PanelBotonesHotel extends JPanel implements ActionListener {
	//CONSTANTES
    //Opci�n registrar
    public final static String REGISTRAR = "REGISTRAR_HUESPED";

    //Opci�n anular
    public final static String ANULAR = "ANULAR_HUESPED";

    //pci�n buscar
    public final static String BUSCAR = "BUSCAR_HUESPED";

    //Opci�n porcentaje de ocupaci�n
    public final static String PORCENTAJE = "PORCENTAJE_OCUPACION";

    //Opci�n extensi�n 1
    private final static String OPCION_1 = "OPCION_1";

    //Opci�n extensi�n 2
    private final static String OPCION_2 = "OPCION_2";

    // ATRIBUTOS DE INTERFAZ
    
    //Bot�n Registro de nuevo pasajero
    private JButton bRegistro;

    //Bot�n Anular
    private JButton bAnular;

    //Bot�n de b�squeda
    private JButton bBuscarHuesped;

    //Bot�n porcentaje de ocupaci�n
    private JButton bPorcOcupacion;

    //Bot�n de extensi�n 1
    private JButton botonOpcion1;

    //Bot�n de extensi�n 2
    private JButton botonOpcion2;

    //Interfaz principal
    private InterfazHotel cuadro;
    
    //CONSTRUCTORES
    
    //Crea el panel de botones
    public PanelBotonesHotel( InterfazHotel elCuadro )
    {
        //guarda la referencia a la ventana padre
        cuadro = elCuadro;

        //Configura propiedades visuales
        setLayout( new GridLayout( 2, 3, 8, 2 ) );
        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );

        //Bot�n registrar
        bRegistro = new JButton( "Registrar Hu�sped" );
        bRegistro.setActionCommand( REGISTRAR );
        bRegistro.addActionListener( this );
        bRegistro.setPreferredSize( new Dimension( 40, 10 ) );
        add( bRegistro );

        //Bot�n anular registro
        bAnular = new JButton( "Eliminar Hu�sped" );
        bAnular.setActionCommand( ANULAR );
        bAnular.addActionListener( this );
        add( bAnular );

        //Bot�n buscar pasajero
        bBuscarHuesped = new JButton( "Buscar Hu�sped" );
        bBuscarHuesped.setActionCommand( BUSCAR );
        bBuscarHuesped.addActionListener( this );
        add( bBuscarHuesped );

        //Bot�n porcentaje de ocupaci�n
        bPorcOcupacion = new JButton( "Porcentaje Ocupaci�n" );
        bPorcOcupacion.setActionCommand( PORCENTAJE );
        bPorcOcupacion.addActionListener( this );
        add( bPorcOcupacion );

        //Botones de opciones adicionales
        botonOpcion1 = new JButton( "Opci�n 1" );
        botonOpcion1.setActionCommand( OPCION_1 );
        botonOpcion1.addActionListener( this );
        add( botonOpcion1 );
        botonOpcion2 = new JButton( "Opci�n 2" );
        botonOpcion2.setActionCommand( OPCION_2 );
        botonOpcion2.addActionListener( this );
        add( botonOpcion2 );
    }
    
    //M�TODOS

    //Acciones de respuesta a los eventos de la interfaz
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( comando.equals( REGISTRAR ) )
        {
            cuadro.registrarHuesped( );
        }
        else if( comando.equals( ANULAR ) )
        {
        	cuadro.anularHuesped( );
        }
        else if( comando.equals( BUSCAR ) )
        {
        	cuadro.buscarHuesped( );
        }
        else if( comando.equals( PORCENTAJE ) )
        {
        	cuadro.mostrarPorcentajeOcupacion( );
        }
        else if( comando.equals( OPCION_1 ) )
        {
        	cuadro.reqFuncOpcion1( );
        }
        else if( comando.equals( OPCION_2 ) )
        {
        	cuadro.reqFuncOpcion2( );
        }
    }

}
