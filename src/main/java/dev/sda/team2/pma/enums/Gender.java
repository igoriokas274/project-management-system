package dev.sda.team2.pma.enums;

import lombok.Getter;

public enum Gender {
    M ("Masculine"),
    F ("Feminine");

    @Getter
    private String displayGender;

    Gender(String displayGender) {
        this.displayGender = displayGender;
    }
}
