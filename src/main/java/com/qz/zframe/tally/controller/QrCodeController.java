package com.qz.zframe.tally.controller;
import com.qz.zframe.common.service.OrgArchitectureService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.CrewInformationExample;
import com.qz.zframe.device.service.CrewInformationService;
import com.qz.zframe.tally.entity.QrCode;
import com.qz.zframe.tally.entity.QrCodeExample;
import com.qz.zframe.tally.entity.QrCodeExample.Criteria;
import com.qz.zframe.tally.service.TallyQrCodeService;
import io.swagger.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("api/support/tallyQrCode")
@Api(
        tags = {"api-support-tallyQrCode"},
        description = "巡检-二维码配置"
)
@Transactional(rollbackFor = Exception.class)
public class QrCodeController {

 
    @Autowired
    TallyQrCodeService tallyQrCodeService;

    @Autowired
    CrewInformationService crewInformationService;


    @ApiOperation(value="二维码配置查询", notes="可以根据线路，位置名称查询" ,httpMethod="GET",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping("list2")
    @ResponseBody
    public NewPageResult<QrCode> listQrCode2(@RequestParam(value = "pageNum",defaultValue = "1")int pageNum,@RequestParam(value = "pageSize",defaultValue = "10")  int pageSize,@RequestParam(required = false,defaultValue = "1") Integer isPage,
                                             @RequestParam(required = false)
	                                         @ApiParam(name="positionName",value="位置名称模糊查询",required=false) String positionName,
                                             @RequestParam(required = false)
                                             @ApiParam(name="positionCode",value="位置编码模糊查询",required=false) String positionCode,
                                             @RequestParam(required = false)
                                             @ApiParam(name="qrId",value="主键",required=false) String qrId){
    	QrCodeExample example = new QrCodeExample();
    	example.setIsPage(isPage);
    	example.setPageNo(pageNum);
    	example.setPageSize(pageSize);
    	example.setOrderByClause("b.position_code asc");
    	Criteria criteria = example.createCriteria();
    	if (!StringUtils.isBlank(positionName)) {
    		criteria.andPositionNameLike(positionName);
    	}
    	if (!StringUtils.isBlank(positionCode)) {
    		criteria.andPositionCodeLike(positionCode);
    	}
    	if(!StringUtils.isBlank(qrId)){
    		criteria.andQrIdEqualTo(qrId);
    	}
    	criteria.andArchitectureTypeEqualTO("02");
        return tallyQrCodeService.getlistQrCode(example);

    }

    @ApiOperation(value="二维码配置插入", notes="根据编号可在行与行之前插入插入" ,httpMethod="POST",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping("insert")
    @ResponseBody
    public ResultEntity insertQrCode(@RequestBody QrCode qrCode) throws Exception { 
        return tallyQrCodeService.insertByCodes(qrCode);
    }


    @ApiOperation(value="二维码配置修改", notes="根据code修改二维码配置数据" ,httpMethod="PUT",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping("update")
    @ResponseBody
    public ResultEntity update(@RequestBody QrCode qrCode) {   
        return  tallyQrCodeService.updateQrCodeByCode(qrCode);
    }

    @ApiOperation(value="二维码配置删除", notes="根据code修改二维码配置数据" ,httpMethod="DELETE",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "qrIds", value = "id集合", required = false),
    })
    @RequestMapping("delete")
    @ResponseBody
    public ResultEntity delete(@RequestBody List<String> qrIds) {
        return  tallyQrCodeService.deleteQrCodeByQrId(qrIds);

    }

    @RequestMapping(value = "/ExportExcl", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "导出二维码信息", notes = "导出二维码信息")
    public ResultEntity ExportExcl(
            HttpServletResponse response,
            @RequestParam(required = false )String noteSite,
            @RequestParam(required = false ,defaultValue = "二维码信息表")String sheetName,
            @RequestParam(required = false)
            @ApiParam(name="positionCode",value="位置编码模糊查询",required=false) String positionCode
      ) throws Exception {
        ResultEntity resultEntity=new ResultEntity();
        QrCodeExample example = new QrCodeExample();
        Criteria criteria = example.createCriteria();
        if (!StringUtils.isBlank(positionCode)) {
            criteria.andPositionCodeLike(positionCode);
        }
        resultEntity= tallyQrCodeService.ExportExcl(example,response,positionCode,sheetName,noteSite,resultEntity);
        return  resultEntity;
    }

    @RequestMapping(value = "/ExportExclByIds", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "导出二维码信息", notes = "导出二维码信息")
    public ResultEntity ExportExclByIds(
            HttpServletResponse response,
            HttpServletRequest request,
            @RequestParam(required = false )String noteSite,
            @RequestParam(required = false ,defaultValue = "二维码信息表")String sheetName,
            @RequestParam(required = false)
            @ApiParam(name="positionCode",value="位置编码模糊查询",required=false) String positionCode,
            @RequestParam(required = false ) List<String> qrIds
    ) throws Exception {


        ResultEntity resultEntity=new ResultEntity();
        QrCodeExample example = new QrCodeExample();
        Criteria criteria = example.createCriteria();
        if (!StringUtils.isBlank(positionCode)) {
            criteria.andPositionCodeLike(positionCode);
        }
        if (qrIds!=null&&!(qrIds.isEmpty())) {
            criteria.andQrIdIn(qrIds);
        }
        resultEntity= tallyQrCodeService.ExportExclByIds(example,response,positionCode,sheetName,noteSite,resultEntity,request);
        //String downloadFilePath="C:\\Users\\45476\\Desktop\\DL\\图片";//从我们的上传文件夹中去取
        //File file = new File(downloadFilePath+File.separator+filename);//新建一个文件
        //return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
        return  resultEntity;
    }




    @ApiOperation(value = "导入二维码配置", notes = "导入二维码配置")
    @RequestMapping(value = "importQrCode", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResultEntity importQrCode(@RequestParam("file") MultipartFile file) throws Exception {
        ResultEntity resultEntity=new ResultEntity();
        if (file.isEmpty()) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("文件为空!");
            return resultEntity;
        }
        resultEntity=tallyQrCodeService.importQrCode(file.getOriginalFilename(),file.getInputStream(),resultEntity);
        return resultEntity;
    }

    @RequestMapping(value="/download",method=RequestMethod.GET) //匹配的是href中的download请求
    public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("filename") String filename,
                                           Model model) throws IOException {

        String downloadFilePath="C:\\Users\\45476\\Desktop\\DL\\图片";//从我们的上传文件夹中去取

        File file = new File(downloadFilePath+File.separator+filename);//新建一个文件

        HttpHeaders headers = new HttpHeaders();//http头信息

        String downloadFileName = new String(filename.getBytes("UTF-8"),"iso-8859-1");//设置编码

        headers.setContentDispositionFormData("attachment", downloadFileName);

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        //MediaType:互联网媒介类型  contentType：具体请求中的媒体类型信息

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);

    }



}
