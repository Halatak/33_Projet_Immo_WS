package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.BienImmobilier;
import fr.adaming.service.IBienImmobilierService;

@RestController
@RequestMapping("/bienImmobilier")
public class BienImmobilierRest {

	//transformation de l'association uml en Java
	@Autowired
	private IBienImmobilierService biService;

	@RequestMapping(value="/liste", method=RequestMethod.GET, produces="application/json")
	public List<BienImmobilier> findAll() {
		return biService.getAll();
	}

	@RequestMapping(value="/recherche", method=RequestMethod.GET, produces="application/json")
	public BienImmobilier getBienImmobilierById(@RequestParam("pId") long id) {
		return biService.getById(id);
	}

	@RequestMapping(value="/ajout", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public BienImmobilier ajoutBienImmobilier(@RequestBody BienImmobilier bi) {
		return biService.ajout(bi);
	}

	@RequestMapping(value="/modif", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public BienImmobilier modifBienImmobilier(@RequestBody BienImmobilier bi) {
		return biService.modifier(bi);
	}

	@RequestMapping(value="/suppr/{pId}", method=RequestMethod.DELETE)
	public void supprBienImmobilier(@PathVariable("pId") long id) {
		biService.supprById(id);
	}

}
