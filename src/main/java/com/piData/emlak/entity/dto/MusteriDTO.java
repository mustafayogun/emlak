package com.piData.emlak.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class MusteriDTO {

    private  Long id;

    private String adi;

    private String soyadi;

    private String telEv;

    private String telCep;

    private String email;


}
