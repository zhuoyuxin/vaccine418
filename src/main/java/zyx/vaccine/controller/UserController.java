package zyx.vaccine.controller;


import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zyx.vaccine.common.Result;
import zyx.vaccine.common.ResultCode;
import zyx.vaccine.entity.User;
import zyx.vaccine.service.UserService;

import java.util.List;

@Api(tags = "PmsBrandController", description = "商品品牌管理")
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Log LOG = Log.get();

    @Autowired
    UserService userService;



    //登录
    @ApiImplicitParam(name = "loginUser", value = "用户登录", required = true)
    @PostMapping("/login")
    public Result login(@RequestParam String username,
                        @RequestParam String password)
    {

        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            return Result.error(ResultCode.VALIDATE_FAILED.getCode(), "参数错误");
        }
        User dto = userService.userLogin(username,password);
        return Result.success(dto,"登录成功");


    }



    //@ApiOperation("新增或者更新用户数据")
    @PostMapping("/save")
    public Result sava(@RequestBody User user){
        //新增或更新
        Boolean res=userService.saveUser(user);
        if(res==false)
        {
            return Result.error(ResultCode.FAILED.getCode(),"操作失败");
        }
        return Result.success(user,"操作成功");
    }

    //根据用户名查询
   // @ApiOperation("根据用户名查询")
    @GetMapping("/name")
    public User findById(@RequestParam String username)
    {
        return userService.getUserByUsername(username);
    }

    //查询全部
    //@ApiOperation("查询全部用户")
    @GetMapping
    public List<User> findAll()
    {
        return userService.list();
    }



    @PostMapping("/register")
    public Result register(@RequestBody User userDTO) {
        String username = userDTO.getUserName();
        String password = userDTO.getUserPassword();
        String Captcha =RandomUtil.randomNumbers(6);

        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            return Result.error(ResultCode.VALIDATE_FAILED.getCode(), "参数错误");
        }
        return Result.success(userService.userRegister(userDTO),"注册成功");
    }


    //分页查询
    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String username,
                           @RequestParam(defaultValue = "") String  nickname,
                           @RequestParam(defaultValue = "") String  user_phone)
    {
        IPage<User> page =new Page(pageNum,pageSize);
        QueryWrapper<User> queryWrapper =new QueryWrapper();
        //queryWrapper.like(Strings.isNotEmpty(address),"address",address)
        if(!"".equals(username))
        {
            queryWrapper.like("user_name",username);
        }
        if(!"".equals(nickname)){
            queryWrapper.like("nickname",nickname);
        }
        if(!"".equals(user_phone)){
            queryWrapper.like("user_phone",user_phone);
        }
        return Result.success(userService.findPage(new Page<>(pageNum,pageSize),queryWrapper),"分页查询成功");

    }



}
