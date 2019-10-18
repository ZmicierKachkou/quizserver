package by.bsu.zmicier.schemas;

import by.bsu.zmicier.schemas.builders.AbstractShuffleSchemaBuilder;
import by.bsu.zmicier.schemas.builders.Shuffle441SchemaBuilder;
import by.bsu.zmicier.schemas.builders.Shuffle44SchemaBuilder;

import java.util.Arrays;

public final class SchemaValidator {
    private SchemaValidator() {}

    private static int[][] getPairs(int[] array) {
        int[][] res = new int[(array.length * (array.length - 1) ) / 2][];
        int index = 0;
        for(int i = 0; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++) {
                res[index] =  new int[] {Math.min(array[i], array[j]), Math.max(array[i], array[j])};
                index++;
            }
        }
        return res;
    }

    private int getNumOfPlayers(int[][] tour) {
        return Arrays.stream(tour)
                .mapToInt(x -> x.length)
                .sum();
    }

    private static Integer checkAllEqualsAndReturn(int[] array) {
        if(array == null || array.length == 0) {
            return null;
        }

        int first = array[0];
        if(Arrays.stream(array, 1, array.length).allMatch(x -> x == first)) {
            return first;
        } else {
            return null;
        }
    }

    private static boolean checkPlayersId(int[][] tour, int expectedNumOfPlayers) {
        for(int i = 1; i <= expectedNumOfPlayers; i++) {
            int index = i;
            if(Arrays.stream(tour).noneMatch(x -> Arrays.binarySearch(x, index) > -1)){
                return false;
            }
        }
        return true;
    }

    private static boolean validateShuffleSchema(int[][][] schema) {
        if(schema == null || schema.length == 0) {
            return false;
        }

        Integer numOfPlayers = checkAllEqualsAndReturn(Arrays.stream(schema)
                .mapToInt(teamsList -> Arrays.stream(teamsList)
                        .mapToInt(x -> x.length)
                        .sum())
                .toArray());

        if(numOfPlayers == null) {
            return false;
        }

        int[][] table = new int[numOfPlayers][numOfPlayers];
        for(int[][] tour: schema) {
            for(int[] team: tour) {
                if(!checkPlayersId(tour, numOfPlayers)) {
                    return false;
                }
                for (int[] pair : getPairs(team)) {
                    table[pair[0] - 1][pair[1] - 1]++;
                }
            }
        }

        int[] result = new int[(numOfPlayers * (numOfPlayers - 1) / 2)];
        int index = 0;

        System.out.print("XX");
        for(int i = 0; i <numOfPlayers; i++) {
            System.out.print("\t" + (i+1));
        }
        System.out.println("\n");

        for(int i = 0; i < numOfPlayers; i++) {
             for(int j = 0; j < numOfPlayers; j++) {
                 if(j > i) {
                     result[index] = table[i][j];
                     index++;
                 }
                 System.out.print("\t" + table[i][j]);
            }
            System.out.println("");
        }

        return checkAllEqualsAndReturn(result) != null;
    }

    public static boolean validateShuffleSchemaBuilder(AbstractShuffleSchemaBuilder builder) {
        return validateShuffleSchema(builder.getSchema());
    }

    public static void main(String[] args) {
        System.out.println(validateShuffleSchemaBuilder(new Shuffle44SchemaBuilder()));
    }
}