package com.qz.zframe.tickets.service.impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.tickets.entity.*;
import com.qz.zframe.tickets.mapper.*;
import com.qz.zframe.tickets.service.StandardWorkTicketService;
import com.qz.zframe.tickets.vo.StandardWorkTicketVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class SatndardWorkTicketServiceImpl implements StandardWorkTicketService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private StandardWorkTicketMapper standardWorkTicketMapper;

    @Autowired
    private WorkTicketSafeMeasureMapper workTicketSafeMeasureMapper;

    @Autowired
    private WorkTicketRiskControlMapper workTicketRiskControlMapper;

    @Override
    public ResultEntity addStandardWorkTicket(StandardWorkTicketVo standardWorkTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (standardWorkTicketVo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getTicketTypeId())) {
            resultEntity.setMsg("工作票类型不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getSerialNumber())) {
            resultEntity.setMsg("标准工作票号不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getWindId())) {
            resultEntity.setMsg("风电场id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getCrewId())) {
            resultEntity.setMsg("机组id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getWorkTeam())) {
            resultEntity.setMsg("工作班组不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getDoubleName())) {
            resultEntity.setMsg("工作的风电场、升压站名称及设备双重名称不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getWorkPlace())) {
            resultEntity.setMsg("工作地点或地段不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getWorkContent())) {
            resultEntity.setMsg("工作内容不能为空");
            return resultEntity;
        }
        //添加主数据
        StandardWorkTicket standardWorkTicket = new StandardWorkTicket();
        BeanUtils.copyProperties(standardWorkTicketVo,standardWorkTicket);
        standardWorkTicket.setStandardTicketId(UUIdUtil.getUUID());
        standardWorkTicket.setSerialNumber(String.valueOf(standardWorkTicketMapper.countByExample(new StandardWorkTicketExample())+1));
        standardWorkTicketMapper.insert(standardWorkTicket);
        //添加安措
        List<WorkTicketSafeMeasure> safeMeasureList = standardWorkTicketVo.getSafeMeasureList();
        if (safeMeasureList!=null && safeMeasureList.size()!=0) {
            safeMeasureList.forEach(workTicketSafeMeasure -> {
                workTicketSafeMeasure.setSafeId(UUIdUtil.getUUID());
                workTicketSafeMeasure.setStandardTicketId(standardWorkTicket.getStandardTicketId());
                workTicketSafeMeasureMapper.insert(workTicketSafeMeasure);
            });
        }
        //添加危险因素控制措施
        List<WorkTicketRiskControl> riskControlList = standardWorkTicketVo.getRiskControlList();
        if (riskControlList!=null && riskControlList.size()!=0) {
            riskControlList.forEach(workTicketRiskControl -> {
                workTicketRiskControl.setMeasureId(UUIdUtil.getUUID());
                workTicketRiskControl.setStandardTicketId(standardWorkTicket.getStandardTicketId());
                workTicketRiskControlMapper.insert(workTicketRiskControl);
            });
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("添加成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteStandardWorkTicket(String standardTicketIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(standardTicketIds)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }

        String[] ids = standardTicketIds.split(",");
        standardWorkTicketMapper.batchDelete(ids);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateStandardWorkTicket(StandardWorkTicketVo standardWorkTicketVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getStandardTicketId())) {
            resultEntity.setMsg("标准工作票id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getSerialNumber())) {
            resultEntity.setMsg("标准工作票号");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (standardWorkTicketVo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getTicketTypeId())) {
            resultEntity.setMsg("工作票类型不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getSerialNumber())) {
            resultEntity.setMsg("标准工作票号不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getWindId())) {
            resultEntity.setMsg("风电场id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getCrewId())) {
            resultEntity.setMsg("机组id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getWorkTeam())) {
            resultEntity.setMsg("工作班组不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getDoubleName())) {
            resultEntity.setMsg("工作的风电场、升压站名称及设备双重名称不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getWorkPlace())) {
            resultEntity.setMsg("工作地点或地段不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(standardWorkTicketVo.getWorkContent())) {
            resultEntity.setMsg("工作内容不能为空");
            return resultEntity;
        }
        //修改主数据
        StandardWorkTicket standardWorkTicket = new StandardWorkTicket();
        BeanUtils.copyProperties(standardWorkTicketVo,standardWorkTicket);
        standardWorkTicketMapper.updateByPrimaryKey(standardWorkTicket);
        //修改安措
        WorkTicketSafeMeasureExample workTicketSafeMeasureExample = new WorkTicketSafeMeasureExample();
        workTicketSafeMeasureExample.createCriteria().andStandardTicketIdEqualTo(standardWorkTicketVo.getStandardTicketId());
        workTicketSafeMeasureMapper.deleteByExample(workTicketSafeMeasureExample);
        List<WorkTicketSafeMeasure> safeMeasureList = standardWorkTicketVo.getSafeMeasureList();
        if (safeMeasureList!=null && safeMeasureList.size()!=0) {
            safeMeasureList.forEach(workTicketSafeMeasure -> {
                workTicketSafeMeasure.setSafeId(UUIdUtil.getUUID());
                workTicketSafeMeasure.setStandardTicketId(standardWorkTicketVo.getStandardTicketId());
                workTicketSafeMeasureMapper.insert(workTicketSafeMeasure);
            });
        }
        //添加危险因素控制措施
        WorkTicketRiskControlExample workTicketRiskControlExample = new WorkTicketRiskControlExample();
        workTicketRiskControlExample.createCriteria().andStandardTicketIdEqualTo(standardWorkTicketVo.getStandardTicketId());
        workTicketRiskControlMapper.deleteByExample(workTicketRiskControlExample);
        List<WorkTicketRiskControl> riskControlList = standardWorkTicketVo.getRiskControlList();
        if (riskControlList!=null && riskControlList.size()!=0) {
            riskControlList.forEach(workTicketRiskControl -> {
                workTicketRiskControl.setMeasureId(UUIdUtil.getUUID());
                workTicketRiskControl.setStandardTicketId(standardWorkTicketVo.getStandardTicketId());
                workTicketRiskControlMapper.insert(workTicketRiskControl);
            });
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getStandardWorkTicketDetail(String standardTicketId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(standardTicketId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        StandardWorkTicketVo standardWorkTicketVo = standardWorkTicketMapper.getStandardWorkTicketDetail(standardTicketId);
        if (standardWorkTicketVo!=null) {
            //获取安全措施
            WorkTicketSafeMeasureExample workTicketSafeMeasureExample = new WorkTicketSafeMeasureExample();
            workTicketSafeMeasureExample.setOrderByClause("safe_number");
            workTicketSafeMeasureExample.createCriteria().andTicketTypeIdEqualTo(standardWorkTicketVo.getStandardTicketId());
            List<WorkTicketSafeMeasure> safeMeasureList = workTicketSafeMeasureMapper.selectByExample(workTicketSafeMeasureExample);
            if (safeMeasureList!=null && safeMeasureList.size()!=0) {
                safeMeasureList.forEach(safeMeasure -> {
                    standardWorkTicketVo.getSafeMeasureList().add(safeMeasure);
                });
            }
            //获取危险因素控制措施
            WorkTicketRiskControlExample workTicketRiskControlExample = new WorkTicketRiskControlExample();
            workTicketRiskControlExample.setOrderByClause("measure_number");
            workTicketRiskControlExample.createCriteria().andStandardTicketIdEqualTo(standardWorkTicketVo.getStandardTicketId());
            List<WorkTicketRiskControl> riskControlList = workTicketRiskControlMapper.selectByExample(workTicketRiskControlExample);
            if(riskControlList!=null && riskControlList.size()!=0) {
                riskControlList.forEach(workTicketRiskControl -> {
                    standardWorkTicketVo.getRiskControlList().add(workTicketRiskControl);
                });
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(standardWorkTicketVo);
        return resultEntity;
    }

    @Override
    public PageResultEntity getStandardWorkTicketList(Map<String,String> pageAndCondition) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        List<StandardWorkTicketVo> standardWorkTicketVoList = standardWorkTicketMapper.getStandardWorkTicketList(pageAndCondition);
        int total = standardWorkTicketMapper.getTotal(pageAndCondition);
        standardWorkTicketVoList.forEach(standardWorkTicketVo -> {
            //获取安全措施
            WorkTicketSafeMeasureExample workTicketSafeMeasureExample = new WorkTicketSafeMeasureExample();
            workTicketSafeMeasureExample.setOrderByClause("safe_number");
            workTicketSafeMeasureExample.createCriteria().andTicketTypeIdEqualTo(standardWorkTicketVo.getStandardTicketId());
            List<WorkTicketSafeMeasure> safeMeasureList = workTicketSafeMeasureMapper.selectByExample(workTicketSafeMeasureExample);
            if (safeMeasureList!=null && safeMeasureList.size()!=0) {
                safeMeasureList.forEach(safeMeasure -> {
                    standardWorkTicketVo.getSafeMeasureList().add(safeMeasure);
                });
            }
            //获取危险因素控制措施
            WorkTicketRiskControlExample workTicketRiskControlExample = new WorkTicketRiskControlExample();
            workTicketRiskControlExample.setOrderByClause("measure_number");
            workTicketRiskControlExample.createCriteria().andStandardTicketIdEqualTo(standardWorkTicketVo.getStandardTicketId());
            List<WorkTicketRiskControl> riskControlList = workTicketRiskControlMapper.selectByExample(workTicketRiskControlExample);
            if(riskControlList!=null && riskControlList.size()!=0) {
                riskControlList.forEach(workTicketRiskControl -> {
                    standardWorkTicketVo.getRiskControlList().add(workTicketRiskControl);
                });
            }

        });

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("操作成功");
        pageResultEntity.setRows(standardWorkTicketVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }
}
