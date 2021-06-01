package com.developersunknown.ubai.bot;

public enum BotClass {
    STORMTROOPER(Constants.STORMTROOPER_ID),
    SNIPER(Constants.SNIPER_ID),
    HEALER(Constants.HEALER_ID),
    TANK(Constants.TANK_ID),
    SCOUT(Constants.SCOUT_ID);

    String name;

    BotClass(String name) {
        this.name = name;
    }

    public static BotClass getType(String type) {
        switch (type) {
            case Constants.STORMTROOPER_ID:
                return STORMTROOPER;
            case Constants.SNIPER_ID:
                return SNIPER;
            case Constants.HEALER_ID:
                return HEALER;
            case Constants.TANK_ID:
                return TANK;
            case Constants.SCOUT_ID:
                return SCOUT;
            default:
                throw new RuntimeException("Unknown bot type!");
        }
    }

    private static class Constants {
        static final String STORMTROOPER_ID = "stormtrooper";
        static final String SNIPER_ID = "sniper";
        static final String HEALER_ID = "healer";
        static final String TANK_ID = "tank";
        static final String SCOUT_ID = "scout";
    }
}
