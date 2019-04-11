package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Contrat;
import fr.adaming.service.IContratService;

@RestController
@RequestMapping("/contrat")
public class ContratRest {

	//transformation de l'association uml en Java
	@Autowired
	private IContratService contService;

	@RequestMapping(value="/liste", method=RequestMethod.GET, produces="application/json")
	public List<Contrat> findAll() {
		return contService.getAll();
	}

	@RequestMapping(value="/recherche", method=RequestMethod.GET, produces="application/json")
	public Contrat getContratById(@RequestParam("pId") long id) {
		return contService.getById(id);
	}

	@RequestMapping(value="/ajout", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Contrat ajoutContrat(@RequestBody Contrat cont) {
		return contService.ajout(cont);
	}

	@RequestMapping(value="/modif", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public Contrat modifContrat(@RequestBody Contrat cont) {
		return contService.modifier(cont);
	}

	@RequestMapping(value="/suppr/{pId}", method=RequestMethod.DELETE)
	public void supprContrat(@PathVariable("pId") long id) {
		contService.supprById(id);
	}

}
