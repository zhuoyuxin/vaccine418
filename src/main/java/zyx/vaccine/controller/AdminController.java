package zyx.vaccine.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zyx.vaccine.common.Result;
import zyx.vaccine.common.ResultCode;
import zyx.vaccine.entity.Admin;
import zyx.vaccine.service.AdminService;
import zyx.vaccine.service.DoctorService;

@Api(tags = "AdminController", description = "医生基本信息管理")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    //医生登录
    @PostMapping("/login")
    public Result loginDoctor(@RequestParam String username,
                              @RequestParam String password)
    {
        QueryWrapper<Admin>queryWrapper =new QueryWrapper<>();
        if(username==null||password==null)
        {
            return  Result.error(ResultCode.VALIDATE_FAILED.getCode(),"管理员基本信息参数校验失败");
        }

        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        Admin res= adminService.login(queryWrapper);
        if(res!=null)
        {
            return Result.success(res,"管理员登录成功");
        }
        return  Result.error();

    }
}
