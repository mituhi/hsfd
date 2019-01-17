package com.qz.zframe.tally.dao;

import com.qz.zframe.tally.vo.TallyUnCheckedVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TallyUncheckedDao {

    /**
     * 查漏检相关信息
     * @return
     */
    List<TallyUnCheckedVO> findAllUncheckedVO();

    
}
