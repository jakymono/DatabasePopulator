package com.LaboratorioIntegrato.DatabasePopulator.interfaces;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.Partite;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Statistiche_Squadre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface interfaccia_partite extends JpaRepository<Partite, Integer> {
}
