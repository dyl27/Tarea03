<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Pagina correcta</title>
</head>
<body>
  Detalle del Usuario
  <hr>
  Nombre Usuario   	: ${user.nombre} <br/>
  Edad        	    : ${user.edad} <br/>  
  Genero      		: ${user.genero} <br/>
  Pais     			: ${user.pais} <br/>
  Sobre ti   		: ${user.sobreTi} <br/>
  Comunidad   		: ${user.comunidad[0]}  ${user.comunidad[1]} ${user.comunidad[2]}<br/>
  Lista Correo		: ${user.listaCorreo} 
</body>
</html>