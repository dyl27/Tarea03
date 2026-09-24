package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import dominio.User;

public class UserValidator implements Validator {

	String Caractinvalidos = "1234567890!@?¡´{].-|";
	
	public boolean ValidaCaracteres( String Cadena ) {
		
		for( int i=0; i < Cadena.length(); i++ )
		   if ( Caractinvalidos.indexOf( Cadena.charAt(i)) >= 0)		   
			   return false;
		return true;			
	}
	
	@Override
	public boolean supports( Class<?> clazz ) {
		//just validate the User instances
		return User.class.isAssignableFrom( clazz );
     }

	@Override
	public void validate( Object target, Errors errors ) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace( errors, "nombre",
				"nombre.required" );
		ValidationUtils.rejectIfEmptyOrWhitespace( errors, "password",
				"password.required" );
		ValidationUtils.rejectIfEmpty( errors, "genero", "genero.required" );
		ValidationUtils.rejectIfEmpty( errors, "pais", "pais.required" );
		ValidationUtils.rejectIfEmptyOrWhitespace( errors, "sobreTi",
				"sobreTi.required" );
				
		User user = (User) target;
		if (user.getComunidad().length == 0) 
			errors.rejectValue( "comunidad", "comunidad.required" );		 
		System.out.println( "Validando Nombre: " + user.getNombre());		
		if ( !ValidaCaracteres( user.getNombre() ))
			errors.rejectValue( "nombre", "nombre.carsinvalidos");
		try {
			int edad = Integer.parseInt( user.getEdad());
		}
		catch( NumberFormatException e  ) {
			errors.rejectValue( "edad", "edad.invalida");
		  }
	}
	
	public boolean validadorSQL( User user )
	  {
		String pReservadas[] = {"select ", "insert ", "delete ","update ", "create ", "like "};
		boolean error = false;
		for( int i=0; i<pReservadas.length; i++)
		  {
			if( user.getGenero().contains( pReservadas[i] ))			  
				error = true;			  
			String tmp[] = user.getComunidad();
			for( int j=0; j<tmp.length; j++ )			  
				if( tmp[j].contains(pReservadas[i] ))				  
					error = true;				  			 
			if( user.getEdad().contains(pReservadas[i] ))
			  	error = true;			  
			if( user.getNombre().contains(pReservadas[i] ))
			  	error = true;			  
			if( user.getPassword().contains(pReservadas[i] ))
			  	error = true;			  
			if( user.getPais().contains(pReservadas[i] ))			  
				error = true;			  
		  }
		return error;
	  }	
}

