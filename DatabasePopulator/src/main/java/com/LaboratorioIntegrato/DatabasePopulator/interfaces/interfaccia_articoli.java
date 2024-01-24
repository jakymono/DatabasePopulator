package com.LaboratorioIntegrato.DatabasePopulator.interfaces;


import com.LaboratorioIntegrato.DatabasePopulator.model.db.Articoli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * interfaccia per la tabella Articoli nel db
 */
@Repository
public interface interfaccia_articoli extends JpaRepository<Articoli,Integer> {

}
