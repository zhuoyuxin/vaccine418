package zyx.vaccine.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import zyx.vaccine.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface OrderService extends IService<Order> {

  Boolean addOrder(Order order);

  Boolean delectOrder(Order order);

  Boolean updateOrder(Order order);

  IPage<Order> findOrder(IPage<Order> page, QueryWrapper<Order> queryWrapper);

  IPage<Order> findOrderByPatient(IPage<Order> page, Long userId,String patientName);

}
