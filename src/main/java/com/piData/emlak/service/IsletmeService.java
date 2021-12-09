package com.piData.emlak.service;

import com.piData.emlak.core.aspect.ExecutionMethod;
import com.piData.emlak.core.constant.CacheConstant;
import com.piData.emlak.core.constant.MessageConstant;
import com.piData.emlak.entity.mapper.IsletmeMapper;
import com.piData.emlak.core.payload.ApiResponse;
import com.piData.emlak.core.utils.GeneralUtils;
import com.piData.emlak.entity.dto.IsletmeDTO;
import com.piData.emlak.entity.model.Isletme;
import com.piData.emlak.repository.IsletmeRepository;
import com.piData.emlak.security.repository.UserRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IsletmeService  {

    private final IsletmeRepository isletmeRepository;

    private final UserRepository userRepository;

    IsletmeMapper mapper;

    public IsletmeService(IsletmeRepository isletmeRepository, UserRepository userRepository) {
        this.isletmeRepository = isletmeRepository;

        this.userRepository = userRepository;
    }


    @ExecutionMethod
    public ApiResponse getById(Long id) {
        try {
            IsletmeDTO isletmeDTO=
                    mapper.INSTANCE.IsletmeDTO2Isletme(isletmeRepository.getById(id));
            return new ApiResponse(true, MessageConstant.INFO,isletmeDTO);
        }catch (Exception e){
            return new ApiResponse(false, MessageConstant.ERROR,e);
        }

    }

    @ExecutionMethod
    @CacheEvict(value = CacheConstant.CACHE_ISLETME_LIST,allEntries = true)
    public ApiResponse getAll(){
        try {
            List<IsletmeDTO> isletmeDTOList=
                    mapper.INSTANCE.IsletmeDTOList2Isletme (isletmeRepository.getAllBy());

            return new ApiResponse(true, MessageConstant.INFO,isletmeDTOList);

        }catch (Exception e){
            return new ApiResponse(false, MessageConstant.ERROR,e);
        }
        
    }


    @ExecutionMethod
    public ApiResponse saveOrUpdate(IsletmeDTO isletmeDTO) {
        try {
            Isletme isletmeDb= new Isletme();
            if(GeneralUtils.valueNullOrEmpty(isletmeDTO.getId())){
                if(!GeneralUtils.valueNullOrEmpty(isletmeDTO.getVergiNo())){
                    isletmeDb = isletmeRepository.getByVergiNo(isletmeDTO.getVergiNo());
                    if (GeneralUtils.valueNullOrEmpty(isletmeDb)){
                        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                        String username = auth.getName();
                        isletmeDb.setFax(isletmeDTO.getFax());
                        isletmeDb.setName(isletmeDTO.getName());
                        isletmeDb.setTelNo(isletmeDTO.getTelNo());
                        isletmeDb.setVergiNo(isletmeDTO.getVergiNo());
                        isletmeDb.setAdres(isletmeDTO.getAdres());
                        isletmeDb.setYetkili(userRepository.getByUsername(username));
                        isletmeDTO = IsletmeMapper.INSTANCE.IsletmeDTO2Isletme(isletmeRepository.save(isletmeDb));
                        return  new ApiResponse (true, MessageConstant.INFO,isletmeDTO);
                    }else
                        return  new ApiResponse (false, MessageConstant.ERROR.concat("-- Vergi Numarası Kayıtlı"),isletmeDTO);
                }else
                    return  new ApiResponse (false, MessageConstant.ERROR.concat("-- Vergi numarası Boş"),isletmeDTO);
            }else{
                isletmeDb = IsletmeMapper.INSTANCE.Isletme2IsletmeDTO(isletmeDTO);
                isletmeDTO = IsletmeMapper.INSTANCE.IsletmeDTO2Isletme(isletmeRepository.save(isletmeDb));
                return  new ApiResponse (true, MessageConstant.INFO,isletmeDTO);
            }
        }catch (Exception e){
            return  new ApiResponse (false, MessageConstant.ERROR,e.getMessage());

        }
    }




}

