package com.qz.zframe.tally.service.impl;

import com.github.pagehelper.PageHelper;
import com.qz.zframe.common.entity.DataDict;
import com.qz.zframe.common.service.DataDictService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tally.dao.TallyStandardDao;
import com.qz.zframe.tally.entity.*;
import com.qz.zframe.tally.service.TallyStandardService;
import com.qz.zframe.tally.vo.EquipmentOrQrCode;
import com.qz.zframe.tally.vo.TallyStandardPostVO;
import com.qz.zframe.tally.vo.TallyStandardVO2;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service("tallyStandardService")
@Transactional(rollbackFor = Exception.class)
public class TallyStandardServiceImpl implements TallyStandardService{

    @Autowired
    TallyStandardDao tallyStandardDao;

    @Autowired
    DataDictService dataDictService;

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
    public String findCycleNameByRouteId(String routeId) {
        return tallyStandardDao.findCycleNameByRouteId(routeId);
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
    public TallyStandard findTallyStandardByStandardId(String standardId) {
        return tallyStandardDao.findTallyStandardByStandardId(standardId);
    }

    @Override
    public void deletetallyRouteStandardByRouteNames(String[] standardIds) {
        tallyStandardDao.deletetallyRouteStandardByRouteNames(standardIds);
    }

    @Override
    public void deleteTallyStandardByRouteNames(String[] standardIds) {
        tallyStandardDao.deleteTallyStandardByRouteNames(standardIds);
    }

    @Override
    public int countStandard(String equipmentBelonging, String routeId, String equipmentState, String alarmType, String standardCoding, String checkContent) {
        return tallyStandardDao.countStandard(equipmentBelonging, routeId, equipmentState, alarmType, standardCoding, checkContent);
    }

    @Override
    public String findCycleIdByCycleNameAndRouteId(String cycleName, String routeId) {
        return tallyStandardDao.findCycleIdByCycleNameAndRouteId(cycleName, routeId);
    }

    @Override
    public List<String> findRouteNameByWindId(String windId) {
        return tallyStandardDao.findRouteNameByWindId(windId);
    }

    @Override
    public String findCycleNameByStandardIdAndRouteId(String standardId, String routeId) {
        return tallyStandardDao.findCycleNameByStandardIdAndRouteId(standardId, routeId);
    }

    @Override
    public List<TallyStandardVO2> findAllTallyStandardVO2(String equipmentBelonging, String routeName, String standardType, String checkContent) {



        return tallyStandardDao.findAllTallyStandardVO2(equipmentBelonging, routeName, standardType, checkContent);
    }

    @Override
    public String findIdByStandardId(String standardId) {
        return tallyStandardDao.findIdByStandardId(standardId);
    }

    @Override
    public int countStandard1() {
        return tallyStandardDao.countStandard1()+10000;
    }

    @Override
    public ResultEntity addTallyStandardNew(TallyStandardPostVO tallyStandardPostVO,ResultEntity resultEntity) {
        TallyStandard tallyStandard=new TallyStandard();
        tallyStandard.setStandardId((UUID.randomUUID()+"").replaceAll("-","")); //标准id 直接上uuid
        tallyStandard.setRouteId(tallyStandardPostVO.getRouteId());//路线id  所属路线下拉框*
        tallyStandard.setStandardCoding(tallyStandardPostVO.getStandardCoding());//标准编码 字符型，5位
        tallyStandard.setEquipmentId(tallyStandardPostVO.getEquipmentId());//所属数据 下拉框 根据设备主数据选择
        tallyStandard.setLocation(tallyStandardPostVO.getLocation());//所在部位 暂时未用...
        tallyStandard.setCheckContent(tallyStandardPostVO.getCheckContent());//点检内容 示例：XXXXX绝缘阻值
        tallyStandard.setStandardType(tallyStandardPostVO.getStandardType());//标准类型 标准代码下拉框 分“定量”和“定性”
        tallyStandard.setDataType(tallyStandardPostVO.getDataType());//数据类型 标准类型下拉框 “时间波形”、“手抄量”、“仪抄量”等
        tallyStandard.setSignalType(tallyStandardPostVO.getSignalType());//信号类型 标准类型下拉框“观察量”、速度、电压等
        tallyStandard.setCheckMethod(tallyStandardPostVO.getCheckMethod());//等下再改 手填描述
        tallyStandard.setStandardJudgment(tallyStandardPostVO.getStandardJudgment());//判断标准
        tallyStandard.setResultOptions(tallyStandardPostVO.getResultOptions());// 可选，03-结果选项配置
        tallyStandard.setMeasurementUnit(tallyStandardPostVO.getMeasurementUnit());//根据信号类型确认下拉值
        tallyStandard.setTypicalValue(tallyStandardPostVO.getTypicalValue());//手输值
        tallyStandard.setEquipmentState(tallyStandardPostVO.getEquipmentState());//设备状态
        tallyStandard.setTwodimensionalcodeLocation(tallyStandardDao.findQrIdByEquipmentId(tallyStandardPostVO.getEquipmentId()));//选择，01-二维码位置配置 ****查一下吧
        tallyStandard.setStartandstopPoint(tallyStandardPostVO.getStartandstopPoint());//暂未发现使用
        tallyStandard.setMaincontrolPoint(tallyStandardPostVO.getMaincontrolPoint());//暂未发现使用
        tallyStandard.setAlarmType(tallyStandardPostVO.getAlarmType());//单选：超上限报警，超下限报警，范围内报警，范围外报警
        tallyStandard.setAlarmCeiling(tallyStandardPostVO.getAlarmCeiling());//
        tallyStandard.setAlarmLowerlimit(tallyStandardPostVO.getAlarmLowerlimit());//
        tallyStandard.setTrueId("0");
        tallyStandardDao.addTallyStandard(tallyStandard);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("添加点检标准相关信息成功!");

        return  resultEntity;
    }

    @Override
    public ResultEntity updateTallyStandardByStandardId(TallyStandardPostVO tallyStandardPostVO, ResultEntity resultEntity) {
        TallyStandard tallyStandard=new TallyStandard();
        tallyStandard.setStandardId(tallyStandardPostVO.getStandardId());//标准id
        tallyStandard.setRouteId(tallyStandardPostVO.getRouteId());//路线id
        tallyStandard.setEquipmentId(tallyStandardPostVO.getEquipmentId());//所属设备→设备id
        tallyStandard.setLocation(tallyStandardPostVO.getLocation());//所在部位
        tallyStandard.setStandardCoding(tallyStandardPostVO.getStandardCoding());//标准编码
        tallyStandard.setCheckContent(tallyStandardPostVO.getCheckContent());//点检内容
        tallyStandard.setStandardType(tallyStandardPostVO.getStandardType());//标准类型
        tallyStandard.setDataType(tallyStandardPostVO.getDataType());//数据类型
        tallyStandard.setSignalType(tallyStandardPostVO.getSignalType());//信号类型
        tallyStandard.setCheckMethod(tallyStandardPostVO.getCheckMethod());//点检方法
        tallyStandard.setStandardJudgment(tallyStandardPostVO.getStandardJudgment());//判断标准
        tallyStandard.setResultOptions(tallyStandardPostVO.getResultOptions());//结果选项
        tallyStandard.setMeasurementUnit(tallyStandardPostVO.getMeasurementUnit());//计量单位
        tallyStandard.setTypicalValue(tallyStandardPostVO.getTypicalValue());//典型值
        tallyStandard.setEquipmentState(tallyStandardPostVO.getEquipmentState());//设备状态
        tallyStandard.setTwodimensionalcodeLocation(tallyStandardDao.findQrIdByEquipmentId(tallyStandardPostVO.getEquipmentId()));//二维码位置
        tallyStandard.setStartandstopPoint(tallyStandardPostVO.getStartandstopPoint());//启停点
        tallyStandard.setMaincontrolPoint(tallyStandardPostVO.getMaincontrolPoint());//主控点
        tallyStandard.setAlarmType(tallyStandardPostVO.getAlarmType());
        tallyStandard.setAlarmCeiling(tallyStandardPostVO.getAlarmCeiling());
        tallyStandard.setAlarmLowerlimit(tallyStandardPostVO.getAlarmLowerlimit());

        tallyStandardDao.updateTallyStandard(tallyStandard);//更新
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("更新点检标准相关信息成功!");
        return resultEntity;
    }

    @Override
    public String findEquipmentNameByEquipmentId(String equipmentId) {
        return tallyStandardDao.findEquipmentNameByEquipmentId(equipmentId);
    }

    @Override
    public ResultEntity findEquipmentOrQrCode(ResultEntity resultEntity,String windCode,String qrId,String equipmentId) {
        List<EquipmentOrQrCode> equipmentOrQrCode = tallyStandardDao.findEquipmentOrQrCode(windCode,qrId,equipmentId);
        if (equipmentOrQrCode==null||equipmentOrQrCode.isEmpty()){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("没有数据!");
            return resultEntity;
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("获取下拉数据成功!");
        resultEntity.setData(equipmentOrQrCode);
        return resultEntity;
    }

    @Override
    public ResultEntity findAllResult(ResultEntity resultEntity) {

        List<TallyResult> tallyResults=tallyStandardDao.findAllResult();
        if (tallyResults==null||tallyResults.isEmpty()){
            resultEntity.setData(ErrorCode.ERROR);
            resultEntity.setMsg("没有数据！");
            return resultEntity;
        }
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("获取下拉数据成功!");
        resultEntity.setData(tallyResults);
        return resultEntity;
    }

    @Override
    public ResultEntity findAllUnit(ResultEntity resultEntity, String name) {

        List<DataDict> dataDicts = dataDictService.queryCodeList("MEASUREMENT_UNIT" + name);
        if (dataDicts==null||dataDicts.isEmpty()){
            resultEntity.setData(ErrorCode.ERROR);
            resultEntity.setMsg("没有数据！");
            return resultEntity;
        }
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("获取下拉数据成功!");
        resultEntity.setData(dataDicts);
        return resultEntity;
    }

    @Override
    public String findTitleByName(String name1, String name2) {

        String title=tallyStandardDao.findTitleByName(name1,name2);

        return title;
    }

    @Override
    public String findPositonNameByQrId(String qrId) {
        return tallyStandardDao.findPositonNameByQrId(qrId);
    }

    @Override
    public String findWindNameByRouteId(String routeId) {
        return tallyStandardDao.findWindNameByRouteId(routeId);
    }

    @Override
    public ResultEntity updateDetail(ResultEntity resultEntity,String standardId) {

        //基本信息
        TallyStandardPostVO tallyStandardPostVO=new TallyStandardPostVO();
        TallyStandard tallyStandard=tallyStandardDao.findTallyStandardByStandardId(standardId);
        if (tallyStandard==null){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("没有详情信息!");
            return resultEntity;
        }
        tallyStandardPostVO.setStandardId(tallyStandard.getStandardId());
        tallyStandardPostVO.setEquipmentBelonging(tallyStandardDao.findEquipmentNameByEquipmentId(tallyStandard.getEquipmentId()));//所属设备
        tallyStandardPostVO.setEquipmentId(tallyStandard.getEquipmentId());//设备id
        tallyStandardPostVO.setLocation(tallyStandard.getLocation());//所在部位
        tallyStandardPostVO.setStandardCoding(tallyStandard.getStandardCoding());//标准编码
        tallyStandardPostVO.setCheckContent(tallyStandard.getCheckContent());//点检内容
        tallyStandardPostVO.setStandardType(tallyStandard.getStandardType());//标准类型
        tallyStandardPostVO.setDataType(tallyStandard.getDataType());//数据类型
        tallyStandardPostVO.setSignalType(tallyStandard.getSignalType());//信号类型
        tallyStandardPostVO.setCheckMethod(tallyStandard.getCheckMethod());//点检方法
        tallyStandardPostVO.setStandardJudgment(tallyStandard.getStandardJudgment());//判断标准
        tallyStandardPostVO.setResultOptions(tallyStandard.getResultOptions());//结果选项
        tallyStandardPostVO.setMeasurementUnit(tallyStandard.getMeasurementUnit());//计量单位
        tallyStandardPostVO.setTypicalValue(tallyStandard.getTypicalValue());//典型值
        tallyStandardPostVO.setEquipmentState(tallyStandard.getEquipmentState());//设备状态
        tallyStandardPostVO.setTwodimensionalcodeLocation(tallyStandardDao.findPositonNameByQrId(tallyStandard.getTwodimensionalcodeLocation()));
        //路线配置
        tallyStandardPostVO.setRouteId(tallyStandard.getRouteId());
        tallyStandardPostVO.setRouteName(tallyStandardDao.findRouteNameByRouteId(tallyStandard.getRouteId()));//所属路线
        tallyStandardPostVO.setWindName(tallyStandardDao.findWindNameByRouteId(tallyStandard.getRouteId()));//所属风场
        tallyStandardPostVO.setCycleName(tallyStandardDao.findCycleNameByRouteId(tallyStandard.getRouteId()));//执行周期
        tallyStandardPostVO.setMaincontrolPoint(tallyStandard.getMaincontrolPoint());//主控点
        tallyStandardPostVO.setStartandstopPoint(tallyStandard.getStartandstopPoint());//启停点
        //报警类型
        tallyStandardPostVO.setAlarmType(tallyStandard.getAlarmType());
        tallyStandardPostVO.setAlarmCeiling(tallyStandard.getAlarmCeiling());//报警上限
        tallyStandardPostVO.setAlarmLowerlimit(tallyStandard.getAlarmLowerlimit());//报警下限

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("更新信息查询成功");
        resultEntity.setData(tallyStandardPostVO);

        return resultEntity;
    }

    @Override
    public List<TallyStandard> findAllTallyStandardForDetail(String qrId) {
        return tallyStandardDao.findAllTallyStandardForDetail(qrId);
    }

    @Override
    public String findResultChooseByResultId(String resultId) {
        return tallyStandardDao.findResultChooseByResultId(resultId);
    }

    @Override
    public ResultEntity findQrCodeByRouteId(ResultEntity resultEntity, String routeId) {
        List<QrCode> qrCodeByRouteId = tallyStandardDao.findQrCodeByRouteId(routeId);
        if (qrCodeByRouteId==null){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("没有查出二维码!");
            return resultEntity;
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询二维码成功!");
        resultEntity.setData(qrCodeByRouteId);
        return resultEntity;
    }


}
