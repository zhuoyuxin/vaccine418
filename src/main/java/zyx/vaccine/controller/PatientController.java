package zyx.vaccine.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zyx.vaccine.common.Result;
import zyx.vaccine.common.ResultCode;
import zyx.vaccine.entity.PatientInformation;
import zyx.vaccine.entity.User;
import zyx.vaccine.entity.VaccineInformation;
import zyx.vaccine.service.PatientInformationService;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private static final Log LOG = Log.get();

    @Autowired
    PatientInformationService patientInformationService;

    //增加接种人信息
    @ApiImplicitParam(name = "addPatient", value = "增加接种人信息", required = true, dataType = "PatientInformation")
    @PostMapping("/add")
    public Result addPatient(@RequestBody PatientInformation patientDTO)
    {
        Boolean res;
        //是否正确传入参数
        if (patientDTO==null) {
            return Result.error(ResultCode.VALIDATE_FAILED.getCode(), "参数错误");
        }
        QueryWrapper<PatientInformation> queryWrapper =new QueryWrapper<>();
        //是否存在重复添加
        if(patientDTO.getIdCard()!=null )
        {
            queryWrapper.eq("id_card",patientDTO.getIdCard());
        }
        PatientInformation patientInformation=patientInformationService.getOne(queryWrapper);
        if(patientInformation!=null)
        {
            res=true;
        }
        else
        {
            res = patientInformationService.savePatient(patientDTO);
        }

        if(res==false)
        {
            return  Result.error(ResultCode.FAILED.getCode(),"操作失败");
        }
          patientInformation=patientInformationService.getOne(queryWrapper);
        return Result.success(patientInformation,"增加接种人信息成功");
    }
    //删除接种人信息
    @ApiImplicitParam(name = "delectPatient", value = "删除接种人信息", required = true, dataType = "PatientInformation")
    @PostMapping("/delect")
    public Result delectPatient(@RequestBody PatientInformation patientDTO)
    {

        if (patientDTO==null) {
            return Result.error(ResultCode.VALIDATE_FAILED.getCode(), "参数错误");
        }
        Boolean res = patientInformationService.delectPatientByID(patientDTO);
        if(res==false)
        {
            return  Result.error(ResultCode.FAILED.getCode(),"操作失败");
        }
        return Result.success("删除接种人信息成功");
    }
    //更改接种人信息
    @ApiImplicitParam(name = "updataPatient", value = "更改接种人信息", required = true, dataType = "PatientInformation")
    @PostMapping("/update")
    public Result updataPatient(@RequestBody PatientInformation patientDTO)
    {

        if (patientDTO==null) {
            return Result.error(ResultCode.VALIDATE_FAILED.getCode(), "参数错误");
        }
        Boolean res = patientInformationService.savePatient(patientDTO);
        if(res==false)
        {
            return  Result.error(ResultCode.FAILED.getCode(),"更改接种人信息操作失败");
        }
        return Result.success("更改接种人信息成功");
    }
    //查询全部
    @ApiOperation("查询全部接种人信息")
    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") Long patientId,
                           @RequestParam(defaultValue = "") String patientName,
                           @RequestParam(defaultValue = "") String idCard)
    {
        return Result.success(patientInformationService.finaPatientpage(new Page<>(pageNum,pageSize),
                patientId,patientName,idCard),"分页展示疫苗信息成功");

    }






}

