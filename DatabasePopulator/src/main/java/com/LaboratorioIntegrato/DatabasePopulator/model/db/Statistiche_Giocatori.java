package com.LaboratorioIntegrato.DatabasePopulator.model.db;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * model per la tabella del db
 */
@Entity
public class Statistiche_Giocatori
{
    @Id
    public int id_giocatore;
    public int stagione; //FK,PK
    public int id_squadra; //FK
    public int presenze;
    public int partita_titolare;
    public int minuti_giocati;
    public String posizione;
    public float media_voto;
    public int cambi_dentro;
    public int cambi_fuori;
    public int tiri_totali;
    public int tiri_porta;
    public int goal;
    public int assist;
    public int passaggi_totali;
    public int passaggi_chiave;
    public int contrasti;
    public int blocchi;
    public int intercetti;
    public int duelli_totali;
    public int duelli_vinti;
    public int dribbling_totali;
    public int dribbling_riusciti;
    public int falli_fatti;
    public int falli_subiti;
    public int cartellini_gialli;
    public int cartellini_doppiogiallo;
    public int cartellini_rosso;
    public int rigori_segnati;
    public int rigori_sbagliati;
    public int rigori_parati;

    public Statistiche_Giocatori(int id_giocatore, int stagione, int id_squadra, int presenze, int partita_titolare, int minuti_giocati, String posizione, float media_voto, int cambi_dentro, int cambi_fuori, int tiri_totali, int tiri_porta, int goal, int assist, int passaggi_totali, int passaggi_chiave, int contrasti, int blocchi, int intercetti, int duelli_totali, int duelli_vinti, int dribbling_totali, int dribbling_riusciti, int falli_fatti, int falli_subiti, int cartellini_gialli, int cartellini_doppiogiallo, int cartellini_rosso, int rigori_segnati, int rigori_sbagliati, int rigori_parati) {
        this.id_giocatore = id_giocatore;
        this.stagione = stagione;
        this.id_squadra = id_squadra;
        this.presenze = presenze;
        this.partita_titolare = partita_titolare;
        this.minuti_giocati = minuti_giocati;
        this.posizione = posizione;
        this.media_voto = media_voto;
        this.cambi_dentro = cambi_dentro;
        this.cambi_fuori = cambi_fuori;
        this.tiri_totali = tiri_totali;
        this.tiri_porta = tiri_porta;
        this.goal = goal;
        this.assist = assist;
        this.passaggi_totali = passaggi_totali;
        this.passaggi_chiave = passaggi_chiave;
        this.contrasti = contrasti;
        this.blocchi = blocchi;
        this.intercetti = intercetti;
        this.duelli_totali = duelli_totali;
        this.duelli_vinti = duelli_vinti;
        this.dribbling_totali = dribbling_totali;
        this.dribbling_riusciti = dribbling_riusciti;
        this.falli_fatti = falli_fatti;
        this.falli_subiti = falli_subiti;
        this.cartellini_gialli = cartellini_gialli;
        this.cartellini_doppiogiallo = cartellini_doppiogiallo;
        this.cartellini_rosso = cartellini_rosso;
        this.rigori_segnati = rigori_segnati;
        this.rigori_sbagliati = rigori_sbagliati;
        this.rigori_parati = rigori_parati;
    }

    public Statistiche_Giocatori() {
    }
}