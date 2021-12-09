package com.piData.emlak.entity.mapper;

import com.piData.emlak.entity.dto.EmlakDTO;
import com.piData.emlak.entity.model.Emlak;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.factory.Mappers.getMapper;


@Mapper(
        componentModel = "spring"
)
public interface EmlakMapper {
    EmlakMapper INSTANCE = getMapper( EmlakMapper.class );

    Emlak Emlak2EmlakDTO (EmlakDTO EmlakDTO);
    EmlakDTO EmlakDTO2Emlak (Emlak Emlak);
    List<EmlakDTO> EmlakDTOList2Emlak(List<Emlak> Emlak);


    
}
