package by.bsu.zmicier.components;

import by.bsu.zmicier.components.actions.ActionMapping;
import by.bsu.zmicier.components.messages.Message;
import by.bsu.zmicier.dto.GameState;
import by.bsu.zmicier.dto.Team;
import by.bsu.zmicier.dto.Tour;
import by.bsu.zmicier.schemas.AllSchemas;

import java.util.*;

public class QuizServer {
    private AllSchemas schema;
    private GameState gameState = new GameState();

    public AllSchemas getSchema() {
        return schema;
    }

    public void setSchema(AllSchemas schema) {
        this.schema = schema;
    }

    public Message processRequest(Request request) {
         return ActionMapping.getAction(request.getAction()).execute(request, gameState);
    }

    private List<String> unifyNames(List<String> names) {
        Map<String, Integer> counter = new HashMap<>();

        List<String> unifiedNames = new ArrayList<>(names.size());

        for(String name: names) {
            String newName;
            if(counter.get(name) == null) {
                newName = name;
                counter.put(name, 1);
            } else {
                int repeats = counter.get(name);
                newName = name + " " + repeats;
                counter.put(name, repeats + 1);
            }
            unifiedNames.add(newName);
        }
        return unifiedNames;
    }

    /**
    public List<Tour> generateQuiz(List<String> names) {
        List<String> newNames = unifyNames(names);
        if(schema.isShuffle()) {
            Collections.shuffle(newNames);
        }

        int playerId = 1;
        Map<Integer, Player> players = new HashMap<>();
        for(String name: newNames) {
            Player player = new Player(playerId, name);
            players.put(playerId, player);
            playerId++;
        }

        int[][][] schemaDescription = schema.getSchemaBuilder().getSchema();

        List<Tour> quiz = new ArrayList<>(schemaDescription.length);
        int tourId = 1;
        for(int[][] tourDescription: schemaDescription) {
            Tour tour = new Tour(tourId);
            tour.setTourName("Тур " + tourId);
            List<Team> teams = new ArrayList<>(tourDescription.length);

            int teamId = 1;
            for(int[] teamDescription: tourDescription) {
                Team team = new Team();
                team.setId(teamId);
                team.setName("Команда " + teamId);
                List<Player> playersOfTeam = new ArrayList<>(teamDescription.length);
                for(int personCode: teamDescription) {
                    playersOfTeam.add(players.get(personCode));
                }
                team.setPlayers(playersOfTeam);
                teams.add(team);
                teamId++;
            }
            tour.setTeams(teams);
            quiz.add(tour);
            tourId++;
        }
        return quiz;
    } */

    public static void main(String[] args) {
        QuizServer server = new QuizServer();
        server.setSchema(AllSchemas.SCHEMA_4_4_1_SHUFFLE);
        // System.out.println(server.generateQuiz(Arrays.asList("Дима", "Инга", "Илья", "Юля", "Антон", "Надя", "Влад", "Паша", "Андрей")));
    }


}
