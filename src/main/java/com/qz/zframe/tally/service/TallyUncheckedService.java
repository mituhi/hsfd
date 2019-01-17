package com.qz.zframe.tally.service;

import com.qz.zframe.tally.vo.TallyUnCheckedVO;

import java.util.List;

public interface TallyUncheckedService {
    /**
     * 查漏检相关信息
     * @return
     */
    List<TallyUnCheckedVO> findAllUncheckedVO();
}
