package com.chao.agv.dao;

import com.chao.agv.entity.ForkliftLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForkliftLineRepository extends JpaRepository<ForkliftLine,Integer> {
}
