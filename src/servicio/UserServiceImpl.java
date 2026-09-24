package servicio;

import baseDeDatos.UsuariosJDBCTemplate;
import dominio.User;

public class UserServiceImpl implements UserService {

	@Override

	public void add( User user ) {
		
		String Comunidades = "";
		
		System.out.println( "Usuario agregado correctamente:" );
		System.out.println( "Nombre: " + user.getNombre() );
		System.out.println( "Edad: package servicio;\r\n"
				+ "\r\n"
				+ "import baseDeDatos.UsuariosJDBCTemplate;\r\n"
				+ "\r\n"
				+ "public class UserServiceImpl implements UserService {\r\n"
				+ "\r\n"
				+ "	@Override\r\n"
				+ "\r\n"
				+ "	public void add( User user ) {\r\n"
				+ "		\r\n"
				+ "		String Comunidades = \"\";\r\n"
				+ "		\r\n"
				+ "		System.out.println( \"Usuario agregado correctamente:\" );\r\n"
				+ "		System.out.println( \"Nombre: \" + user.getNombre() );\r\n"
				+ "		System.out.println( \"Edad: \" + user.getEdad() );\r\n"
				+ "		System.out.println( \"G�nero: \" + user.getGenero() );\r\n"
				+ "		System.out.println( \"Pa�s: \" + user.getPais() );\r\n"
				+ "		System.out.println( \"Sobre t�: \" + user.getSobreTi() );\r\n"
				+ "		System.out.print( \"Comunidad: \" ) ;\r\n"
				+ "		 for( int i=0; i<user.getComunidad().length; i++)\r\n"
				+ "		 {	 System.out.print( user.getComunidad()[i] + \" \" );\r\n"
				+ "		 	Comunidades= Comunidades + \"-\" + user.getComunidad()[i];\r\n"
				+ "		 }\r\n"
				+ "		System.out.println();\r\n"
				+ "		System.out.println( \"Lista de correo: \" + user.getListaCorreo());\r\n"
				+ "\r\n"
				+ "		UsuariosJDBCTemplate conn = new UsuariosJDBCTemplate();\r\n"
				+ "		try {\r\n"
				+ "			  conn.insertarU( user );\r\n"
				+ "		  } catch(Exception e)\r\n"
				+ "		{\r\n"
				+ "			System.out.println(\"Error NamingException: \" + e.toString());\r\n"
				+ "		}\r\n"
				+ "	}\r\n"
				+ "}\r\n"
				+ "" + user.getEdad() );
		System.out.println( "G�nero: " + user.getGenero() );
		System.out.println( "Pa�s: " + user.getPais() );
		System.out.println( "Sobre t�: " + user.getSobreTi() );
		System.out.print( "Comunidad: " ) ;
		 for( int i=0; i<user.getComunidad().length; i++)
		 {	 System.out.print( user.getComunidad()[i] + " " );
		 	Comunidades= Comunidades + "-" + user.getComunidad()[i];
		 }
		System.out.println();
		System.out.println( "Lista de correo: " + user.getListaCorreo());

		UsuariosJDBCTemplate conn = new UsuariosJDBCTemplate();
		try {
			  conn.insertarU( user );
		  } catch(Exception e)
		{
			System.out.println("Error NamingException: " + e.toString());
		}
	}
}
