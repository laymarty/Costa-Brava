package CostaBravaGUI;

import java.awt.*;
import javax.swing.*;
import CostaBravaMUNDO.*;

//FORMULARIO PARA LA ASIGNACIÓN DE LAS HABITACIONES
public class DialogoAsignacion extends JDialog {
	
	//Atributos
	private Hotel hotel;
	
	//Atributos de interfaz
	
	//Interfaz principal
   private InterfazHotel cuadro;

   //Panel con los botones
   private PanelBotonesAsignacion panelBotones;

   //Panel con los datos
   private PanelDatosAsignacion panelDatos;
   
   //CONSTRUCTORES
   
   //Crea el formulario de asignacion de huespedes
   public DialogoAsignacion( InterfazHotel elCuadro, Hotel elHotel )
   {

       //Guarda la referencia al hotel
       hotel = elHotel;

       //Guarda la referencia al cuadro padre
       cuadro = elCuadro;

       //Configuración de propiedades gráficas
       setLayout( new BorderLayout( ) );

       //Crea el panel de datos
       panelDatos = new PanelDatosAsignacion( );
       add( panelDatos, BorderLayout.CENTER );

       //Crea el panel de botones
       panelBotones = new PanelBotonesAsignacion( this );
       add( panelBotones, BorderLayout.SOUTH );

       setTitle( "Registro de huesped" );
       pack( );
       //setResizable( false );
       setDefaultCloseOperation( DISPOSE_ON_CLOSE );
   }
   
   //MÉTODOS
   
   //Procesa el registro de un huésped
   public void registrar( )
   {
       int cedula, clase;
       char ubicacion;
       String nombre, sCedula;
       Huesped huesped;

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

       //Crea al huésped
       huesped = new Huesped( cedula, nombre );

       //verifica que no este ya el huesped registrado
       Habitacion habitacion = hotel.buscarHuesped( huesped );

       if( habitacion != null )
       {
           JOptionPane.showMessageDialog( this, "El huesped ya tiene una habitacion asignada", "Registro", JOptionPane.ERROR_MESSAGE );
           return;
       }

       //Registra al huésped
       clase = panelDatos.darClase( );
       ubicacion = panelDatos.darUbicacion( );
       habitacion = hotel.asignarHabitacion( clase, ubicacion, huesped );

       if( habitacion == null )
       {
           JOptionPane.showMessageDialog( this, "No hay habitaciones disponibles con dichas características", "Registro", JOptionPane.ERROR_MESSAGE );
           return;
       }
       cuadro.actualizar( );
       dispose( );

   }

   //Cancela el proceso de registro
   public void cancelar( )
   {
       cuadro.actualizar( );
       dispose( );
   }
}
