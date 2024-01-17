package com.LaboratorioIntegrato.DatabasePopulator.interfaces;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.Eventi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventiRepository extends JpaRepository<Eventi,Integer> {
}
