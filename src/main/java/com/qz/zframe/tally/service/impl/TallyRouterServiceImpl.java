package com.qz.zframe.tally.service.impl;


import com.github.pagehelper.PageInfo;
import com.qz.zframe.common.entity.DataDict;
import com.qz.zframe.common.entity.OrgArchitecture;
import com.qz.zframe.common.service.DataDictService;
import com.qz.zframe.common.service.OrgArchitectureService;
import com.qz.zframe.common.service.UserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.material.entity.MaterialGroup;
import com.qz.zframe.tally.dao.TallyPlanDao;
import com.qz.zframe.tally.dao.TallyRouterDao;
import com.qz.zframe.tally.dto.PostDto;
import com.qz.zframe.tally.dto.TallyRouterDto;
import com.qz.zframe.tally.dto.UserDto;
import com.qz.zframe.tally.entity.*;
import com.qz.zframe.tally.service.TallyRouterService;
import com.qz.zframe.tally.vo.ArchitectureAndMenberVO;
import com.qz.zframe.tally.vo.PeriodTimeVO;
import com.qz.zframe.tally.vo.RouteUserVO;
import com.qz.zframe.tally.vo.TallyPlanVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("tallyRouterService")
@Transactional(rollbackFor = Exception.class)
public class TallyRouterServiceImpl implements TallyRouterService {
    @Autowired
    TallyRouterDao tallyRouterDao;

    @Autowired
    TallyPlanDao tallyPlanDao;

    @Autowired
    OrgArchitectureService orgArchitectureService;

    @Autowired
    UserService userService;
    
    @Autowired
    private DataDictService dataDictService;
    

    @Override
    public List<TallyRoute> findAllTallyRouter(String windId, String routeCode, String routeName) {
        return tallyRouterDao.findAllTallyRouter(windId,routeCode,routeName);
    }

    @Override
    public List<String> findCycleNameByRouteId(String routeId) {
        return tallyRouterDao.findCycleNameByRouteId(routeId);
    }


    @Override
    public List<String> findUserIdsByRouteId(String routeId) {
        return tallyRouterDao.findUserIdsByRouteId(routeId);
    }

    @Override
    public String findUserNameByUserId(String userId) {
        return tallyRouterDao.findUserNameByUserId(userId);
    }

    @Override
    public void deleteByRouteId(String[] routeIds) {
        tallyRouterDao.deleteByRouteId(routeIds);
    }

    @Override
    public void deleteRouteUserByRouteId(String[] routeIds) {
        tallyRouterDao.deleteRouteUserByRouteId(routeIds);
    }

    @Override
    public void deleteTallyRouteStandardByRouteId(String[] routeIds) {
        tallyRouterDao.deleteTallyRouteStandardByRouteId(routeIds);
    }

    @Override
    public void deleteTallyRouteByRouteId(List<String> routeIds) {
        tallyRouterDao.deleteTallyRouteByRouteId(routeIds);
    }

    @Override
    public int findserialNum() {

        return tallyRouterDao.findserialNum()+10001;
    }

    @Override
    public void addTallyRoute(TallyRoute tallyRoute) {
        tallyRouterDao.addTallyRoute(tallyRoute);
    }

    @Override
    public void addCycle(Cycle cycle) {
        tallyRouterDao.addCycle(cycle);
    }

    @Override
    public void addPeriodTime(PeriodTime periodTime) {
        tallyRouterDao.addPeriodTime(periodTime);
    }

    @Override
    public void addCyclePeriodTime(CyclePeriodTime cyclePeriodTime) {
        tallyRouterDao.addCyclePeriodTime(cyclePeriodTime);
    }

    @Override
    public String findUserIdByUserName(String userName) {
        return tallyRouterDao.findUserIdByUserName(userName);
    }

    @Override
    public void addRouteUser(RouteUser routeUser) {
        tallyRouterDao.addRouteUser(routeUser);
    }

    @Override
    public int checkRouteId(String routeId) {
        return tallyRouterDao.checkRouteId(routeId);
    }

    @Override
    public List<String> choicePeople() {
        return tallyRouterDao.choicePeople();
    }

    @Override
    public List<TallyRouterDto> findAllTallyRouterDto(String windId, String routeCode, String routeName) {
        return tallyRouterDao.findAllTallyRouterDto(windId, routeCode, routeName);
    }

    @Override
    public List<TallyRoute> findTallyRouteByPlan(String routeName, String maintenancer, String windId, Date startTime, Date endTime) {
        return tallyRouterDao.findTallyRouteByPlan(routeName, maintenancer, windId, startTime, endTime);
    }

    @Override
    public List<PeriodTime> findPeriodTimeByPlan(String routeId) {
        return tallyPlanDao.findPeriodTimeByPlan(routeId);
    }

    @Override
    public List<TallyPlanVO> findTallyPlanVOByPlan(String routeName, String maintenancer, String windId, Date startTime, Date endTime) {
        return tallyRouterDao.findTallyPlanVOByPlan(routeName, maintenancer, windId, startTime, endTime);
    }

    @Override
    public List<String> findAllRouteCode() {
        return tallyRouterDao.findAllRouteCode();
    }

    @Override
    public String findWindIdByRouteCode(String routeCode) {
        return tallyRouterDao.findWindIdByRouteCode(routeCode);
    }

    @Override
    public int countTallyRoute(String windId, String routeCode, String routeName) {
        return tallyRouterDao.countTallyRoute(windId, routeCode, routeName);
    }

    @Override
    public PostDto findPostByUserName(String userName) {
        return tallyRouterDao.findPostByUserName(userName);
    }

    @Override
    public TallyRoute findRouteCodeRelevant(String routeCode) {
        return tallyRouterDao.findRouteCodeRelevant(routeCode);
    }

    @Override
    public Cycle findCycleByCycleNameAndRouteId(String routeId, String cycleName) {
        return tallyRouterDao.findCycleByCycleNameAndRouteId(routeId, cycleName);
    }

    @Override
    public List<PeriodTime> findPeriodTimeByCycleId(String cycleId) {
        return tallyRouterDao.findPeriodTimeByCycleId(cycleId);
    }

    @Override
    public void updateTallyRoute(TallyRoute tallyRoute) {
        tallyRouterDao.updateTallyRoute(tallyRoute);
    }

    @Override
    public void updateCycle(Cycle cycle) {
        tallyRouterDao.updateCycle(cycle);
    }

    @Override
    public String findPeriodTimeIdByCycleIdStartTimeAndEndTime(String cycleId, Date startTime, Date endTime) {
        return tallyRouterDao.findPeriodTimeIdByCycleIdStartTimeAndEndTime(cycleId, startTime, endTime);
    }

    @Override
    public void updatePeriodTime(PeriodTime periodTime) {
        tallyRouterDao.updatePeriodTime(periodTime);
    }

    @Override
    public String findIdByRouteIdAndUserId(String routeId, String userId) {
        return tallyRouterDao.findIdByRouteIdAndUserId(routeId, userId);
    }

    @Override
    public void updateRouteUser(RouteUser routeUser) {
    	
        tallyRouterDao.addRouteUser(routeUser);
    }

    @Override
    public void deletePeriodTimeByCycleNameAndStartTimeAndEndTime(String cycleName, Date startTime, Date endTime) {
        tallyRouterDao.deletePeriodTimeByCycleNameAndStartTimeAndEndTime(cycleName, startTime, endTime);
    }

    @Override
    public int findPeriodTimeByCycleIdStartTimeAndEndTime(String cycleId, Date startTime, Date endTime) {
        return tallyRouterDao.findPeriodTimeByCycleIdStartTimeAndEndTime(cycleId, startTime, endTime);
    }

    @Override
    public List<TallyRoute> findTallyRouteByWindIdAndRouteName(String routeName, String windId) {
        return tallyRouterDao.findTallyRouteByWindIdAndRouteName(routeName, windId);
    }

    @Override
    public List<TallyRoute> findTallyRouteByWindIdAndRouteName(String routeName, String windId11, String windId22) {
        return tallyRouterDao.findTallyRouteByWindIdAndRouteName2(routeName, windId11, windId22);
    }

    @Override
    public int countByWindIdAndRouteName(String routeName, String windId) {
        return tallyRouterDao.countByWindIdAndRouteName(routeName, windId);
    }

    @Override
    public String findRouteId() {
        if (StringUtils.isBlank(tallyRouterDao.findRouteId())){
            return "0";
        }
        return String.valueOf(new Integer(tallyRouterDao.findRouteId())+1);
    }

    @Override
    public String findCycleId() {
      /*  if (StringUtils.isBlank(tallyRouterDao.findCycleId())){
            return "0";
        }
        return String.valueOf(new Integer(tallyRouterDao.findCycleId())+1);*/

        if (StringUtils.isBlank(tallyRouterDao.findCycleId().get(0))){
            return "0";
        }

        List<String> findserialNums=tallyRouterDao.findCycleId();

        int big=0;
        int len=findserialNums.size();
        for (String s:findserialNums){
            int x=new Integer(s);
            if (big<x){
                big=x;
            }
        }

        return String.valueOf(big+1);
    }

    @Override
    public List<UserDto> findAllUserDto() {
        return tallyRouterDao.findAllUserDto();
    }

    @Override
    public void deletePeriodTimeByCycleId(String cycleId) {
        tallyRouterDao.deletePeriodTimeByCycleId(cycleId);
    }

    @Override
    public TallyRoute findTallyRouteByRouteId(String routeId) {
        return tallyRouterDao.findTallyRouteByRouteId(routeId);
    }

    @Override
    public Cycle findCycleByRouteId(String routeId) {
    	Cycle cycle = tallyRouterDao.findCycleByRouteId(routeId);
    	if(cycle!=null){
    		try {
				makeCodeType(cycle);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
        return cycle;
    }
    
    private Cycle makeCodeType(Cycle cycle) throws Exception {
		List<String> codeTypes = new ArrayList<String>();
		codeTypes.add("PERIODIC_UNIT");
		List<DataDict> dataDicts = dataDictService.findDataDictsByCodeType(codeTypes);
		if (dataDicts != null && !dataDicts.isEmpty()) {
				for(DataDict d : dataDicts) {
					if ("PERIODIC_UNIT".equals(d.getCodeTypeName()) && cycle.getCycleUnit().equals(d.getName())) {
						cycle.setCycleUnitText(d.getTitle());
					}
				}
		}
		return cycle;
	}
	

    @Override
    public List<PeriodTimeVO> findPeriodTimeVOByCycleId(String cycleId) {
        return tallyRouterDao.findPeriodTimeVOByCycleId(cycleId);  
    }

    @Override
    public String findRouteUserId() {
        return String.valueOf(tallyRouterDao.findRouterUserId()+1);
    }

    @Override
    public List<RouteUserVO> findRouteUserByrouteId(String routeId) {
        return tallyRouterDao.findRouteUserByrouteId(routeId);
    }

    @Override
    public String findWindIdByCode(String windId1) {
        return tallyRouterDao.findWindIdByCode(windId1);
    }

    @Override
    public PageResultEntity getArchitectureAndMemberByWindId(String windId,PageResultEntity resultEntity) {
        
    	String orgArchitectureId =orgArchitectureService.getwindId(windId);
    	
    	List<OrgArchitecture> orgArchitectures = orgArchitectureService.queryOrgArchitectureList(null,
                "03",null, orgArchitectureId);

        if (orgArchitectures!=null && !orgArchitectures.isEmpty()){
            List<com.qz.zframe.common.entity.UserDto> architectureAndMenberVOList=new ArrayList<com.qz.zframe.common.entity.UserDto>();
            for (OrgArchitecture orgArchitecture:orgArchitectures){
                ArchitectureAndMenberVO architectureAndMenberVO=new ArchitectureAndMenberVO();
                try {
                    List<com.qz.zframe.common.entity.UserDto> userDtos = userService.queryUserInfoByDeptId(orgArchitecture.getArchitectureId());
                    if (userDtos==null||userDtos.isEmpty()){
                        resultEntity.setCode(ErrorCode.ERROR);
                        resultEntity.setMsg("部门下没有员工!");
                        return resultEntity;
                    }
                    for (com.qz.zframe.common.entity.UserDto userDto:userDtos){
                        architectureAndMenberVOList.add(userDto);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            PageInfo<com.qz.zframe.common.entity.UserDto> pageData=new PageInfo<com.qz.zframe.common.entity.UserDto>(architectureAndMenberVOList);
            resultEntity.setCode(ErrorCode.SUCCESS);
            resultEntity.setMsg("获取人员部门信息成功!");
            resultEntity.setRows(architectureAndMenberVOList);
            resultEntity.setTotal((int) pageData.getTotal());
            return resultEntity;
        }
        resultEntity.setCode(ErrorCode.SUCCESS);
        return resultEntity;
    }

    @Override
    public ResultEntity findAllTallyRouteName(ResultEntity resultEntity) {

        List<TallyRoute> tallyRouteList=tallyRouterDao.findAllTallyRouteName();
        if (tallyRouteList==null||tallyRouteList.isEmpty()){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("没有巡检路线!");
            return resultEntity;
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询巡检路线名称!");
        resultEntity.setData(tallyRouteList);
        return resultEntity;
    }

	@Override
	public void deleteUserByRouteId(String routeId) {
		tallyRouterDao.deleteUserByRouteId(routeId);
		
	}


}
