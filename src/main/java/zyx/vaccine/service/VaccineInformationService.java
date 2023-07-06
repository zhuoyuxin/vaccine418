package zyx.vaccine.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import zyx.vaccine.entity.PatientInformation;
import zyx.vaccine.entity.User;
import zyx.vaccine.entity.UserRelationPatient;
import zyx.vaccine.entity.VaccineInformation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface VaccineInformationService extends IService<VaccineInformation> {
    /**
     增加/更改疫苗信息
     */
    public boolean saveVaccine(VaccineInformation vaccineInformation);
    /**
     * 删除疫苗信息
     */
    public boolean delectVaccine(VaccineInformation vaccineInformation);
    /**
    展示疫苗信息
     */
    public IPage<VaccineInformation> findPage(IPage<VaccineInformation> page, QueryWrapper queryWrapper);


}
