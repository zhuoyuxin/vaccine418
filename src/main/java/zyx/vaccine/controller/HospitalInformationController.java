package zyx.vaccine.controller;

import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zyx.vaccine.common.Result;
import zyx.vaccine.common.ResultCode;
import zyx.vaccine.entity.HospitalInformation;
import zyx.vaccine.entity.PatientInformation;
import zyx.vaccine.service.HospitalInformationService;

@Api(tags = "HospitalInformationController", description = "医院基本信息管理")
@RestController
@RequestMapping("/hospital")
public class HospitalInformationController {
    private static final Log LOG = Log.get();

    @Autowired
    HospitalInformationService hospitalInformationService;

    /**
     * 增加医院基本信息
     * @param hospitalInformation
     * @return
     */
    @ApiImplicitParam(name = "addHospitalInformation", value = "增加医院基本信息", required = true, dataType = "HospitalInformation")
    @PostMapping("/add")
    public Result addHospitalInformation(@RequestBody HospitalInformation hospitalInformation)
    {
        //判断是否为空
        if (hospitalInformation==null) {
            return Result.error(ResultCode.VALIDATE_FAILED.getCode(), "参数错误");
        }
        //判断是否有重复信息
        IPage<HospitalInformation> page=new Page<>(1,1);
        page=hospitalInformationService.findPage(page,hospitalInformation.getHospitalName(),null);
        if(page.getRecords()!=null)
        {
            Result.error(ResultCode.VALIDATE_FAILED.getCode(),"医院基本信息重复，请修改信息");
        }
        Boolean res=hospitalInformationService.addHospital(hospitalInformation);
        if(res==false)
        {
            Result.error(ResultCode.FAILED.getCode(),"增加医院基本信息失败");
        }
        return Result.success("增加医院基本信息成功");
    }
    @ApiImplicitParam(name = "electHospitalInformation", value = "删除医院基本信息", required = true, dataType = "HospitalInformation")
    @PostMapping("/delect")
    public Result delectHospitalInformation(@RequestBody HospitalInformation hospitalInformation)
    {
        //判断是否为空
        if (hospitalInformation==null||hospitalInformation.getHospitalId()==null) {
            return Result.error(ResultCode.VALIDATE_FAILED.getCode(), "参数错误");
        }
        Boolean res=hospitalInformationService.delectHospital(hospitalInformation);
        if(res==false)
        {
            return  Result.error(ResultCode.FAILED.getCode(),"删除医院基本信息操作失败");
        }
        return Result.success("删除医院基本信息成功");
    }
    @ApiImplicitParam(name = "updateHospitalInformation", value = "更改医院基本信息", required = true, dataType = "HospitalInformation")
    @PostMapping("/update")
    public Result updateHospitalInformation(@RequestBody HospitalInformation hospitalInformation)
    {
        //判断是否为空
        if (hospitalInformation==null||hospitalInformation.getHospitalId()==null) {
            return Result.error(ResultCode.VALIDATE_FAILED.getCode(), "参数错误");
        }
        Boolean res=hospitalInformationService.updateHospital(hospitalInformation);
        if(res==false)
        {
            return  Result.error(ResultCode.FAILED.getCode(),"更改医院基本信息操作失败");
        }
        return Result.success("更改医院基本信息成功");
    }
    @ApiImplicitParam(name = "pageHospitalInformation", value = "展示医院基本信息", required = true, dataType = "HospitalInformation")
    @GetMapping("/page")
    public Result pageHospitalInformation(@RequestParam(defaultValue = "2") Integer pageNum,
                                          @RequestParam (defaultValue = "1")Integer pageSize,
                                          @RequestParam(defaultValue = "") String hospitalName,
                                          @RequestParam (defaultValue = "")Long hospitalId)
    {
        return Result.success(hospitalInformationService.findPage(new Page<>(pageNum,pageSize),
                hospitalName,
                hospitalId),
                "分页展示医院基本信息信息成功");
    }





}
