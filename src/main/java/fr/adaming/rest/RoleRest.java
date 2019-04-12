package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Role;
import fr.adaming.service.IRoleService;

@RestController
@RequestMapping("/role")
public class RoleRest {

	//transformation de l'association uml en Java
	@Autowired
	private IRoleService rService;

	@RequestMapping(value="/liste", method=RequestMethod.GET, produces="application/json")
	public List<Role> findAll() {
		return rService.getAll();
	}

	@RequestMapping(value="/recherche", method=RequestMethod.GET, produces="application/json")
	public Role getRoleById(@RequestParam("pId") int id) {
		return rService.getById(id);
	}

	@RequestMapping(value="/ajout", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Role ajoutRole(@RequestBody Role r) {
		return rService.ajout(r);
	}

	@RequestMapping(value="/modif", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public Role modifRole(@RequestBody Role r) {
		return rService.modifier(r);
	}

	@RequestMapping(value="/suppr/{pId}", method=RequestMethod.DELETE)
	public void supprRole(@PathVariable("pId") int id) {
		rService.supprById(id);
	}

}
