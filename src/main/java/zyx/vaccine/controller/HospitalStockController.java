package zyx.vaccine.controller;

import cn.hutool.log.Log;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zyx.vaccine.common.Result;
import zyx.vaccine.common.ResultCode;
import zyx.vaccine.entity.HospitalStock;
import zyx.vaccine.service.HospitalStockService;

@Api(tags = "HospitalStockController", description = "医院库存基本信息管理")
@RestController
@RequestMapping("/hospitalstock")
public class HospitalStockController {

    private static final Log LOG = Log.get();

    @Autowired
    HospitalStockService hospitalStockService;

    //增加医院库存信息
    @ApiImplicitParam(name = "addHospitalStock", value = "增加医院库存信息", required = true, dataType = "HospitalStock")
    @PostMapping("/add")
    public Result addHospitalStock(@RequestBody HospitalStock HospitalStockDTO)
    {

        if (HospitalStockDTO==null) {
            return Result.error(ResultCode.VALIDATE_FAILED.getCode(), "医院库存参数错误");
        }
        Boolean res = hospitalStockService.addHospitalStock(HospitalStockDTO);
        if(res==false)
        {
            return  Result.error(ResultCode.FAILED.getCode(),"增加医院库存信息操作失败");
        }
        return Result.success("增加医院库存信息成功");
    }
    //删除医院库存信息
    @ApiImplicitParam(name = "delectHospitalStock", value = "删除医院库存信息", required = true, dataType = "HospitalStock")
    @PostMapping("/delect")
    public Result delectHospitalStock(@RequestBody HospitalStock HospitalStockDTO)
    {

        if (HospitalStockDTO==null) {
            return Result.error(ResultCode.VALIDATE_FAILED.getCode(), "医院库存参数错误");
        }
        Boolean res = hospitalStockService.delectHospitalStock(HospitalStockDTO);
        if(res==false)
        {
            return  Result.error(ResultCode.FAILED.getCode(),"删除医院库存信息操作失败");
        }
        return Result.success("删除医院库存信息成功");
    }
    //更改医院库存信息
    @ApiImplicitParam(name = "updateHospitalStock", value = "更新医院库存信息", required = true, dataType = "HospitalStock")
    @PostMapping("/update")
    public Result HospitalStock(@RequestBody HospitalStock HospitalStockDTO)
    {

        if (HospitalStockDTO==null) {
            return Result.error(ResultCode.VALIDATE_FAILED.getCode(), "医院库存参数错误");
        }
        Boolean res = hospitalStockService.updateHospitalStock(HospitalStockDTO);
        if(res==false)
        {
            return  Result.error(ResultCode.FAILED.getCode(),"更新医院库存信息操作失败");
        }
        return Result.success("更新医院库存信息成功");
    }
    //查询全部
    @ApiOperation("查询医院库存信息")
    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String vaccineName,
                           @RequestParam(defaultValue = "") Long hospitalId,
                           @RequestParam(defaultValue = "") Long vaccineId )
    {
        return Result.success(hospitalStockService.findHospitalStock(new Page<>(pageNum,pageSize),
                vaccineName,hospitalId,vaccineId),"分页展示疫苗信息成功");

    }



}
