package dev.sda.team2.pma.enums;

import lombok.Getter;

public enum ItemType {
    SERVICE ("Service"),
    STOCK_ITEM ("Stock Item"),
    RENTAL ("Rental");

    @Getter
    private String displayItemTypes;

    ItemType(String displayItemTypes) {
        this.displayItemTypes = displayItemTypes;
    }
}
