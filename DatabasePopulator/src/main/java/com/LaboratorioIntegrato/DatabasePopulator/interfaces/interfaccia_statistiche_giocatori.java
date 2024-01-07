package com.LaboratorioIntegrato.DatabasePopulator.interfaces;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.Statistiche_Giocatori;
import org.springframework.data.jpa.repository.JpaRepository;

public interface interfaccia_statistiche_giocatori extends JpaRepository<Statistiche_Giocatori,Integer> {
}
