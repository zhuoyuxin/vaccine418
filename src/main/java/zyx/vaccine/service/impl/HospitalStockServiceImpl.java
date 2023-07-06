package zyx.vaccine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import zyx.vaccine.entity.HospitalInformation;
import zyx.vaccine.entity.HospitalStock;
import zyx.vaccine.mapper.VaccineInformationMapper;
import zyx.vaccine.service.HospitalStockService;
import zyx.vaccine.mapper.HospitalStockMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class HospitalStockServiceImpl extends ServiceImpl<HospitalStockMapper, HospitalStock>
    implements HospitalStockService{

    @Resource
    HospitalStockMapper hospitalStockMapper;
    @Resource
    VaccineInformationMapper vaccineInformationMapper;

    public Boolean addHospitalStock (HospitalStock hospitalStock)
    {
        if (vaccineInformationMapper.selectById(hospitalStock.getVaccineId())==null)
        {
            return false;
        }
       return saveOrUpdate(hospitalStock);
    }

    public Boolean delectHospitalStock(HospitalStock hospitalStock)
    {
        System.out.println(hospitalStock);
        return  removeById(hospitalStock.getStockId());
    }

    public Boolean updateHospitalStock(HospitalStock hospitalStock)
    {
        if (vaccineInformationMapper.selectById(hospitalStock.getVaccineId())==null||getById(hospitalStock)==null)
        {
            return false;
        }
        return saveOrUpdate(hospitalStock);
    }
    public Boolean deductStock(Long vaccineId,Long h)
    {
        int a=hospitalStockMapper.deductStock(vaccineId,h);
        if(a>0)
        {
            return true;
        }
        return false;
    }
    public int findstock(Long hospitalId,Long vaccineId)
    {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("hospital_id",hospitalId);
        queryWrapper.eq("vaccine_id",vaccineId);
        HospitalStock h=getOne(queryWrapper);
        return  h.getVaccineNum();


    }

    public IPage<HospitalStock> findHospitalStock(IPage<HospitalStock>page2 , String vaccineName,
                                           Long hospitalId, Long vaccineId)
    {
        QueryWrapper<HospitalStock> queryWrapper=new QueryWrapper<>();
        if(vaccineName != null && !"".equals(vaccineName))
        {
            queryWrapper.like("vaccine_name",vaccineName);
        }
        if(hospitalId != null &&!"".equals(hospitalId))
        {
            queryWrapper.eq("hospital_id",hospitalId);
        }
        if(vaccineId != null &&!"".equals(vaccineId))
        {
            queryWrapper.eq("vaccine_id",vaccineId);
        }

        return  page(page2,queryWrapper);
    }

}




