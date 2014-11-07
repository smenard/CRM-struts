package fr.treeptik.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.treeptik.entity.Echange;

public interface EchangeDao extends JpaRepository<Echange, Integer>{

}
