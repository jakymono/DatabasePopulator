package com.LaboratorioIntegrato.DatabasePopulator.controllers;

import com.LaboratorioIntegrato.DatabasePopulator.model.api.players.Player;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.players.Players;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.players.Response;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Squadre;
import com.LaboratorioIntegrato.DatabasePopulator.service.SquadraService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class provaController
{

    SquadraService squadraService;
    @Autowired
    public provaController(SquadraService squadraService) {
        this.squadraService = squadraService;
    }

    @GetMapping("/squadre")
    public List<Squadre> getSquadre()
    {
        return squadraService.RitornaSquadre();
    }

    @GetMapping("/popolaSquadreStadi")
    public ResponseEntity<?> popolaSquadreStadi(){return squadraService.SquadretadioSplit(135,2023);}

    @GetMapping("/prova")
    public Object prova()
    {
       String json= "{\n" +
               "    \"get\": \"players\",\n" +
               "    \"parameters\": {\n" +
               "        \"league\": \"135\",\n" +
               "        \"season\": \"2023\",\n" +
               "        \"page\": \"1\"\n" +
               "    },\n" +
               "    \"errors\": [],\n" +
               "    \"results\": 20,\n" +
               "    \"paging\": {\n" +
               "        \"current\": 1,\n" +
               "        \"total\": 47\n" +
               "    },\n" +
               "    \"response\": [{\n" +
               "            \" player\": {\n" +
               "                \"id\": 217,\n" +
               "                \"name\": \"L. Martínez\",\n" +
               "                \"firstname\": \"Lautaro Javier\",\n" +
               "                \"lastname\": \"Martínez\",\n" +
               "                \"age\": 26,\n" +
               "                \"birth\": {\n" +
               "                    \"date\": \"1997-08-22\",\n" +
               "                    \"place\": \"Bahía Blanca\",\n" +
               "                    \"country\": \"Argentina\"\n" +
               "                },\n" +
               "                \"nationality\": \"Argentina\",\n" +
               "                \"height\": \"174 cm\",\n" +
               "                \"weight\": \"72 kg\",\n" +
               "                \"injured\": false,\n" +
               "                \"photo\": \"https://media-4.api-sports.io/football/players/217.png\"\n" +
               "            },\n" +
               "            \"statistics\": [\n" +
               "                {\n" +
               "                    \"team\": {\n" +
               "                        \"id\": 505,\n" +
               "                        \"name\": \"Inter\",\n" +
               "                        \"logo\": \"https://media-4.api-sports.io/football/teams/505.png\"\n" +
               "                    },\n" +
               "                    \"league\": {\n" +
               "                        \"id\": 135,\n" +
               "                        \"name\": \"Serie A\",\n" +
               "                        \"country\": \"Italy\",\n" +
               "                        \"logo\": \"https://media-4.api-sports.io/football/leagues/135.png\",\n" +
               "                        \"flag\": \"https://media-4.api-sports.io/flags/it.svg\",\n" +
               "                        \"season\": 2022\n" +
               "                    },\n" +
               "                    \"games\": {\n" +
               "                        \"appearences\": 38,\n" +
               "                        \"lineups\": 27,\n" +
               "                        \"minutes\": 2575,\n" +
               "                        \"number\": null,\n" +
               "                        \"position\": \"Attacker\",\n" +
               "                        \"rating\": \"7.218918\",\n" +
               "                        \"captain\": false\n" +
               "                    },\n" +
               "                    \"substitutes\": {\n" +
               "                        \"in\": 11,\n" +
               "                        \"out\": 9,\n" +
               "                        \"bench\": 11\n" +
               "                    },\n" +
               "                    \"shots\": {\n" +
               "                        \"total\": 100,\n" +
               "                        \"on\": 52\n" +
               "                    },\n" +
               "                    \"goals\": {\n" +
               "                        \"total\": 21,\n" +
               "                        \"conceded\": 0,\n" +
               "                        \"assists\": 6,\n" +
               "                        \"saves\": null\n" +
               "                    },\n" +
               "                    \"passes\": {\n" +
               "                        \"total\": 655,\n" +
               "                        \"key\": 46,\n" +
               "                        \"accuracy\": 13\n" +
               "                    },\n" +
               "                    \"tackles\": {\n" +
               "                        \"total\": 25,\n" +
               "                        \"blocks\": 1,\n" +
               "                        \"interceptions\": 13\n" +
               "                    },\n" +
               "                    \"duels\": {\n" +
               "                        \"total\": 331,\n" +
               "                        \"won\": 153\n" +
               "                    },\n" +
               "                    \"dribbles\": {\n" +
               "                        \"attempts\": 59,\n" +
               "                        \"success\": 28,\n" +
               "                        \"past\": null\n" +
               "                    },\n" +
               "                    \"fouls\": {\n" +
               "                        \"drawn\": 61,\n" +
               "                        \"committed\": 46\n" +
               "                    },\n" +
               "                    \"cards\": {\n" +
               "                        \"yellow\": 3,\n" +
               "                        \"yellowred\": 0,\n" +
               "                        \"red\": 0\n" +
               "                    },\n" +
               "                    \"penalty\": {\n" +
               "                        \"won\": null,\n" +
               "                        \"commited\": null,\n" +
               "                        \"scored\": 1,\n" +
               "                        \"missed\": 1,\n" +
               "                        \"saved\": null\n" +
               "                    }\n" +
               "                }\n" +
               "            ]\n" +
               "        }," +
               "{\n" +
               "            \" player\": {\n" +
               "                \"id\": 217,\n" +
               "                \"name\": \"L. Martínez\",\n" +
               "                \"firstname\": \"Lautaro Javier\",\n" +
               "                \"lastname\": \"Martínez\",\n" +
               "                \"age\": 26,\n" +
               "                \"birth\": {\n" +
               "                    \"date\": \"1997-08-22\",\n" +
               "                    \"place\": \"Bahía Blanca\",\n" +
               "                    \"country\": \"Argentina\"\n" +
               "                },\n" +
               "                \"nationality\": \"Argentina\",\n" +
               "                \"height\": \"174 cm\",\n" +
               "                \"weight\": \"72 kg\",\n" +
               "                \"injured\": false,\n" +
               "                \"photo\": \"https://media-4.api-sports.io/football/players/217.png\"\n" +
               "            },\n" +
               "            \"statistics\": [\n" +
               "                {\n" +
               "                    \"team\": {\n" +
               "                        \"id\": 505,\n" +
               "                        \"name\": \"Inter\",\n" +
               "                        \"logo\": \"https://media-4.api-sports.io/football/teams/505.png\"\n" +
               "                    },\n" +
               "                    \"league\": {\n" +
               "                        \"id\": 135,\n" +
               "                        \"name\": \"Serie A\",\n" +
               "                        \"country\": \"Italy\",\n" +
               "                        \"logo\": \"https://media-4.api-sports.io/football/leagues/135.png\",\n" +
               "                        \"flag\": \"https://media-4.api-sports.io/flags/it.svg\",\n" +
               "                        \"season\": 2022\n" +
               "                    },\n" +
               "                    \"games\": {\n" +
               "                        \"appearences\": 38,\n" +
               "                        \"lineups\": 27,\n" +
               "                        \"minutes\": 2575,\n" +
               "                        \"number\": null,\n" +
               "                        \"position\": \"Attacker\",\n" +
               "                        \"rating\": \"7.218918\",\n" +
               "                        \"captain\": false\n" +
               "                    },\n" +
               "                    \"substitutes\": {\n" +
               "                        \"in\": 11,\n" +
               "                        \"out\": 9,\n" +
               "                        \"bench\": 11\n" +
               "                    },\n" +
               "                    \"shots\": {\n" +
               "                        \"total\": 100,\n" +
               "                        \"on\": 52\n" +
               "                    },\n" +
               "                    \"goals\": {\n" +
               "                        \"total\": 21,\n" +
               "                        \"conceded\": 0,\n" +
               "                        \"assists\": 6,\n" +
               "                        \"saves\": null\n" +
               "                    },\n" +
               "                    \"passes\": {\n" +
               "                        \"total\": 655,\n" +
               "                        \"key\": 46,\n" +
               "                        \"accuracy\": 13\n" +
               "                    },\n" +
               "                    \"tackles\": {\n" +
               "                        \"total\": 25,\n" +
               "                        \"blocks\": 1,\n" +
               "                        \"interceptions\": 13\n" +
               "                    },\n" +
               "                    \"duels\": {\n" +
               "                        \"total\": 331,\n" +
               "                        \"won\": 153\n" +
               "                    },\n" +
               "                    \"dribbles\": {\n" +
               "                        \"attempts\": 59,\n" +
               "                        \"success\": 28,\n" +
               "                        \"past\": null\n" +
               "                    },\n" +
               "                    \"fouls\": {\n" +
               "                        \"drawn\": 61,\n" +
               "                        \"committed\": 46\n" +
               "                    },\n" +
               "                    \"cards\": {\n" +
               "                        \"yellow\": 3,\n" +
               "                        \"yellowred\": 0,\n" +
               "                        \"red\": 0\n" +
               "                    },\n" +
               "                    \"penalty\": {\n" +
               "                        \"won\": null,\n" +
               "                        \"commited\": null,\n" +
               "                        \"scored\": 1,\n" +
               "                        \"missed\": 1,\n" +
               "                        \"saved\": null\n" +
               "                    }\n" +
               "                }\n" +
               "            ]\n" +
               "        }]\n" +
               "}";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Players player = objectMapper.readValue(json, Players.class);
            return "works";
        } catch (JsonMappingException e) {
            return e.fillInStackTrace();
        } catch (Exception e) {
            return e.getStackTrace();
        }
    }
}
