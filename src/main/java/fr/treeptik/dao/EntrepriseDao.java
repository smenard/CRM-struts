package fr.treeptik.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.treeptik.entity.Entreprise;

public interface EntrepriseDao extends JpaRepository<Entreprise, Integer>{
	
	@Query("Select e from Entreprise e left join fetch e.contacts where e.id = :id")
	public Entreprise getWithContacts(@Param("id")Integer id) throws DataAccessException;
}
