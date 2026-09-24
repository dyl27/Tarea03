package control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dominio.Moneda;
import servicio.MonedaService;

@Controller
@RequestMapping( "/moneda" )
public class MonedaController {

	private MonedaService monedaService;

	@Autowired
	public MonedaController( MonedaService monedaService ) {
		this.monedaService = monedaService;
	  }

	@RequestMapping( value = "/listar.htm", method = RequestMethod.GET )
	public String listar( ModelMap model ) {
		List<Moneda> monedas = monedaService.getAll();
		model.addAttribute( "monedas", monedas );
		return "monedaListar";
	  }

	@RequestMapping( value = "/nuevo.htm", method = RequestMethod.GET )
	public String mostrarFormulario( ModelMap model ) {
		model.addAttribute( "moneda", new Moneda() );
		return "monedaForm";
	  }

	@RequestMapping( value = "/guardar.htm", method = RequestMethod.POST )
	public String guardar( @ModelAttribute("moneda") Moneda moneda ) {
		if ( moneda.getIdMoneda() == null )
			monedaService.add( moneda );
		else
			monedaService.update( moneda );
		return "redirect:/moneda/listar.htm"; 
	  }

	@RequestMapping( value = "/editar/{id}.htm", method = RequestMethod.GET )
	public String editar( @PathVariable("id") Integer idMoneda, ModelMap model ) {
		model.addAttribute( "moneda", monedaService.getById( idMoneda ) );
		return "monedaForm";
	  }

	@RequestMapping( value = "/eliminar/{id}.htm", method = RequestMethod.GET )
	public String eliminar( @PathVariable("id") Integer idMoneda ) {
		monedaService.delete( idMoneda );
		return "redirect:/moneda/listar.htm";
	  }
}