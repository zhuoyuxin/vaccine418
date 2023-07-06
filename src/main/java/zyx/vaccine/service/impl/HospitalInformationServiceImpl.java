package zyx.vaccine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import zyx.vaccine.common.Result;
import zyx.vaccine.common.ResultCode;
import zyx.vaccine.entity.HospitalInformation;
import zyx.vaccine.service.HospitalInformationService;
import zyx.vaccine.mapper.HospitalInformationMapper;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;

/**
 *
 */
@Service
public class HospitalInformationServiceImpl extends ServiceImpl<HospitalInformationMapper, HospitalInformation>
    implements HospitalInformationService{
    /**
     * 增加医院基本信息
     * @param hospitalInformation
     * @return
     */
    public Boolean addHospital(HospitalInformation hospitalInformation)
    {
        return  save(hospitalInformation);
    }

    /**
     * 删除医院基本信息
     * @param hospitalInformation
     * @return
     */
    public Boolean delectHospital(HospitalInformation hospitalInformation)
    {
        return removeById(hospitalInformation.getHospitalId());
    }
    /**
     * 更改医院基本信息
     */
    public Boolean updateHospital(HospitalInformation hospitalInformation)
    {
        return saveOrUpdate(hospitalInformation);
    }
    /**
     * 展示医院信息
     */
    public IPage<HospitalInformation> findPage(IPage<HospitalInformation> page2, String hospitalName, Long hospitalId)
    {
        QueryWrapper<HospitalInformation> queryWrapper=new QueryWrapper<>();
        if(hospitalName != null && !"".equals(hospitalName))
        {
            queryWrapper.like("hospital_name",hospitalName);
        }
        if(hospitalId != null &&!"".equals(hospitalId))
        {
            queryWrapper.eq("hospital_id",hospitalId);
        }
        return  page(page2,queryWrapper);

    }


}




