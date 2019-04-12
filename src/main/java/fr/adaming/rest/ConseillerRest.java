package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Conseiller;
import fr.adaming.service.IConseillerService;

@RestController
@RequestMapping("/conseiller")
public class ConseillerRest {

	//transformation de l'association uml en Java
	@Autowired
	private IConseillerService consService;

	@RequestMapping(value="/liste", method=RequestMethod.GET, produces="application/json")
	public List<Conseiller> findAll() {
		return consService.getAll();
	}

	@RequestMapping(value="/recherche", method=RequestMethod.GET, produces="application/json")
	public Conseiller getConseillerById(@RequestParam("pId") int id) {
		return consService.getById(id);
	}

	@RequestMapping(value="/ajout", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Conseiller ajoutConseiller(@RequestBody Conseiller cons) {
		return consService.ajout(cons);
	}

	@RequestMapping(value="/modif", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public Conseiller modifConseiller(@RequestBody Conseiller cons) {
		return consService.modifier(cons);
	}

	@RequestMapping(value="/suppr/{pId}", method=RequestMethod.DELETE)
	public void supprConseiller(@PathVariable("pId") int id) {
		consService.supprById(id);
	}

}
