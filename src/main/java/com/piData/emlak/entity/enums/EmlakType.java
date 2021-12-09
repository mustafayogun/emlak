package com.piData.emlak.entity.enums;


public enum EmlakType {
    EV ("EV"),
    DUKKAN ("DUKKAN");


    private String value;

    EmlakType(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



}
