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

import fr.adaming.model.BienAchat;
import fr.adaming.model.BienImmobilier;
import fr.adaming.model.BienLocation;
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Client;
import fr.adaming.model.Proprietaire;
import fr.adaming.service.IBienImmobilierService;
import fr.adaming.service.IClasseStandardService;

@RestController
@RequestMapping("/bienImmobilier")
@CrossOrigin(origins="http://localhost:4200")
public class BienImmobilierRest {

	// transformation de l'association uml en Java
	@Autowired
	private IBienImmobilierService biService;
	@Autowired
	private IClasseStandardService clService;

	@RequestMapping(value = "/liste", method = RequestMethod.GET, produces = "application/json")
	public List<BienImmobilier> findAll() {
		return biService.getAll();
	}

	@RequestMapping(value = "/rechercheClassStandard", method = RequestMethod.GET, produces = "application/json")
	public List<BienImmobilier> getBienImmobilierByClassStandard(@RequestParam("pId") int id) {
		ClasseStandard classeStandard = clService.getById(id);
		return biService.recBImmoParClasse(classeStandard);
	}

	@RequestMapping(value = "/rechercheProprietaire", method = RequestMethod.GET, produces = "application/json")
	public List<BienImmobilier> getBienImmobilierByProprietaire(@RequestParam("pId") int id) {
		Proprietaire proprio = new Proprietaire();
		proprio.setId(id);

		return biService.recBImmoParProp(proprio);
	}
	
	@RequestMapping(value = "/rechercheClient", method = RequestMethod.GET, produces = "application/json")
	public List<BienImmobilier> getBImmoByClient(@RequestParam("pId") int id) {
		Client client = new Client();
		client.setId(id);
		return biService.recBImmoParClient(client);
	}


	@RequestMapping(value = "/recherche", method = RequestMethod.GET, produces = "application/json")
	public BienImmobilier getBienImmobilierById(@RequestParam("pId") int id) {
		return biService.getById(id);
	}

	@RequestMapping(value = "/ajoutAchat", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public BienImmobilier ajoutBienAchat(@RequestBody BienAchat ba) {
		return biService.ajout(ba);
	}

	@RequestMapping(value = "/ajoutLocation", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public BienImmobilier ajoutBienLocation(@RequestBody BienLocation bl) {
		return biService.ajout(bl);
	}

	@RequestMapping(value = "/modifAchat", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public BienImmobilier modifBienAchat(@RequestBody BienAchat ba) {
		return biService.modifier(ba);
	}

	@RequestMapping(value = "/modifLocation", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public BienImmobilier modifBienLocation(@RequestBody BienLocation bl) {
		return biService.modifier(bl);
	}

	@RequestMapping(value = "/suppr/{pId}", method = RequestMethod.DELETE)
	public void supprBienImmobilier(@PathVariable("pId") int id) {
		biService.supprById(id);
	}

}
