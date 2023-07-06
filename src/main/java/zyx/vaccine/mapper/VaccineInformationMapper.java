package zyx.vaccine.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import zyx.vaccine.entity.PatientInformation;
import zyx.vaccine.entity.UserRelationPatient;
import zyx.vaccine.entity.VaccineInformation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Entity zyx.vaccine.entity.VaccineInformation
 */
public interface VaccineInformationMapper extends BaseMapper<VaccineInformation> {

    IPage<VaccineInformation> findPage(IPage<VaccineInformation> page , String vaccineName);

}




