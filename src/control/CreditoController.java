package control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dominio.Credito;
import servicio.CreditoService;
import servicio.MonedaService;
import servicio.ClienteService;
import servicio.PagoTarjetaService;

@Controller
@RequestMapping( "/credito" )
public class CreditoController {

	private CreditoService creditoService;
	private MonedaService monedaService;
	private ClienteService clienteService;
	private PagoTarjetaService pagoTarjetaService;

	@Autowired
	public CreditoController( CreditoService creditoService, MonedaService monedaService,
	                          ClienteService clienteService, PagoTarjetaService pagoTarjetaService ) {
		this.creditoService = creditoService;
		this.monedaService = monedaService;
		this.clienteService = clienteService;
		this.pagoTarjetaService = pagoTarjetaService;
	}

	@InitBinder
	public void initBinder( WebDataBinder binder ) {
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
		sdf.setLenient( false );
		binder.registerCustomEditor( Date.class, new CustomDateEditor( sdf, true ) );
	}

	@RequestMapping( value = "/listar.htm", method = RequestMethod.GET )
	public String listar( ModelMap model ) {
		List<Credito> creditos = creditoService.getAll();
		model.addAttribute( "creditos", creditos );
		model.addAttribute( "pagos", pagoTarjetaService.getAll() );
		return "creditoListar";
	}

	@RequestMapping( value = "/nuevo.htm", method = RequestMethod.GET )
	public String mostrarFormulario( ModelMap model ) {
		Credito credito = new Credito();
		credito.setPagos( pagoTarjetaService.getAll() );
		model.addAttribute( "credito", credito );
		model.addAttribute( "monedas", monedaService.getAll() );
		model.addAttribute( "clientes", clienteService.getAll() );
		return "creditoForm";
	}

	@RequestMapping( value = "/guardar.htm", method = RequestMethod.POST )
	public String guardar( @ModelAttribute("credito") Credito credito ) {
		if ( credito.getIdCredito() == null )
			creditoService.add( credito );
		else
			creditoService.update( credito );
		pagoTarjetaService.actualizarPagos( credito.getPagos() );
		return "redirect:/credito/listar.htm";
	}

	@RequestMapping( value = "/editar/{id}.htm", method = RequestMethod.GET )
	public String editar( @PathVariable("id") Integer idCredito, ModelMap model ) {
		Credito credito = creditoService.getById( idCredito );
		credito.setPagos( pagoTarjetaService.getAll() );
		model.addAttribute( "credito", credito );
		model.addAttribute( "monedas", monedaService.getAll() );
		model.addAttribute( "clientes", clienteService.getAll() );
		return "creditoForm";
	}

	@RequestMapping( value = "/eliminar/{id}.htm", method = RequestMethod.GET )
	public String eliminar( @PathVariable("id") Integer idCredito ) {
		creditoService.delete( idCredito );
		return "redirect:/credito/listar.htm";
	}

	@RequestMapping( value = "/porCliente/{idCliente}.htm", method = RequestMethod.GET )
	public String porCliente( @PathVariable("idCliente") Integer idCliente, ModelMap model ) {
		model.addAttribute( "creditos", creditoService.getByCliente( idCliente ) );
		model.addAttribute( "pagos", pagoTarjetaService.getAll() );
		return "creditoListar";
	}
}
