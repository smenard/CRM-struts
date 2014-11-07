package fr.treeptik.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import fr.treeptik.dao.EchangeDao;
import fr.treeptik.entity.Echange;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.service.EchangeService;

@Service
public class EchangeServiceImpl implements EchangeService {

	@Autowired
	private EchangeDao echangeDao;
	@Override
	public void add(Echange echange) throws ServiceException {
		try{
			echangeDao.save(echange);
		}catch(DataAccessException e){
			throw new ServiceException(e,"EchangeService Impl add");
		}
		
	}

	@Override
	public List<Echange> getAll() throws ServiceException {
		try{
			return echangeDao.findAll();
		}catch(DataAccessException e){
			throw new ServiceException(e,"EchangeServiceImpl getAll");
		}

	}

	@Override
	public Echange get(Integer id) throws ServiceException {
		try{
			return echangeDao.findOne(id);
		}catch(DataAccessException e){
			throw new ServiceException(e, "EchangeServiceImpl get");
		}
		
	}

	@Override
	public void delete(Integer echangeId) throws ServiceException {
		try{
			echangeDao.delete(echangeId);
		}catch(DataAccessException e){
			throw new ServiceException(e, "EchangeServiceImpl delete");
		}
		
	}

}
