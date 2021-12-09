package com.piData.emlak.web;


import com.piData.emlak.core.payload.ApiResponse;
import com.piData.emlak.entity.dto.MusteriDTO;
import com.piData.emlak.service.MusteriService;
import com.piData.emlak.web.constant.RestConstant;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = RestConstant.MUSTERI)
public class MusteriController {

    @Autowired
    private MusteriService musteriService;

    @PostMapping(value = RestConstant.URL_SAVE_OR_UPDATE)
    @ApiOperation(value = "Save Or Update musteri Get By Id ", response = MusteriDTO.class)
    public ResponseEntity<?> saveOrUpdateIsletme(@RequestBody MusteriDTO musteriDTO){
        ApiResponse apiResponse = musteriService.saveOrUpdate(musteriDTO);
        return apiResponse.getResponseJson(apiResponse);
    }

    @GetMapping(value = RestConstant.URL_GETALL)
    @ApiOperation(value = "get List musteri Get By Id ", response = MusteriDTO.class)
    public ResponseEntity getList(){
        ApiResponse apiResponse = musteriService.getAll();
        return apiResponse.getResponseJson(apiResponse);
    }

    @GetMapping(value = RestConstant.URL_GETBYID)
    @ApiOperation(value = "musteri  Get By Id ", response = MusteriDTO.class)
    public ResponseEntity getById( @RequestParam("id") Long id){
        ApiResponse apiResponse = musteriService.getById(id);
        return apiResponse.getResponseJson(apiResponse);
    }

}
