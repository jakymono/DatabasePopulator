package com.LaboratorioIntegrato.DatabasePopulator.interfaces;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.Eventi;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * interfaccia per la tabella Eventi nel db
 */
public interface interfaccia_eventi extends JpaRepository<Eventi,Integer> {
}
