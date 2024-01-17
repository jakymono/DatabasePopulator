package com.LaboratorioIntegrato.DatabasePopulator.interfaces;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.Stadio;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface interfaccia_stadio extends JpaRepository<Stadio, Integer> {

    @Modifying
    @Query(value = "insert into stadio (id,nome,indirizzo,citta,capacita,terreno,immagine) values(:id,:nome,:indirizzo,:citta,:capacita,:terreno,:immagine)",nativeQuery = true)
    Void InserisciStadio(@Param(value = "id")int id, @Param(value = "nome")String nome,@Param(value = "indirizzo")String indirizzo, @Param(value = "citta")String citta, @Param(value = "capacita")int capacita,@Param(value = "terreno")String terreno,@Param(value = "immagine")String immagine);
}
