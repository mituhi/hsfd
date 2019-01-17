package com.qz.zframe.tally.service.impl;

import com.qz.zframe.tally.dao.TallyUncheckedDao;
import com.qz.zframe.tally.service.TallyUncheckedService;
import com.qz.zframe.tally.vo.TallyUnCheckedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("tallyUncheckedService")
@Transactional(rollbackFor = Exception.class)
public class TallyUncheckedServiceImpl implements TallyUncheckedService{
    @Autowired
    TallyUncheckedDao tallyUncheckedDao;

    @Override
    public List<TallyUnCheckedVO> findAllUncheckedVO() {
        return tallyUncheckedDao.findAllUncheckedVO();
    }
}
