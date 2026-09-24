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
import dominio.Moneda;

public class MonedaJDBCTemplate {

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

	public void insertar( Moneda moneda ) {

		Connection connect = null;
		try
		  {
			connect = getConexion();
			String sql = "insert into moneda ( nombre, simbolo ) values ( ?, ? )";
			PreparedStatement ps = connect.prepareStatement( sql );
			ps.setString( 1, moneda.getNombre() );
			ps.setString( 2, moneda.getSimbolo() );
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

	public void actualizar( Moneda moneda ) { 

		Connection connect = null;
		try
		  {
			connect = getConexion();
			String sql = "update moneda set nombre=?, simbolo=? where id_moneda=?";
			PreparedStatement ps = connect.prepareStatement( sql );
			ps.setString( 1, moneda.getNombre() );
			ps.setString( 2, moneda.getSimbolo() );
			ps.setInt( 3, moneda.getIdMoneda() );
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

	public void eliminar( Integer idMoneda ) {

		Connection connect = null;
		try
		  {
			connect = getConexion();
			String sql = "delete from moneda where id_moneda=?";
			PreparedStatement ps = connect.prepareStatement( sql );
			ps.setInt( 1, idMoneda );
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

	public Moneda obtenerPorId( Integer idMoneda ) {

		Connection connect = null;
		Moneda moneda = null;
		try
		  {
			connect = getConexion();
			String sql = "select * from moneda where id_moneda=?";
			PreparedStatement ps = connect.prepareStatement( sql );
			ps.setInt( 1, idMoneda );
			ResultSet rs = ps.executeQuery();
			if ( rs.next() )
			  {
				moneda = new Moneda();
				moneda.setIdMoneda( rs.getInt( "id_moneda" ) );
				moneda.setNombre( rs.getString( "nombre" ) );
				moneda.setSimbolo( rs.getString( "simbolo" ) );
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
		return moneda;
	  }

	public List<Moneda> listar() {

		Connection connect = null;
		List<Moneda> monedas = new ArrayList<Moneda>();
		try
		  {
			connect = getConexion();
			String sql = "select * from moneda";
			PreparedStatement ps = connect.prepareStatement( sql );
			ResultSet rs = ps.executeQuery();
			while ( rs.next() )
			  {
				Moneda moneda = new Moneda();
				moneda.setIdMoneda( rs.getInt( "id_moneda" ) );
				moneda.setNombre( rs.getString( "nombre" ) );
				moneda.setSimbolo( rs.getString( "simbolo" ) );
				monedas.add( moneda );
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
		return monedas;
	  }
}