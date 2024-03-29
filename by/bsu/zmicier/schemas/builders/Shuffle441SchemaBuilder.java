package by.bsu.zmicier.schemas.builders;

public class Shuffle441SchemaBuilder extends AbstractShuffleSchemaBuilder{

    @Override
    public int[][][] getSchemaTemplate() {
        return new int[][][]{
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
    }
}
