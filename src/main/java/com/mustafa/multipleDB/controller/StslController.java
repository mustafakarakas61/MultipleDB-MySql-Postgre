package com.mustafa.multipleDB.controller;

import com.mustafa.multipleDB.entity.DefStsl;
import com.mustafa.multipleDB.service.StslService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "apiStsl(MySql)")
public class StslController {
    public StslService stslService;

    //-------------------------------------------------Constructor
    public StslController(StslService stslService) {
        this.stslService = stslService;
    }

    //-------------------------------------------------Methods
    @GetMapping("/teamList")
    public List<DefStsl> teamList() {
        return (List<DefStsl>) stslService.stslList();
    }
}
