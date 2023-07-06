package zyx.vaccine.mapper;

import zyx.vaccine.entity.HospitalStock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Entity zyx.vaccine.entity.HospitalStock
 */
public interface HospitalStockMapper extends BaseMapper<HospitalStock> {

    int deductStock(Long vaccineId,Long hospitalId);

}




