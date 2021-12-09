package com.piData.emlak.entity.dto;

import com.piData.emlak.entity.enums.Status;
import com.piData.emlak.security.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class IsletmeDTO  implements Serializable {

    private Long id;

    private String name;

    private String adres;

    private String vergiNo;

    private int telNo;

    private int fax;

    private Status status;

    private User yetkili;



}
