/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author esporras
 */
public class validaciones {
       
     
    
    private static final String patron_email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        
    public boolean email(String email){
        // Se realiza una compilación de la expresión entrante en relación con el patrón que se determina como entrada
        Pattern patron = Pattern.compile(patron_email);
 
        // Se parsea el string el email, para analizar su respectiva equivalencia con el patrón de email destacado al inicion
        Matcher parseo = patron.matcher(email);
        return parseo.matches();
    }
    
/*
	Tipo de input 

	+000000000000000
	donde se deben incluir el código del país, por ejemplo

	+50600000000

	Se tomó la decisión de no limitar el tamaño de los números debido a que en algunos paises
	los números de telefono son de una extensión mayor a 8 caracteres o menor a 7


*/
public static boolean esNumberoTelefonico(String phonenumber){
	// Retorna true si el numero es efectivamente un número

	int posicion = 0;
	if ( (phonenumber.charAt(posicion)) == '+' || Character.isDigit(phonenumber.charAt(posicion)) ){

		for(int counter = 1; counter < phonenumber.length(); counter++){                    
			if( !Character.isDigit(phonenumber.charAt(counter))){
				return false;                                
			}                        
		}
		return true;
	}
	else{

		return false;
	}
}

       
    
    //determinar si un campo de texto es vacío
    public boolean esVacio(String texto){
        if(texto.isEmpty()){//está vacío
            return true;
        }
        else{
            return false;
        }            
    }
    
    //valida paara cupo o grupo que sea un número menor a 127
    public boolean espacio(int numero){ 
        if(numero >127){
            return true;
        }
        else{
            return false;
        }
    }
    
    //validar npumeros enteros
    private static boolean esNumero(String numero){
	try {
		Integer.parseInt(numero);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }

    
    
}


