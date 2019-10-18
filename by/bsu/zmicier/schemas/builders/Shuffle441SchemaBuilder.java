package by.bsu.zmicier.schemas.builders;

import by.bsu.zmicier.schemas.SchemaPresentator;

import java.util.Arrays;

public class Shuffle441SchemaBuilder implements SchemaPresentator {

    private final static int NUMBER_OF_TOURS = 9;
    private final static int NUMBER_OF_TEAMS = 3;


    private static final int[][][] schemaTemplate = {
            {{1,2,3,4}, {5,6,7,8}, {9}},
            {{1,2,5,6}, {3,7,8,9}, {4}},
            {{1,2,7,8}, {4,5,6,9}, {3}},
            {{1,3,6,9}, {2,4,5,7}, {8}},
            {{1,5,8,9}, {3,4,6,7}, {2}},
            {{1,4,7,9}, {2,3,6,8}, {5}},
            {{1,3,5,7}, {2,4,8,9}, {6}},
            {{1,4,6,8}, {2,3,5,9}, {7}},
            {{2,6,7,9}, {3,4,5,8}, {1}}
    };

    @Override
    public int[][][] getSchema() {
        int[][][] schema = new int[NUMBER_OF_TOURS][][];
        for(int i = 0; i < NUMBER_OF_TOURS; i++) {
            schema[i] = new int[NUMBER_OF_TEAMS][];
        }
        applyTeams(schema, 0,
                new int[] {1, 2, 3, 4}, new int[] {5, 6, 7, 8}, 9);

        return new int[0][][];
    }

    private void applyTeams(int[][][] schema, int tour, int[] team1, int[] team2, int host) {
        schema[tour][0] = Arrays.copyOf(team1, team1.length);
        schema[tour][1] = Arrays.copyOf(team2, team2.length);
        schema[tour][2] = new int[] {host};
    }

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

    public static void main(String[] args) {
        int[][] table = new int[9][9];
        for(int[][] tour: schemaTemplate) {
            for(int[] pair: getPairs(tour[0])) {
                table[pair[0]-1][pair[1]-1]++;
            }
            for(int[] pair: getPairs(tour[1])) {
                table[pair[0]-1][pair[1]-1]++;
            }
        }
        System.out.println("XX\t1\t2\t3\t4\t5\t6\t7\t8\t9\n");
        for(int i = 0; i < 9; i++) {
            System.out.print(i+1 + ")");
            for(int j = 0; j < 9; j++) {
                System.out.print("\t" + table[i][j]);
            }
            System.out.println("");
        }
    }
}
