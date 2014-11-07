package fr.treeptik.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.treeptik.entity.Contact;


public interface ContactDao extends JpaRepository<Contact, Integer>{

	@Query("select c from Contact c left join c.entreprise e where e.id=:entrepriseId")
	public List<Contact> findAllEntreprise(@Param("entrepriseId")Integer entrepriseId);
	@Query("select c from Contact c left join fetch c.echanges  e where c.id = :id order by e.date desc")
	public Contact getWithEchanges(@Param("id")Integer id) throws DataAccessException;
}
