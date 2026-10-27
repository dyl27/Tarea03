package servicio;

import java.util.List;
import dominio.PagoTarjeta;

public interface PagoTarjetaService {
	List<PagoTarjeta> getAll();
	void actualizarPagos( List<PagoTarjeta> pagos );
}
