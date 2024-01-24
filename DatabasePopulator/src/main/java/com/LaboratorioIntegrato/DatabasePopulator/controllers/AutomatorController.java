package com.LaboratorioIntegrato.DatabasePopulator.controllers;

import com.LaboratorioIntegrato.DatabasePopulator.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * classe per le automazioni
 */
@Component
@EnableScheduling
public class AutomatorController {

    EventiService eventiService;
    FormazioniService formazioniService;
    GiocatoreService giocatoreService;
    PartitaService partitaService;
    SquadraCampionatoService squadraCampionatoService;
    SquadraService squadraService;
    SquadreGiocatoriService squadreGiocatoriService;
    StadioService stadioService;
    StatisticheSquadraService statisticheSquadraService;
    AutomationService automationService;

    @Autowired
    public AutomatorController(AutomationService automationService,EventiService eventiService, FormazioniService formazioniService, GiocatoreService giocatoreService, PartitaService partitaService, SquadraCampionatoService squadraCampionatoService, SquadraService squadraService, SquadreGiocatoriService squadreGiocatoriService, StadioService stadioService, StatisticheSquadraService statisticheSquadraService) {
        this.eventiService = eventiService;
        this.formazioniService = formazioniService;
        this.giocatoreService = giocatoreService;
        this.partitaService = partitaService;
        this.squadraCampionatoService = squadraCampionatoService;
        this.squadraService = squadraService;
        this.squadreGiocatoriService = squadreGiocatoriService;
        this.stadioService = stadioService;
        this.statisticheSquadraService = statisticheSquadraService;
        this.automationService = automationService;
    }

    /**
     * metodo per automatizzare il popolamento di squadre e stadi
     */
    @Scheduled(cron = "0 0 1 8 *")
    public void AutoSquadreStadio()
    {
        try{
            partitaService.MettiPartite(135,automationService.AnnoStagione());
        }
        catch (Exception e){
            System.out.println(e.getMessage() + "\n" + "Errore in AutoSquadreStadio");
        }
        System.out.println("AutoSquadreStadio OK");
    }


    /**
     * metodo per automatizzare il popolamento della tabella relazonale tra campionati e squadre
     */
    @Scheduled(cron = "0 0 1 8 *")
    public void AutoCampionatoSquadre()
    {
        try {
            squadraCampionatoService.CollegamentoSquadreCampionato(automationService.AnnoStagione(),135);
        }
        catch (Exception e){
            System.out.println(e.getMessage() + "\n" + "Errore in AutoCampionatoSquadre");
        }
        System.out.println("AutoCampionatoSquadre OK");
    }


    /**
     * metodo per automatizzare il popolamento di statistiche_squadra
     */
    @Scheduled(cron = "0 0 1 * * MON")
    public void AutoStatisticheSquadre()
    {
        try {
            statisticheSquadraService.MettiStatistiche(135,automationService.AnnoStagione());
        }
        catch (Exception e){
            System.out.println(e.getMessage() + "\n" + "Errore in AutoStatisticheSquadre");
        }
        System.out.println("AutoStatisticheSquadre OK");
    }


    /**
     * metodo per automatizzare il popolamento di giocatori
     */
    @Scheduled(cron = "0 0 2 8 *")
    public void AutoGiocatori()
    {
        try {
            giocatoreService.MettiGiocatori(135,automationService.AnnoStagione());
        }
        catch (Exception e){
            System.out.println(e.getMessage() + "\n" + "Errore in AutoGiocatori");
        }
        System.out.println("AutoGiocatori OK");
    }


    /**
     * metodo per automatizzare il popolamento di partite
     */
    @Scheduled(cron = "0 0 1 8 *")
    public void AutoPartite()
    {
        try {
            partitaService.MettiPartite(135,automationService.AnnoStagione());
        }
        catch (Exception e){
            System.out.println(e.getMessage() + "\n" + "Errore in AutoPartite");
        }
        System.out.println("AutoPartite OK");
    }


    /**
     * metodo per automatizzare il popolamento della tabella di collegamento tra Squadre e Giocatori
     */
    @Scheduled(cron = "0 1 2 8 *")
    public void AutoSquadreGiocatori()
    {
        try {
            squadreGiocatoriService.CollegaSquadreGiocatori(automationService.AnnoStagione());
        }
        catch (Exception e){
            System.out.println(e.getMessage() + "\n" + "Errore in AutoSquadreGiocatori");
        }
        System.out.println("AutoSquadreGiocatori OK");
    }

    /**
     * metodo per automatizzare il popolamento delle tabelle Fromazioni, eventi e partita_eventi
     */
    @Scheduled(cron = "")
    public void AutoFormazioniEventi()
    {
        try {
            eventiService.popolaEventiFormazioniGiornata(automationService.getRound());
        }
        catch (Exception e){
            System.out.println(e.getMessage() + "\n" + "Errore in AutoFormazioniEventi");
        }
        System.out.println("AutoFormazioniEventi OK");
    }


}
