package com.piData.emlak.entity.dto;

import com.piData.emlak.entity.enums.EmlakType;
import com.piData.emlak.entity.enums.IlanType;
import com.piData.emlak.entity.enums.IsınmaType;
import com.piData.emlak.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class EmlakCrudDTO {

    private Long id;

    private String adres;

    private int metre2;

    private int odaSayisi;

    private int kat;

    private Long sahibiId;

    private Long aliciId;

    private Status status;

    private EmlakType emlakType;

    private IlanType ilanType;

    private IsınmaType isinma;
}
