package zyx.vaccine.controller;


import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zyx.vaccine.common.Result;
import zyx.vaccine.common.ResultCode;
import zyx.vaccine.entity.Doctor;
import zyx.vaccine.service.DoctorService;

@Api(tags = "DoctorController", description = "医生基本信息管理")
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private static final Log LOG = Log.get();

    @Autowired
    DoctorService doctorService;

    //医生登录
    @ApiImplicitParam(name = "loginDoctor", value = "增加医生基本信息", required = true, dataType = "Doctor")
    @PostMapping("/login")
    public Result loginDoctor(@RequestParam String doctorUsername,
                              @RequestParam String doctorPassword)
    {
        QueryWrapper<Doctor> queryWrapper=new QueryWrapper<>();
        if(doctorUsername==null||doctorPassword==null)
        {
            return  Result.error(ResultCode.VALIDATE_FAILED.getCode(),"医生基本信息参数校验失败");
        }
        queryWrapper.eq("doctor_username",doctorUsername);
        queryWrapper.eq("doctor_password",doctorPassword);
        Doctor doctor1= doctorService.getOne(queryWrapper);
        if(doctor1==null)
        {
            return Result.error(ResultCode.VALIDATE_FAILED.getCode(),"检查医生用户名或密码！");
        }

            return Result.success(doctor1,"医生登录成功");



    }

    //增加接种人信息
    @ApiImplicitParam(name = "addDoctor", value = "增加医生基本信息", required = true, dataType = "Doctor")
    @PostMapping("/add")
    public Result addDoctor(@RequestBody Doctor doctor)
    {
        if(doctor==null)
        {
            return  Result.error(ResultCode.VALIDATE_FAILED.getCode(),"医生基本信息参数校验失败");
        }
        Boolean res=doctorService.addDoctor(doctor);
        if(res==false)
        {
            return  Result.error(ResultCode.FAILED.getCode(),"医生基本信息添加失败");
        }
        else
        {
            return Result.success("医生基本信息添加成功");
        }



    }
    //删除接种人信息
        @ApiImplicitParam(name = "delectDoctor", value = "删除医生基本信息", required = true, dataType = "Doctor")
        @PostMapping("/delect")
        public Result delectDoctor(@RequestBody Doctor doctor)
        {
            if(doctor==null)
            {
                return  Result.error(ResultCode.VALIDATE_FAILED.getCode(),"医生基本信息参数校验失败");
            }
            Boolean res=doctorService.delectDoctor(doctor);
            if(res==false)
            {
                return  Result.error(ResultCode.FAILED.getCode(),"医生基本信息删除失败");
            }
            else
            {
                return Result.success("医生基本信息删除成功");
            }

        }
        //更改医生信息
    @ApiImplicitParam(name = "updatetDoctor", value = "更改医生基本信息", required = true, dataType = "Doctor")
    @PostMapping("/update")
    public Result updatetDoctor(@RequestBody Doctor doctor)
    {
        if(doctor==null)
        {
            return  Result.error(ResultCode.VALIDATE_FAILED.getCode(),"医生基本信息参数校验失败");
        }
        Boolean res=doctorService.delectDoctor(doctor);
        if(res==false)
        {
            return  Result.error(ResultCode.FAILED.getCode(),"医生基本信息更改失败");
        }
        else
        {
            return Result.success("医生基本信息更改成功");
        }

    }
    //查找医生信息
    //查询全部
    @ApiOperation("查询医生信息")
    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String doctorName,
                           @RequestParam(defaultValue = "") Long hospitalID,
                           @RequestParam(defaultValue = "") Long doctorID)
    {
        return Result.success(doctorService.findPage(new Page<>(pageNum,pageSize),
                doctorName,doctorID,hospitalID),"分页展示疫苗信息成功");

    }

}
