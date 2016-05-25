package CostaBravaMUNDO;

import CostaBravaMUNDO.Huesped;
import CostaBravaMUNDO.Habitacion;

//Hotel de huespedes
public class Hotel {
	
	//CONSTANTES
	 public final static int HABITACIONES_SUITEPRESIDENCIAL = 8;
	 public final static int HABITACIONES_PREMIUM = 42;
	 
	 //ATRIBUTOS
	 private Habitacion[] habitacionesSuitePresidencial;
	  
	 private Habitacion[] habitacionesPremium;
	 
	 //CONSTRUCTORES
	 
	 //Construye el hotel
	 public Hotel( )
	    {
	        int ubicacion;

	        // Crea las habitaciones suite presidencial
	        habitacionesSuitePresidencial = new Habitacion[HABITACIONES_SUITEPRESIDENCIAL];

	        // crea las HABITACIONES PREMIUM
	        habitacionesPremium = new Habitacion[HABITACIONES_PREMIUM];

	        habitacionesSuitePresidencial[ 0 ] = new Habitacion( 1, Habitacion.CLASE_SUITEPRESIDENCIAL, Habitacion.JARDIN );
	        habitacionesSuitePresidencial[ 1 ] = new Habitacion( 2, Habitacion.CLASE_SUITEPRESIDENCIAL, Habitacion.PISCINA );
	        habitacionesSuitePresidencial[ 2 ] = new Habitacion( 3, Habitacion.CLASE_SUITEPRESIDENCIAL, Habitacion.PISCINA );
	        habitacionesSuitePresidencial[ 3 ] = new Habitacion( 4, Habitacion.CLASE_SUITEPRESIDENCIAL, Habitacion.JARDIN );
	        habitacionesSuitePresidencial[ 4 ] = new Habitacion( 5, Habitacion.CLASE_SUITEPRESIDENCIAL, Habitacion.JARDIN );
	        habitacionesSuitePresidencial[ 5 ] = new Habitacion( 6, Habitacion.CLASE_SUITEPRESIDENCIAL, Habitacion.PISCINA );
	        habitacionesSuitePresidencial[ 6 ] = new Habitacion( 7, Habitacion.CLASE_SUITEPRESIDENCIAL, Habitacion.PISCINA );
	        habitacionesSuitePresidencial[ 7 ] = new Habitacion( 8, Habitacion.CLASE_SUITEPRESIDENCIAL, Habitacion.JARDIN );

	        for( int numHabitacion = 1 + HABITACIONES_SUITEPRESIDENCIAL, j = 1; j <= HABITACIONES_PREMIUM; numHabitacion++, j++ )
	        {
	            //Habitaciones jardin
	            if( j % 6 == 1 || j % 6 == 0 )
	                ubicacion = Habitacion.JARDIN;
	            //habitaciones sin vista 
	            else if( j % 6 == 2 || j % 6 == 5 )
	                ubicacion = Habitacion.SINVISTA;
	            //Habitaciones piscina
	            else
	                ubicacion = Habitacion.PISCINA;

	            habitacionesPremium[ j - 1 ] = new Habitacion( numHabitacion, Habitacion.CLASE_PREMIUM, ubicacion );
	        }
	    }
	 
	 //MÉTODOS
	 
	 /*
	  * Asignar habitación a un huésped
	  * Si existe una habitación con la clase y la ubicación dada, el huesped queda asignado en la primera de ellas según el orden numérico
	  */
	 
	 public Habitacion asignarHabitacion( int clase, int ubicacion, Huesped huesped )
	    {
	        //busca una habitación libre
	        Habitacion habitacion = null;
	        if( clase == Habitacion.CLASE_SUITEPRESIDENCIAL )
	        {
	            habitacion = buscarhabitacionSuitePresidencialLibre (ubicacion );
	        }
	        else if( clase == Habitacion.CLASE_PREMIUM )
	        {
	            habitacion = buscarHabitacionPremiumLibre (ubicacion );
	        }
	        if( habitacion != null )
	        {
	        	habitacion.asignarAHuesped ( huesped );
	        }
	        return habitacion;
	    }
	 
	 //Busca la siguiente habitación suite presidencial libre
	 public Habitacion buscarhabitacionSuitePresidencialLibre( int ubicacion )
	    {
	        boolean encontrado = false;
	        Habitacion habitacion = null;
	        for( int i = 0; i < HABITACIONES_SUITEPRESIDENCIAL && !encontrado; i++ )
	        {
	            habitacion = habitacionesSuitePresidencial[ i ];
	            if( ! ( habitacion.habitacionAsignada( ) ) && habitacion.darUbicacion( ) == ubicacion )
	            {
	                encontrado = true;
	            }
	        }
	        if( encontrado )
	            return habitacion;
	        else
	            return null;
	    }
	 
	 //Busca la siguiente habitación premium libre
	 public Habitacion buscarHabitacionPremiumLibre( int ubicacion )
	    {
	        boolean encontrado = false;
	        Habitacion habitacion = null;
	        for( int i = 0; i < HABITACIONES_PREMIUM && !encontrado; i++ )
	        {
	            habitacion = habitacionesPremium[ i ];
	            if( ! ( habitacion.habitacionAsignada( ) ) && habitacion.darUbicacion( ) == ubicacion )
	            {
	                encontrado = true;
	            }
	        }
	        if( encontrado )
	            return habitacion;
	        else
	            return null;
	    }
	 
	 //Busca un huésped en el hotel
	 public Habitacion buscarHuesped( Huesped huesped )
	    {
	        //Busca el huésped en suite presidencial
	        Habitacion habitacion = buscarHuespedSuitepresidencial( huesped );
	        //Si no estaba en suite presidencial
	        if( null == habitacion )
	            //Busca en premium
	            habitacion = buscarHuespedPremium( huesped );
	        return habitacion;
	    }
	 
	 //Buscar huésped en las habitaciones suite presidencial
	 public Habitacion buscarHuespedSuitepresidencial( Huesped huesped )
	    {
	        boolean encontrado = false;
	        Habitacion habitacion = null;
	        for( int i = 0; i < HABITACIONES_SUITEPRESIDENCIAL && !encontrado; i++ )
	        {
	            habitacion = habitacionesSuitePresidencial[ i ];
	            if( habitacion.habitacionAsignada( ) && habitacion.darHuesped( ).igualA( huesped ) )
	            {
	                encontrado = true;
	            }
	        }
	        if( encontrado )
	            return habitacion;
	        else
	            return null;
	    }
	 
	 //Busca huésped en las habitaciones premium
	 public Habitacion buscarHuespedPremium( Huesped huesped )
	    {
	        boolean encontrado = false;
	        Habitacion habitacion = null;
	        for( int i = 0; i < HABITACIONES_PREMIUM && !encontrado; i++ )
	        {
	            habitacion = habitacionesPremium[ i ];
	            if( habitacion.habitacionAsignada( ) && habitacion.darHuesped( ).igualA( huesped ) )
	            {
	                encontrado = true;
	            }
	        }
	        if( encontrado )
	            return habitacion;
	        else
	            return null;
	    }
	 
	 //Desasigna la habitación de un huésped
	 public boolean desasignarHabitacion( Huesped huesped )
	    {
	        //Busca el huésped en el hotel
	        Habitacion habitacion = buscarHuesped( huesped );
	        //Si lo encuentra desasigna
	        if( habitacion != null )
	        {
	            habitacion.desasignarHabitacion( );
	            return true;
	        }
	        else
	            return false;
	    }
	 
	 //Retorna el número de habitaciones suite presidencial ocupadas
	 public int contarHabitacionesSuitePresidencialOcupadas( )
	    {
	        int contador = 0;
	        for( int i = 0; i < HABITACIONES_SUITEPRESIDENCIAL; i++ )
	        {
	            if( habitacionesSuitePresidencial[ i ].habitacionAsignada( ) )
	            {
	                contador++;
	            }
	        }
	        return contador;
	    }
	 
	 //Retorna el número de habitaciones premium ocupadas
	 public int contarHabitacionesPremiumOcupadas( )
	    {
	        int contador = 0;
	        for( int i = 0; i < HABITACIONES_PREMIUM; i++ )
	        {
	            if( habitacionesPremium[ i ].habitacionAsignada( ) )
	            {
	                contador++;
	            }
	        }
	        return contador;
	    }

	 //Calcula el porcentaje de ocupación del hotel
	  
	    public double calcularPorcentajeOcupacion( )
	    {
	        double porcentaje;
	        int totalHabitaciones = HABITACIONES_PREMIUM + HABITACIONES_SUITEPRESIDENCIAL;
	        int habitacionesOcupadas = contarHabitacionesPremiumOcupadas( ) + contarHabitacionesSuitePresidencialOcupadas( );
	        porcentaje = ( double ) habitacionesOcupadas / totalHabitaciones * 100;
	        return porcentaje;
	    }

	    
	  //Retorna las habitaciones suite presidencial del hotel
	     
	    public Habitacion[] obtenerHabitacionesSuitepresidencial( )
	    {
	        return habitacionesSuitePresidencial;
	    }

	  
	  //Retorna las habitaciones premium del hotel
	    
	    public Habitacion[] obtenerHabitacionesPremium( )
	    {
	        return habitacionesPremium;
	    }

	    
	    public String metodo1( )
	    {
	        return "respuesta 1";
	    }

	  
	    public String metodo2( )
	    {
	        return "respuesta 2";
	    }
}
