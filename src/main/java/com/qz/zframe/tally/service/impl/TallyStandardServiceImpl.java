package com.qz.zframe.tally.service.impl;

import com.qz.zframe.tally.dao.TallyStandardDao;
import com.qz.zframe.tally.entity.TallyRoute;
import com.qz.zframe.tally.entity.TallyRouteStandard;
import com.qz.zframe.tally.entity.TallyStandard;
import com.qz.zframe.tally.service.TallyStandardService;
import com.qz.zframe.tally.vo.TallyStandardPostVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("tallyStandardService")
@Transactional(rollbackFor = Exception.class)
public class TallyStandardServiceImpl implements TallyStandardService{

    @Autowired
    TallyStandardDao tallyStandardDao;

    @Override
    public List<TallyStandard> findAllTallyStandard(String equipmentBelonging, String routeId, String equipmentState, String alarmType, String standardCoding, String checkContent) {
        return tallyStandardDao.findAllTallyStandard(equipmentBelonging,routeId,equipmentState,alarmType,standardCoding,checkContent);
    }

    @Override
    public String findRouteNameByRouteId(String routeId) {
        return tallyStandardDao.findRouteNameByRouteId(routeId);
    }

    @Override
    public String findWindIdByRouteId(String routeId) {
        return tallyStandardDao.findWindIdByRouteId(routeId);
    }

    @Override
    public void deletetallyRouteStandardByPeriodTimeIds(String[] periodTimeIds) {
        tallyStandardDao.deletetallyRouteStandardByPeriodTimeIds(periodTimeIds);
    }

    @Override
    public void deleteTallyStandardByPeriodTimeIds(String[] periodTimeIds) {
        tallyStandardDao.deleteTallyStandardByPeriodTimeIds(periodTimeIds);
    }

    @Override
    public String findRouteIdByRouteName(String routeName) {
        return tallyStandardDao.findRouteIdByRouteName(routeName);
    }

    @Override
    public void addTallyStandard(TallyStandard tallyStandard) {
        tallyStandardDao.addTallyStandard(tallyStandard);
    }

    @Override
    public void addTallyRouteStandard(TallyRouteStandard tallyRouteStandard) {
        tallyStandardDao.addTallyRouteStandard(tallyRouteStandard);
    }

    @Override
    public String findWindIdByRouteName(String routeName) {
        return tallyStandardDao.findWindIdByRouteName(routeName);
    }

    @Override
    public String findCycleNameByRouteName(String routeName) {
        return tallyStandardDao.findCycleNameByRouteName(routeName);
    }

    @Override
    public String findStandardIdByRouteName(String routeName) {
        return tallyStandardDao.findStandardIdByRouteName(routeName);
    }

    @Override
    public String findEquipmentIdByRouteName(String routeName) {
        return tallyStandardDao.findStandardIdByRouteName(routeName);
    }

    @Override
    public void updateTallyStandard(TallyStandard tallyStandard) {
        tallyStandardDao.updateTallyStandard(tallyStandard);
    }

    @Override
    public String findIdByRouteName(String routeName) {
        return tallyStandardDao.findIdByRouteName(routeName);
    }

    @Override
    public void updateTallyRouteStandard(TallyRouteStandard tallyRouteStandard) {
        tallyStandardDao.updateTallyRouteStandard(tallyRouteStandard);
    }

    @Override
    public TallyStandard findTallyStandardByRouteName(String routeName) {
        return tallyStandardDao.findTallyStandardByRouteName(routeName);
    }

    @Override
    public void deletetallyRouteStandardByRouteNames(String[] routeNames) {
        tallyStandardDao.deletetallyRouteStandardByRouteNames(routeNames);
    }

    @Override
    public void deleteTallyStandardByRouteNames(String[] routeNames) {
        tallyStandardDao.deleteTallyStandardByRouteNames(routeNames);
    }

    @Override
    public int countStandard(String equipmentBelonging, String routeId, String equipmentState, String alarmType, String standardCoding, String checkContent) {
        return tallyStandardDao.countStandard(equipmentBelonging, routeId, equipmentState, alarmType, standardCoding, checkContent);
    }


}
