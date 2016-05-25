package CostaBravaMUNDO;

//habitación del hotel

public class Habitacion {
	//CONSTANTES
	
	//Clase de la habitacion
	public final static int CLASE_SUITEPRESIDENCIAL = 1;
	public final static int CLASE_PREMIUM = 2;
	
	//Ubicación de la habitación dentro del hotel
	public final static int JARDIN = 1;
	public final static int SINVISTA = 2;
	public final static int PISCINA = 3;
	
	//ATRIBUTOS
	
	//Numero de la habitación
	//Clase de la habitación
	//Ubicación de la habitación
	private int numero;
	private int clase;
	private int ubicacion;
	private Huesped huesped;
	
	//CONSTRUCTORES
	
	//crear la habitación
	 public Habitacion (int unNumero, int unaClase, int unaUbicacion )
	    {
	        numero = unNumero;
	        clase = unaClase;
	        ubicacion = unaUbicacion;
	        // Inicialmente no hay ningún cliente en la habitación
	        huesped = null;
	    }
	 
	 //MÉTODOS
	 
	 //Asignar la habitación al cliente
	 public void asignarAHuesped (Huesped h )
	    {
	        huesped = h;
	    }
	 
	 //desasignar habitación, esta queda libre
	 public void desasignarHabitacion( )
	    {
	        huesped = null;
	    }
	 
	 //Indica si la habitación está asignada
	 public boolean habitacionAsignada( )
	    {
	        if( null == huesped )
	            return false;
	        else
	            return true;
	    }
	 
	 
	 
	 //Indica si la habitación está asignada al cliente dado
	 public boolean habitacionAsignadaHuesped( Huesped h )
	    {
	        if( null == huesped )
	            return false;
	        else if( huesped.igualA( h ) )
	            return true;
	        else
	            return false;
	    }
	 
	 //Retorna el número de la habitación
	 public int darNumero( )
	    {
	        return numero;
	    }
	 
	 //Retorna la clase de la habitación
	 public int darClase( )
	    {
	        return clase;
	    }
	 
	 //Retorna la ubicación de la habitación
	 public int darUbicacion( )
	 {
		 return ubicacion;
	 }
	 
	 //Retorna el cliente de la habitación
	 public Huesped darHuesped( )
	    {
	        return huesped;
	    }
}
