package org.example.Security;

public enum Level {
    LEVEL_0,
    LEVEL_1,
    LEVEL_2,
    LEVEL_3;
    @Override
    public String toString() {
        //ENUM转int便于后续计算
        return switch (this) {
            case LEVEL_0 -> "0";
            case LEVEL_1 -> "1";
            case LEVEL_2 -> "2";
            case LEVEL_3 -> "3";
        };
    }

}
