package servicio;

import java.util.List;
import baseDeDatos.PagoTarjetaJDBCTemplate;
import dominio.PagoTarjeta;

public class PagoTarjetaServiceImpl implements PagoTarjetaService {

	@Override
	public List<PagoTarjeta> getAll() {
		return new PagoTarjetaJDBCTemplate().listar();
	}

	@Override
	public void actualizarPagos( List<PagoTarjeta> pagos ) {
		new PagoTarjetaJDBCTemplate().actualizarPagos( pagos );
	}
}
