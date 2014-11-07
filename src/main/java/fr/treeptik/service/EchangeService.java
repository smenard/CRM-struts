package fr.treeptik.service;

import java.util.List;

import fr.treeptik.entity.Echange;
import fr.treeptik.exception.ServiceException;

public interface EchangeService {
	public void add(Echange echange)throws ServiceException;
    public List<Echange> getAll()throws ServiceException;
    public Echange get(Integer id)throws ServiceException;
    public void delete(Integer echangeId)throws ServiceException;

}
