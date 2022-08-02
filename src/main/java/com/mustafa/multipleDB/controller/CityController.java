package com.mustafa.multipleDB.controller;

import com.mustafa.multipleDB.entity.DefCity;
import com.mustafa.multipleDB.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("apiCity(Postgre)")
public class CityController {

    public CityService cityService;

    //-------------------------------------------------Constructor
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    //-------------------------------------------------Methods
    @GetMapping("/cityList")
    public List<DefCity> cityList() {
        return (List<DefCity>) cityService.cityList();
    }
}
