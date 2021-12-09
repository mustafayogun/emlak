package com.piData.emlak.service;

import com.piData.emlak.core.aspect.ExecutionMethod;
import com.piData.emlak.core.constant.CacheConstant;
import com.piData.emlak.core.constant.MessageConstant;
import com.piData.emlak.entity.mapper.MusteriMapper;
import com.piData.emlak.core.payload.ApiResponse;
import com.piData.emlak.core.utils.GeneralUtils;
import com.piData.emlak.entity.dto.MusteriDTO;
import com.piData.emlak.entity.enums.Status;
import com.piData.emlak.entity.model.Musteri;
import com.piData.emlak.repository.MusteriRepository;
import com.piData.emlak.security.repository.UserRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MusteriService {

    private final MusteriRepository musteriRepository;

    private final UserRepository userRepository;

    private final MusteriMapper mapper;

    public MusteriService(MusteriRepository musteriRepository, UserRepository userRepository, MusteriMapper mapper) {
        this.musteriRepository = musteriRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }


    @ExecutionMethod
    public ApiResponse getById(Long id) {
        try {
            MusteriDTO musteriDTO=
                    mapper.INSTANCE.musteriDTO2Musteri(musteriRepository.getById(id));
            return new ApiResponse(true, MessageConstant.INFO,musteriDTO);
        }catch (Exception e){
            return new ApiResponse(false, MessageConstant.ERROR,e);
        }

    }

    @ExecutionMethod
    @CacheEvict(value = CacheConstant.CACHE_Musteri_LIST,allEntries = true)
    public ApiResponse getAll(){
        try {
            List<MusteriDTO> musteriDTOList=
                    mapper.INSTANCE.musteriDTOList2Musteri(musteriRepository.getAllBy());

            return new ApiResponse(true, MessageConstant.INFO,musteriDTOList);

        }catch (Exception e){
            return new ApiResponse(false, MessageConstant.ERROR,e);
        }
        
    }


    @ExecutionMethod
    public ApiResponse saveOrUpdate(MusteriDTO musteriDTO) {
        try {
            Musteri musteriDb= new Musteri();
            if(GeneralUtils.valueNullOrEmpty(musteriDTO.getId())){
                if(!GeneralUtils.valueNullOrEmpty(musteriDTO.getTelCep())){
                    musteriDb = musteriRepository.findByTelCep(musteriDTO.getTelCep());
                    if (GeneralUtils.valueNullOrEmpty(musteriDb)){
                        musteriDb.setAdi(musteriDTO.getAdi());
                        musteriDb.setSoyadi(musteriDTO.getSoyadi());
                        musteriDb.setEmail(musteriDTO.getEmail());
                        musteriDb.setTelCep(musteriDTO.getTelCep());
                        musteriDb.setStatus(Status.AKTIF);
                        musteriDTO = mapper.INSTANCE.musteriDTO2Musteri(musteriRepository.save(musteriDb));
                        return  new ApiResponse (true, MessageConstant.INFO,musteriDTO);
                    }else
                        return  new ApiResponse (false, MessageConstant.ERROR.concat("-- Vergi Numarası Kayıtlı"),musteriDTO);
                }else
                    return  new ApiResponse (false, MessageConstant.ERROR.concat("-- Vergi numarası Boş"),musteriDTO);
            }else{
                musteriDb = mapper.INSTANCE.musteri2MusteriDTO(musteriDTO);
                musteriDTO = mapper.INSTANCE.musteriDTO2Musteri(musteriRepository.save(musteriDb));
                return  new ApiResponse (true, MessageConstant.INFO,musteriDTO);
            }
        }catch (Exception e){
            return  new ApiResponse (false, MessageConstant.ERROR,e.getMessage());

        }
    }




}

