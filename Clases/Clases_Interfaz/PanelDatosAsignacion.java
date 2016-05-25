package CostaBravaGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import CostaBravaMUNDO.*;
import CostaBravaMUNDO.Habitacion;
import CostaBravaMUNDO.Huesped;
import CostaBravaMUNDO.Hotel;

//PANEL DE LOS DATOS DEL REGISTRO DEL HUÉSPED
public class PanelDatosAsignacion extends JPanel implements ActionListener {
	
	//CONSTANTES
	
    private final static String CLASE_SUITEPRESIDENCIAL = "Clase suitePresidencial";
    private final static String CLASE_PREMIUM = "Clase premium";
    private final static String UBICACION_JARDIN = "Jardin";
    private final static String UBICACION_PISCINA = "Piscina";
    private final static String UBICACION_SINVISTA = "SinVista";
    
    //ATRIBUTOS DE INTERFAZ
    
    //Combo de selección de la clase
    private JComboBox cbClase;

    //Combo de selección de la ubicación
    private JComboBox cbUbicacion;

    //Texto de ingreso de cédula
    private JTextField txtCedula;

    //Texto de ingreso de cédula
    private JTextField txtNombre;
    
    //CONSTRUCTORES
    //-----------------------------------------------------------------

    //Crea el panel de los datos requeridos para la asignación
    public PanelDatosAsignacion( )
    {
        setLayout( new GridLayout( 4, 1, 1, 6 ) );
        setBorder( BorderFactory.createTitledBorder( "Datos del huésped" ) );

        //Cédula
        JPanel panelCedula = new JPanel( );
        panelCedula.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaCedula = new JLabel( "Cédula " );
        txtCedula = new JTextField( );
        txtCedula.setColumns( 15 );
        panelCedula.add( etiquetaCedula );
        panelCedula.add( txtCedula );
        add( panelCedula );

        //Nombre
        JPanel panelNombre = new JPanel( );
        panelNombre.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaNombre = new JLabel( "Nombre " );
        txtNombre = new JTextField( );
        txtNombre.setColumns( 15 );
        panelNombre.add( etiquetaNombre );
        panelNombre.add( txtNombre );
        add( panelNombre );

        //Ubicación en el hotel
        JPanel pUbicacion = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
        pUbicacion.setPreferredSize( new Dimension( 250, 30 ) );
        JLabel lUbicacion = new JLabel( "Ubicación " );
        cbUbicacion = new JComboBox( );
        cbUbicacion.setAlignmentX( Component.LEFT_ALIGNMENT );
        cbUbicacion.setPreferredSize( txtCedula.getPreferredSize( ) );
        cbUbicacion.addActionListener( this );
        pUbicacion.add( lUbicacion );
        pUbicacion.add( cbUbicacion );

        //Clase de habitación
        JPanel pClase = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
        pClase.setPreferredSize( new Dimension( 250, 30 ) );
        JLabel lClase = new JLabel( "Clase " );
        cbClase = new JComboBox( );
        cbClase.setAlignmentX( Component.LEFT_ALIGNMENT );
        cbClase.addActionListener( this );
        cbClase.addItem( CLASE_PREMIUM );
        cbClase.addItem( CLASE_SUITEPRESIDENCIAL );
        cbClase.setPreferredSize( txtCedula.getPreferredSize( ) );
        pClase.add( lClase );
        pClase.add( cbClase );

        add( pClase );
        add( pUbicacion );
    }
    
    //MÉTODOS
    
    //Retorna el contenido del campo nombre en el panel
    public String darNombre( )
    {
        return txtNombre.getText( );
    }

    //Retorna el contenido del campo cédula en el panel
    public String darCedula( )
    {
        return txtCedula.getText( );
    }

    //Retorna la clase de la habitación elegida en el panel
    public int darClase( )
    {
        String sClase = ( String )cbClase.getSelectedItem( );
        if( sClase.equals( CLASE_SUITEPRESIDENCIAL ) )
            return Habitacion.CLASE_SUITEPRESIDENCIAL;
        else
            return Habitacion.CLASE_PREMIUM;
    }

    //Retorna la ubicación de la habitación elegida en el panel
    public char darUbicacion( )
    {
        String sUbicacion = ( String )cbUbicacion.getSelectedItem( );
        if( sUbicacion.equals( UBICACION_JARDIN ) )
            return Habitacion.JARDIN;
        else if( sUbicacion.equals( UBICACION_PISCINA ) )
            return Habitacion.PISCINA;
        else
            return Habitacion.SINVISTA;
    }

    //Acciones de respuesta a los eventos en el combo de las clases
     public void actionPerformed( ActionEvent evento )
    {
        if( evento.getSource( ) == cbClase )
        {
            String sClase = ( String )cbClase.getSelectedItem( );

            if( sClase.equals( CLASE_SUITEPRESIDENCIAL ) )
            {
                cbUbicacion.removeAllItems( );
                cbUbicacion.addItem( UBICACION_JARDIN );
                cbUbicacion.addItem( UBICACION_PISCINA );
            }
            else
            {
                cbUbicacion.removeAllItems( );
                cbUbicacion.addItem( UBICACION_JARDIN );
                cbUbicacion.addItem( UBICACION_SINVISTA );
                cbUbicacion.addItem( UBICACION_PISCINA );
            }
            cbUbicacion.validate( );
        }
    }
}