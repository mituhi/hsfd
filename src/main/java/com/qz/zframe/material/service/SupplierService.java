package com.qz.zframe.material.service;
import java.util.List;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.material.entity.Supplier;
import com.qz.zframe.material.entity.SupplierExample;

public interface SupplierService {

	/**
	 * 获取供应商信息列表
	 * 
	 * @param @param example
	 * @param @return    参数
	 * @return PageResultEntity    返回类型
	 * @throws
	 */
	public NewPageResult<Supplier> getSupplierList(SupplierExample example);

	/**
	 * @新增供应商
	 * 
	 * @param @param supplier
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity addSupplier(Supplier supplier);

	/**
	 * 获取供应商详情
	 * 
	 * @param @param supplierId
	 * @param @return    参数
	 * @return PageResultEntity    返回类型
	 * @throws
	 */
	public ResultEntityDetail<Supplier> getSupplierDetail(String supplierId);

	/**
	 * 编辑供应商信息
	 * 
	 * @param @param supplier
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity editSupplier(Supplier supplier);

	/**
	 * 批量删除供应商信息(假删除)
	 * 
	 * @param @param supplierIds
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity delSupplier(List<String> supplierIds);

}
