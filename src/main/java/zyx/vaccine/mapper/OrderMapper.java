package zyx.vaccine.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import zyx.vaccine.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import zyx.vaccine.entity.PatientInformation;
import zyx.vaccine.entity.UserRelationPatient;

/**
 * @Entity zyx.vaccine.entity.Order
 */
public interface OrderMapper extends BaseMapper<Order> {

    IPage<Order> findPageByUser(IPage<Order> page , Long userId,String patientName);
}




