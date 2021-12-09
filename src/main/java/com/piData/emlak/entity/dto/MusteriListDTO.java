package com.piData.emlak.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class MusteriListDTO {

    private Long id;

    private String adi;

    private String soyadi;

    public String getAdSoyad()
    {
        return this.adi+" "+this.soyadi;
    }




}
