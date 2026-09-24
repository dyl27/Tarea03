<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <title>Pagina de Registro</title>
   <style>
     .error {
        color: #ff0000;
        font-style: italic;
      }
   </style>
</head>
<body>

<form:form method="POST" commandName="user">
	<table border="0" bgcolor="11BBB0">	
		<tr>		 
			<td colspan="3">
			  <center>
			    <h1>Formulario de Inscripción</h1>
			  </center>
			</td>		 
		</tr>
		<tr>
			<td>Nombre Usuario :</td>
			<td><form:input path="nombre" /></td>
			<td><form:errors path="nombre" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Edad :</td>
			<td><form:input path="edad" /></td>
			<td><form:errors path="edad" cssClass="error" /></td>
		</tr>		
		<tr>
			<td>Password :</td>
			<td><form:password path="password" /></td>
			<td><form:errors path="password" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Genero :</td>
			<td><form:radiobutton path="genero" value="M" label="M" /> 
				<form:radiobutton path="genero" value="F" label="F" />
			</td>
			<td><form:errors path="genero" cssClass="error" /></td>	
		</tr>
		<tr>
			<td>Pais :</td>
			<td><form:select path="pais">
				   <form:option value="" label="Selecciona" />
				   <form:option value="1" label="España" />
				   <form:option value="2" label="USA" />
				   <form:option value="3" label="UK" />
			    </form:select></td>
			<td><form:errors path="pais" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Sobre ti :</td>
			<td><form:textarea path="sobreTi" /></td>
			<td><form:errors path="sobreTi" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Comunidad :</td>
			<td><form:checkbox path="comunidad" value="Spring" label="Spring" /> 
			    <form:checkbox path="comunidad" value="Hibernate" label="Hibernate" /> 
			    <form:checkbox path="comunidad" value="Struts" label="Struts" />
			</td>
			<td><form:errors path="comunidad" cssClass="error" /></td>
		</tr>
		<tr>
			<td colspan="3">
			   <form:checkbox path="listaCorreo" 
				  label="¿Te gustaría formar parte de nuestra lista de correo?" />
		    </td>
		</tr> 
		<tr>
		  <td colspan="3">
		    <br>
		  </td>
		</tr>
		<tr>		 
			<td colspan="3">
			  <center>
			    <input type="submit" value="Register">
			  </center>
			</td>		 
		</tr>
	</table>
	<form:errors path="*" cssClass="error" />
</form:form>

</body>
</html>