package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Role;

public interface IRoleService {
	
	public Role getById(int id);

	public List<Role> getAll();

	public Role ajout(Role r);

	public Role modifier(Role r);

	public void suppr(final Role r);

	public void supprById(final int id);

}
