package zyx.vaccine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import zyx.vaccine.entity.VaccineInformation;
import zyx.vaccine.service.VaccineInformationService;
import zyx.vaccine.mapper.VaccineInformationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class VaccineInformationServiceImpl extends ServiceImpl<VaccineInformationMapper, VaccineInformation>
    implements VaccineInformationService{
    @Resource
    VaccineInformationMapper vaccineInformationMapper;
    /**
     增加/更改疫苗信息
     */
    public boolean saveVaccine(VaccineInformation vaccineInformation)
    {
        return saveOrUpdate(vaccineInformation);
    }
    /**
     * 删除疫苗信息
     */
    public boolean delectVaccine(VaccineInformation vaccineInformation)
    {
        return removeById(vaccineInformation.getVaccineId());
    }
    /**
     展示疫苗信息
     */
    public IPage<VaccineInformation> findPage(IPage<VaccineInformation> page1, QueryWrapper queryWrapper)
    {


        return page(page1,queryWrapper);
    }

}




