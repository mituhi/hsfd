package com.qz.zframe.device.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.PositionEncodeExample;

public interface UniversalDropBoxService {
	/**
	 *  //设备分类上级设备
	 * @return
	 */
  
 public PageResultEntity  findSuperiorEquipment();
 /**
  *  //位置上级位置
  * @return
  */
  
 public PageResultEntity  findSuperiorPostition();
   //风电厂
 public PageResultEntity  findWind();
    //公司
 public PageResultEntity  findCompany();
   //部门
 public PageResultEntity  findSection();
  //班组
 public PageResultEntity  findTeamGroup();
 /**
  *  //供应商
  * @return
  */
 public PageResultEntity  findSupplier();
 /**
  *  //机组
  * @return
  */
 public PageResultEntity  findCrews();
 //获取当前登陆人新增时的流水号，时间
 public ResultEntity   find();
 /**
  * //设备分类带入数据
  * @param equipmentId
  * @return
  */
public PageResultEntity  findSuperiorEquipmentList(String equipmentId);
/**
 * //位置上级位置带入数据
 * @param positionId
 * @return
 */

public PageResultEntity  findSuperiorPostitionList(String positionId);
/**
 * //所有设备分类
 * @return
 */
public PageResultEntity  findSuperiorEquipmentAll();
/**
 *   //所有位置
 * @return
 */
public PageResultEntity  findSuperiorPostitionAll();
/**
 * //根据风电场来查询位置信息
 * @param windId
 * @return
 */

public PageResultEntity  findWindAndPosition(String windId);


/**
 * //根据风电场和位置查询设备信息
 * @param positionId
 * @return
 */
public PageResultEntity  findWindAndPositionAndEquipment(String positionId);


public PageResultEntity  findSuperiorPostitionAlls(String windId);

//根据层级来查询下拉框数据

public PageResultEntity  findSuperiorPostitionAllByHierarchy(String Hierarchy,String windId);

//根据风电场查询机组信息

public PageResultEntity  findCrewByWind(String windId);

}
