package CostaBravaGUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import CostaBravaMUNDO.*;
import CostaBravaMUNDO.Hotel;
import CostaBravaGUI.HabitacionGrafica;
import CostaBravaMUNDO.Hotel;
import CostaBravaMUNDO.Habitacion;

public class PanelHotel extends JPanel {
	
	// ATRIBUTOS
	
    //HOTEL DEL MODELO DEL MUNDO
	private Hotel hotel;
	
    // Atributos de interfaz
	
    //Imagen del hotel
    private ImageIcon imagen;
    
    //CONSTRUCTORES
    //Crea el panel del hotel
    public PanelHotel( Hotel hotel1 )
    {
        super( new BorderLayout( ) );
        hotel = hotel1;
        imagen = new ImageIcon( "planoHotel.gif" );
        setPreferredSize( new Dimension( imagen.getIconWidth( ), imagen.getIconHeight( ) ) );
        setOpaque( false );

        //Adiciona las imágenes de las habitaciones suitePresdidencial
        JPanel panelSuitePresidencial = new JPanel( );
        dibujarHabitacionesSuitePresidencial( panelSuitePresidencial );
        add( panelSuitePresidencial, BorderLayout.NORTH );
        
        //Adiciona las imágenes de las habitaciones premium
        JPanel panelPremium = new JPanel( );
        dibujarHabitacionesPremium( panelPremium );
        add( panelPremium, BorderLayout.CENTER );
    }
    
    //MÉTODOS
    
    //Dibuja la gráfica del hotel
    public void paint( Graphics grafica )
    {
        grafica.drawImage( imagen.getImage( ), 0, 0, null, null );
        super.paint( grafica );
    }

    //Crea las gráficas de las habitaciones suitePresidencial del hotel
    private void dibujarHabitacionesSuitePresidencial( JPanel panel )
    {
        panel.setLayout( new GridLayout( Hotel.HABITACIONES_SUITEPRESIDENCIAL / 4, 5, 8, 5 ) );
        panel.setBorder( new EmptyBorder( 90, 210, 20, 210 ) );

        Habitacion[] suitePresidencial = hotel.obtenerHabitacionesSuitepresidencial( );
        Habitacion habitacion;

        for( int i = 0; i < suitePresidencial.length; i++ )
        {
            habitacion = suitePresidencial[ i ];
            HabitacionGrafica habitacionG = new HabitacionGrafica( habitacion );
            panel.add( habitacionG );
            if( i % 4 == 1 )
            {
                panel.add( new JLabel( " " ) );
            }
        }
        panel.setOpaque( false );
    }

    //Crea las gráficas de las habitaciones premium del hotel
    private void dibujarHabitacionesPremium( JPanel panel )
    {
        panel.setLayout( new GridLayout( Hotel.HABITACIONES_PREMIUM / 6, 7, 5, 4 ) );
        panel.setBorder( new EmptyBorder( 0, 200, 100, 200 ) );

        Habitacion[] premium = hotel.obtenerHabitacionesPremium( );
        Habitacion habitacion;

        for( int i = 0; i < premium.length; i++ )
        {
            habitacion = premium[ i ];

            HabitacionGrafica habitacionG = new HabitacionGrafica( habitacion );
            panel.add( habitacionG );
            if( i % 6 == 2 )
            {
                panel.add( new JLabel( " " ) );
            }
        }
        panel.setOpaque( false );
    }
}