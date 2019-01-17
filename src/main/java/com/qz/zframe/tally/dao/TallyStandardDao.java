package com.qz.zframe.tally.dao;

import com.qz.zframe.common.entity.DataDict;
import com.qz.zframe.tally.entity.*;
import com.qz.zframe.tally.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TallyStandardDao {

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
    void deletetallyRouteStandardByPeriodTimeIds(@Param("periodTimeIds") String[] periodTimeIds);

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
     * @return
     */
    String findCycleNameByRouteId(String routeId);

    /**
     * 更新标准
     * @param tallyStandard
     */
    void updateTallyStandard(TallyStandard tallyStandard);

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

    /**
     * 根据路线名称查询路线标准
     * @return
     */
    TallyStandard findTallyStandardByStandardId(String standardId);

    /**
     * 根据路线名称数组进行删除路线标准关联表
     */
    void deletetallyRouteStandardByRouteNames(@Param("standardIds") String[] standardIds);

    /**
     * 根据标准id数组进行删除点检标准表
     */
    void deleteTallyStandardByRouteNames(@Param("standardIds") String[] standardIds);

    /**
     * 查询记录总数用于分页
     * @param equipmentBelonging
     * @param routeId
     * @param equipmentState
     * @param alarmType
     * @param standardCoding
     * @param checkContent
     * @return
     */
    int countStandard(@Param("equipmentBelonging") String equipmentBelonging, @Param("routeId") String routeId, @Param("equipmentState") String equipmentState, @Param("alarmType") String alarmType, @Param("standardCoding") String standardCoding, @Param("checkContent") String checkContent);

    /**
     * 根据周期名称和路线id查询周期id
     * @param cycleName
     * @param routeId
     * @return
     */
    String findCycleIdByCycleNameAndRouteId(@Param("cycleName")String cycleName,@Param("routeId")String routeId);

    /**
     * 根据所属风场查询所属风场下面的所属路线
     * @param windId
     * @return
     */
    List<String> findRouteNameByWindId(String windId);

    /**
     * 根据标准id和路线id查询周期名称
     * @param standardId
     * @param routeId
     * @return
     */
    String findCycleNameByStandardIdAndRouteId(@Param("standardId") String standardId,@Param("routeId") String routeId);

    /**
     * 查询巡检标准改版v1.0
     * @param equipmentBelonging
     * @param routeName
     * @param standardType
     * @param checkContent
     * @return
     */
    List<TallyStandardVO2> findAllTallyStandardVO2(@Param("equipmentBelonging")String equipmentBelonging,@Param("routeName") String routeName,@Param("standardType") String standardType,@Param("checkContent") String checkContent);

    String findIdByStandardId(String standardId);

    int countStandard1();

    String findEquipmentNameByEquipmentId(String equipmentId);

    List<EquipmentOrQrCode> findEquipmentOrQrCode(@Param("windCode")String windCode,@Param("qrId")String qrId,@Param("equipmentId")String equipmentId);

    List<TallyResult> findAllResult();

    String findTitleByName(@Param("name1")String name1,@Param("name2")String name2);

    String findPositonNameByQrId(String qrId);

    String findWindNameByRouteId(String routeId);

    String findQrIdByEquipmentId(String equipmentId);

    List<TallyStandard> findAllTallyStandardForDetail(String qrId);

    String findResultChooseByResultId(String resultId);

    List<QrCode> findQrCodeByRouteId(String routeId);
}
