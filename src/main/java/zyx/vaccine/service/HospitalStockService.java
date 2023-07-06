package zyx.vaccine.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import zyx.vaccine.entity.HospitalStock;
import com.baomidou.mybatisplus.extension.service.IService;
import zyx.vaccine.entity.User;
import zyx.vaccine.mapper.HospitalStockMapper;

import javax.annotation.Resource;

/**
 *
 */
public interface HospitalStockService extends IService<HospitalStock> {

       Boolean addHospitalStock (HospitalStock hospitalStock);

       Boolean delectHospitalStock(HospitalStock hospitalStock);

       Boolean updateHospitalStock(HospitalStock hospitalStock);

       Boolean deductStock(Long vaccineId,Long h);

       int findstock(Long hospitalId,Long vaccineId);

       IPage<HospitalStock> findHospitalStock(IPage<HospitalStock>page ,String vaccineName,
                                              Long hospitalId,Long vaccineId);

}
