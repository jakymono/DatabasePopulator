package com.LaboratorioIntegrato.DatabasePopulator.interfaces;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.Formazioni;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * interfaccia per la tabella formazioni nel db
 */
public interface interfaccia_formazioni extends JpaRepository<Formazioni,Integer> {
}
