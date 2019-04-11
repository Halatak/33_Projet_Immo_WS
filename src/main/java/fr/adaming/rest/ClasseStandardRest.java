package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.ClasseStandard;
import fr.adaming.service.IClasseStandardService;

@RestController
@RequestMapping("/classeStandard")
public class ClasseStandardRest {

	//transformation de l'association uml en Java
	@Autowired
	private IClasseStandardService csService;

	@RequestMapping(value="/liste", method=RequestMethod.GET, produces="application/json")
	public List<ClasseStandard> findAll() {
		return csService.getAll();
	}

	@RequestMapping(value="/recherche", method=RequestMethod.GET, produces="application/json")
	public ClasseStandard getClasseStandardById(@RequestParam("pId") long id) {
		return csService.getById(id);
	}

	@RequestMapping(value="/ajout", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public ClasseStandard ajoutClasseStandard(@RequestBody ClasseStandard cs) {
		return csService.ajout(cs);
	}

	@RequestMapping(value="/modif", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public ClasseStandard modifClasseStandard(@RequestBody ClasseStandard cs) {
		return csService.modifier(cs);
	}

	@RequestMapping(value="/suppr/{pId}", method=RequestMethod.DELETE)
	public void supprClasseStandard(@PathVariable("pId") long id) {
		csService.supprById(id);
	}

}
