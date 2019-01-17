package com.qz.zframe.maintain.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.*;
import com.qz.zframe.maintain.entity.*;
import com.qz.zframe.maintain.mapper.DefectWorkorderMapper;
import com.qz.zframe.maintain.mapper.WorkorderInfoMapper;
import com.qz.zframe.maintain.mapper.WorkorderTypeMapper;
import com.qz.zframe.maintain.service.WorkorderTypeService;
import com.qz.zframe.maintain.vo.WorkorderTypeVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class WorkorderTypeServiceimpl implements WorkorderTypeService {

    @Autowired
    private WorkorderTypeMapper workorderTypeMapper;

    @Autowired
    private DefectWorkorderMapper defectWorkorderMapper;

    @Autowired
    private WorkorderInfoMapper workorderInfoMapper;

    @Autowired
    private CurrentUserService currentUserService;

    @Override
    public ResultEntity addWorkorderType(WorkorderTypeVo workorderTypeVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workorderTypeVo.getWorkorderTypeCode())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("工单类型编码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderTypeVo.getWorkorderTypeName())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("工单类型名称不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderTypeVo.getStatus())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("工单类型状态不能为空");
            return resultEntity;
        }

        WorkorderTypeExample workorderTypeExample = new WorkorderTypeExample();
        workorderTypeExample.createCriteria().andWorkorderTypeCodeEqualTo(workorderTypeVo.getWorkorderTypeCode());
        List<WorkorderType> workorderTypeList = workorderTypeMapper.selectByExample(workorderTypeExample);
        if (workorderTypeList!=null && workorderTypeList.size()!=0) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("该工单类型编号已存在,请重新定义");
            return resultEntity;
        }
        //设置id
        workorderTypeVo.setWorkorderTypeId(UUIdUtil.getUUID());
        //添加维护人
        if (!StringUtils.isNoneBlank(workorderTypeVo.getMaintainer())) {
            workorderTypeVo.setMaintainer(currentUserService.getId());
        }
        //添加维护日期
        if (workorderTypeVo.getMaintainDate()==null) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                workorderTypeVo.setMaintainDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            }catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //插入数据库
        workorderTypeMapper.insert(workorderTypeVo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("添加成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateWorkorderType(WorkorderTypeVo workorderTypeVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workorderTypeVo.getWorkorderTypeId())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("工单类型id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderTypeVo.getMaintainer())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("维护人id不能为空");
            return resultEntity;
        }
        if (workorderTypeVo.getMaintainDate()==null) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderTypeVo.getWorkorderTypeCode())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("工单类型编码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderTypeVo.getWorkorderTypeName())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("工单类型名称不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(workorderTypeVo.getStatus())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("工单类型状态不能为空");
            return resultEntity;
        }

        WorkorderTypeExample workorderTypeExample = new WorkorderTypeExample();
        workorderTypeExample.createCriteria().andWorkorderTypeCodeEqualTo(workorderTypeVo.getWorkorderTypeCode()).andWorkorderTypeIdNotEqualTo(workorderTypeVo.getWorkorderTypeId());
        List<WorkorderType> workorderTypeList = workorderTypeMapper.selectByExample(workorderTypeExample);
        if (workorderTypeList!=null && workorderTypeList.size()!=0) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("该工单类型编号已存在,请重新定义");
            return resultEntity;
        }

        //修改工单类型
        WorkorderType workorderType = workorderTypeMapper.selectByPrimaryKey(workorderTypeVo.getWorkorderTypeId());
        BeanUtil.copyProperties(workorderTypeVo,workorderType,true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        workorderTypeMapper.updateByPrimaryKey(workorderType);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteWorkorderType(String[] workorderTypeIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!ArrayUtils.isNotEmpty(workorderTypeIds)) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }
        for (String workorderTypeId:workorderTypeIds) {
            //如果该类型正在被使用,不能删除
            DefectWorkorderExample defectWorkorderExample = new DefectWorkorderExample();
            defectWorkorderExample.createCriteria().andWorkorderTypeIdEqualTo(workorderTypeId).andStatusEqualTo("01");
            List<DefectWorkorder> defectWorkorders = defectWorkorderMapper.selectByExample(defectWorkorderExample);
            if (CollectionUtils.isNotEmpty(defectWorkorders)) {
                resultEntity.setMsg("选中的类型正在被使用,无法删除");
                return resultEntity;
            }
            WorkorderInfoExample workorderInfoExample = new WorkorderInfoExample();
            workorderInfoExample.createCriteria().andWorkorderTypeIdEqualTo(workorderTypeId).andStatusEqualTo("01");
            List<WorkorderInfo> workorderInfos = workorderInfoMapper.selectByExample(workorderInfoExample);
            if (CollectionUtils.isNotEmpty(workorderInfos)) {
                resultEntity.setMsg("选中的类型正在被使用,无法删除");
                return resultEntity;
            }
        }
        workorderTypeMapper.batchDelete(workorderTypeIds);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getWorkorderTypeDetail(String workorderTypeId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(workorderTypeId)) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        WorkorderTypeVo workorderTypeVo = workorderTypeMapper.getWorkorderTypeDetail(workorderTypeId);
        if (workorderTypeVo!=null) {
            workorderTypeVo.setStatusName(this.getStatusName(workorderTypeVo.getStatus()));
        }


        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(workorderTypeVo);
        return resultEntity;
    }

    @Override
    public PageResultEntity getWorkorderTypeList(Map<String,String> pageAndCondition) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        List<WorkorderTypeVo> workorderTypeVoList = workorderTypeMapper.getWorkorderTypeList(pageAndCondition);
        if (CollectionUtils.isNotEmpty(workorderTypeVoList)) {
            workorderTypeVoList.forEach(workorderTypeVo -> {
                workorderTypeVo.setStatusName(this.getStatusName(workorderTypeVo.getStatus()));
            });
        }
        int total = workorderTypeMapper.getTotal(pageAndCondition);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("查询成功");
        pageResultEntity.setRows(workorderTypeVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }

    @Override
    public void exportToExcel(HttpServletResponse response) {
        ResultEntity resultEntity = new ResultEntity();

        List<WorkorderTypeVo> workorderTypeVoList = workorderTypeMapper.getAllWorkorderType();
        if (CollectionUtils.isNotEmpty(workorderTypeVoList)) {
            workorderTypeVoList.forEach(workorderTypeVo -> {
                workorderTypeVo.setStatusName(this.getStatusName(workorderTypeVo.getStatus()));
            });
        }
        int i = 1;
        for (WorkorderTypeVo workorderTypeVo:workorderTypeVoList) {
            workorderTypeVo.setNumber(i++);
        }

        LinkedHashMap<String, String> testMap = new LinkedHashMap<String, String>();
        testMap.put("number", "序号");
        testMap.put("workorderTypeCode", "类型编码");
        testMap.put("workorderTypeName", "类型名称");
        testMap.put("status", "状态");
        testMap.put("remark", "备注");
        testMap.put("maintainerName", "维护人");

        try {
            ExcelUtil.listToExcel2(workorderTypeVoList, testMap, "工单分类", 65535, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getStatusName(String status) {
        if ("01".equals(status)) {
            return "启用";
        }
        if ("02".equals(status)) {
            return "停用";
        }
        return null;
    }

    @Override
    public PageResultEntity getAllWorkorderTypeList() {
        PageResultEntity pageResultEntity = new PageResultEntity();
        List<WorkorderTypeVo> workorderTypeVos = workorderTypeMapper.getAllWorkorderTypeByStatus();
        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setRows(workorderTypeVos);
        return pageResultEntity;
    }
}
