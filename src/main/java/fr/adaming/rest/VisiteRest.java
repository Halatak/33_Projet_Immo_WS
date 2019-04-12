package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Visite;
import fr.adaming.service.IVisiteService;

@RestController
@RequestMapping("/visite")
public class VisiteRest {

	//transformation de l'association uml en Java
	@Autowired
	private IVisiteService vService;

	@RequestMapping(value="/liste", method=RequestMethod.GET, produces="application/json")
	public List<Visite> findAll() {
		return vService.getAll();
	}

	@RequestMapping(value="/recherche", method=RequestMethod.GET, produces="application/json")
	public Visite getRoleById(@RequestParam("pId") long id) {
		return vService.getById(id);
	}

	@RequestMapping(value="/ajout", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Visite ajoutRole(@RequestBody Visite v) {
		return vService.ajout(v);
	}

	@RequestMapping(value="/modif", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public Visite modifRole(@RequestBody Visite v) {
		return vService.modifier(v);
	}

	@RequestMapping(value="/suppr/{pId}", method=RequestMethod.DELETE)
	public void supprVisite(@PathVariable("pId") long id) {
		vService.supprById(id);
	}

}
