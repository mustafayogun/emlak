package com.piData.emlak.entity.model;

import com.piData.emlak.entity.enums.EmlakType;
import com.piData.emlak.entity.enums.IlanType;
import com.piData.emlak.entity.enums.IsınmaType;
import com.piData.emlak.entity.enums.Status;
import com.piData.emlak.security.model.DateAudit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Emlak extends DateAudit {

    private int metre2;

    private int odaSayisi;

    private int kat;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private IsınmaType isinma;

    @ManyToOne
    private Musteri sahibi;

    @ManyToOne
    private Musteri alici;

    @Enumerated(EnumType.ORDINAL)
    @Column(length = 30)
    private Status status;

    @Enumerated(EnumType.STRING)
    private EmlakType emlakType;

    @Enumerated(EnumType.STRING)
    private IlanType ilanType;

    private String adres;


}
