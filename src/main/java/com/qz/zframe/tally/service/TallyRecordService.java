package com.qz.zframe.tally.service;

import com.qz.zframe.tally.dto.TallyRecordDto;
import com.qz.zframe.tally.entity.TallyRecord;
import com.qz.zframe.tally.vo.TallyDetailVO;
import com.qz.zframe.tally.vo.TallyRecordVO;
import com.qz.zframe.tally.vo.TallyUnCheckedVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TallyRecordService {
    /**
     * 查询巡检记录
     * @param routeName
     * @param practitioners
     * @param windId
     * @param startTime
     * @param endTime
     * @return
     */
    List<TallyRecordDto> findAllTallyRecord(String routeName, String practitioners, String windId, Date startTime, Date endTime);

    /**
     * 报表需要显示的记录
     * @return
     */
    List<TallyRecordVO> findAllTallyRecordVO();

    /**
     * 根据路线id查记录细节
     * @param routeId
     * @return
     */
    TallyDetailVO findTallyDetailVOByRouteId(String routeId);


}
