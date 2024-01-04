package com.LaboratorioIntegrato.DatabasePopulator.interfaces;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.Giocatore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface interfaccia_giocatori extends JpaRepository<Giocatore,Integer> {
}
