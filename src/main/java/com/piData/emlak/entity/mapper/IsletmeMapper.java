package com.piData.emlak.entity.mapper;

import com.piData.emlak.entity.dto.IsletmeDTO;
import com.piData.emlak.entity.model.Isletme;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.factory.Mappers.getMapper;


@Mapper(
        componentModel = "spring"
)
public interface IsletmeMapper {
    IsletmeMapper INSTANCE = getMapper( IsletmeMapper.class );

    Isletme Isletme2IsletmeDTO (IsletmeDTO IsletmeDTO);
    IsletmeDTO IsletmeDTO2Isletme (Isletme Isletme);
    List<IsletmeDTO> IsletmeDTOList2Isletme(List<Isletme> Isletme);


    
}
