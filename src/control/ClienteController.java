package control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dominio.Cliente;
import servicio.ClienteService;

@Controller
@RequestMapping( "/cliente" )
public class ClienteController {

	private ClienteService clienteService;

	@Autowired
	public ClienteController( ClienteService clienteService ) {
		this.clienteService = clienteService;
	  }

	@RequestMapping( value = "/listar.htm", method = RequestMethod.GET )
	public String listar( ModelMap model ) {
		List<Cliente> clientes = clienteService.getAll();
		model.addAttribute( "clientes", clientes );
		return "clienteListar";
	  }

	@RequestMapping( value = "/nuevo.htm", method = RequestMethod.GET )
	public String mostrarFormulario( ModelMap model ) {
		model.addAttribute( "cliente", new Cliente() );
		return "clienteForm";
	  }

	@RequestMapping( value = "/guardar.htm", method = RequestMethod.POST )
	public String guardar( @ModelAttribute("cliente") Cliente cliente ) {
		if ( cliente.getIdCliente() == null )
			clienteService.add( cliente );
		else
			clienteService.update( cliente );
		return "redirect:/cliente/listar.htm";
	  }

	@RequestMapping( value = "/editar/{id}.htm", method = RequestMethod.GET )
	public String editar( @PathVariable("id") Integer idCliente, ModelMap model ) {
		model.addAttribute( "cliente", clienteService.getById( idCliente ) );
		return "clienteForm";
	  }

	@RequestMapping( value = "/eliminar/{id}.htm", method = RequestMethod.GET )
	public String eliminar( @PathVariable("id") Integer idCliente ) {
		clienteService.delete( idCliente );
		return "redirect:/cliente/listar.htm";
	  }
}