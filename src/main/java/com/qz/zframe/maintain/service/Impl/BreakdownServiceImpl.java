package com.qz.zframe.maintain.service.Impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.maintain.entity.*;
import com.qz.zframe.maintain.mapper.BreakdownAttributeMapper;
import com.qz.zframe.maintain.mapper.BreakdownDealwithModeMapper;
import com.qz.zframe.maintain.mapper.BreakdownInfoMapper;
import com.qz.zframe.maintain.mapper.BreakdownLocationMapper;
import com.qz.zframe.maintain.service.BreakdownService;
import com.qz.zframe.maintain.vo.BreakdownRes;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class BreakdownServiceImpl implements BreakdownService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private BreakdownInfoMapper breakdownInfoMapper;

    @Autowired
    private BreakdownDealwithModeMapper breakdownDealwithModeMapper;

    @Autowired
    private BreakdownLocationMapper breakdownLocationMapper;

    @Autowired
    private BreakdownAttributeMapper breakdownAttributeMapper;

    @Override
    public ResultEntity addBreakdown(BreakdownInfo breakdownInfo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(breakdownInfo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (breakdownInfo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getBreakdownDesc())) {
            resultEntity.setMsg("故障描述不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getBreakdownCode())) {
            resultEntity.setMsg("故障代码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getDealwithMode())) {
            resultEntity.setMsg("处理方式不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getWindId())) {
            resultEntity.setMsg("风电场id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getDealwithTeam())) {
            resultEntity.setMsg("处理班组不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getDealwithPerson())) {
            resultEntity.setMsg("处理人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getPositionId())) {
            resultEntity.setMsg("位置id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getCrewId())) {
            resultEntity.setMsg("机组id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getBreakdownLocation())) {
            resultEntity.setMsg("故障位置不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getBreakdownAttribute())) {
            resultEntity.setMsg("故障属性不能为空");
            return resultEntity;
        }


        BreakdownInfoExample breakdownInfoExample = new BreakdownInfoExample();
        breakdownInfoExample.createCriteria().andBreakdownCodeEqualTo(breakdownInfo.getBreakdownCode());
        List<BreakdownInfo> breakdownInfoList = breakdownInfoMapper.selectByExample(breakdownInfoExample);
        if (breakdownInfoList!=null && breakdownInfoList.size()!=0) {
            resultEntity.setMsg("该故障代码已存在,请重新定义");
            return resultEntity;
        }

        String breakdownId = UUIdUtil.getUUID();
        String serialNumber = String.valueOf(breakdownInfoMapper.countByExample(new BreakdownInfoExample())+1);

        breakdownInfo.setBreakdownId(breakdownId);
        breakdownInfo.setSerialNumber(serialNumber);
        breakdownInfoMapper.insert(breakdownInfo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("添加成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteBreakdown(String breakdownIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(breakdownIds)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }

        String[] ids = breakdownIds.split(",");
        breakdownInfoMapper.batchDelete(ids);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateBreakdown(BreakdownInfo breakdownInfo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(breakdownInfo.getBreakdownId())) {
            resultEntity.setMsg("故障id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getSerialNumber())) {
            resultEntity.setMsg("故障流水号不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (breakdownInfo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getBreakdownDesc())) {
            resultEntity.setMsg("故障描述不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getBreakdownCode())) {
            resultEntity.setMsg("故障代码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getDealwithMode())) {
            resultEntity.setMsg("处理方式不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getWindId())) {
            resultEntity.setMsg("风电场id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getDealwithTeam())) {
            resultEntity.setMsg("处理班组不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getDealwithPerson())) {
            resultEntity.setMsg("处理人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getPositionId())) {
            resultEntity.setMsg("位置id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getCrewId())) {
            resultEntity.setMsg("机组id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getBreakdownLocation())) {
            resultEntity.setMsg("故障位置不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getBreakdownAttribute())) {
            resultEntity.setMsg("故障属性不能为空");
            return resultEntity;
        }

        breakdownInfoMapper.updateByPrimaryKey(breakdownInfo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getBreakdownDetail(String breakdownId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(breakdownId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }

        BreakdownRes breakdownVo = breakdownInfoMapper.getBreakdownDetail(breakdownId);

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
        List<BreakdownRes> breakDownList = breakdownInfoMapper.getBreakdownListByPageAndCondition(pageAndCondition);
        int totalCount = breakdownInfoMapper.getTotal(pageAndCondition);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("查询成功");
        pageResultEntity.setTotal(totalCount);
        pageResultEntity.setRows(breakDownList);
        return pageResultEntity;
    }

    @Override
    public ResultEntity getDealwithModeList() {
        ResultEntity resultEntity = new ResultEntity();
        List<BreakdownDealwithMode> breakdownDealwithModeList = breakdownDealwithModeMapper.selectByExample(new BreakdownDealwithModeExample());

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(breakdownDealwithModeList);
        return resultEntity;
    }

    @Override
    public ResultEntity getBreakdownLocationList() {
        ResultEntity resultEntity = new ResultEntity();
        List<BreakdownLocation> breakdownLocationList = breakdownLocationMapper.selectByExample(new BreakdownLocationExample());

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(breakdownLocationList);
        return resultEntity;
    }

    @Override
    public ResultEntity getBreakdownAttributeList() {
        ResultEntity resultEntity = new ResultEntity();
        List<BreakdownAttribute> breakdownAttributeList = breakdownAttributeMapper.selectByExample(new BreakdownAttributeExample());

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(breakdownAttributeList);
        return resultEntity;
    }
}
