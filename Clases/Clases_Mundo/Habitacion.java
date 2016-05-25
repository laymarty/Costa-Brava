package CostaBravaMUNDO;

//habitaci�n del hotel

public class Habitacion {
	//CONSTANTES
	
	//Clase de la habitacion
	public final static int CLASE_SUITEPRESIDENCIAL = 1;
	public final static int CLASE_PREMIUM = 2;
	
	//Ubicaci�n de la habitaci�n dentro del hotel
	public final static int JARDIN = 1;
	public final static int SINVISTA = 2;
	public final static int PISCINA = 3;
	
	//ATRIBUTOS
	
	//Numero de la habitaci�n
	//Clase de la habitaci�n
	//Ubicaci�n de la habitaci�n
	private int numero;
	private int clase;
	private int ubicacion;
	private Huesped huesped;
	
	//CONSTRUCTORES
	
	//crear la habitaci�n
	 public Habitacion (int unNumero, int unaClase, int unaUbicacion )
	    {
	        numero = unNumero;
	        clase = unaClase;
	        ubicacion = unaUbicacion;
	        // Inicialmente no hay ning�n cliente en la habitaci�n
	        huesped = null;
	    }
	 
	 //M�TODOS
	 
	 //Asignar la habitaci�n al cliente
	 public void asignarAHuesped (Huesped h )
	    {
	        huesped = h;
	    }
	 
	 //desasignar habitaci�n, esta queda libre
	 public void desasignarHabitacion( )
	    {
	        huesped = null;
	    }
	 
	 //Indica si la habitaci�n est� asignada
	 public boolean habitacionAsignada( )
	    {
	        if( null == huesped )
	            return false;
	        else
	            return true;
	    }
	 
	 
	 
	 //Indica si la habitaci�n est� asignada al cliente dado
	 public boolean habitacionAsignadaHuesped( Huesped h )
	    {
	        if( null == huesped )
	            return false;
	        else if( huesped.igualA( h ) )
	            return true;
	        else
	            return false;
	    }
	 
	 //Retorna el n�mero de la habitaci�n
	 public int darNumero( )
	    {
	        return numero;
	    }
	 
	 //Retorna la clase de la habitaci�n
	 public int darClase( )
	    {
	        return clase;
	    }
	 
	 //Retorna la ubicaci�n de la habitaci�n
	 public int darUbicacion( )
	 {
		 return ubicacion;
	 }
	 
	 //Retorna el cliente de la habitaci�n
	 public Huesped darHuesped( )
	    {
	        return huesped;
	    }
}
