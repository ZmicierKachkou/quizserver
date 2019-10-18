package by.bsu.zmicier.schemas.builders;

import by.bsu.zmicier.schemas.SchemaBuilder;

import java.util.Arrays;

public class StableSchemaBuilder implements SchemaBuilder {
    private int tours;
    private int[] teams;

    public StableSchemaBuilder(int tours, int ... teams) {
        this.tours = tours;

        if(Arrays.stream(teams).anyMatch(i -> i < 1)) {
            throw new IllegalArgumentException("Cannot have teams with less than 1 player!");
        };
        this.teams = teams;
    }

    @Override
    public int[][][] getSchema() {
        int[][][] schema = new int[tours][][];
        for(int i = 0; i < schema.length; i++) {
            schema[i] = new int[teams.length][];
            int playerIdIndex = 1;
            for(int teamsNo = 0; teamsNo < teams.length; teamsNo++) {
                schema[i][teamsNo] = new int[teams[teamsNo]];
                for(int playerId = 0; playerId < teams[teamsNo]; playerId++) {
                    schema[i][teamsNo][playerId] = playerIdIndex + playerId;
                }
                playerIdIndex += teams[teamsNo];
            }
        }

        return schema;
    }
}
