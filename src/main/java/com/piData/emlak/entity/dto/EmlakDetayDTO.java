package com.piData.emlak.entity.dto;

import com.piData.emlak.entity.enums.EmlakType;
import com.piData.emlak.entity.enums.IlanType;
import com.piData.emlak.entity.enums.IsınmaType;
import com.piData.emlak.entity.enums.Status;
import com.piData.emlak.entity.model.Musteri;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class EmlakDetayDTO {

    private int metre2;

    private int odaSayisi;

    private int kat;

    private String adres;

    private IsınmaType isinma;

    private Musteri sahibi;

    private Musteri alici;

    private Status status;

    private EmlakType emlakType;

    private IlanType ilanType;


}
