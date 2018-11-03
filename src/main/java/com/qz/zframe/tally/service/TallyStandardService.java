package com.qz.zframe.tally.service;

import com.qz.zframe.tally.entity.TallyRoute;
import com.qz.zframe.tally.entity.TallyRouteStandard;
import com.qz.zframe.tally.entity.TallyStandard;
import com.qz.zframe.tally.vo.TallyStandardPostVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TallyStandardService {

    /**
     * 查巡检导航信息
     * @return
     */
    List<TallyStandard> findAllTallyStandard(@Param("equipmentBelonging") String equipmentBelonging, @Param("routeId") String routeId, @Param("equipmentState") String equipmentState, @Param("alarmType") String alarmType, @Param("standardCoding") String standardCoding, @Param("checkContent") String checkContent);

    /**
     * 根据路线id查路线名称
     * @param routeId
     * @return
     */
    String findRouteNameByRouteId(String routeId);

    /**
     * 根据路线id获取所属风场
     * @param routeId
     * @return
     */
    String findWindIdByRouteId(String routeId);

    /**
     * 根据标准id数组进行删除路线标准关联表
     * @param periodTimeIds
     */
    void deletetallyRouteStandardByPeriodTimeIds(String[] periodTimeIds);

    /**
     * 根据标准id数组进行删除点检标准表
     * @param periodTimeIds
     */
    void deleteTallyStandardByPeriodTimeIds(@Param("periodTimeIds") String[] periodTimeIds);

    /**
     * 根据路线名称查路线id
     * @param routeName
     * @return
     */
    String findRouteIdByRouteName(String routeName);

    /**
     * 新增点检标准
     * @param tallyStandard
     */
    void addTallyStandard(TallyStandard tallyStandard);

    /**
     * 新增路线标准关系
     * @param tallyRouteStandard
     */
    void addTallyRouteStandard(TallyRouteStandard tallyRouteStandard);

    /**
     *根据路线名称获取所属风场
     * @param routeName
     * @return
     */
    String findWindIdByRouteName(@Param("routeName") String routeName);

    /**
     * 根据路线名称查找周期名称
     * @param routeName
     * @return
     */
    String findCycleNameByRouteName(String routeName);

    /**
     * 根据路线名称查标准id
     * @param routeName
     * @return
     */
    String findStandardIdByRouteName(String routeName);

    /**
     * 根据路线名称查设备名称
     * @param routeName
     * @return
     */
    String findEquipmentIdByRouteName(String routeName);

    /**
     * 更新标准
     * @param tallyStandard
     */
    void updateTallyStandard(TallyStandard tallyStandard);

    /**
     * 根据路线名称查关联表id
     * @param routeName
     * @return
     */
    String findIdByRouteName(String routeName);

    /**
     * 更新关系表路线标准和路线
     * @param tallyRouteStandard
     */
    void updateTallyRouteStandard(TallyRouteStandard tallyRouteStandard);


}
