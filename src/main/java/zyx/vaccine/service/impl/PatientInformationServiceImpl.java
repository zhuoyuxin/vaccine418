package zyx.vaccine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zyx.vaccine.entity.PatientInformation;
import zyx.vaccine.service.PatientInformationService;
import zyx.vaccine.mapper.PatientInformationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Api(tags = "patientController", description = "接种人信息管理")
@RestController
@RequestMapping("/patient")
@Service
public class PatientInformationServiceImpl extends ServiceImpl<PatientInformationMapper, PatientInformation>
    implements PatientInformationService{
    @Resource
     PatientInformationMapper patientInformationMapper;


    public boolean  savePatient(PatientInformation patientInformation)
    {
        return saveOrUpdate(patientInformation);
    }
    //根据名称查找接种人信息
    public PatientInformation getPatientByUsername(String PatientName)
    {
        QueryWrapper<PatientInformation> queryWrapper = new QueryWrapper<>();
        //查询名字为 Tom 的一条记录
        queryWrapper.eq("patientName",PatientName);
        PatientInformation user = patientInformationMapper.selectOne(queryWrapper);
        return user;

    }

    //根据patientID查询接种人信息
    public PatientInformation getPatientByPatientID(Long patientID)
    {
        PatientInformation user = patientInformationMapper.selectById(patientID);
        return  user;
    }
    // 删除patientID
    public boolean delectPatientByID(PatientInformation patientInformation)
    {
        return removeById(patientInformation.getPatientId());
    }
    public IPage<PatientInformation> finaPatientpage(IPage<PatientInformation> pagelist,
                                                        Long patientId,String patientName,String idCard)
    {
        QueryWrapper<PatientInformation> queryWrapper =  new QueryWrapper<>();
        if(patientId != null &&!"".equals(patientId))
        {
            queryWrapper.eq("patient_id",patientId);
        }
        if(patientName != null &&!"".equals(patientName))
        {
            queryWrapper.eq("patient_name",patientName);
        }
        if(idCard != null &&!"".equals(idCard))
        {
            queryWrapper.eq("id_card",idCard);
        }
         return patientInformationMapper.selectPage(pagelist,queryWrapper);
    }
}




