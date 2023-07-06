package zyx.vaccine.controller;


import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zyx.vaccine.common.Result;
import zyx.vaccine.common.ResultCode;
import zyx.vaccine.entity.Doctor;
import zyx.vaccine.entity.Order;
import zyx.vaccine.service.HospitalStockService;
import zyx.vaccine.service.OrderService;

@Api(tags = "Ordercontroller", description = "订单信息管理")
@RestController
@RequestMapping("/order")
public class Ordercontroller {

    private static final Log LOG = Log.get();

    @Autowired
    OrderService orderService;
    @Autowired
    HospitalStockService stockService;
    //增加订单信息
    @ApiImplicitParam(name = "addOrder", value = "增加订单基本信息", required = true, dataType = "Order")
    @PostMapping("/add")
    public Result addDoctor(@RequestBody Order order)
    {
        if(order==null)
        {
            return  Result.error(ResultCode.VALIDATE_FAILED.getCode(),"订单基本信息参数校验失败");
        }
        Boolean res=false;
        if(stockService.findstock(order.getHospitalId(),order.getVaccineId())>0)
        {
            res=orderService.addOrder(order);
                stockService.deductStock(order.getVaccineId(),order.getHospitalId());

        }
        else
        {
            return Result.error(ResultCode.FAILED.getCode(),"库存不足");
        }
        if(res==false)
        {
            return  Result.error(ResultCode.FAILED.getCode(),"订单基本信息添加失败");
        }

            return Result.success("订单基本信息添加成功");
    }
    //更改订单信息
    @ApiImplicitParam(name = "updateOrder", value = "更改订单基本信息", required = true, dataType = "Order")
    @PostMapping("/update")
    public Result updateOrder(@RequestBody Order order)
    {
        if(order==null||order.getOrderId()==null)
        {
            return  Result.error(ResultCode.VALIDATE_FAILED.getCode(),"订单基本信息参数校验失败");
        }
        Boolean res=orderService.updateOrder(order);
        if(res==false)
        {
            return  Result.error(ResultCode.FAILED.getCode(),"订单基本信息修改失败");
        }
        return Result.success("订单基本信息修改成功");
    }
    //查询订单信息
    @ApiImplicitParam(name = "pageOrder", value = "查询订单基本信息", required = true, dataType = "Order")
    @GetMapping("/pageOrder")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") Long orderId,
                           @RequestParam(defaultValue = "") Long patientId,
                           @RequestParam(defaultValue = "") String patientName,
                           @RequestParam(defaultValue = "") Long hospitalId,
                           @RequestParam(defaultValue = "") Long hospitalName)
    {
        QueryWrapper<Order> queryWrapper=new QueryWrapper<>();
        if(orderId != null &&!"".equals(orderId))
        {
            queryWrapper.eq("order_id",orderId);
        }
        if(patientId != null &&!"".equals(patientId))
        {
            queryWrapper.eq("patient_id",patientId);
        }
        if(patientName != null && !"".equals(patientName))
        {
            queryWrapper.like("patient_name",patientName);
        }
        if(hospitalId != null && !"".equals(hospitalId))
        {
            queryWrapper.like("hospital_id",hospitalId);
        }
        if(hospitalName != null && !"".equals(hospitalName))
        {
            queryWrapper.like("hospital_name",hospitalName);
        }

      IPage<Order> res= orderService.findOrder(new Page<>(pageNum,pageSize),queryWrapper);

        return Result.success(res,"查询订单基本信息成功");
    }

    //查询全部
    @ApiOperation("查询用户绑定接种人信息")
    @GetMapping("/pagebyuser")
    public Result findPageByUser(@RequestParam Integer pageNum,
                                 @RequestParam Integer pageSize,
                                 @RequestParam(defaultValue = "") Long userId,
                                 @RequestParam(defaultValue = "") String patientName)
    {
        return Result.success(orderService.findOrderByPatient(new Page<>(pageNum,pageSize),
                userId,patientName),"分页展示订单信息成功");

    }
}
