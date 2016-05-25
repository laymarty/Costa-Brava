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
	
	//M�TODOS
	
	//Retorna la c�dula y el nombre del hu�sped
	public int darCedula( )
    {
        return cedula;
    }

    public String darNombre( )
    {
        return nombre;
    }
    
    //Indica si el hu�sped es igual a otro
    public boolean igualA( Huesped otroHuesped )
    {
        if( cedula == otroHuesped.darCedula( ) )
            return true;
        else
            return false;
    }

}
