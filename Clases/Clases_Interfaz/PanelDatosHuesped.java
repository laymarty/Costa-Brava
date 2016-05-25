package CostaBravaGUI;
														
import java.awt.*;
import javax.swing.*;
import CostaBravaMUNDO.*;
import CostaBravaMUNDO.Huesped;
import CostaBravaMUNDO.Habitacion;

//PANEL CON LA INFORMACIÓN DEL HUÉSPED
public class PanelDatosHuesped extends JPanel  {
	
	//ATRIBUTOS DE INTERFAZ
    private JTextField txtCedula;

    //Texto que contiene el nombre
    private JTextField txtNombre;

    //Texto que contiene la clase
    private JTextField txtClase;

    //Texto que contiene la ubicación
    private JTextField txtUbicacion;

    //Texto que contiene la habitación
    private JTextField txtHabitacion;
    
    //CONSTRUCTORES
    
    //Crea el panel con los datos del huésped
    public PanelDatosHuesped( Huesped huesped, Habitacion habitacion )
    {
        setLayout( new GridLayout( 5, 1, 1, 1 ) );
        setBorder( BorderFactory.createTitledBorder( "Datos del huesped" ) );

        //Cédula
        JPanel panelCedula = new JPanel( );
        panelCedula.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaCedula = new JLabel( "Cédula " );
        txtCedula = new JTextField( Integer.toString( huesped.darCedula( ) ) );
        txtCedula.setColumns( 15 );
        txtCedula.setEditable( false );
        panelCedula.add( etiquetaCedula );
        panelCedula.add( txtCedula );
        add( panelCedula );

        //Nombre
        JPanel panelNombre = new JPanel( );
        panelNombre.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaNombre = new JLabel( "Nombre " );
        txtNombre = new JTextField( huesped.darNombre( ) );
        txtNombre.setColumns( 15 );
        txtNombre.setEditable( false );
        panelNombre.add( etiquetaNombre );
        panelNombre.add( txtNombre );
        add( panelNombre );

        //Habitación
        JPanel panelHabitacion = new JPanel( );
        panelHabitacion.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaHabitacion = new JLabel( "Habitacion " );
        txtHabitacion = new JTextField( Integer.toString( habitacion.darNumero( ) ) );
        txtHabitacion.setColumns( 15 );
        txtHabitacion.setEditable( false );
        panelHabitacion.add( etiquetaHabitacion );
        panelHabitacion.add( txtHabitacion);
        add( panelHabitacion );

        //Clase
        JPanel panelClase = new JPanel( );
        panelClase.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaClase = new JLabel( "Clase " );
        String sClase;
        if( habitacion.darClase( ) == Habitacion.CLASE_PREMIUM )
        {
            sClase = "Premium";
        }
        else
        {
            sClase = "Premium";
        }
        txtClase = new JTextField( sClase );
        txtClase.setColumns( 15 );
        txtClase.setEditable( false );
        panelClase.add( etiquetaClase );
        panelClase.add( txtClase );
        add( panelClase );

        //Ubicación
        JPanel panelUbicacion = new JPanel( );
        panelUbicacion.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaUbicacion = new JLabel( "Ubicación " );
        String sUbicacion;
        if( habitacion.darUbicacion( ) == Habitacion.SINVISTA )
        {
            sUbicacion = "SinVista";
        }
        else if( habitacion.darUbicacion( ) == Habitacion.PISCINA )
        {
            sUbicacion = "Piscina";
        }
        else
        {
            sUbicacion = "Jardin";
        }
        txtUbicacion = new JTextField( sUbicacion );
        txtUbicacion.setColumns( 15 );
        txtUbicacion.setEditable( false );
        panelUbicacion.add( etiquetaUbicacion );
        panelUbicacion.add( txtUbicacion );
        add( panelUbicacion );
    }
    
}