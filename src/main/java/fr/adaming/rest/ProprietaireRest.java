package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Proprietaire;
import fr.adaming.service.IPropritaireService;

@RestController
@RequestMapping("/proprietaire")
@CrossOrigin(origins="http://localhost:4200")
public class ProprietaireRest {

	//transformation de l'association uml en Java
	@Autowired
	private IPropritaireService pService;

	@RequestMapping(value="/liste", method=RequestMethod.GET, produces="application/json")
	public List<Proprietaire> findAll() {
		return pService.getAll();
	}

	@RequestMapping(value="/recherche", method=RequestMethod.GET, produces="application/json")
	public Proprietaire getProprietaireById(@RequestParam("pId") int id) {
		return pService.getById(id);
	}

	@RequestMapping(value="/ajout", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Proprietaire ajoutProprietaire(@RequestBody Proprietaire p) {
		return pService.ajout(p);
	}

	@RequestMapping(value="/modif", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public Proprietaire modifProprietaire(@RequestBody Proprietaire p) {
		return pService.modifier(p);
	}

	@RequestMapping(value="/suppr/{pId}", method=RequestMethod.DELETE)
	public void supprProprietaire(@PathVariable("pId") int id) {
		pService.supprById(id);
	}

}
