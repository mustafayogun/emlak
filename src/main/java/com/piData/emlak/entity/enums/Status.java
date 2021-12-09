package com.piData.emlak.entity.enums;


public enum Status {
    AKTIF ("AKTIF"),
    PASIF ("PASIF"),
    DELETE ("DELETE");
    private String value;

    Status (String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
