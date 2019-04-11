package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.dao.IRoleDao;
import fr.adaming.model.Role;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements IRoleService{
	

	//transformation uml en java
	private IRoleDao roleDao;

	//setters
	@Autowired
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
		roleDao.setClazz(Role.class);
	}
	public IGeneriqueDao<Role> getRoleDao() {
		return roleDao;
	}

	@Override
	public List<Role> getAll() {
		return roleDao.getAll();
	}

	@Override
	public Role ajout(Role r) {
		return roleDao.ajout(r);
	}

	@Override
	public Role modifier(Role r) {
		return roleDao.modifier(r);

	}

	@Override
	public void suppr(Role r) {
		roleDao.suppr(r);
	}

	@Override
	public void supprById(long id) {
		roleDao.supprById(id);

	}

	@Override
	public Role getById(long id) {
		return roleDao.getById(id);
	}


}
