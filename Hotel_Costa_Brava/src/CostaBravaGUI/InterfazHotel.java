package CostaBravaGUI;

import java.awt.*;
import java.text.*;
import javax.swing.*;
import CostaBravaMUNDO.*;
import CostaBravaGUI.DialogoAsignacion;
import CostaBravaGUI.InterfazHotel;
import CostaBravaGUI.PanelHotel;
import CostaBravaGUI.CuadroDatosHuesped;
import CostaBravaMUNDO.Huesped;
import CostaBravaMUNDO.Habitacion;

public class InterfazHotel extends JFrame {
	
    // ATRIBUTOS
    private Hotel hotel;

    // Atributos de interfaz
    //Panel que contiene el hotel
    private PanelHotel panelHotel;

    //Panel de botones
    private PanelBotonesHotel panelBotones;
    
    //Dialogo de nuevo huésped
    private DialogoAsignacion dAsignacion;
    
    //CONSTRUCTORES
    //Crea la interfaz del hotel
    public InterfazHotel( )
    {
        //Crea al hotel
        hotel = new Hotel( );

        //Configura la interfaz
        setLayout( new BorderLayout( ) );

        //Panel de botones
        panelBotones = new PanelBotonesHotel( this );
        add( panelBotones, BorderLayout.NORTH );

        //Panel del hotel
        panelHotel = new PanelHotel( hotel );
        add( panelHotel, BorderLayout.CENTER );

        String titulo = "El Hotel";
        setTitle( titulo );
        pack( );
        setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
    //MÉTODOS
    //Procesa el registro un huésped
    public void registrarHuesped( )
    {
        dAsignacion = new DialogoAsignacion( this, hotel );
        dAsignacion.setLocation( calculaPosicionCentral( this, dAsignacion ) );
        dAsignacion.setModal( true );
        dAsignacion.setVisible( true );
        actualizar( );
    }

    //Procesa la anulación del registro de un huesped
    public void anularHuesped( )
    {
        //Pregunta el numero de cédula
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

        Huesped huesped = new Huesped( cedula, "no importa" );
        if( !hotel.desasignarHabitacion( huesped ) )
        {
            JOptionPane.showMessageDialog( this, "El huesped no tenía habitacion asignada", "Anulación", JOptionPane.ERROR_MESSAGE );
            return;
        }

        actualizar( );
    }

    //Muestra el porcentaje de ocupación que tiene el hotel
    public void mostrarPorcentajeOcupacion( )
    {
        double porcentaje;
        porcentaje = hotel.calcularPorcentajeOcupacion( );
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "###.##" );
        JOptionPane.showMessageDialog( this, "El porcentaje de ocupación es " + df.format( porcentaje ) + "%", "Ocupación del hotel", JOptionPane.INFORMATION_MESSAGE );
    }

    //Procesa la búsqueda de un huésped
    
    public void buscarHuesped( )
    {
        // Pregunta el numero de cédula
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
        Huesped huesped = new Huesped( cedula, "no importa" );

        Habitacion habitacion = hotel.buscarHuesped( huesped );

        if( habitacion != null )
        {
            CuadroDatosHuesped vDatos = new CuadroDatosHuesped( habitacion );
            vDatos.setLocation( calculaPosicionCentral( this, vDatos ) );
            vDatos.setVisible( true );

        }
        else
        {
            JOptionPane.showMessageDialog( this, "El huesped no se encuentra registrado", "Búsqueda registro", JOptionPane.INFORMATION_MESSAGE );
            return;
        }
    }

    //Método 1 de extensión para el ejemplo
    public void reqFuncOpcion1( )
    {
        String respuesta = hotel.metodo1( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    //Método 2 de extensión para el ejemplo
    public void reqFuncOpcion2( )
    {
        String respuesta = hotel.metodo2( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

   //Repinta la gráfica del hotel
    public void actualizar( )
    {
        remove( panelHotel );

        //Panel del avión
        panelHotel = new PanelHotel( hotel );
        add( panelHotel, BorderLayout.CENTER );
        validate( );
    }

    //Calcula el punto central entre dos componentes
    private Point calculaPosicionCentral( Component componentePadre, Component componenteHijo )
    {

        //Centra el cuadro y asegura que no sea mayor que la resolución actual
        Dimension tamanhoPantalla = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int maxY = tamanhoPantalla.height;
        int minY = 0;

        //Tamaño de la resolución de la pantalla
        Dimension tamanhoPadre = componentePadre.getSize( );
        Point locacionPadre = componentePadre.getLocation( );
        Dimension tamanhoHijo = componenteHijo.getSize( );
        int x = ( tamanhoPadre.width - tamanhoHijo.width ) / 2 + locacionPadre.x;
        int y = ( tamanhoPadre.height - tamanhoHijo.height ) / 2 + locacionPadre.y;

        // Ajuste para abajo
        if( y + tamanhoHijo.height > maxY )
        {
            y = maxY - tamanhoHijo.height;
        }

        // Ajuste para arriba
        if( y < minY )
        {
            y = 0;
        }
        return new Point( x, y );
    }

    //Método principal de ejecución
    public static void main( String[] args )
    {
        InterfazHotel interfaz = new InterfazHotel( );
        interfaz.setVisible( true );
    }
}
