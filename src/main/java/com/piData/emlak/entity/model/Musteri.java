package com.piData.emlak.entity.model;

import com.piData.emlak.entity.enums.Status;
import com.piData.emlak.security.model.DateAudit;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Musteri extends DateAudit {

    private String adi;

    private String soyadi;

    private String telEv;

    private String telCep;

    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;

}
