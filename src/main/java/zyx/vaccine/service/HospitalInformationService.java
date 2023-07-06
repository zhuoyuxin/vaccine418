package zyx.vaccine.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import zyx.vaccine.entity.HospitalInformation;
import com.baomidou.mybatisplus.extension.service.IService;
import zyx.vaccine.entity.VaccineInformation;

/**
 *
 */
public interface HospitalInformationService extends IService<HospitalInformation> {
    /**
     * 增加医院基本信息
     * @param hospitalInformation
     * @return
     */
    Boolean addHospital(HospitalInformation hospitalInformation);

    /**
     * 删除医院基本信息
     * @param hospitalInformation
     * @return
     */
    Boolean delectHospital(HospitalInformation hospitalInformation);
    /**
     * 更改医院基本信息
     */
    Boolean updateHospital(HospitalInformation hospitalInformation);
    /**
     * 展示医院信息
     */
    IPage<HospitalInformation> findPage(IPage<HospitalInformation> page, String hospitalName,Long hospitalId);


}
