package com.qz.zframe.maintain.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.service.DataDictService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.maintain.entity.*;
import com.qz.zframe.maintain.mapper.BreakdownInfoMapper;
import com.qz.zframe.maintain.mapper.DefectWorkorderMapper;
import com.qz.zframe.maintain.service.BreakdownService;
import com.qz.zframe.maintain.vo.BreakdownVo;
import com.qz.zframe.maintain.vo.ChooseDealModeVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class BreakdownServiceImpl implements BreakdownService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private BreakdownInfoMapper breakdownInfoMapper;

    @Autowired
    private DefectWorkorderMapper defectWorkorderMapper;

    @Override
    public ResultEntity addBreakdown(BreakdownVo breakdownVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (StringUtils.isNoneBlank(breakdownVo.getBreakdownId())
                && breakdownInfoMapper.selectByPrimaryKey(breakdownVo.getBreakdownId())!= null) {
            return this.updateBreakdown(breakdownVo);
        }

        if (!StringUtils.isNoneBlank(breakdownVo.getBreakdownDesc())) {
            resultEntity.setMsg("故障描述不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownVo.getBreakdownCode())) {
            resultEntity.setMsg("故障代码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownVo.getWindId())) {
            resultEntity.setMsg("风电场编码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownVo.getDealwithPerson())) {
            resultEntity.setMsg("处理人id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownVo.getPositionId())) {
            resultEntity.setMsg("位置id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownVo.getCrewId())) {
            resultEntity.setMsg("机组id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownVo.getBreakdownLocation())) {
            resultEntity.setMsg("故障位置id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownVo.getBreakdownAttribute())) {
            resultEntity.setMsg("故障属性id不能为空");
            return resultEntity;
        }
        BreakdownInfoExample breakdownInfoExample = new BreakdownInfoExample();
        breakdownInfoExample.createCriteria().andBreakdownCodeEqualTo(breakdownVo.getBreakdownCode());
        List<BreakdownInfo> breakdownInfoList = breakdownInfoMapper.selectByExample(breakdownInfoExample);
        if (breakdownInfoList!=null && breakdownInfoList.size()!=0) {
            resultEntity.setMsg("该故障代码已存在,请重新定义");
            return resultEntity;
        }
        //生成id
        breakdownVo.setBreakdownId(UUIdUtil.getUUID());
        //生成流水号
        breakdownVo.setSerialNumber(String.valueOf(breakdownInfoMapper.countByExample(new BreakdownInfoExample())+1));
        //设置故障来源为手动填报
        breakdownVo.setBreakdownSource("102001");
        //根据是否有处理方式设置故障信息状态
        if (!StringUtils.isNoneBlank(breakdownVo.getDealwithMode())) {
            breakdownVo.setStatus("01");
        }else {
            breakdownVo.setStatus("02");
        }
        //添加维护人
        if (!StringUtils.isNoneBlank(breakdownVo.getMaintainer())) {
            breakdownVo.setMaintainer(currentUserService.getId());
        }
        //添加维护日期
        if (breakdownVo.getMaintainDate()==null) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                breakdownVo.setMaintainDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            }catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //插入数据库
        breakdownInfoMapper.insert(breakdownVo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("添加成功");
        return resultEntity;
    }

    @Override
    public ResultEntity addBreakdownList(List<BreakdownVo> breakdownVoList) {
        ResultEntity resultEntity = new ResultEntity();
        if (CollectionUtils.isNotEmpty(breakdownVoList)) {
            for (BreakdownVo breakdownVo:breakdownVoList) {
                if (!StringUtils.isNoneBlank(breakdownVo.getBreakdownDesc())) {
                    resultEntity.setMsg("故障描述不能为空");
                    return resultEntity;
                }
                if (!StringUtils.isNoneBlank(breakdownVo.getBreakdownCode())) {
                    resultEntity.setMsg("故障代码不能为空");
                    return resultEntity;
                }
                if (!StringUtils.isNoneBlank(breakdownVo.getWindId())) {
                    resultEntity.setMsg("风电场编码不能为空");
                    return resultEntity;
                }
                /*if (!StringUtils.isNoneBlank(breakdownVo.getDealwithTeam())) {
                    resultEntity.setMsg("处理班组id不能为空");
                    return resultEntity;
                }*/
                /*if (!StringUtils.isNoneBlank(breakdownVo.getDealwithPerson())) {
                    resultEntity.setMsg("处理人id不能为空");
                    return resultEntity;
                }*/
                if (!StringUtils.isNoneBlank(breakdownVo.getPositionId())) {
                    resultEntity.setMsg("位置id不能为空");
                    return resultEntity;
                }
                if (!StringUtils.isNoneBlank(breakdownVo.getCrewId())) {
                    resultEntity.setMsg("机组id不能为空");
                    return resultEntity;
                }
                if (!StringUtils.isNoneBlank(breakdownVo.getBreakdownLocation())) {
                    resultEntity.setMsg("故障位置id不能为空");
                    return resultEntity;
                }
                if (!StringUtils.isNoneBlank(breakdownVo.getBreakdownAttribute())) {
                    resultEntity.setMsg("故障属性id不能为空");
                    return resultEntity;
                }
                BreakdownInfoExample breakdownInfoExample = new BreakdownInfoExample();
                breakdownInfoExample.createCriteria().andBreakdownCodeEqualTo(breakdownVo.getBreakdownCode());
                List<BreakdownInfo> breakdownInfoList = breakdownInfoMapper.selectByExample(breakdownInfoExample);
                if (breakdownInfoList!=null && breakdownInfoList.size()!=0) {
                    resultEntity.setMsg("该故障代码已存在,请重新定义");
                    return resultEntity;
                }
                //生成id
                breakdownVo.setBreakdownId(UUIdUtil.getUUID());
                //生成流水号
                breakdownVo.setSerialNumber(String.valueOf(breakdownInfoMapper.countByExample(new BreakdownInfoExample())+1));
                //设置故障来源为手动填报
                breakdownVo.setBreakdownSource("102001");
                //根据是否有处理方式设置故障信息状态
                if (!StringUtils.isNoneBlank(breakdownVo.getDealwithTeam())) {
                    breakdownVo.setStatus("01");
                }else {
                    breakdownVo.setStatus("02");
                }
                //添加维护人
                if (!StringUtils.isNoneBlank(breakdownVo.getMaintainer())) {
                    breakdownVo.setMaintainer(currentUserService.getId());
                }
                //添加维护日期
                if (breakdownVo.getMaintainDate()==null) {
                    try {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        breakdownVo.setMaintainDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
                    }catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
            //批量插入数据库
            breakdownInfoMapper.insertList(breakdownVoList);
            resultEntity.setCode(ErrorCode.SUCCESS);
            resultEntity.setMsg("批量添加成功");

        }else {
            resultEntity.setMsg("数据为空");
        }

        return resultEntity;
    }

    @Override
    public ResultEntity updateBreakdown(BreakdownVo breakdownVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(breakdownVo.getBreakdownId())) {
            resultEntity.setMsg("故障id不能为空");
            return resultEntity;
        }
        BreakdownVo breakdownDetail = breakdownInfoMapper.getBreakdownDetail(breakdownVo.getBreakdownId());
        if ("02".equals(breakdownDetail.getStatus())) {
            resultEntity.setMsg("该票已处理完成,无法再编辑");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownVo.getSerialNumber())) {
            resultEntity.setMsg("故障流水号不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownVo.getBreakdownDesc())) {
            resultEntity.setMsg("故障描述不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownVo.getBreakdownCode())) {
            resultEntity.setMsg("故障代码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownVo.getWindId())) {
            resultEntity.setMsg("风电场编码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownVo.getDealwithTeam())) {
            resultEntity.setMsg("处理班组id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownVo.getDealwithPerson())) {
            resultEntity.setMsg("处理人id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownVo.getPositionId())) {
            resultEntity.setMsg("位置id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownVo.getCrewId())) {
            resultEntity.setMsg("机组id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownVo.getBreakdownLocation())) {
            resultEntity.setMsg("故障位置id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownVo.getBreakdownAttribute())) {
            resultEntity.setMsg("故障属性id不能为空");
            return resultEntity;
        }
        //修改故障信息
        BreakdownInfo breakdownInfo = breakdownInfoMapper.selectByPrimaryKey(breakdownVo.getBreakdownId());
        BeanUtil.copyProperties(breakdownVo,breakdownInfo,true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        breakdownInfoMapper.updateByPrimaryKey(breakdownInfo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity chooseDealMode(ChooseDealModeVo chooseDealModeVo) {
        ResultEntity resultEntity = new ResultEntity();

        String dealwithMode = chooseDealModeVo.getDealwithMode();
        String[] breakdownIds = chooseDealModeVo.getBreakdownIds();

        if (!(breakdownIds!=null && breakdownIds.length!=0)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }
        for (String breakdownId:breakdownIds) {
            BreakdownInfo breakdownInfo = breakdownInfoMapper.selectByPrimaryKey(breakdownId);
            if ("02".equals(breakdownInfo.getStatus())) {
                resultEntity.setMsg("已完成的故障信息无法再进行处理,请重新选择");
                return resultEntity;
            }
        }
        if ("转缺陷工单".equals(dealwithMode) && breakdownIds.length>1) {
            resultEntity.setMsg("转缺陷工单无法进行批量操作");
            return resultEntity;
        }

        breakdownInfoMapper.chooseDealMode(breakdownIds,dealwithMode);

        if ("转缺陷工单".equals(dealwithMode)) {
            //判断该故障生成的缺陷工单是否有人已经提交
            DefectWorkorderExample defectWorkorderExample = new DefectWorkorderExample();
            DefectWorkorderExample.Criteria criteria = defectWorkorderExample.createCriteria();
            criteria.andBreakdownIdEqualTo(breakdownIds[0]);
            List<String> list = new ArrayList<>();
            list.add("01");
            list.add("02");
            criteria.andStatusIn(list);
            List<DefectWorkorder> defectWorkorderList = defectWorkorderMapper.selectByExample(defectWorkorderExample);
            if (CollectionUtils.isNotEmpty(defectWorkorderList)) {
                resultEntity.setMsg("该故障已做转缺陷处理,无法再次操作");
            }

            breakdownInfoMapper.chooseDealMode(breakdownIds,dealwithMode);
            BreakdownInfo breakdownInfo = breakdownInfoMapper.selectByPrimaryKey(breakdownIds[0]);
            if (breakdownInfo!=null) {
                //生成缺陷工单
                DefectWorkorder defectWorkorder = new DefectWorkorder();
                //id
                defectWorkorder.setWorkorderId(UUIdUtil.getUUID());

                //返回缺陷工单id
                resultEntity.setData(defectWorkorder.getWorkorderId());

                //设置状态为未提交
                defectWorkorder.setStatus("03");
                //设置故障id来源
                defectWorkorder.setBreakdownId(breakdownInfo.getBreakdownId());
                //维护人
                defectWorkorder.setMaintainer(currentUserService.getId());
                try {
                    //维护日期
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    defectWorkorder.setMaintainDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
                }catch (ParseException e) {
                    e.printStackTrace();
                }
                //故障描述
                defectWorkorder.setBreakdownDesc(breakdownInfo.getBreakdownDesc());
                //故障代码
                defectWorkorder.setBreakdownCode(breakdownInfo.getBreakdownCode());
                //风电场
                defectWorkorder.setWindId(breakdownInfo.getWindId());
                if (StringUtils.isNoneBlank(breakdownInfo.getDealwithTeam())) {
                    //处理班组
                    defectWorkorder.setDutyTeam(breakdownInfo.getDealwithTeam());
                }
                if (StringUtils.isNoneBlank(breakdownInfo.getDealwithPerson())) {
                    //处理人
                    defectWorkorder.setDutyHead(breakdownInfo.getDealwithPerson());
                }
                //位置
                defectWorkorder.setPositionId(breakdownInfo.getPositionId());
                //机组
                defectWorkorder.setCrewId(breakdownInfo.getCrewId());
                if (StringUtils.isNoneBlank(breakdownInfo.getEquipmentId())) {
                    //设备
                    defectWorkorder.setEquipmentId(breakdownInfo.getBreakdownId());
                }
                if (breakdownInfo.getActiveTime()!=null) {
                    //故障激活时间
                    defectWorkorder.setActiveTime(breakdownInfo.getActiveTime());
                }
                if (StringUtils.isNoneBlank(breakdownInfo.getDowntimeWindspeed())) {
                    //停机风速
                    defectWorkorder.setDowntimeWindspeed(breakdownInfo.getDowntimeWindspeed());
                }
                if (breakdownInfo.getInterruptTime()!=null) {
                    //中断时间
                    defectWorkorder.setInterruptTime(breakdownInfo.getInterruptTime());
                }
                if (breakdownInfo.getRecoverTime()!=null) {
                    //恢复时间
                    defectWorkorder.setRecoverTime(breakdownInfo.getRecoverTime());
                }
                if (StringUtils.isNoneBlank(breakdownInfo.getRecoverWindspeed())) {
                    //恢复风速
                    defectWorkorder.setRecoverWindspeed(breakdownInfo.getRecoverWindspeed());
                }
                if (StringUtils.isNoneBlank(breakdownInfo.getElectricityLoss())) {
                    //损失电量
                    defectWorkorder.setElectricityLoss(breakdownInfo.getElectricityLoss());
                }
                if (breakdownInfo.getGridConnectedRecoverTime()!=null) {
                    //并网恢复时间
                    defectWorkorder.setGridConnectedRecoverTime(breakdownInfo.getGridConnectedRecoverTime());
                }
                //故障位置
                defectWorkorder.setBreakdownLocation(breakdownInfo.getBreakdownLocation());
                //故障属性
                defectWorkorder.setBreakdownAttribute(breakdownInfo.getBreakdownAttribute());
                defectWorkorderMapper.insert(defectWorkorder);
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteBreakdown(String[] breakdownIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!ArrayUtils.isNotEmpty(breakdownIds)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }
        for (String breakdownId:breakdownIds) {
            BreakdownInfo breakdownInfo = breakdownInfoMapper.selectByPrimaryKey(breakdownId);
            if (breakdownInfo!=null) {
                if ("02".equals(breakdownInfo.getStatus())){
                    resultEntity.setMsg("已经处理完成的故障无法删除");
                    return resultEntity;
                }
            }
        }
        breakdownInfoMapper.batchDelete(breakdownIds);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getBreakdownDetail(String breakdownId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(breakdownId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        BreakdownVo breakdownVo = breakdownInfoMapper.getBreakdownDetail(breakdownId);
        breakdownVo.setStatusName(this.getStatusName(breakdownVo.getStatus()));

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(breakdownVo);
        return resultEntity;
    }

    @Override
    public PageResultEntity getBreakdownList(Map<String, String> pageAndCondition) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        List<BreakdownVo> breakdownVoList = breakdownInfoMapper.getBreakdownList(pageAndCondition);
        if (CollectionUtils.isNotEmpty(breakdownVoList)) {
            breakdownVoList.forEach(breakdownVo -> {
                breakdownVo.setStatusName(this.getStatusName(breakdownVo.getStatus()));
            });
        }
        int totalCount = breakdownInfoMapper.getTotal(pageAndCondition);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("查询成功");
        pageResultEntity.setTotal(totalCount);
        pageResultEntity.setRows(breakdownVoList);
        return pageResultEntity;
    }

    private String getStatusName(String statsu) {
        if ("01".equals(statsu)) {
            return "处理中";
        }
        if ("02".equals(statsu)) {
            return "完成";
        }
        return null;
    }
}
