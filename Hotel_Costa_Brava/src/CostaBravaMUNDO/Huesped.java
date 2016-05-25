package CostaBravaMUNDO;

//HUESPED DEL HOTEL

public class Huesped {
	
	//ATRIBUTOS
	
	private int cedula;
	private String nombre;
	
	//CONSTRUCTORES
	
	//Crea un huesped con sus respectivos datos
	public Huesped( int unaCedula, String unNombre )
    {
        cedula = unaCedula;
        nombre = unNombre;
    }
	
	//MÉTODOS
	
	//Retorna la cédula y el nombre del huésped
	public int darCedula( )
    {
        return cedula;
    }

    public String darNombre( )
    {
        return nombre;
    }
    
    //Indica si el huésped es igual a otro
    public boolean igualA( Huesped otroHuesped )
    {
        if( cedula == otroHuesped.darCedula( ) )
            return true;
        else
            return false;
    }

}
