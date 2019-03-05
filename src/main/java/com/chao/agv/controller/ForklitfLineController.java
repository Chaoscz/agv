package com.chao.agv.controller;

import com.chao.agv.entity.ForkliftLine;
import com.chao.agv.service.ForklitfLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ForklitfLineController {

    @Autowired
    private ForklitfLineService forklitfLineService;

    @GetMapping("/getForkliftLine")
    public List<ForkliftLine> getForkliftLine(){
        return forklitfLineService.getForkliftLine();
    }

}
