package com.LaboratorioIntegrato.DatabasePopulator.interfaces;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.Partita_Evento;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.classId.PartitaEventoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface interfaccia_partita_evento extends JpaRepository<Partita_Evento, PartitaEventoId> {
}
