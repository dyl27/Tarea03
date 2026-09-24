package servicio;

import java.util.List;

import baseDeDatos.CreditoJDBCTemplate;
import dominio.Credito;

public class CreditoServiceImpl implements CreditoService {

	@Override
	public void add( Credito credito ) {
		CreditoJDBCTemplate dao = new CreditoJDBCTemplate();
		dao.insertar( credito );
	  }

	@Override
	public void update( Credito credito ) {
		CreditoJDBCTemplate dao = new CreditoJDBCTemplate();
		dao.actualizar( credito );
	  }

	@Override
	public void delete( Integer idCredito ) {
		CreditoJDBCTemplate dao = new CreditoJDBCTemplate();
		dao.eliminar( idCredito );
	  }

	@Override
	public Credito getById( Integer idCredito ) {
		CreditoJDBCTemplate dao = new CreditoJDBCTemplate();
		return dao.obtenerPorId( idCredito );
	  }

	@Override
	public List<Credito> getAll() {
		CreditoJDBCTemplate dao = new CreditoJDBCTemplate();
		return dao.listar();
	  }

	@Override
	public List<Credito> getByCliente( Integer idCliente ) {
		CreditoJDBCTemplate dao = new CreditoJDBCTemplate();
		return dao.listarPorCliente( idCliente );
	  }
}