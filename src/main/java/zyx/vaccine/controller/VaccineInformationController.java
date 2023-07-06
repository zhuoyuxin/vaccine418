package zyx.vaccine.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import zyx.vaccine.common.Result;
import zyx.vaccine.common.ResultCode;
import zyx.vaccine.entity.User;
import zyx.vaccine.entity.UserRelationPatient;
import zyx.vaccine.entity.VaccineInformation;
import zyx.vaccine.mapper.VaccineInformationMapper;
import zyx.vaccine.service.VaccineInformationService;

@Api(tags = "VaccineInformationController", description = "疫苗基本信息信息管理")
@RestController
@RequestMapping("/vaccine")
public class VaccineInformationController {
    @Autowired
    VaccineInformationService vaccineInformationService;


    /**
     * 增加疫苗基本信息
     */
    @ApiImplicitParam(name = "vaccineAdd", value = "增加疫苗基本信息", required = true, dataType = "VaccineInformation")
    @PostMapping("/add")
    public Result addVaccine(@RequestBody VaccineInformation vaccineInformation)
    {
        if(vaccineInformation==null)
        {
            return Result.error(ResultCode.VALIDATE_FAILED.getCode(),"添加疫苗基本信息参数校验失败");
        }
        Boolean res=vaccineInformationService.saveVaccine(vaccineInformation);
        if(res==false)
        {
            return  Result.error(ResultCode.FAILED.getCode(),"添加疫苗基本信息失败");
        }
        return  Result.success("添加疫苗基本信息成功");
    }
    /**
    删除疫苗基本信息
     */
    @ApiImplicitParam(name = "vaccineDelete", value = "删除疫苗基本信息", required = true, dataType = "VaccineInformation")
    @PostMapping("/delect")
    public Result delectVaccine(@RequestBody VaccineInformation vaccineInformation)
    {
        if(vaccineInformation==null)
        {
            return Result.error(ResultCode.VALIDATE_FAILED.getCode(),"删除疫苗基本信息参数校验失败");
        }
        Boolean res =vaccineInformationService.delectVaccine(vaccineInformation);
        if(res==false)
        {
            return  Result.error(ResultCode.FAILED.getCode(),"删除疫苗基本信息失败");
        }
        return  Result.success("删除疫苗基本信息成功");
    }
    /**
     * 更改疫苗信息
     */
    @ApiImplicitParam(name = "updateVaccine", value = "更改疫苗基本信息", required = true, dataType = "VaccineInformation")
    @PostMapping("/update")
    public Result updateVaccine(@RequestBody VaccineInformation vaccineInformation)
    {
        if(vaccineInformation==null)
        {
            return Result.error(ResultCode.VALIDATE_FAILED.getCode(),"更改疫苗基本信息参数校验失败");
        }
        Boolean res=vaccineInformationService.saveVaccine(vaccineInformation);
        if(res==false)
        {
            return  Result.error(ResultCode.FAILED.getCode(),"更改疫苗基本信息失败");
        }
        return  Result.success("更改疫苗基本信息成功");
    }
    /**
     * 分页展示疫苗信息
     */
    //分页查询
    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String vaccineName,
                           @RequestParam(defaultValue = "") Long vaccineId)
    {
        Page<VaccineInformation> page =new Page(pageNum,pageSize);
        QueryWrapper<VaccineInformation> queryWrapper=new QueryWrapper<>();
        System.out.println(vaccineId+"  ++++    "+vaccineName);
        if(!"".equals(vaccineName)&&vaccineName!=null)
        {
            queryWrapper.like("vaccine_name",vaccineName);
        }
        if(!"".equals(vaccineId)&&vaccineId!=null)
        {

            queryWrapper.like("vaccine_id",vaccineId);
        }
        return Result.success(vaccineInformationService.findPage(new Page<>(pageNum,pageSize),queryWrapper),"分页展示疫苗信息成功");

    }

}
