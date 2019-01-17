package com.qz.zframe.common.service.impl;

import com.qz.zframe.common.dao.ApproveRecordMapper;
import com.qz.zframe.common.entity.ApproveRecord;
import com.qz.zframe.common.service.ApproveRecordService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ApproveRecordServiceImpl implements ApproveRecordService {

    @Autowired
    private ApproveRecordMapper approveRecordMapper;

    public ResultEntity addApproveRecord(ApproveRecord approveRecord) {
        ResultEntity resultEntity = new ResultEntity();

        if (StringUtils.isBlank(approveRecord.getProcessDetailId())) {
            resultEntity.setMsg("流程详情id不能为空");
            return resultEntity;
        }
        if (StringUtils.isBlank(approveRecord.getApproveResult())) {
            resultEntity.setMsg("审批结果不能为空");
            return resultEntity;
        }
        if (StringUtils.isBlank(approveRecord.getApproveUser())) {
            resultEntity.setMsg("审批人不能为空");
            return resultEntity;
        }
        if (approveRecord.getApproveTime()==null) {
            resultEntity.setMsg("审批时间不能为空");
            return resultEntity;
        }

        //设置审批记录id
        approveRecord.setApproveId(UUIdUtil.getUUID());
        approveRecordMapper.insertSelective(approveRecord);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("新增成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getApproveRecordListByOrderId(String orderId) {
        ResultEntity resultEntity = new ResultEntity();

        List<ApproveRecord> approveRecords = approveRecordMapper.getApproveRecordListByOrderId(orderId);

        resultEntity.setMsg("查询成功");
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setData(approveRecords);
        return resultEntity;
    }
}
