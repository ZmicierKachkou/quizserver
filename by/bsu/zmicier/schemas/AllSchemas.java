package by.bsu.zmicier.schemas;

import by.bsu.zmicier.schemas.builders.AbstractShuffleSchemaBuilder;
import by.bsu.zmicier.schemas.builders.Shuffle441SchemaBuilder;
import by.bsu.zmicier.schemas.builders.Shuffle44SchemaBuilder;
import by.bsu.zmicier.schemas.builders.StableSchemaBuilder;

public enum AllSchemas {
    SCHEMA_4_4(new StableSchemaBuilder(7, 4, 4), "Две статические команды " +
            "по четыре человека, 7 туров."),
    SCHEMA_4_4_SHUFFLE(new Shuffle44SchemaBuilder(), "Две команды по четыре человека играют " +
            "7 туров, постоянно сменяясь."),
    SCHEMA_4_4_1_SHUFFLE(new Shuffle441SchemaBuilder(),"Две команды по четыре человека " +
            "и один свободный игрок (ведущий?). Все постоянно меняются");

    private final SchemaBuilder schemaBuilder;
    private final boolean isShuffle;
    private final String description;

    AllSchemas(SchemaBuilder schemaBuilder, String description) {
        this.schemaBuilder = schemaBuilder;
        this.isShuffle = schemaBuilder instanceof AbstractShuffleSchemaBuilder;
        this.description = description;
    }

    public SchemaBuilder getSchemaBuilder() {
        return schemaBuilder;
    }

    public boolean isShuffle() {
        return isShuffle;
    }

    public String getDescription() {
        return description;
    }
}
