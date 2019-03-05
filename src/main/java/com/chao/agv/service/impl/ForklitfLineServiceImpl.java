package com.chao.agv.service.impl;

import com.chao.agv.dao.ForkliftLineRepository;
import com.chao.agv.entity.ForkliftLine;
import com.chao.agv.service.ForklitfLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForklitfLineServiceImpl  implements ForklitfLineService {

    @Autowired
    private ForkliftLineRepository forkliftLineRepository;

    @Override
    public List<ForkliftLine> getForkliftLine() {
        return forkliftLineRepository.findAll();
    }
}
