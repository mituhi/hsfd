package com.qz.zframe.maintain.service.Impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.maintain.entity.WorkorderType;
import com.qz.zframe.maintain.entity.WorkorderTypeExample;
import com.qz.zframe.maintain.mapper.WorkorderTypeMapper;
import com.qz.zframe.maintain.service.WorkorderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class WorkorderTypeServiceimpl implements WorkorderTypeService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private WorkorderTypeMapper workorderTypeMapper;

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

    @Override
    public ResultEntity createWorkorderType() {
        ResultEntity resultEntity = new ResultEntity();
        WorkorderType workorderType = new WorkorderType();

        try {
            String workorderTypeId = UUIdUtil.getUUID();
            String maintainer = currentUserService.getUsername();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dddd");
            Date maintainDate = simpleDateFormat.parse(simpleDateFormat.format(new Date()));

            workorderType.setWorkorderTypeId(workorderTypeId);
            workorderType.setMaintainer(maintainer);
            workorderType.setMaintainDate(maintainDate);
        }catch (ParseException e) {
            e.printStackTrace();
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("新建成功");
        resultEntity.setData(workorderType);
        return resultEntity;
    }

    @Override
    public ResultEntity addWorkorderType(WorkorderType workorderType) {
        ResultEntity resultEntity = new ResultEntity();

        workorderTypeMapper.insert(workorderType);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("添加成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteWorkorderType(String workorderTypeIds) {
        ResultEntity resultEntity = new ResultEntity();

        String[] ids = workorderTypeIds.split(",");
        workorderTypeMapper.batchDelete(ids);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateWorkorderType(WorkorderType workorderType) {
        ResultEntity resultEntity = new ResultEntity();

        workorderTypeMapper.updateByPrimaryKey(workorderType);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity selectWorkorderType(String workorderTypeId) {
        ResultEntity resultEntity = new ResultEntity();

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
}
