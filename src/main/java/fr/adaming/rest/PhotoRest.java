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

import fr.adaming.model.Photo;
import fr.adaming.service.IPhotoService;

@RestController
@RequestMapping("/photo")
@CrossOrigin(origins="http://localhost:4200")
public class PhotoRest {
	//transformation de l'association uml en Java
	@Autowired
	private IPhotoService phService;

	@RequestMapping(value="/liste", method=RequestMethod.GET, produces="application/json")
	public List<Photo> findAll() {
		return phService.getAll();
	}

	@RequestMapping(value="/recherche", method=RequestMethod.GET, produces="application/json")
	public Photo getPhotoById(@RequestParam("pId") int id) {
		return phService.getById(id);
	}

	@RequestMapping(value="/ajout", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Photo ajoutPhoto(@RequestBody Photo ph) {
		return phService.ajout(ph);
	}

	@RequestMapping(value="/modif", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public Photo modifPhoto(@RequestBody Photo ph) {
		return phService.modifier(ph);
	}

	@RequestMapping(value="/suppr/{pId}", method=RequestMethod.DELETE)
	public void supprPhoto(@PathVariable("pId") int id) {
		phService.supprById(id);
	}
	
}
