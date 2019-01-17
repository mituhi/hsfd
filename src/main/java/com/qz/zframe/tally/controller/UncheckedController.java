package com.qz.zframe.tally.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageBean;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tally.entity.TallyAlarm;
import com.qz.zframe.tally.entity.TallyRoute;
import com.qz.zframe.tally.service.TallyPlanService;
import com.qz.zframe.tally.service.TallyUncheckedService;
import com.qz.zframe.tally.vo.TallyUnCheckedVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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

    @Autowired
    TallyUncheckedService tallyUncheckedService;

    @Autowired
    TallyPlanService tallyPlanService;

    @ApiOperation(value="漏检统计查询", notes="漏检统计查询" ,httpMethod="GET")
    @RequestMapping("list")
    @ResponseBody
    public PageResultEntity listUnchecked(@RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                          @RequestParam(value = "pageSize",defaultValue = "10")  int pageSize) {
        PageResultEntity resultEntity=new PageResultEntity();
        PageHelper.startPage(pageNum,pageSize);

        List<TallyUnCheckedVO> tallyUnCheckedVOList=tallyUncheckedService.findAllUncheckedVO();

        List<TallyUnCheckedVO> tallyUnCheckedVOList2=new ArrayList<TallyUnCheckedVO>();
        for (TallyUnCheckedVO tallyUnCheckedVO:tallyUnCheckedVOList){

            if (tallyUnCheckedVO.getCycleUnit().equals("年")){
                tallyUnCheckedVO.setFinishTime(new Date(tallyUnCheckedVO.getBenchmarkDate().getTime()+new Integer(tallyUnCheckedVO.getCycle())*365*24*60*60*1000));
            }else  if (tallyUnCheckedVO.getCycleUnit().equals("月")){
                tallyUnCheckedVO.setFinishTime(new Date(tallyUnCheckedVO.getBenchmarkDate().getTime()+new Integer(tallyUnCheckedVO.getCycle())*30*24*60*60*1000));
            }else  if (tallyUnCheckedVO.getCycleUnit().equals("周")){
                tallyUnCheckedVO.setFinishTime(new Date(tallyUnCheckedVO.getBenchmarkDate().getTime()+new Integer(tallyUnCheckedVO.getCycle())*7*24*60*60*1000));
            }else  if (tallyUnCheckedVO.getCycleUnit().equals("日")){
                tallyUnCheckedVO.setFinishTime(new Date(tallyUnCheckedVO.getBenchmarkDate().getTime()+new Integer(tallyUnCheckedVO.getCycle())*24*60*60*1000));
            }else  if (tallyUnCheckedVO.getCycleUnit().equals("时")){
                tallyUnCheckedVO.setFinishTime(new Date(tallyUnCheckedVO.getBenchmarkDate().getTime()+new Integer(tallyUnCheckedVO.getCycle())*60*60*1000));
            }

           // tallyUnCheckedVO.setUserNames(tallyPlanService.findUserNamesByRouteName(tallyUnCheckedVO.getRouteName()));

            tallyUnCheckedVO.setTotal(String.valueOf(new Integer(tallyUnCheckedVO.getUncheckedQuantity())+new Integer(tallyUnCheckedVO.getCheckedQuantity())));

            tallyUnCheckedVO.setLeakageRate(String.valueOf(new Double(tallyUnCheckedVO.getUncheckedQuantity())/new Double(tallyUnCheckedVO.getTotal())));
            System.out.println(new Integer(tallyUnCheckedVO.getUncheckedQuantity()));
            System.out.println(new Integer(tallyUnCheckedVO.getTotal()));
            System.out.println(String.valueOf(new Double(tallyUnCheckedVO.getUncheckedQuantity())/new Double(tallyUnCheckedVO.getTotal())));

            tallyUnCheckedVOList2.add(tallyUnCheckedVO);
        }

        PageInfo<TallyUnCheckedVO> pageData=new PageInfo<TallyUnCheckedVO>(tallyUnCheckedVOList2);
        //System.out.println(currentPage+"***"+pageSize+"***"+tallyRouterVOList.size());
        resultEntity.setRows(tallyUnCheckedVOList2);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("漏检统计查询成功");
        resultEntity.setTotal((int) pageData.getTotal());

        return resultEntity;

    }

}
