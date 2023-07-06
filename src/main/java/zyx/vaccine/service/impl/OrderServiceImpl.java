package zyx.vaccine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import zyx.vaccine.entity.Order;
import zyx.vaccine.service.OrderService;
import zyx.vaccine.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{
    @Resource
    OrderMapper orderMapper;

    public Boolean addOrder(Order order)
    {
        QueryWrapper<Order> queryWrapper=new QueryWrapper<>();
        if(order.getPatientId()==null||order.getVaccineId()==null)
        {
            return false;
        }

            return save(order);

    }

    public Boolean delectOrder(Order order)
    {
        return removeById(order.getOrderId());
    }

    public Boolean updateOrder(Order order)
    {
        QueryWrapper<Order> queryWrapper=new QueryWrapper<>();
        if(getById(order.getOrderId())==null)
        {
            return false;
        }
        return saveOrUpdate(order);
    }

    public IPage<Order> findOrder(IPage<Order> page2,  QueryWrapper<Order> queryWrapper)
    {
        return page(page2,queryWrapper);
    }
    public  IPage<Order> findOrderByPatient(IPage<Order> page, Long userId,String patientName)
    {
       return orderMapper.findPageByUser(page,userId,patientName);
    }


}




