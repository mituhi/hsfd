package com.qz.zframe.material.service;

import java.util.List;

import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.material.entity.Material;
import com.qz.zframe.material.entity.MaterialExample;

public interface MaterialService {

    //获取物资信息
	public List<Material> listMaterial(MaterialExample materialExample);

    /**
     * 新增物资
     * 
     * @param material
     * @return
     */
    public ResultEntity saveMaterial(Material material) throws Exception;

	/**
	 * 获取物资列表
	 * 
	 * @param materialExample
	 * @return
	 */
	public NewPageResult<Material> getMaterialList(MaterialExample materialExample);

	/**
	 * 编辑物资信息
	 * 
	 * @param @param material
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity updateMaterial(Material material);

	public ResultEntity delMaterial(List<String> materialIds);

	public ResultEntity detailMaterial(String materialId);

	/**
	 * 获取最大单号
	 * 
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	public String getMaxMaterialCode();


}
