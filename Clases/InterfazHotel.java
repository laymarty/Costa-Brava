package hotel.interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class InterfazHotel {


    private Hotel Hotel;


    private PanelHotel panelHotel;

    private PanelBotonesHotel panelBotones;

    private DialogoAsignacion dAsignacion;


    public InterfazHotel( )
    {
      
        Hotel = new Hotel( );

        
        setLayout( new BorderLayout( ) );

        
        panelBotones = new PanelBotonesHotel( this );
        add( panelBotones, BorderLayout.NORTH );

        
        panelHotel = new PanelHotel( Hotel );
        add( panelHotel, BorderLayout.CENTER );

        String titulo = "El Avión";
        setTitle( titulo );
        pack( );
        setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }


    public void registrarhuesped( )
    {
        dAsignacion = new DialogoAsignacion( this, Hotel );
        dAsignacion.setLocation( calculaPosicionCentral( this, dAsignacion ) );
        dAsignacion.setModal( true );
        dAsignacion.setVisible( true );
        actualizar( );
    }

    public void anularhuesped( )
    {
       
        int cedula;
        String sCedula = JOptionPane.showInputDialog( this, "Ingrese el número de cédula" );
        try
        {
            cedula = Integer.parseInt( sCedula );
        }
        catch( NumberFormatException e )
        {
            JOptionPane.showMessageDialog( this, "Error en el número de cédula.", "Anulación", JOptionPane.ERROR_MESSAGE );
            return;
        }

        huesped huesped = new huesped( cedula, "no importa" );
        if( !Hotel.desasignarhabitacion( huesped ) )
        {
            JOptionPane.showMessageDialog( this, "El huesped no tenía habitacion asignada", "Anulación", JOptionPane.ERROR_MESSAGE );
            return;
        }

        actualizar( );
    }


    public void mostrarPorcentajeOcupacion( )
    {
        double porcentaje;
        porcentaje = Hotel.calcularPorcentajeOcupacion( );
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "###.##" );
        JOptionPane.showMessageDialog( this, "El porcentaje de ocupación es " + df.format( porcentaje ) + "%", "Ocupación del avión", JOptionPane.INFORMATION_MESSAGE );
    }


    public void buscarhuesped( )
    {
       
        int cedula;
        String sCedula = JOptionPane.showInputDialog( this, "Ingrese el número de cédula" );
        try
        {
            cedula = Integer.parseInt( sCedula );
        }
        catch( NumberFormatException e )
        {
            JOptionPane.showMessageDialog( this, "Error en el número de cédula.", "Anulación", JOptionPane.ERROR_MESSAGE );
            return;
        }
        huesped huesped = new huesped( cedula, "no importa" );

        habitacion habitacion = Hotel.buscarhuesped( huesped );

        if( habitacion != null )
        {
            VentanaDatoshuesped vDatos = new VentanaDatoshuesped( habitacion );
            vDatos.setLocation( calculaPosicionCentral( this, vDatos ) );
            vDatos.setVisible( true );

        }
        else
        {
            JOptionPane.showMessageDialog( this, "El huesped no se encuentra registrado", "Búsqueda registro", JOptionPane.INFORMATION_MESSAGE );
            return;
        }
    }

    public void reqFuncOpcion1( )
    {
        String respuesta = Hotel.metodo1( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }


    public void reqFuncOpcion2( )
    {
        String respuesta = Hotel.metodo2( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    public void actualizar( )
    {
        remove( panelHotel );

       
        panelHotel = new PanelHotel( Hotel );
        add( panelHotel, BorderLayout.CENTER );
        validate( );
    }


    private Point calculaPosicionCentral( Component componentePadre, Component componenteHijo )
    {

        
        Dimension tamanhoPantalla = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int maxY = tamanhoPantalla.height;
        int minY = 0;

        Dimension tamanhoPadre = componentePadre.getSize( );
        Point locacionPadre = componentePadre.getLocation( );
        Dimension tamanhoHijo = componenteHijo.getSize( );
        int x = ( tamanhoPadre.width - tamanhoHijo.width ) / 2 + locacionPadre.x;
        int y = ( tamanhoPadre.height - tamanhoHijo.height ) / 2 + locacionPadre.y;

      
        if( y + tamanhoHijo.height > maxY )
        {
            y = maxY - tamanhoHijo.height;
        }

    
        if( y < minY )
        {
            y = 0;
        }
        return new Point( x, y );
    }


    public static void main( String[] args )
    {
        InterfazHotel interfaz = new InterfazHotel( );
        interfaz.setVisible( true );
    }
}
