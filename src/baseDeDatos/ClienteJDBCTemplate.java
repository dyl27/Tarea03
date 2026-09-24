package baseDeDatos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.MysqlDataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dominio.BDMySql;
import dominio.Cliente;

public class ClienteJDBCTemplate {

	public Connection getConexion() {

		MysqlDataSource ds = null;
		Connection connect = null;

		try {
			ds = new MysqlDataSource();

			ApplicationContext context = new ClassPathXmlApplicationContext( "Spring-Datasource.xml" );
			BDMySql bdMySql = (BDMySql) context.getBean( "servicioPropiedades" );

			ds.setUrl( bdMySql.getUrlBD() );
			ds.setUser( bdMySql.getUser() );
			ds.setPassword( bdMySql.getPassword() );
			connect = ds.getConnection();
			return connect;
		}
		catch ( SQLException error )
		  {
			System.out.println( error.toString() );
			return connect;
		  }
	  }

	public void insertar( Cliente cliente ) {

		Connection connect = null;
		try
		  {
			connect = getConexion();
			String sql = "insert into cliente ( nombres, apellidos, dni, direccion, telefono, correo ) values ( ?, ?, ?, ?, ?, ? )";
			PreparedStatement ps = connect.prepareStatement( sql );
			ps.setString( 1, cliente.getNombres() );
			ps.setString( 2, cliente.getApellidos() );
			ps.setString( 3, cliente.getDni() );
			ps.setString( 4, cliente.getDireccion() );
			ps.setString( 5, cliente.getTelefono() );
			ps.setString( 6, cliente.getCorreo() );
			ps.executeUpdate();
		  }
		catch ( SQLException error )
		  {
			System.out.println( error.toString() );
		  }
		finally
		  {
			try { connect.close(); }
			catch ( SQLException error ) { System.out.println( "Error Connect :" + error.toString() ); }
		  }
	  }

	public void actualizar( Cliente cliente ) {

		Connection connect = null;
		try
		  {
			connect = getConexion();
			String sql = "update cliente set nombres=?, apellidos=?, dni=?, direccion=?, telefono=?, correo=? where id_cliente=?";
			PreparedStatement ps = connect.prepareStatement( sql );
			ps.setString( 1, cliente.getNombres() );
			ps.setString( 2, cliente.getApellidos() );
			ps.setString( 3, cliente.getDni() );
			ps.setString( 4, cliente.getDireccion() );
			ps.setString( 5, cliente.getTelefono() );
			ps.setString( 6, cliente.getCorreo() );
			ps.setInt( 7, cliente.getIdCliente() );
			ps.executeUpdate();
		  }
		catch ( SQLException error )
		  {
			System.out.println( error.toString() );
		  }
		finally
		  {
			try { connect.close(); }
			catch ( SQLException error ) { System.out.println( "Error Connect :" + error.toString() ); }
		  }
	  }

	public void eliminar( Integer idCliente ) {

		Connection connect = null;
		try
		  {
			connect = getConexion();
			String sql = "delete from cliente where id_cliente=?";
			PreparedStatement ps = connect.prepareStatement( sql );
			ps.setInt( 1, idCliente );
			ps.executeUpdate();
		  }
		catch ( SQLException error )
		  {
			System.out.println( error.toString() );
		  }
		finally
		  {
			try { connect.close(); }
			catch ( SQLException error ) { System.out.println( "Error Connect :" + error.toString() ); }
		  }
	  }

	public Cliente obtenerPorId( Integer idCliente ) {

		Connection connect = null;
		Cliente cliente = null;
		try
		  {
			connect = getConexion();
			String sql = "select * from cliente where id_cliente=?";
			PreparedStatement ps = connect.prepareStatement( sql );
			ps.setInt( 1, idCliente );
			ResultSet rs = ps.executeQuery();
			if ( rs.next() )
			  {
				cliente = new Cliente();
				cliente.setIdCliente( rs.getInt( "id_cliente" ) );
				cliente.setNombres( rs.getString( "nombres" ) );
				cliente.setApellidos( rs.getString( "apellidos" ) );
				cliente.setDni( rs.getString( "dni" ) );
				cliente.setDireccion( rs.getString( "direccion" ) );
				cliente.setTelefono( rs.getString( "telefono" ) );
				cliente.setCorreo( rs.getString( "correo" ) );
				cliente.setFechaRegistro( rs.getDate( "fecha_registro" ) );
			  }
		  }
		catch ( SQLException error )
		  {
			System.out.println( error.toString() );
		  }
		finally
		  {
			try { connect.close(); }
			catch ( SQLException error ) { System.out.println( "Error Connect :" + error.toString() ); }
		  }
		return cliente;
	  }

	public List<Cliente> listar() {

		Connection connect = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		try
		  {
			connect = getConexion();
			String sql = "select * from cliente";
			PreparedStatement ps = connect.prepareStatement( sql );
			ResultSet rs = ps.executeQuery();
			while ( rs.next() )
			  {
				Cliente cliente = new Cliente();
				cliente.setIdCliente( rs.getInt( "id_cliente" ) );
				cliente.setNombres( rs.getString( "nombres" ) );
				cliente.setApellidos( rs.getString( "apellidos" ) );
				cliente.setDni( rs.getString( "dni" ) );
				cliente.setDireccion( rs.getString( "direccion" ) );
				cliente.setTelefono( rs.getString( "telefono" ) );
				cliente.setCorreo( rs.getString( "correo" ) );
				cliente.setFechaRegistro( rs.getDate( "fecha_registro" ) );
				clientes.add( cliente );
			  }
		  }
		catch ( SQLException error )
		  {
			System.out.println( error.toString() );
		  }
		finally
		  {
			try { connect.close(); }
			catch ( SQLException error ) { System.out.println( "Error Connect :" + error.toString() ); }
		  }
		return clientes;
	  }
}