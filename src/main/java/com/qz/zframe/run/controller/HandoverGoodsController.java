package com.qz.zframe.run.controller;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.HandoverGoods;
import com.qz.zframe.run.entity.HandoverGoodsExample;
import com.qz.zframe.run.entity.HandoverGoodsExample.Criteria;
import com.qz.zframe.run.entity.submit.HandoverGoodsSubmit;
import com.qz.zframe.run.entity.submit.HandoverSearchSubmit;
import com.qz.zframe.run.service.HandoverGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>Title: HandoverGoodsController</p>
 * <p>@Description: 交接物品Controller层 </p>
 * @author 
 * @date 2018年11月14日 下午4:04:36
 * @version:V1.0
 */
@RestController
@RequestMapping("/api/support/Goods")
@Api(tags = "api-support-api-support-Goods", description = "运行-运行管理-日志管理-交接物品配置")
public class HandoverGoodsController {

	@Autowired
	private HandoverGoodsService handoverGoodsService;
	
	/**
	 * @Description:新增交接物品
	 * @param: @param handoverGoods
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/saveHandoverGoods",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增交接物品", notes = "新增交接物品")
	public ResultEntity saveHandoverGoods(@RequestBody HandoverGoods handoverGoods ) {		
		return handoverGoodsService.saveHandoverGoods(handoverGoods);

	}
	
	/**
	 * @Description:编辑交接物品
	 * @param: @param handoverGoodsId
	 * @param: @return   
	 * @return: PageResultEntity
	 */
	@RequestMapping(value="/editHandoverGoods" , method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="编辑修改", notes="编辑修改")
	public ResultEntity editHandoverGoods( @RequestBody HandoverGoods handoverGoods){
		return handoverGoodsService.updateHandoverGoods(handoverGoods);
		
	}
	
	
	
	/**
	 * @Description:交接物品配置首页数据
	 * @param: @param searchKey
	 * @param: @param pageNum
	 * @param: @param pageSize
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/listHandoverGoods", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "交接物品列表", notes = "交接物品配置首页数据")
	public NewPageResult<HandoverGoods> listHandoverGoods(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false, defaultValue = "1") @ApiParam(name = "isPage", value = "是否分页，传0不分页", required = false) Integer isPage,
			@RequestParam(required = false) @ApiParam(name = "startWindCode", value = "风电场开始编码", required = false) String startWindCode,
			@RequestParam(required = false) @ApiParam(name = "endWindCode", value = "风电场结束编码", required = false) String endWindCode,
			@RequestParam(required = false) @ApiParam(name = "searchKey", value = "搜索关键字", required = false) String searchKey) {
		HandoverGoodsExample example = new HandoverGoodsExample();
		example.setIsPage(isPage);
		example.setPageNo(pageNum);
		example.setPageSize(pageSize);
		example.setOrderByClause(" a.serial_num asc");
		Criteria criteria = example.createCriteria();
		if (!StringUtils.isBlank(startWindCode)) {
			if (!StringUtils.isBlank(startWindCode)) {
				if (!StringUtils.isBlank(endWindCode)) {
					criteria.andWindCodeBetween(startWindCode, endWindCode);
				} else {
					criteria.andWindCodeEqualTo(startWindCode);
				}
			}
		}
		criteria.andWindTypeEqualTo("02");
		if (!StringUtils.isBlank(searchKey)) {
			criteria.andWindNameLike(searchKey);
            example.or().andLogTypeLike(searchKey);
            example.or().andRemarkLike(searchKey);
            example.or().andMaintainTimeLikeTo(searchKey);
            example.or().andUserNameLike(searchKey);
		}
		return handoverGoodsService.listHandoverGoods(example);
	}
	
	@RequestMapping(value="/detailHandoverGoods",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "物品交接详情", notes = "交接物品配置首页数据")
	public NewPageResult<HandoverGoods>detailHandoverGoods(@RequestParam(required = true)@ApiParam(name = "handoverGoodsId", value = "物品交接表Id", required = false) String handoverGoodsId){
		return handoverGoodsService.detailHandoverGoods(handoverGoodsId);
	}
	
	/**
	 * @Description:删除
	 * @param: @param handoverGoodsIds
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/delHandoverGoods", method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="批量删除 ", notes="批量删除 ")
	public ResultEntity delHandoverGoods(@RequestBody List<String> handoverGoodsIds){		
		return handoverGoodsService.delHandoverGoods(handoverGoodsIds);	
	}
	
	
	
//	@RequestMapping(value="/toExcel",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ApiOperation(value = "导出EXCEL", notes = "导出EXCEL")
//	public void toExcel(@RequestParam(required = false) @ApiParam(name="searchKey",value="关键字查询") String searchKey,
//			@RequestParam(required = false)@ApiParam(name="windNames",value="风电场集合")  List<String> windNames, //风场名称选择查询
//			HttpServletResponse response) {
//		
//		//交接物品配置模糊查询数据封装对象
//		HandoverSearchSubmit handoverSearchSubmit = new HandoverSearchSubmit();
//		
//		//如果关键字搜索不为空
//		if(StringUtils.isNotBlank(searchKey)){
//			//使用的是电厂名称模糊查询
//			handoverSearchSubmit.setSearchKey("%"+searchKey+"%");
//		}
//		
//		//如果风场名称选择了
//		if(CollectionUtils.isNotEmpty(windNames)){
//			//使用风电场名称查询
//			handoverSearchSubmit.setWindNames(windNames);
//		}else{
//			handoverSearchSubmit.setWindNames(null);
//		}
//		
//		//调用接口 实现查询
//	//	PageResultEntity pageResultEntity = handoverGoodsRelationService.listHandoverGoodsRelation(handoverSearchSubmit, 0, 0);
//		
//		List<HandoverResult> list = pageResultEntity.getRows();
//		
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		//修改维护时间
//		for (HandoverResult handoverResult : list) {
//			Date maintainTime = handoverResult.getMaintainTime();
//			String maintainTimeStr = format.format(maintainTime);
//			handoverResult.setMaintainTimeStr(maintainTimeStr);
//		}
//		 
//		
//		LinkedHashMap<String, String> testMap = new LinkedHashMap<String, String>();
//		testMap.put("windName", "风电场名称");
//		testMap.put("logName", "日志名称");
//		testMap.put("count", "物品数量");
//		testMap.put("remark", "备注");
//		testMap.put("status", "状态");
//		testMap.put("maintainUser", "维护人");
//		testMap.put("maintainTimeStr", "维护时间");
//		
//		try {
//			String fileName = ExcelUtil.listToExcel2(list, testMap, "物品交接", 65535, response);
//			System.out.println(fileName);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
	
}
