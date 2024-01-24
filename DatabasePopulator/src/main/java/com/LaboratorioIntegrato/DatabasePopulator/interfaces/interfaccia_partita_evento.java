package com.LaboratorioIntegrato.DatabasePopulator.interfaces;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.Partita_Evento;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.classId.PartitaEventoId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * interfaccia per la tabella partita_evento nel db
 */
public interface interfaccia_partita_evento extends JpaRepository<Partita_Evento, PartitaEventoId> {
}
