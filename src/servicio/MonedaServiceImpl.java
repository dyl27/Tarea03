package servicio;

import java.util.List;

import baseDeDatos.MonedaJDBCTemplate;
import dominio.Moneda;

public class MonedaServiceImpl implements MonedaService {

	@Override
	public void add( Moneda moneda ) {
		MonedaJDBCTemplate dao = new MonedaJDBCTemplate();
		dao.insertar( moneda );
	  }

	@Override
	public void update( Moneda moneda ) {
		MonedaJDBCTemplate dao = new MonedaJDBCTemplate();
		dao.actualizar( moneda );
	  }

	@Override
	public void delete( Integer idMoneda ) {
		MonedaJDBCTemplate dao = new MonedaJDBCTemplate();
		dao.eliminar( idMoneda );
	  }

	@Override
	public Moneda getById( Integer idMoneda ) {
		MonedaJDBCTemplate dao = new MonedaJDBCTemplate();
		return dao.obtenerPorId( idMoneda );
	  }

	@Override
	public List<Moneda> getAll() {
		MonedaJDBCTemplate dao = new MonedaJDBCTemplate();
		return dao.listar();
	  }
}