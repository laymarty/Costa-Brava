package CostaBravaGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import CostaBravaGUI.InterfazHotel;

//PANEL DE BOTONES DE INTERACCIÓN CON EL PROGRAMA DEL HOTEL
public class PanelBotonesHotel extends JPanel implements ActionListener {
	//CONSTANTES
    //Opción registrar
    public final static String REGISTRAR = "REGISTRAR_HUESPED";

    //Opción anular
    public final static String ANULAR = "ANULAR_HUESPED";

    //pción buscar
    public final static String BUSCAR = "BUSCAR_HUESPED";

    //Opción porcentaje de ocupación
    public final static String PORCENTAJE = "PORCENTAJE_OCUPACION";

    //Opción extensión 1
    private final static String OPCION_1 = "OPCION_1";

    //Opción extensión 2
    private final static String OPCION_2 = "OPCION_2";

    // ATRIBUTOS DE INTERFAZ
    
    //Botón Registro de nuevo pasajero
    private JButton bRegistro;

    //Botón Anular
    private JButton bAnular;

    //Botón de búsqueda
    private JButton bBuscarHuesped;

    //Botón porcentaje de ocupación
    private JButton bPorcOcupacion;

    //Botón de extensión 1
    private JButton botonOpcion1;

    //Botón de extensión 2
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

        //Botón registrar
        bRegistro = new JButton( "Registrar Huésped" );
        bRegistro.setActionCommand( REGISTRAR );
        bRegistro.addActionListener( this );
        bRegistro.setPreferredSize( new Dimension( 40, 10 ) );
        add( bRegistro );

        //Botón anular registro
        bAnular = new JButton( "Eliminar Huésped" );
        bAnular.setActionCommand( ANULAR );
        bAnular.addActionListener( this );
        add( bAnular );

        //Botón buscar pasajero
        bBuscarHuesped = new JButton( "Buscar Huésped" );
        bBuscarHuesped.setActionCommand( BUSCAR );
        bBuscarHuesped.addActionListener( this );
        add( bBuscarHuesped );

        //Botón porcentaje de ocupación
        bPorcOcupacion = new JButton( "Porcentaje Ocupación" );
        bPorcOcupacion.setActionCommand( PORCENTAJE );
        bPorcOcupacion.addActionListener( this );
        add( bPorcOcupacion );

        //Botones de opciones adicionales
        botonOpcion1 = new JButton( "Opción 1" );
        botonOpcion1.setActionCommand( OPCION_1 );
        botonOpcion1.addActionListener( this );
        add( botonOpcion1 );
        botonOpcion2 = new JButton( "Opción 2" );
        botonOpcion2.setActionCommand( OPCION_2 );
        botonOpcion2.addActionListener( this );
        add( botonOpcion2 );
    }
    
    //MÉTODOS

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
