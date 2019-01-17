package com.qz.zframe.run.entity.submit;

import java.util.List;

import com.qz.zframe.run.entity.MainEquipment;
import com.qz.zframe.run.entity.MainEquipmentInfo;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>Title: MainEquipmentSubmit</p>
 * <p>@Description: 电厂主设备配置添加页面提交整合实体类 </p>
 * @author 
 * @date 2018年11月9日 下午1:20:17
 * @version:V1.0
 */
public class MainEquipmentSubmit  extends  MainEquipment{
	
	/*@ApiModelProperty(value="主设备",name="mainEquipment",required = true)
	private MainEquipment mainEquipment;*/
	
	@ApiModelProperty(value="主设备信息",name="equipmentInfos",required = true)
	private List<MainEquipmentInfo> equipmentInfos;

	/*public MainEquipment getMainEquipment() {
		return mainEquipment;
	}

	public void setMainEquipment(MainEquipment mainEquipment) {
		this.mainEquipment = mainEquipment;
	}
*/
	public List<MainEquipmentInfo> getEquipmentInfos() {
		return equipmentInfos;
	}

	public void setEquipmentInfos(List<MainEquipmentInfo> equipmentInfos) {
		this.equipmentInfos = equipmentInfos;
	}
	
	
}
