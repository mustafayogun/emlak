package com.piData.emlak.entity.model;

import com.piData.emlak.entity.enums.Status;
import com.piData.emlak.security.model.DateAudit;
import com.piData.emlak.security.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Isletme extends DateAudit implements Serializable {

    private String name;

    private String adres;

    private int telNo;

    private int fax;

    private String vergiNo;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @ManyToOne
    private User yetkili;


}
