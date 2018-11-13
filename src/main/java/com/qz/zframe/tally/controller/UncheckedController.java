package com.qz.zframe.tally.controller;

import com.github.pagehelper.PageHelper;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageBean;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tally.entity.TallyAlarm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("api/support/tallyUnchecked")
@Api(
        tags = {"api-support-tallyUnchecked"},
        description = "巡检-漏检统计"
)
@Transactional(rollbackFor = Exception.class)
public class UncheckedController {

    @ApiOperation(value="漏检统计查询", notes="风机场，开始时间，结束时间查询" ,httpMethod="GET")
    @RequestMapping("list")
    @ResponseBody
    public ResultEntity listUnchecked(String windId,
                                     Date startTime,
                                     Date endTime,
                                     @RequestParam(value = "currentPage",defaultValue = "1")int currentPage,
                                     @RequestParam(value = "pageSize",defaultValue = "5")  int pageSize) {
        ResultEntity resultEntity=new ResultEntity();

        PageHelper.startPage(currentPage,pageSize);

      //  List<TallyAlarm> tallyAlarmList=tallyAlarmService.findAllTallyAlarm(windId, routeName, treatmentStandard, startTime, endTime);

 //       PageBean<TallyAlarm> pageDate=new PageBean<TallyAlarm>(currentPage,pageSize,tallyAlarmList.size());
   //     pageDate.setItems(tallyAlarmList);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("报警管理查询成功");
//        resultEntity.setData(pageDate);
        return resultEntity;

    }

}
