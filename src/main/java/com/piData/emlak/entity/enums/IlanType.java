package com.piData.emlak.entity.enums;


public enum IlanType {
    KIRALIK ("KIRALIK"),
    SATILIK ("SATILIK");


    private String value;

    IlanType(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



}
