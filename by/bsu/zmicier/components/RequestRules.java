package by.bsu.zmicier.components;

import java.io.File;

public final class RequestRules {
    private RequestRules() {}

    public final static String FILE_NAME = "file_name";
    public final static Class<?> FILE_NAME_CLASS_CHECK = File.class;

    public final static String PLAYERS_NAME = "players_name";
    public final static Class<?> PLAYERS_NAME_CLASS_CHECK = String[].class;

    public final static String SHUFFLE_PLAYERS = "shuffle_players";
    public final static Class<?> SHUFFLE_PLAYERS_CLASS_CHECK = Boolean.class;
}
