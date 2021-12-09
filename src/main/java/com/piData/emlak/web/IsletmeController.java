package com.piData.emlak.web;


import com.piData.emlak.core.payload.ApiResponse;
import com.piData.emlak.entity.dto.IsletmeDTO;
import com.piData.emlak.service.IsletmeService;
import com.piData.emlak.web.constant.RestConstant;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = RestConstant.ISLETME)
public class IsletmeController {

    @Autowired
    private IsletmeService isletmeService;

    @PostMapping(value = RestConstant.URL_SAVE_OR_UPDATE)
    @ApiOperation(value = "Save Or Update Isletme Get By Id ", response = IsletmeDTO.class)
    public ResponseEntity<?> saveOrUpdateIsletme(@RequestBody IsletmeDTO isletmeDTO){
        ApiResponse apiResponse = isletmeService.saveOrUpdate(isletmeDTO);
        return apiResponse.getResponseJson(apiResponse);
    }

    @GetMapping(value = RestConstant.URL_GETALL)
    @ApiOperation(value = "get List Isletme Get By Id ", response = IsletmeDTO.class)
    public ResponseEntity getList(){
        ApiResponse apiResponse = isletmeService.getAll();
        return apiResponse.getResponseJson(apiResponse);
    }

    @GetMapping(value = RestConstant.URL_GETBYID)
    @ApiOperation(value = "Isletme  Get By Id ", response = IsletmeDTO.class)
    public ResponseEntity getById( @RequestParam("id") Long id){
        ApiResponse apiResponse = isletmeService.getById(id);
        return apiResponse.getResponseJson(apiResponse);
    }

}
