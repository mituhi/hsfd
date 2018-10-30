package com.qz.zframe.material.controller;

import com.github.pagehelper.PageHelper;
import com.qz.zframe.material.entity.TallyRoute;
import com.qz.zframe.material.service.TallyRouterService;
import com.qz.zframe.material.utils.PageBean;
import com.qz.zframe.material.vo.TallyRouterVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("api/support/tallyRouter")
@Api(
        tags = {"api-support-iscTally"},
        description = "巡检"
)
public class InspectionController {

    @Autowired
    TallyRouterService tallyRouterService;

    /**
     * 点击巡检和页面相关查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ApiOperation(value="获取巡检线路", notes="测试巡检线路接口" ,httpMethod="POST")
    @RequestMapping("line")
    @ResponseBody
    public List<TallyRouterVO> tallyList(@RequestParam(value = "windId",defaultValue = "null")String windId,
                                         @RequestParam(value = "currentPage",defaultValue = "1")int currentPage,
                                         @RequestParam(value = "pageSize",defaultValue = "1")  int pageSize) {
        PageHelper.startPage(currentPage,pageSize);

        //1.先查询所有点检路线表需要的字段
        List<TallyRoute> tallyRouteList=tallyRouterService.findAllTallyRouter();
        List<TallyRouterVO> tallyRouterVOList=new ArrayList<TallyRouterVO>();

        //2.先添加点检路线表的数据，然后路线→周期 或者→关联人id→姓名
        for (TallyRoute tallyRoute:tallyRouteList){
            TallyRouterVO tallyRouterVO=new TallyRouterVO();
            tallyRouterVO.setRouteName(tallyRoute.getRouteName());
            tallyRouterVO.setRouteCode(tallyRoute.getRouteCode());
            tallyRouterVO.setWindId(tallyRoute.getWindId());
            tallyRouterVO.setRouteId(tallyRoute.getRouteId());

            //2.1根据路线id查周期名称
            tallyRouterVO.setCycleName(tallyRouterService.findCycleNameByRouteId(tallyRoute.getRouteId()));

            List<String> userNames=new ArrayList<String>();
            //2.2关联人id查出人员
            /*2.2.1先根据路线id查出关联人id*/
            List<String> userIds=tallyRouterService.findUserIdsByRouteId(tallyRoute.getRouteId());
            for (String userId:userIds){
                /*2.2.2根据id查名字*/
                userNames.add(tallyRouterService.findUserNameByUserId(userId));
            }
            tallyRouterVO.setUserNames(userNames);

            tallyRouterVOList.add(tallyRouterVO);
        }

        PageBean<TallyRouterVO> pageData=new PageBean<TallyRouterVO>(currentPage,pageSize,tallyRouterVOList.size());
        pageData.setItems(tallyRouterVOList);
        return pageData.getItems();
    }

}
