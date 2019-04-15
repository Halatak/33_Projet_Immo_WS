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

import fr.adaming.model.BienImmobilier;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Visite;
import fr.adaming.service.IBienImmobilierService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IConseillerService;
import fr.adaming.service.IVisiteService;

@RestController
@RequestMapping("/visite")
@CrossOrigin(origins="http://localhost:4200")
public class VisiteRest {

	// transformation de l'association uml en Java
	@Autowired
	private IVisiteService vService;
	@Autowired
	private IConseillerService consService;
	@Autowired
	private IClientService clService;
	@Autowired
	private IBienImmobilierService biService;

	@RequestMapping(value = "/liste", method = RequestMethod.GET, produces = "application/json")
	public List<Visite> findAll() {
		return vService.getAll();
	}

	@RequestMapping(value = "/recherche", method = RequestMethod.GET, produces = "application/json")
	public Visite getVisiteById(@RequestParam("pId") int id) {
		return vService.getById(id);
	}

	@RequestMapping(value = "/rechercheByConseiller", method = RequestMethod.GET, produces = "application/json")
	public Visite getVisiteByIdConseiller(@RequestParam("pId") int id) {
		// recupere le conseiller
		Conseiller cIn = consService.getById(id);
		return (Visite) vService.recVisiteParConseiller(cIn);
	}

	@RequestMapping(value = "/rechercheByClient", method = RequestMethod.GET, produces = "application/json")
	public List<Visite> getVisiteByIdClient(@RequestParam("pId") int id) {
		// recupere le client
		Client clIn = clService.getById(id);
		return vService.recVisiteParClient(clIn);
	}

	@RequestMapping(value = "/rechercheByBienImmo", method = RequestMethod.GET, produces = "application/json")
	public List<Visite> getVisiteByIdBienImmo(@RequestParam("pId") int id) {
		// recupere le bien immo
		BienImmobilier biIn = biService.getById(id);
		return vService.recVisiteParBImmo(biIn);
	}

	@RequestMapping(value = "/ajout", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Visite ajoutVisite(@RequestBody Visite v) {
		return vService.ajout(v);
	}

	@RequestMapping(value = "/modif", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public Visite modifVisite(@RequestBody Visite v) {
		return vService.modifier(v);
	}

	@RequestMapping(value = "/suppr/{pId}", method = RequestMethod.DELETE)
	public void supprVisite(@PathVariable("pId") int id) {
		vService.supprById(id);
	}

}
