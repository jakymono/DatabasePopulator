package com.LaboratorioIntegrato.DatabasePopulator.interfaces;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.StatisticheGiocatore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface interfaccia_statistiche_giocatori extends JpaRepository<StatisticheGiocatore,Integer> {
}
