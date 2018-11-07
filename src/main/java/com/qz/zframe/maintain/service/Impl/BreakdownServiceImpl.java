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
import com.qz.zframe.maintain.vo.BreakdownVo;
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
    private BreakdownDealwithModeMapper breakdownDealwithModeMapper;

    @Autowired
    private BreakdownLocationMapper breakdownLocationMapper;

    @Autowired
    private BreakdownAttributeMapper breakdownAttributeMapper;

    @Override
    public PageResultEntity getBreakdownList(Map<String, String> pageAndCondition) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        List<BreakdownVo> breakDownList = breakdownInfoMapper.getBreakdownListByPageAndCondition(pageAndCondition);
        int totalCount = breakdownInfoMapper.getTotalCount(pageAndCondition);

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

    @Override
    public ResultEntity createBreakdown() {
        ResultEntity resultEntity = new ResultEntity();
        BreakdownInfo breakdownInfo = new BreakdownVo();

        try {
            String breakdownId = UUIdUtil.getUUID();
            String serialNumber = "1111";
            String maintainer = currentUserService.getUsername();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dddd");
            Date maintainDate = simpleDateFormat.parse(simpleDateFormat.format(new Date()));

            breakdownInfo.setBreakdownId(breakdownId);
            breakdownInfo.setSerialNumber(serialNumber);
            breakdownInfo.setMaintainer(maintainer);
            breakdownInfo.setMaintainDate(maintainDate);
        }catch (ParseException e) {
            e.printStackTrace();
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("新建成功");
        resultEntity.setData(breakdownInfo);
        return resultEntity;
    }

    @Override
    public ResultEntity addBreakdown(BreakdownInfo breakdownInfo) {
        ResultEntity resultEntity = new ResultEntity();

        if ("1".equals(breakdownInfo.getModeId())||"2".equals(breakdownInfo.getModeId())){
            breakdownInfo.setStatus("2");
        }
        breakdownInfoMapper.insert(breakdownInfo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("添加成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteBreakdown(String breakdownIds) {
        ResultEntity resultEntity = new ResultEntity();

        String[] ids = breakdownIds.split(",");
        breakdownInfoMapper.batchDelete(ids);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateBreakdown(BreakdownInfo breakdownInfo) {
        ResultEntity resultEntity = new ResultEntity();

        breakdownInfoMapper.updateByPrimaryKey(breakdownInfo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity selectBreakdownDetail(String breakdownId) {
        ResultEntity resultEntity = new ResultEntity();

        BreakdownVo breakdownVo = breakdownInfoMapper.getBreakdownDetail(breakdownId);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(breakdownVo);
        return resultEntity;
    }
}
