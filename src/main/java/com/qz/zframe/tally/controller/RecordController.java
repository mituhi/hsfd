package com.qz.zframe.tally.controller;

import com.github.pagehelper.PageHelper;
import com.qz.zframe.authentication.JwtTokenUtil;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageBean;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tally.dao.TallyRecordDao;
import com.qz.zframe.tally.dto.TallyRecordDto;
import com.qz.zframe.tally.service.TallyRecordService;
import com.qz.zframe.tally.vo.TallyPlanVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("api/support/tallyRecord")
@Api(
        tags = {"api-support-tallyRecord"},
        description = "巡检-巡检记录查询"
)
@Transactional(rollbackFor = Exception.class)
public class RecordController {

    @Autowired
    TallyRecordService tallyRecordService;


    @ApiOperation(value="巡检记录查询", notes="根据线路，负责人，风机场，开始时间，结束时间" ,httpMethod="GET")
    @RequestMapping("list")
    @ResponseBody
    public ResultEntity listStandard(String windId,
                                     String routeName,
                                     String practitioners,
                                     Date startTime,
                                     Date endTime,
                                     @RequestParam(value = "currentPage",defaultValue = "1")int currentPage,
                                     @RequestParam(value = "pageSize",defaultValue = "5")  int pageSize) {
        ResultEntity resultEntity=new ResultEntity();

        PageHelper.startPage(currentPage,pageSize);

        List<TallyRecordDto> tallyRecordDtoList=tallyRecordService.findAllTallyRecord(routeName, practitioners, windId, startTime, endTime);

        PageBean<TallyRecordDto> pageDate=new PageBean<TallyRecordDto>(currentPage,pageSize,tallyRecordDtoList.size());
        pageDate.setItems(tallyRecordDtoList);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("巡检记录查询成功");
        resultEntity.setData(pageDate);
        return resultEntity;

    }


}
