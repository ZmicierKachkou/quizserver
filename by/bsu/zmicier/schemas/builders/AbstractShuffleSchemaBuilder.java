package by.bsu.zmicier.schemas.builders;

import by.bsu.zmicier.schemas.SchemaBuilder;

import java.util.Arrays;

public abstract class AbstractShuffleSchemaBuilder implements SchemaBuilder {

    public abstract int[][][] getSchemaTemplate();
    @Override
    public int[][][] getSchema() {
        int[][][] schemaTemplate = getSchemaTemplate();

        int[][][] copy = new int[schemaTemplate.length][][];
        for(int i = 0; i < schemaTemplate.length; i++) {
            copy[i] = new int[schemaTemplate[i].length][];
            for(int j = 0; j < schemaTemplate[i].length; j++) {
                copy[i][j] = Arrays.copyOf(schemaTemplate[i][j], schemaTemplate[i][j].length);
                Arrays.sort(copy[i][j]);
            }
        }
        return copy;
    }
}
