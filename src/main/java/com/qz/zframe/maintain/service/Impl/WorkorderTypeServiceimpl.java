package com.qz.zframe.maintain.service.Impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.maintain.entity.WorkorderType;
import com.qz.zframe.maintain.entity.WorkorderTypeExample;
import com.qz.zframe.maintain.mapper.WorkorderTypeMapper;
import com.qz.zframe.maintain.service.WorkorderTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class WorkorderTypeServiceimpl implements WorkorderTypeService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private WorkorderTypeMapper workorderTypeMapper;

    @Override
    public ResultEntity addWorkorderType(WorkorderType workorderType) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workorderType.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (workorderType.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderType.getWorkorderTypeCode())) {
            resultEntity.setMsg("工单类型编码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderType.getWorkorderTypeName())) {
            resultEntity.setMsg("工单类型名称不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderType.getStatus())) {
            resultEntity.setMsg("工单类型状态不能为空");
            return resultEntity;
        }

        WorkorderTypeExample workorderTypeExample = new WorkorderTypeExample();
        workorderTypeExample.createCriteria().andWorkorderTypeCodeEqualTo(workorderType.getWorkorderTypeCode());
        List<WorkorderType> workorderTypeList = workorderTypeMapper.selectByExample(workorderTypeExample);
        if (workorderTypeList!=null && workorderTypeList.size()!=0) {
            resultEntity.setMsg("该工单类型编号已存在,请重新定义");
            return resultEntity;
        }

        String workorderTypeId = UUIdUtil.getUUID();
        workorderType.setWorkorderTypeId(workorderTypeId);
        workorderTypeMapper.insert(workorderType);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("添加成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteWorkorderType(String workorderTypeIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workorderTypeIds)) {
            resultEntity.setMsg("工单类型ids不能为空");
            return resultEntity;
        }

        String[] ids = workorderTypeIds.split(",");
        workorderTypeMapper.batchDelete(ids);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateWorkorderType(WorkorderType workorderType) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workorderType.getWorkorderTypeId())) {
            resultEntity.setMsg("工单类型id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderType.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (workorderType.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderType.getWorkorderTypeCode())) {
            resultEntity.setMsg("工单类型编码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderType.getWorkorderTypeName())) {
            resultEntity.setMsg("工单类型名称不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderType.getStatus())) {
            resultEntity.setMsg("工单类型状态不能为空");
            return resultEntity;
        }

        workorderTypeMapper.updateByPrimaryKey(workorderType);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getWorkorderType(String workorderTypeId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workorderTypeId)) {
            resultEntity.setMsg("工单类型id不能为空");
            return resultEntity;
        }

        WorkorderTypeExample workorderTypeExample = new WorkorderTypeExample();
        WorkorderTypeExample.Criteria criteria = workorderTypeExample.createCriteria();
        criteria.andWorkorderTypeIdEqualTo(workorderTypeId);
        criteria.andStatusNotEqualTo("0");
        List<WorkorderType> workorderTypeList = workorderTypeMapper.selectByExample(workorderTypeExample);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        if (workorderTypeList.size()!=0) {
            resultEntity.setData(workorderTypeList.get(0));
        }
        return resultEntity;
    }

    @Override
    public ResultEntity getWorkorderTypeList() {
        ResultEntity resultEntity = new ResultEntity();

        WorkorderTypeExample workorderTypeExample = new WorkorderTypeExample();
        workorderTypeExample.createCriteria().andStatusNotEqualTo("0");
        List<WorkorderType> workorderTypeList = workorderTypeMapper.selectByExample(workorderTypeExample);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(workorderTypeList);
        return resultEntity;
    }
}
