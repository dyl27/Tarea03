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
import dominio.PagoTarjeta;

public class PagoTarjetaJDBCTemplate {

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
		catch ( SQLException error ) {
			System.out.println( error.toString() );
			return connect;
		}
	}

	public List<PagoTarjeta> listar() {
		Connection connect = null;
		List<PagoTarjeta> lista = new ArrayList<PagoTarjeta>();
		try {
			connect = getConexion();
			ResultSet rs = connect.prepareStatement( "select * from pago_tarjeta order by fecha" ).executeQuery();
			while ( rs.next() ) {
				PagoTarjeta p = new PagoTarjeta();
				p.setIdPago( rs.getInt( "id_pago" ) );
				p.setFecha( rs.getDate( "fecha" ) );
				p.setMes( rs.getString( "mes" ) );
				p.setTarjeta( rs.getString( "tarjeta" ) );
				p.setTransaccion( rs.getString( "transaccion" ) );
				p.setGastos( rs.getBigDecimal( "gastos" ) );
				p.setPagos( rs.getBigDecimal( "pagos" ) );
				lista.add( p );
			}
		}
		catch ( SQLException error ) { System.out.println( error.toString() ); }
		finally {
			try { connect.close(); }
			catch ( SQLException error ) { System.out.println( "Error Connect :" + error.toString() ); }
		}
		return lista;
	}

	public void actualizarPagos( List<PagoTarjeta> pagos ) {
		Connection connect = null;
		try {
			connect = getConexion();
			PreparedStatement ps = connect.prepareStatement( "update pago_tarjeta set pagos=? where id_pago=?" );
			for ( PagoTarjeta p : pagos ) {
				ps.setBigDecimal( 1, p.getPagos() );
				ps.setInt( 2, p.getIdPago() );
				ps.executeUpdate();
			}
		}
		catch ( SQLException error ) { System.out.println( error.toString() ); }
		finally {
			try { connect.close(); }
			catch ( SQLException error ) { System.out.println( "Error Connect :" + error.toString() ); }
		}
	}
}
