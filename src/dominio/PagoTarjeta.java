package dominio;

import java.math.BigDecimal;
import java.util.Date;

public class PagoTarjeta {

	private Integer idPago;
	private Date fecha;
	private String mes;
	private String tarjeta;
	private String transaccion;
	private BigDecimal gastos;
	private BigDecimal pagos;

	public Integer getIdPago() { return idPago; }
	public void setIdPago( Integer idPago ) { this.idPago = idPago; }

	public Date getFecha() { return fecha; }
	public void setFecha( Date fecha ) { this.fecha = fecha; }

	public String getMes() { return mes; }
	public void setMes( String mes ) { this.mes = mes; }

	public String getTarjeta() { return tarjeta; }
	public void setTarjeta( String tarjeta ) { this.tarjeta = tarjeta; }

	public String getTransaccion() { return transaccion; }
	public void setTransaccion( String transaccion ) { this.transaccion = transaccion; }

	public BigDecimal getGastos() { return gastos; }
	public void setGastos( BigDecimal gastos ) { this.gastos = gastos; }

	public BigDecimal getPagos() { return pagos; }
	public void setPagos( BigDecimal pagos ) { this.pagos = pagos; }
}
