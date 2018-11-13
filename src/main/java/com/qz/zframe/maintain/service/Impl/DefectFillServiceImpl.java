package com.qz.zframe.maintain.service.Impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.maintain.entity.BreakdownInfo;
import com.qz.zframe.maintain.entity.BreakdownInfoExample;
import com.qz.zframe.maintain.entity.DefectWorkorder;
import com.qz.zframe.maintain.entity.DefectWorkorderExample;
import com.qz.zframe.maintain.mapper.BreakdownInfoMapper;
import com.qz.zframe.maintain.mapper.DefectWorkorderMapper;
import com.qz.zframe.maintain.service.DefectFillService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class DefectFillServiceImpl implements DefectFillService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private BreakdownInfoMapper breakdownInfoMapper;

    @Autowired
    private DefectWorkorderMapper defectWorkorderMapper;

    @Override
    public ResultEntity saveBreakdown(BreakdownInfo breakdownInfo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(breakdownInfo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (breakdownInfo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getWorkorderDesc())) {
            resultEntity.setMsg("工单描述不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getWorkorderType())) {
            resultEntity.setMsg("工单类型不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getWindId())) {
            resultEntity.setMsg("风电场id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getCompany())) {
            resultEntity.setMsg("公司不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getDealwithTeam())) {
            resultEntity.setMsg("负责班组不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getDealwithPerson())) {
            resultEntity.setMsg("负责人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getFillPerson())) {
            resultEntity.setMsg("填报人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getPositionId())) {
            resultEntity.setMsg("位置id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(breakdownInfo.getBreakdownDesc())) {
            resultEntity.setMsg("故障描述不能为空");
            return resultEntity;
        }
        if (breakdownInfo.getActiveTime()==null) {
            resultEntity.setMsg("故障激活时间不能为空");
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
        if (!StringUtils.isNoneBlank(breakdownInfo.getPhenomenon())) {
            resultEntity.setMsg("故障现象不能为空");
            return resultEntity;
        }
        BreakdownInfoExample breakdownInfoExample = new BreakdownInfoExample();
        breakdownInfoExample.createCriteria().andBreakdownCodeEqualTo(breakdownInfo.getBreakdownCode());
        List<BreakdownInfo> breakdownInfoList = breakdownInfoMapper.selectByExample(breakdownInfoExample);
        if (breakdownInfoList!=null && breakdownInfoList.size()!=0) {
            resultEntity.setMsg("该故障代码已存在,请重新定义");
            return resultEntity;
        }

        if (!StringUtils.isNoneBlank(breakdownInfo.getBreakdownId())) {
            DefectWorkorder defectWorkorder = new DefectWorkorder();

            breakdownInfo.setBreakdownId(UUIdUtil.getUUID());
            breakdownInfo.setSerialNumber(String.valueOf(breakdownInfoMapper.countByExample(new BreakdownInfoExample())+1));
            //生成工单号
            String workorderNumber = String.valueOf(breakdownInfoMapper.countByExample(new BreakdownInfoExample())+1);
            breakdownInfo.setWorkorderNumber(workorderNumber);

            defectWorkorder.setWorkorderId(UUIdUtil.getUUID());
            defectWorkorder.setSerialNumber(workorderNumber);
            defectWorkorder.setStatus("缺陷填报");
            defectWorkorder.setWorkorderDesc(breakdownInfo.getWorkorderDesc());
            defectWorkorder.setWorkorderTypeId(breakdownInfo.getWorkorderType());
            defectWorkorder.setWindId(breakdownInfo.getWindId());
            defectWorkorder.setCompany(breakdownInfo.getCompany());
            defectWorkorder.setDutyHead(breakdownInfo.getDealwithPerson());
            defectWorkorder.setFillPerson(breakdownInfo.getFillPerson());
            defectWorkorder.setDutyTeam(breakdownInfo.getDealwithTeam());
            defectWorkorder.setPositionId(breakdownInfo.getPositionId());
            defectWorkorder.setPositionDesc(breakdownInfo.getPositionDesc());
            if (StringUtils.isNoneBlank(breakdownInfo.getCrewId())) {
                defectWorkorder.setCrewId(breakdownInfo.getCrewId());
            }
            if (StringUtils.isNoneBlank(breakdownInfo.getEquipmentId())) {
                defectWorkorder.setEquipmentId(breakdownInfo.getBreakdownId());
                defectWorkorder.setEquipmentDesc(breakdownInfo.getEquipmentDesc());
            }
            defectWorkorder.setBreakdownDesc(breakdownInfo.getBreakdownDesc());
            defectWorkorder.setBreakdownCode(breakdownInfo.getBreakdownCode());
            if (breakdownInfo.getActiveTime()!=null) {
                defectWorkorder.setActiveTime(breakdownInfo.getActiveTime());
            }
            if (StringUtils.isNoneBlank(breakdownInfo.getDowntimeWindspeed())) {
                defectWorkorder.setDowntimeWindspeed(breakdownInfo.getDowntimeWindspeed());
            }
            defectWorkorder.setBreakdownLocation(breakdownInfo.getBreakdownLocation());
            defectWorkorder.setBreakdownAttribute(breakdownInfo.getBreakdownAttribute());
            defectWorkorder.setPhenomenon(breakdownInfo.getPhenomenon());

            breakdownInfoMapper.insert(breakdownInfo);
            defectWorkorderMapper.insert(defectWorkorder);
        }else {
            if (!StringUtils.isNoneBlank(breakdownInfo.getSerialNumber())) {
                resultEntity.setMsg("故障流水号不能为空");
                return resultEntity;
            }
            if (!StringUtils.isNoneBlank(breakdownInfo.getWorkorderNumber())) {
                resultEntity.setMsg("工单号不能为空");
                return resultEntity;
            }
            DefectWorkorderExample defectWorkorderExample = new DefectWorkorderExample();
            DefectWorkorderExample.Criteria criteria = defectWorkorderExample.createCriteria();
            criteria.andSerialNumberEqualTo(breakdownInfo.getWorkorderNumber());
            criteria.andStatusEqualTo("缺陷填报");
            List<DefectWorkorder> defectWorkorderList = defectWorkorderMapper.selectByExample(defectWorkorderExample);
            if (defectWorkorderList !=null && defectWorkorderList.size()!=0) {
                DefectWorkorder defectWorkorder = defectWorkorderList.get(0);
                defectWorkorder.setWorkorderDesc(breakdownInfo.getWorkorderDesc());
                defectWorkorder.setWorkorderTypeId(breakdownInfo.getWorkorderType());
                defectWorkorder.setWindId(breakdownInfo.getWindId());
                defectWorkorder.setCompany(breakdownInfo.getCompany());
                defectWorkorder.setDutyHead(breakdownInfo.getDealwithPerson());
                defectWorkorder.setFillPerson(breakdownInfo.getFillPerson());
                defectWorkorder.setDutyTeam(breakdownInfo.getDealwithTeam());
                defectWorkorder.setPositionId(breakdownInfo.getPositionId());
                defectWorkorder.setPositionDesc(breakdownInfo.getPositionDesc());
                if (StringUtils.isNoneBlank(breakdownInfo.getCrewId())) {
                    defectWorkorder.setCrewId(breakdownInfo.getCrewId());
                }
                if (StringUtils.isNoneBlank(breakdownInfo.getEquipmentId())) {
                    defectWorkorder.setEquipmentId(breakdownInfo.getBreakdownId());
                    defectWorkorder.setEquipmentDesc(breakdownInfo.getEquipmentDesc());
                }
                defectWorkorder.setBreakdownDesc(breakdownInfo.getBreakdownDesc());
                defectWorkorder.setBreakdownCode(breakdownInfo.getBreakdownCode());
                if (breakdownInfo.getActiveTime()!=null) {
                    defectWorkorder.setActiveTime(breakdownInfo.getActiveTime());
                }
                if (StringUtils.isNoneBlank(breakdownInfo.getDowntimeWindspeed())) {
                    defectWorkorder.setDowntimeWindspeed(breakdownInfo.getDowntimeWindspeed());
                }
                defectWorkorder.setBreakdownLocation(breakdownInfo.getBreakdownLocation());
                defectWorkorder.setBreakdownAttribute(breakdownInfo.getBreakdownAttribute());
                defectWorkorder.setPhenomenon(breakdownInfo.getPhenomenon());
                defectWorkorderMapper.updateByPrimaryKey(defectWorkorder);
            }
            breakdownInfoMapper.updateByPrimaryKey(breakdownInfo);
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("保存成功");
        return resultEntity;
    }

    @Override
    public ResultEntity submitBreakdown(BreakdownInfo breakdownInfo) {
        ResultEntity resultEntity = this.saveBreakdown(breakdownInfo);

        DefectWorkorderExample defectWorkorderExample = new DefectWorkorderExample();
        DefectWorkorderExample.Criteria criteria = defectWorkorderExample.createCriteria();
        criteria.andSerialNumberEqualTo(breakdownInfo.getWorkorderNumber());
        criteria.andStatusEqualTo("缺陷填报");
        List<DefectWorkorder> defectWorkorderList = defectWorkorderMapper.selectByExample(defectWorkorderExample);
        if (defectWorkorderList !=null && defectWorkorderList.size()!=0) {
            resultEntity.setData(defectWorkorderList.get(0));
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("提交成功");
        return resultEntity;
    }

    /*public String getPaths(MultipartFile[] files) {
        StringBuffer stringBuffer = new StringBuffer();
        String path = "/src/main/resources/images/";
        if(files!=null && files.length>0){
            for(int i = 0;i<files.length;i++){
                MultipartFile file = files[i];
                String fileName = file.getOriginalFilename();
                //保存文件
                if (!file.isEmpty()) {
                    try {
                        File filepath = new File(path);
                        if (!filepath.exists())
                            filepath.mkdirs();
                        // 转存文件
                        String savePath = path+UUIdUtil.getUUID()+fileName.substring(fileName.lastIndexOf("."));
                        stringBuffer.append(savePath).append(",");
                        file.transferTo(new File(savePath));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
            return stringBuffer.toString();
    }*/
}
