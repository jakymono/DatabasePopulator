package com.LaboratorioIntegrato.DatabasePopulator.interfaces;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.Squadra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface interfaccia_squadre extends JpaRepository<Squadra, Integer> {

    @Query(value = "select * from squadre",nativeQuery = true)
    Squadra[] RitornaSquadre();

    @Query(value = "insert into squadre (id,nome,abbreviazione,id_stadio,paese,fondazione,nazionale,logo) values(:id,:nome,:abbreviazione,:id_stadio,:paese,:fondazione,:logo)",nativeQuery = true)
    Boolean InserisciSquadra(@Param(value = "id")int id,@Param(value = "nome")String nome,@Param(value = "abbreviazione")String abbreviazione,@Param(value = "id_stadio")int id_stadio,@Param(value = "paese")String paese,@Param(value = "fondazione")int fondazione,@Param(value = "logo")String logo);

}

