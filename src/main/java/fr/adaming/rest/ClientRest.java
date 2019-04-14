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
import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@RestController
@RequestMapping("/client")
public class ClientRest {

	//transformation de l'association uml en Java
	@Autowired
	private IClientService clService;

	@RequestMapping(value="/liste", method=RequestMethod.GET, produces="application/json")
	public List<Client> findAll() {
		return clService.getAll();
	}

	@RequestMapping(value="/recherche", method=RequestMethod.GET, produces="application/json")
	public Client getRoleById(@RequestParam("pId") int id) {
		return clService.getById(id);
	}

	@RequestMapping(value="/ajout", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Client ajoutRole(@RequestBody Client cl) {
		return clService.ajout(cl);
	}

	@RequestMapping(value="/modif", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public Client modifRole(@RequestBody Client cl) {
		return clService.modifier(cl);
	}

	@RequestMapping(value="/suppr/{pId}", method=RequestMethod.DELETE)
	public void supprRole(@PathVariable("pId") int id) {
		clService.supprById(id);
	}
	
	@RequestMapping(value = "/rechercheClasse", method = RequestMethod.GET, produces = "application/json")
	public List<Client> getClientByClasse(@RequestParam("pId") int id) {
		ClasseStandard classe = new ClasseStandard();
		classe.setId(id);
		return clService.recClientParClasse(classe);
	}

}
