package zyx.vaccine.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zyx.vaccine.common.Result;
import zyx.vaccine.common.ResultCode;
import zyx.vaccine.entity.PatientInformation;
import zyx.vaccine.entity.User;
import zyx.vaccine.entity.UserRelationPatient;
import zyx.vaccine.service.PatientInformationService;
import zyx.vaccine.service.UserRelationPatientService;
@Api(tags = "UserRelationPatientController", description = "亲属接种人信息管理")
@RestController
@RequestMapping("/relation")
public class UserRelationPatientController {
    @Autowired
    UserRelationPatientService userRelationPatientService;
    @Autowired
    PatientInformationService patientInformationService;
    /**
     * *增加亲属接种人信息
     */
    //增加接种人信息
    @ApiImplicitParam(name = "patientAdd", value = "增加亲属接种人信息", required = true, dataType = "UserRelationPatient")
    @PostMapping("/add")
    public Result addPatientRelation(@RequestBody UserRelationPatient userRelationPatient)
    {
        boolean res=false;

        if (userRelationPatient==null) {
            return Result.error(ResultCode.VALIDATE_FAILED.getCode(), "参数错误");
        }
        //如果数据库没有patientID对应接种人，就不添加
        if(patientInformationService.getPatientByPatientID(userRelationPatient.getPatientId())!=null)
        {
             res = userRelationPatientService.addRelation(userRelationPatient);
        }

        if(res==false)
        {
            return  Result.error(ResultCode.FAILED.getCode(),"操作失败");
        }

        return Result.success("增加亲属接种人信息成功");
    }

     /**
     * @param userRelationPatient
     * @return
     */
    //删除接种人信息
    @ApiImplicitParam(name = "patientDelete", value = "删除接种人信息", required = true, dataType = "UserRelationPatient")
    @PostMapping("/delect")
    public Result delectPatient(@RequestBody UserRelationPatient userRelationPatient)
    {

        if (userRelationPatient==null) {
            return Result.error(ResultCode.VALIDATE_FAILED.getCode(), "参数错误");
        }
        Integer res = userRelationPatientService.delectRelation(userRelationPatient);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+res);
        if(res==0)
        {
            return  Result.error(ResultCode.FAILED.getCode(),"操作失败");
        }
        return Result.success("删除亲属接种人信息");
    }
    //分页查询
    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") Long userID)
    {
        IPage<User> page =new Page(pageNum,pageSize);

        return Result.success(userRelationPatientService.findPage(new Page<>(pageNum,pageSize),userID),"分页查询亲属接种人信息成功");

    }


}
