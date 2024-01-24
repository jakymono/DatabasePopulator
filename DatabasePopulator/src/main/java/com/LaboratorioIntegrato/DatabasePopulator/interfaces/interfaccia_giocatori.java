package com.LaboratorioIntegrato.DatabasePopulator.interfaces;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.Giocatori;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * interfaccia per la tabella Giocatori nel db
 */
public interface interfaccia_giocatori extends JpaRepository<Giocatori,Integer> {
}
