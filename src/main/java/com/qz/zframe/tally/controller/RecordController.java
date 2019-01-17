package com.qz.zframe.tally.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qz.zframe.authentication.JwtTokenUtil;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageBean;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tally.dao.TallyRecordDao;
import com.qz.zframe.tally.dto.TallyRecordDto;
import com.qz.zframe.tally.entity.TallyRecord;
import com.qz.zframe.tally.service.TallyRecordService;
import com.qz.zframe.tally.vo.TallyDetailVO;
import com.qz.zframe.tally.vo.TallyPlanVO;
import com.qz.zframe.tally.vo.TallyRecordVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
    public PageResultEntity listRecord(@RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                         @RequestParam(value = "pageSize",defaultValue = "10")  int pageSize) {
        PageResultEntity resultEntity=new PageResultEntity();

        PageHelper.startPage(pageNum,pageSize);

        //List<TallyRecordDto> tallyRecordDtoList=tallyRecordService.findAllTallyRecord(routeName, practitioners, windId, startTime, endTime);
        List<TallyRecordVO> tallyRecordList=tallyRecordService.findAllTallyRecordVO();
        PageInfo<TallyRecordVO> pageDate=new PageInfo<TallyRecordVO>(tallyRecordList);
        List<TallyRecordVO> tallyRecordList2=new ArrayList<TallyRecordVO>();
        for (TallyRecordVO tallyRecordVO:tallyRecordList){

            //System.out.println(tallyRecordVO.getBenchmarkDate());

            if (tallyRecordVO.getCycleUnit().equals("年")){
                tallyRecordVO.setFinishTime(new Date(tallyRecordVO.getBenchmarkDate().getTime()+new Integer(tallyRecordVO.getCycle())*365*24*60*60*1000));
            }else if (tallyRecordVO.getCycleUnit().equals("月")){
                tallyRecordVO.setFinishTime(new Date(tallyRecordVO.getBenchmarkDate().getTime()+new Integer(tallyRecordVO.getCycle())*30*24*60*60*1000));
            }else if (tallyRecordVO.getCycleUnit().equals("周")){
                tallyRecordVO.setFinishTime(new Date(tallyRecordVO.getBenchmarkDate().getTime()+new Integer(tallyRecordVO.getCycle())*7*24*60*60*1000));
            }else if (tallyRecordVO.getCycleUnit().equals("日")){
                tallyRecordVO.setFinishTime(new Date(tallyRecordVO.getBenchmarkDate().getTime()+new Integer(tallyRecordVO.getCycle())*24*60*60*1000));
            }else if (tallyRecordVO.getCycleUnit().equals("时")){
                tallyRecordVO.setFinishTime(new Date(tallyRecordVO.getBenchmarkDate().getTime()+new Integer(tallyRecordVO.getCycle())*60*60*1000));
            }

            tallyRecordList2.add(tallyRecordVO);
        }
       // pageDate.setItems(tallyRecordDtoList);

        resultEntity.setRows(tallyRecordList2);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("巡检记录查询成功");
        resultEntity.setTotal((int) pageDate.getTotal());
        //resultEntity.setData(pageDate);
        return resultEntity;

    }

    @ApiOperation(value="巡检记录详情", notes="双击查看详情" ,httpMethod="GET")
    @RequestMapping("detail")
    @ResponseBody
    public ResultEntity listRecordDetail(String routeId) {
        ResultEntity resultEntity=new ResultEntity();


        TallyDetailVO tallyDetailVO=tallyRecordService.findTallyDetailVOByRouteId(routeId);

        if (tallyDetailVO.getCycleUnit().equals("年")){
            tallyDetailVO.setFinishTime(new Date(tallyDetailVO.getBenchmarkDate().getTime()+new Integer(tallyDetailVO.getCycle())*365*24*60*60*1000));
        }else if (tallyDetailVO.getCycleUnit().equals("月")){
            tallyDetailVO.setFinishTime(new Date(tallyDetailVO.getBenchmarkDate().getTime()+new Integer(tallyDetailVO.getCycle())*30*24*60*60*1000));
        }else if (tallyDetailVO.getCycleUnit().equals("周")){
            tallyDetailVO.setFinishTime(new Date(tallyDetailVO.getBenchmarkDate().getTime()+new Integer(tallyDetailVO.getCycle())*7*24*60*60*1000));
        }else if (tallyDetailVO.getCycleUnit().equals("日")){
            tallyDetailVO.setFinishTime(new Date(tallyDetailVO.getBenchmarkDate().getTime()+new Integer(tallyDetailVO.getCycle())*24*60*60*1000));
        }else if (tallyDetailVO.getCycleUnit().equals("时")){
            tallyDetailVO.setFinishTime(new Date(tallyDetailVO.getBenchmarkDate().getTime()+new Integer(tallyDetailVO.getCycle())*60*60*1000));
        }


        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("巡检记录查询成功");
        resultEntity.setData(tallyDetailVO);
        return resultEntity;

    }

    @ApiOperation(value="提交巡检记录", notes="提交巡检记录" ,httpMethod="GET")
    @RequestMapping("post")
    @ResponseBody
    public ResultEntity post(String routeId) {
        ResultEntity resultEntity=new ResultEntity();


        TallyDetailVO tallyDetailVO=tallyRecordService.findTallyDetailVOByRouteId(routeId);

        if (tallyDetailVO.getCycleUnit().equals("年")){
            tallyDetailVO.setFinishTime(new Date(tallyDetailVO.getBenchmarkDate().getTime()+new Integer(tallyDetailVO.getCycle())*365*24*60*60*1000));
        }else if (tallyDetailVO.getCycleUnit().equals("月")){
            tallyDetailVO.setFinishTime(new Date(tallyDetailVO.getBenchmarkDate().getTime()+new Integer(tallyDetailVO.getCycle())*30*24*60*60*1000));
        }else if (tallyDetailVO.getCycleUnit().equals("周")){
            tallyDetailVO.setFinishTime(new Date(tallyDetailVO.getBenchmarkDate().getTime()+new Integer(tallyDetailVO.getCycle())*7*24*60*60*1000));
        }else if (tallyDetailVO.getCycleUnit().equals("日")){
            tallyDetailVO.setFinishTime(new Date(tallyDetailVO.getBenchmarkDate().getTime()+new Integer(tallyDetailVO.getCycle())*24*60*60*1000));
        }else if (tallyDetailVO.getCycleUnit().equals("时")){
            tallyDetailVO.setFinishTime(new Date(tallyDetailVO.getBenchmarkDate().getTime()+new Integer(tallyDetailVO.getCycle())*60*60*1000));
        }


        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("巡检记录查询成功");
        resultEntity.setData(tallyDetailVO);
        return resultEntity;

    }




}
