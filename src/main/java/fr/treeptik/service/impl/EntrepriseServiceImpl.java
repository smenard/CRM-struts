package fr.treeptik.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import fr.treeptik.dao.EntrepriseDao;
import fr.treeptik.entity.Entreprise;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.service.EntrepriseService;

@Service
public class EntrepriseServiceImpl implements EntrepriseService{

	@Autowired
	private EntrepriseDao entrepriseDao;
	@Override
	public void add(Entreprise entreprise) throws ServiceException {
		try{
			entrepriseDao.save(entreprise);
		}catch(DataAccessException e){
			throw new ServiceException(e,"EntrepriseServiceImpl add");
		}
		
	}

	@Override
	public List<Entreprise> getAll() throws ServiceException {
		try{
			return entrepriseDao.findAll();
		}catch(DataAccessException e){
			throw new ServiceException(e, "EntrepriseServiceImpl getAll");
		}
		
	}

	@Override
	public Entreprise get(Integer id) throws ServiceException {
		try{
			return entrepriseDao.findOne(id);
		}catch(DataAccessException e){
			throw new ServiceException(e,"EntrepriseServiceImpl get");
		}
		
	}

	@Override
	public void delete(Integer entrepriseId) throws ServiceException {
		try{
			entrepriseDao.delete(entrepriseId);
		}catch(DataAccessException e){
			throw new ServiceException(e,"EntrepriseServiceImpl delete");
		}
		
	}

	@Override
	public Entreprise getWithContacts(Integer id) throws ServiceException {
		try{
			return entrepriseDao.getWithContacts(id);
		}catch(DataAccessException e){
			throw new ServiceException(e,"EntrepriseServiceImpl getWithContact");
		}
		
	}

}
