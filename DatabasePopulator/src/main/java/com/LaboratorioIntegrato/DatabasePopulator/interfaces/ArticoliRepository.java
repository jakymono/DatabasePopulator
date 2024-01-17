package com.LaboratorioIntegrato.DatabasePopulator.interfaces;


import com.LaboratorioIntegrato.DatabasePopulator.model.db.Articoli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticoliRepository extends JpaRepository<Articoli,Integer> {

}
