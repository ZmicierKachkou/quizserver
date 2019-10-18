package by.bsu.zmicier.schemas;

import by.bsu.zmicier.schemas.builders.StableSchemaBuilder;

public enum AllSchemas {
    SCHEMA_4_4(new StableSchemaBuilder(7, 4, 4));

    private SchemaPresentator schemaPresentator;

    AllSchemas(SchemaPresentator schemaPresentator) {
        this.schemaPresentator = schemaPresentator;
    }

    public SchemaPresentator getSchemaPresentator() {
        return schemaPresentator;
    }
}
