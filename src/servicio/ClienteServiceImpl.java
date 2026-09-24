package servicio;

import java.util.List;

import baseDeDatos.ClienteJDBCTemplate;
import dominio.Cliente;

public class ClienteServiceImpl implements ClienteService {

	@Override
	public void add( Cliente cliente ) {
		ClienteJDBCTemplate dao = new ClienteJDBCTemplate();
		dao.insertar( cliente );
	  }

	@Override
	public void update( Cliente cliente ) {
		ClienteJDBCTemplate dao = new ClienteJDBCTemplate();
		dao.actualizar( cliente );
	  }

	@Override
	public void delete( Integer idCliente ) {
		ClienteJDBCTemplate dao = new ClienteJDBCTemplate();
		dao.eliminar( idCliente );
	  }

	@Override
	public Cliente getById( Integer idCliente ) {
		ClienteJDBCTemplate dao = new ClienteJDBCTemplate();
		return dao.obtenerPorId( idCliente );
	  }

	@Override
	public List<Cliente> getAll() {
		ClienteJDBCTemplate dao = new ClienteJDBCTemplate();
		return dao.listar();
	  }
}