package com.qz.zframe.material.controller;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.authentication.domain.UserInfo;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.material.entity.DamagedParts;
import com.qz.zframe.material.entity.DamagedPartsExample;
import com.qz.zframe.material.entity.DamagedPartsExample.Criteria;
import com.qz.zframe.material.service.DamagedPartsService;
import com.qz.zframe.material.service.InInventoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/api/support/damagedParts")
@Api(tags = "api-support-damagedParts", description = "物资管理-损坏件入库管理")
public class DamagedPartsController {
	
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 

	@Autowired
	private DamagedPartsService damagedPartsService;
	
	@Autowired
	private CurrentUserService currentUSerservice;

	@RequestMapping(value = "/listDamagedParts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "损坏件入库单列表", notes = "")
	public PageResultEntity getDamagedPartsList(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) @ApiParam(name = "damagedPartsDescribe", value = "损坏件入库描述", required = false) String damagedPartsDescribe,
			@RequestParam(required = false) @ApiParam(name = "stockAddId", value = "库存地点id", required = false) String stockAddId,
			@RequestParam(required = false) @ApiParam(name = "createDate", value = "创建日期", required = false) String createDate) throws ParseException{
		DamagedPartsExample example = new DamagedPartsExample();
		example.setPageNo(pageNum);
		example.setPageSize(pageSize);
		example.setOrderByClause("a.create_time desc");
		Criteria criteria = example.createCriteria();
		if (!StringUtils.isBlank(damagedPartsDescribe)) {
			criteria.andDamagedPartsDescribeLike(damagedPartsDescribe);
		}
		if (!StringUtils.isBlank(stockAddId)) {
			criteria.andStockAddIdEqualTo(stockAddId);
		}	
		if (!StringUtils.isBlank(createDate)) {
			criteria.andCreateTimeLikeTo(createDate);
		}
		return damagedPartsService.getDamagedPartsList(example);	
	}

	@RequestMapping(value = "/detailDamagedParts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "损坏件入库单详情", notes = "")
	public ResultEntity getDamagedPartsDetails(@RequestParam String damagedPartsId){		
		return damagedPartsService.getDamagedPartsDetails(damagedPartsId);
	}

	@RequestMapping(value = "/saveDamagedParts", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增损坏件入库单", notes = "")
	public ResultEntity addDamagedParts(@RequestBody DamagedParts damagedParts) throws ParseException{
		ResultEntity resultEntity = new ResultEntity();
		if(damagedParts.getDamagedPartsDetails().size() ==0||damagedParts.getDamagedPartsDetails().isEmpty()){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少物资明细");
			return resultEntity;
		}
		UserInfo userInfo = currentUSerservice.getUserInfo();
		damagedParts.setCreater(userInfo.getUserId());
	    return damagedPartsService.addDamagedParts(damagedParts);	
	}
	

	@RequestMapping(value = "/editDamagedParts", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "编辑损坏件入库单信息", notes = "")
	public ResultEntity editDamagedParts(@RequestBody DamagedParts damagedParts) throws ParseException{
	    return damagedPartsService.editDamagedParts(damagedParts);	
	}
	
	@RequestMapping(value = "/delDamagedParts", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "删除损坏件入库单信息", notes = "")
	public ResultEntity delDamagedParts(@RequestBody List<String> damagedPartsIds) throws ParseException{ 	
		return damagedPartsService.delDamagedParts(damagedPartsIds);	
	}
	
}
