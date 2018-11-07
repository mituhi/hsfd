package com.qz.zframe.tickets.service.impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.tickets.entity.*;
import com.qz.zframe.tickets.mapper.WorkTicketTypeMapper;
import com.qz.zframe.tickets.mapper.WorkTicketTypeSafeMeasureMapper;
import com.qz.zframe.tickets.mapper.WorkTicketTypeUserMapper;
import com.qz.zframe.tickets.service.WorkTicketTypeService;
import com.qz.zframe.tickets.vo.WorkTicketTypeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(rollbackFor = Exception.class)
public class WorkTicketTypeServiceImpl implements WorkTicketTypeService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private WorkTicketTypeMapper workTicketTypeMapper;

    @Autowired
    private WorkTicketTypeUserMapper workTicketTypeUserMapper;

    @Autowired
    private WorkTicketTypeSafeMeasureMapper workTicketTypeSafeMeasureMapper;

    @Override
    public ResultEntity getWorkTicketTypeList() {
        ResultEntity resultEntity = new ResultEntity();
        List<WorkTicketTypeVo> workTicketTypeVoList = new ArrayList<>();

        List<WorkTicketType> workTicketTypeList = workTicketTypeMapper.selectByExample(new WorkTicketTypeExample());
        workTicketTypeList.forEach(workTicketType -> {
            WorkTicketTypeVo workTicketTypeVo = new WorkTicketTypeVo();
            BeanUtils.copyProperties(workTicketType,workTicketTypeVo);
            //获取安全措施
            WorkTicketTypeSafeMeasureExample workTicketTypeSafeMeasureExample = new WorkTicketTypeSafeMeasureExample();
            workTicketTypeSafeMeasureExample.createCriteria().andTicketTypeIdEqualTo(workTicketType.getTicketTypeId());
            List<WorkTicketTypeSafeMeasure> safeMeasureList = workTicketTypeSafeMeasureMapper.selectByExample(workTicketTypeSafeMeasureExample);
            if (safeMeasureList!=null) {
                safeMeasureList.forEach(safeMeasure -> {
                    workTicketTypeVo.getSafeMeasureList().add(safeMeasure);
                });
            }
            //获取工作负责人
            WorkTicketTypeUserExample workTicketTypeUserExample = new WorkTicketTypeUserExample();
            WorkTicketTypeUserExample.Criteria workHeadCriteria = workTicketTypeUserExample.createCriteria();
            workHeadCriteria.andTicketTypeIdEqualTo(workTicketType.getTicketTypeId());
            workHeadCriteria.andUserTypeEqualTo("01");
            List<WorkTicketTypeUser> workHeadList = workTicketTypeUserMapper.selectByExample(workTicketTypeUserExample);
            if (workHeadList!=null) {
                workHeadList.forEach(workTicketTypeUser -> {
                    workTicketTypeVo.getWorkHeadList().add(workTicketTypeUser);
                });
            }
            //获取签发人
            WorkTicketTypeUserExample.Criteria signerCriteria = workTicketTypeUserExample.createCriteria();
            signerCriteria.andTicketTypeIdEqualTo(workTicketType.getTicketTypeId());
            signerCriteria.andUserTypeEqualTo("02");
            List<WorkTicketTypeUser> signerList = workTicketTypeUserMapper.selectByExample(workTicketTypeUserExample);
            if (signerList!=null) {
                signerList.forEach(workTicketTypeUser -> {
                    workTicketTypeVo.getSignerList().add(workTicketTypeUser);
                });
            }
            //获取许可人
            WorkTicketTypeUserExample.Criteria licensorCriteria = workTicketTypeUserExample.createCriteria();
            licensorCriteria.andTicketTypeIdEqualTo(workTicketType.getTicketTypeId());
            licensorCriteria.andUserTypeEqualTo("03");
            List<WorkTicketTypeUser> licensorList = workTicketTypeUserMapper.selectByExample(workTicketTypeUserExample);
            if (licensorList!=null) {
                licensorList.forEach(workTicketTypeUser -> {
                    workTicketTypeVo.getLicensorList().add(workTicketTypeUser);
                });
            }
            workTicketTypeVoList.add(workTicketTypeVo);
        });

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(workTicketTypeVoList);
        return resultEntity;
    }

    @Override
    public ResultEntity createWorkTicketType() {
        ResultEntity resultEntity = new ResultEntity();
        WorkTicketType workTicketType = new WorkTicketType();

        try {
            String ticketTypeId = UUIdUtil.getUUID();
            String serialNumber = "1111";
            String maintainer = currentUserService.getUsername();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date maintainDate = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            workTicketType.setTicketTypeId(ticketTypeId);
            workTicketType.setSerialNumber(serialNumber);
            workTicketType.setMaintainer(maintainer);
            workTicketType.setMaintainDate(maintainDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(workTicketType);
        return resultEntity;
    }

    @Override
    public ResultEntity addWorkTicketType(WorkTicketTypeVo workTicketTypeVo) {
        ResultEntity resultEntity = new ResultEntity();

        WorkTicketType workTicketType = new WorkTicketType();
        BeanUtils.copyProperties(workTicketTypeVo,workTicketType);
        workTicketTypeMapper.insert(workTicketType);
        //添加安全措施
        List<WorkTicketTypeSafeMeasure> safeMeasureList = workTicketTypeVo.getSafeMeasureList();
        if (safeMeasureList!=null) {
            safeMeasureList.forEach(workTicketTypeSafeMeasure -> {
                workTicketTypeSafeMeasure.setMeasureId(UUID.randomUUID().toString().replace("-",""));
                workTicketTypeSafeMeasure.setTicketTypeId(workTicketTypeVo.getTicketTypeId());
                workTicketTypeSafeMeasureMapper.insert(workTicketTypeSafeMeasure);
            });
        }else {
            resultEntity.setMsg("安全措施不能为空");
            return resultEntity;
        }
        //添加工作负责人
        List<WorkTicketTypeUser> workHeadList = workTicketTypeVo.getWorkHeadList();
        if (workHeadList!=null) {
            workHeadList.forEach(workTicketTypeUser -> {
                workTicketTypeUser.setId(UUID.randomUUID().toString().replace("-",""));
                workTicketTypeUser.setTicketTypeId(workTicketTypeVo.getTicketTypeId());
                workTicketTypeUser.setUserType("01");
                workTicketTypeUserMapper.insert(workTicketTypeUser);
            });
        }
        //添加签发人
        List<WorkTicketTypeUser> signerList = workTicketTypeVo.getSignerList();
        if (signerList!=null) {
            signerList.forEach(workTicketTypeUser -> {
                workTicketTypeUser.setId(UUID.randomUUID().toString().replace("-",""));
                workTicketTypeUser.setTicketTypeId(workTicketTypeVo.getTicketTypeId());
                workTicketTypeUser.setUserType("02");
                workTicketTypeUserMapper.insert(workTicketTypeUser);
            });
        }
        //添加许可人
        List<WorkTicketTypeUser> licensorList = workTicketTypeVo.getLicensorList();
        if (licensorList!=null) {
            licensorList.forEach(workTicketTypeUser -> {
                workTicketTypeUser.setId(UUID.randomUUID().toString().replace("-",""));
                workTicketTypeUser.setTicketTypeId(workTicketTypeVo.getTicketTypeId());
                workTicketTypeUser.setUserType("03");
                workTicketTypeUserMapper.insert(workTicketTypeUser);
            });
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteWorkTicketType(String ticketTypeIds) {
        ResultEntity resultEntity = new ResultEntity();

        String[] ids = ticketTypeIds.split(",");

        workTicketTypeMapper.batchDelete(ids);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateWorkTicketType(WorkTicketTypeVo workTicketTypeVo) {
        ResultEntity resultEntity = new ResultEntity();

        WorkTicketType workTicketType = new WorkTicketType();
        BeanUtils.copyProperties(workTicketTypeVo,workTicketType);
        workTicketTypeMapper.updateByPrimaryKey(workTicketType);
        //删除工作类型关联的安全措施,负责人,签收人,许可人,等待重新插入
        WorkTicketTypeUserExample workTicketTypeUserExample = new WorkTicketTypeUserExample();
        workTicketTypeUserExample.createCriteria().andTicketTypeIdEqualTo(workTicketTypeVo.getTicketTypeId());
        workTicketTypeUserMapper.deleteByExample(workTicketTypeUserExample);
        //添加安全措施
        List<WorkTicketTypeSafeMeasure> safeMeasureList = workTicketTypeVo.getSafeMeasureList();
        if (safeMeasureList!=null) {
            safeMeasureList.forEach(workTicketTypeSafeMeasure -> {
                workTicketTypeSafeMeasure.setMeasureId(UUID.randomUUID().toString().replace("-",""));
                workTicketTypeSafeMeasure.setTicketTypeId(workTicketTypeVo.getTicketTypeId());
                workTicketTypeSafeMeasureMapper.insert(workTicketTypeSafeMeasure);
            });
        }else {
            resultEntity.setMsg("安全措施不能为空");
            return resultEntity;
        }
        //添加工作负责人
        List<WorkTicketTypeUser> workHeadList = workTicketTypeVo.getWorkHeadList();
        if (workHeadList!=null) {
            workHeadList.forEach(workTicketTypeUser -> {
                workTicketTypeUser.setId(UUID.randomUUID().toString().replace("-",""));
                workTicketTypeUser.setTicketTypeId(workTicketTypeVo.getTicketTypeId());
                workTicketTypeUser.setUserType("01");
                workTicketTypeUserMapper.insert(workTicketTypeUser);
            });
        }
        //添加签收人
        List<WorkTicketTypeUser> signerList = workTicketTypeVo.getSignerList();
        if (signerList!=null) {
            signerList.forEach(workTicketTypeUser -> {
                workTicketTypeUser.setId(UUID.randomUUID().toString().replace("-",""));
                workTicketTypeUser.setTicketTypeId(workTicketTypeVo.getTicketTypeId());
                workTicketTypeUser.setUserType("02");
                workTicketTypeUserMapper.insert(workTicketTypeUser);
            });
        }
        //添加许可人
        List<WorkTicketTypeUser> licensorList = workTicketTypeVo.getLicensorList();
        if (licensorList!=null) {
            licensorList.forEach(workTicketTypeUser -> {
                workTicketTypeUser.setId(UUID.randomUUID().toString().replace("-",""));
                workTicketTypeUser.setTicketTypeId(workTicketTypeVo.getTicketTypeId());
                workTicketTypeUser.setUserType("03");
                workTicketTypeUserMapper.insert(workTicketTypeUser);
            });
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getWorkTicketTypeDetail(String ticketTypeId) {
        ResultEntity resultEntity = new ResultEntity();

        WorkTicketType workTicketType = workTicketTypeMapper.selectByPrimaryKey(ticketTypeId);
        if (workTicketType==null) {
            resultEntity.setMsg("该工作票类型不存在");
            return resultEntity;
        }

        WorkTicketTypeVo workTicketTypeVo = new WorkTicketTypeVo() ;
        BeanUtils.copyProperties(workTicketType,workTicketTypeVo);
        //获取安全措施
        WorkTicketTypeSafeMeasureExample workTicketTypeSafeMeasureExample = new WorkTicketTypeSafeMeasureExample();
        workTicketTypeSafeMeasureExample.createCriteria().andTicketTypeIdEqualTo(workTicketType.getTicketTypeId());
        List<WorkTicketTypeSafeMeasure> safeMeasureList = workTicketTypeSafeMeasureMapper.selectByExample(workTicketTypeSafeMeasureExample);
        if (safeMeasureList!=null) {
            safeMeasureList.forEach(safeMeasure -> {
                workTicketTypeVo.getSafeMeasureList().add(safeMeasure);
            });
        }
        //获取工作负责人
        WorkTicketTypeUserExample workTicketTypeUserExample = new WorkTicketTypeUserExample();
        WorkTicketTypeUserExample.Criteria workHeadCriteria = workTicketTypeUserExample.createCriteria();
        workHeadCriteria.andTicketTypeIdEqualTo(workTicketType.getTicketTypeId());
        workHeadCriteria.andUserTypeEqualTo("01");
        List<WorkTicketTypeUser> workHeadList = workTicketTypeUserMapper.selectByExample(workTicketTypeUserExample);
        if (workHeadList!=null) {
            workHeadList.forEach(workTicketTypeUser -> {
                workTicketTypeVo.getWorkHeadList().add(workTicketTypeUser);
            });
        }
        //获取签收人
        WorkTicketTypeUserExample.Criteria signerCriteria = workTicketTypeUserExample.createCriteria();
        signerCriteria.andTicketTypeIdEqualTo(workTicketType.getTicketTypeId());
        signerCriteria.andUserTypeEqualTo("02");
        List<WorkTicketTypeUser> signerList = workTicketTypeUserMapper.selectByExample(workTicketTypeUserExample);
        if (signerList!=null) {
            signerList.forEach(workTicketTypeUser -> {
                workTicketTypeVo.getSignerList().add(workTicketTypeUser);
            });
        }
        //获取许可人
        WorkTicketTypeUserExample.Criteria licensorCriteria = workTicketTypeUserExample.createCriteria();
        licensorCriteria.andTicketTypeIdEqualTo(workTicketType.getTicketTypeId());
        licensorCriteria.andUserTypeEqualTo("03");
        List<WorkTicketTypeUser> licensorList = workTicketTypeUserMapper.selectByExample(workTicketTypeUserExample);
        if (licensorList!=null) {
            licensorList.forEach(workTicketTypeUser -> {
                workTicketTypeVo.getLicensorList().add(workTicketTypeUser);
            });
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("操作成功");
        resultEntity.setData(workTicketTypeVo);
        return resultEntity;
    }
}
