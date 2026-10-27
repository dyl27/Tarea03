package dominio;

import java.math.BigDecimal;
import java.util.Date;
import org.springframework.util.AutoPopulatingList;
import java.util.List;

public class Credito {

	private Integer idCredito;
	private Integer idCliente;
	private Integer idMoneda;
	private Date fecha;
	private BigDecimal monto;
	private Integer periodoMeses;
	private BigDecimal cuota;
	private BigDecimal tea;
	private Date fechaVencimiento;
	private List<PagoTarjeta> pagos = new AutoPopulatingList<PagoTarjeta>( PagoTarjeta.class );

	public Integer getIdCredito() {
		return idCredito;
	  }
	public Integer getIdCliente() {
		return idCliente;
	  }
	public Integer getIdMoneda() {
		return idMoneda;
	  }
	public Date getFecha() {
		return fecha;
	  }
	public BigDecimal getMonto() {
		return monto;
	  }
	public Integer getPeriodoMeses() {
		return periodoMeses;
	  }
	public BigDecimal getCuota() {
		return cuota;
	  }
	public BigDecimal getTea() {
		return tea;
	  }
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	  }
	public void setIdCredito( Integer idCredito ) {
		this.idCredito = idCredito;
	  }
	public void setIdCliente( Integer idCliente ) {
		this.idCliente = idCliente;
	  }
	public void setIdMoneda( Integer idMoneda ) {
		this.idMoneda = idMoneda;
	  }
	public void setFecha( Date fecha ) {    
		this.fecha = fecha;
	  }
	public void setMonto( BigDecimal monto ) {
		this.monto = monto;
	  }
	public void setPeriodoMeses( Integer periodoMeses ) {
		this.periodoMeses = periodoMeses;
	  }
	public void setCuota( BigDecimal cuota ) {
		this.cuota = cuota;
	  }
	public void setTea( BigDecimal tea ) {
		this.tea = tea;
	  }
	public void setFechaVencimiento( Date fechaVencimiento ) {
		this.fechaVencimiento = fechaVencimiento;
	  }
	
	public List<PagoTarjeta> getPagos() {
		return pagos;
	}
	public void setPagos( List<PagoTarjeta> pagos ) {
		this.pagos = pagos;
	}	
	
	
}