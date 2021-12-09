package com.piData.emlak.entity.mapper;

import com.piData.emlak.entity.dto.MusteriDTO;
import com.piData.emlak.entity.model.Musteri;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.factory.Mappers.getMapper;


@Mapper(
        componentModel = "spring"
)
public interface MusteriMapper {
    MusteriMapper INSTANCE = getMapper( MusteriMapper.class );

    Musteri musteri2MusteriDTO (MusteriDTO MusteriDTO);
    MusteriDTO musteriDTO2Musteri (Musteri Musteri);
    List<MusteriDTO> musteriDTOList2Musteri(List<Musteri> Musteri);


    
}
