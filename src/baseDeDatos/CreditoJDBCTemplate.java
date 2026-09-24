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
import dominio.Credito;

public class CreditoJDBCTemplate {

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

	public void insertar( Credito credito ) {

		Connection connect = null;
		try
		  {
			connect = getConexion();
			String sql = "insert into credito ( id_cliente, id_moneda, fecha, monto, periodo_meses, cuota, tea, fecha_vencimiento ) values ( ?, ?, ?, ?, ?, ?, ?, ? )";
			PreparedStatement ps = connect.prepareStatement( sql );
			ps.setInt( 1, credito.getIdCliente() );
			ps.setInt( 2, credito.getIdMoneda() );
			ps.setDate( 3, new java.sql.Date( credito.getFecha().getTime() ) );
			ps.setBigDecimal( 4, credito.getMonto() );
			ps.setInt( 5, credito.getPeriodoMeses() );
			ps.setBigDecimal( 6, credito.getCuota() );
			ps.setBigDecimal( 7, credito.getTea() );
			ps.setDate( 8, new java.sql.Date( credito.getFechaVencimiento().getTime() ) );
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

	public void actualizar( Credito credito ) {

		Connection connect = null;
		try
		  {
			connect = getConexion();
			String sql = "update credito set id_cliente=?, id_moneda=?, fecha=?, monto=?, periodo_meses=?, cuota=?, tea=?, fecha_vencimiento=? where id_credito=?";
			PreparedStatement ps = connect.prepareStatement( sql );
			ps.setInt( 1, credito.getIdCliente() );
			ps.setInt( 2, credito.getIdMoneda() );
			ps.setDate( 3, new java.sql.Date( credito.getFecha().getTime() ) );
			ps.setBigDecimal( 4, credito.getMonto() );
			ps.setInt( 5, credito.getPeriodoMeses() );
			ps.setBigDecimal( 6, credito.getCuota() );
			ps.setBigDecimal( 7, credito.getTea() );
			ps.setDate( 8, new java.sql.Date( credito.getFechaVencimiento().getTime() ) );
			ps.setInt( 9, credito.getIdCredito() );
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

	public void eliminar( Integer idCredito ) {

		Connection connect = null;
		try
		  {
			connect = getConexion();
			String sql = "delete from credito where id_credito=?";
			PreparedStatement ps = connect.prepareStatement( sql );
			ps.setInt( 1, idCredito );
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

	public Credito obtenerPorId( Integer idCredito ) {

		Connection connect = null;
		Credito credito = null;
		try
		  {
			connect = getConexion();
			String sql = "select * from credito where id_credito=?";
			PreparedStatement ps = connect.prepareStatement( sql );
			ps.setInt( 1, idCredito );
			ResultSet rs = ps.executeQuery();
			if ( rs.next() )
			  credito = mapearCredito( rs );
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
		return credito;
	  }

	public List<Credito> listar() {

		Connection connect = null;
		List<Credito> creditos = new ArrayList<Credito>();
		try
		  {
			connect = getConexion();
			String sql = "select * from credito";
			PreparedStatement ps = connect.prepareStatement( sql );
			ResultSet rs = ps.executeQuery();
			while ( rs.next() )
			  creditos.add( mapearCredito( rs ) );
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
		return creditos;
	  }

	public List<Credito> listarPorCliente( Integer idCliente ) {

		Connection connect = null;
		List<Credito> creditos = new ArrayList<Credito>();
		try
		  {
			connect = getConexion();
			String sql = "select * from credito where id_cliente=?";
			PreparedStatement ps = connect.prepareStatement( sql );
			ps.setInt( 1, idCliente );
			ResultSet rs = ps.executeQuery();
			while ( rs.next() )
			  creditos.add( mapearCredito( rs ) );
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
		return creditos;
	  }

	private Credito mapearCredito( ResultSet rs ) throws SQLException {

		Credito credito = new Credito();
		credito.setIdCredito( rs.getInt( "id_credito" ) );
		credito.setIdCliente( rs.getInt( "id_cliente" ) );
		credito.setIdMoneda( rs.getInt( "id_moneda" ) );
		credito.setFecha( rs.getDate( "fecha" ) );
		credito.setMonto( rs.getBigDecimal( "monto" ) );
		credito.setPeriodoMeses( rs.getInt( "periodo_meses" ) );
		credito.setCuota( rs.getBigDecimal( "cuota" ) );
		credito.setTea( rs.getBigDecimal( "tea" ) );
		credito.setFechaVencimiento( rs.getDate( "fecha_vencimiento" ) );
		return credito;
	  }
}