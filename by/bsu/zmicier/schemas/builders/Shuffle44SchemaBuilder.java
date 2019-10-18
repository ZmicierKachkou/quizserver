package by.bsu.zmicier.schemas.builders;

public class Shuffle44SchemaBuilder extends AbstractShuffleSchemaBuilder {

    @Override
    public int[][][] getSchemaTemplate() {
        return new int[][][]{
                {{3,4,7,8}, {1,2,6,5}},
                {{1,3,6,7}, {2,4,5,8}},
                {{2,3,6,8}, {1,4,5,7}},
                {{2,4,6,7}, {1,3,5,8}},
                {{3,4,5,6}, {1,2,7,8}},
                {{1,2,3,4}, {5,6,7,8}},
                {{2,3,5,7}, {1,4,6,8}}
        };
    }
}
