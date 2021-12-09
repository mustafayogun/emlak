package com.piData.emlak.entity.enums;


public enum IsınmaType {
    DOGALGAZ ("DOGALGAZ"),
    PASIF ("SOBA");


    private String value;

    IsınmaType(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



}
