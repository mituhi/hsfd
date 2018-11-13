package com.qz.zframe.maintain.service;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.entity.BreakdownInfo;
import org.springframework.web.multipart.MultipartFile;

public interface DefectFillService {

    /**
     * 保存缺陷单
     */
    public ResultEntity saveBreakdown(BreakdownInfo breakdownInfo);

    /**
     * 提交缺陷单
     */
    public ResultEntity submitBreakdown(BreakdownInfo breakdownInfo);
}
