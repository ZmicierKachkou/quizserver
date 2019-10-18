package by.bsu.zmicier.schemas;

import by.bsu.zmicier.schemas.builders.AbstractShuffleSchemaBuilder;
import by.bsu.zmicier.schemas.builders.Shuffle44SchemaBuilder;
import by.bsu.zmicier.schemas.builders.StableSchemaBuilder;

public enum AllSchemas {
    SCHEMA_4_4(new StableSchemaBuilder(7, 4, 4)),
    SCHEMA_4_4_SHUFFLE(new Shuffle44SchemaBuilder()),
    SCHEMA_4_4_1_SHUFFLE(new Shuffle44SchemaBuilder());

    private final SchemaBuilder schemaBuilder;
    private final boolean isShuffle;

    AllSchemas(SchemaBuilder schemaBuilder) {
        this.schemaBuilder = schemaBuilder;
        this.isShuffle = schemaBuilder instanceof AbstractShuffleSchemaBuilder;
    }

    public SchemaBuilder getSchemaBuilder() {
        return schemaBuilder;
    }

    public boolean isShuffle() {
        return isShuffle;
    }
}
