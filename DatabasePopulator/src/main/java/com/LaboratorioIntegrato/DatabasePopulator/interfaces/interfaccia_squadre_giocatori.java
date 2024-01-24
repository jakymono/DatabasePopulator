package com.LaboratorioIntegrato.DatabasePopulator.interfaces;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.Squadre_giocatori;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * interfaccia per la tabella squadre_giocatori nel db
 */
public interface interfaccia_squadre_giocatori extends JpaRepository<Squadre_giocatori,Integer> {
}
