package com.chao.agv.controller;

import com.chao.agv.entity.ForkliftLine;
import com.chao.agv.service.ForkliftLineService;
import com.chao.agv.utils.Dijkstra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ForkliftLineController {

    @Autowired
    private ForkliftLineService forkliftLineService;

    @GetMapping("/getForkliftLine")
    public List<ForkliftLine> getForkliftLine(){
        return Dijkstra.getPathInt(forkliftLineService.getForkliftLine(),1,10);

    }

}
