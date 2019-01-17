package com.qz.zframe.run.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.NewSchedulingAssociated;
import com.qz.zframe.run.entity.NewSchedulingAssociatedExample;
import com.qz.zframe.run.entity.NewSchedulingAssociated.ListView;
import com.qz.zframe.run.entity.NewSchedulingAssociatedExample.Criteria;
import com.qz.zframe.run.service.NewSchedulingAssociatedService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/run/SchedulingAssociated")
@Api(tags = "api-support-api-support-SchedulingAssociated", description = "运行-排班管理")
public class SchedulingAssociatedController {

	@Autowired
	private NewSchedulingAssociatedService newScheduAssService;
	
	@RequestMapping(value = "/listAssociated", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取排班管理列表", notes = "")
    public NewPageResult<NewSchedulingAssociated> getSchedulingAssociatedList(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false,defaultValue = "1")  @ApiParam(name = "isPage", value = "是否分页，传0不分页", required = false)Integer isPage,
			@RequestParam(required = false) @ApiParam(name = "startWindCode", value = "风电场开始编码", required = false) String startWindCode,
			@RequestParam(required = false) @ApiParam(name = "endWindCode", value = "风电场结束编码", required = false) String endWindCode,
			@RequestParam(required = false) @ApiParam(name = "searchKey", value = "搜索关键字", required = false) String searchKey){
		NewSchedulingAssociatedExample example = new NewSchedulingAssociatedExample();
		example.setPageNo(pageNum);
		example.setPageSize(pageSize);
		example.setIsPage(isPage);
		example.setOrderByClause("a.create_time desc,b.sort asc");
		Criteria criteria = example.createCriteria();
		if (!StringUtils.isBlank(startWindCode)) {
			if(!StringUtils.isBlank(startWindCode)){
				if(!StringUtils.isBlank(endWindCode)){
					criteria.andWindCodeBetween(startWindCode, endWindCode);
				}else{
					criteria.andWindCodeEqualTo(startWindCode);
				}
			}
			}
		criteria.andIsDeleteEqualTo("01");
		criteria.andDetailAssociatedIdIsNotNull();
		if(!StringUtils.isBlank(searchKey)){
			criteria.andAssociatedCodeLike(searchKey);
			example.or().andAssociatedNameLike(searchKey);
			example.or().andSchedulingRuleCodeLike(searchKey);
			example.or().andschedulingRuleLike(searchKey);
			example.or().andStartDateLike(searchKey);
			example.or().andEndDateLike(searchKey);
		}
		return newScheduAssService.getSchedulingAssociatedList(example);
	}
	
	@RequestMapping(value = "/detailAssociated", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取排班管理详情", notes = "传入排班管理主键Id")
	@JsonView({ListView.class})
	public NewPageResult<NewSchedulingAssociated> getSchedulingAssociatedDetail(@RequestParam String associatedId){	
		return  newScheduAssService.getSchedulingAssociatedDetail(associatedId);
	}
	
	@RequestMapping(value = "/saveAssociated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增排班管理", notes = "传入排班管理主键Id")
	public ResultEntity saveSchedulingAssociated(@RequestBody NewSchedulingAssociated newSchedulingAssociated){
		return newScheduAssService.saveSchedulingAssociated(newSchedulingAssociated);
	}
	
	@RequestMapping(value = "/editAssociated", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "编辑排班管理", notes = "传入排班管理主键Id")
	public ResultEntity editSchedulingAssociated(@RequestBody NewSchedulingAssociated newSchedulingAssociated){
		return newScheduAssService.editSchedulingAssociated(newSchedulingAssociated);
	}
	
	@RequestMapping(value = "/delAssociatedDetail", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "批量删除排班管理", notes = "传入排班管理主键Id")
	public ResultEntity delAssociatedDetail(@RequestBody List<String> associatedDetailIds){
		return newScheduAssService.delAssociatedDetail(associatedDetailIds);
	}
}
