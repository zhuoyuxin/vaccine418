package zyx.vaccine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import zyx.vaccine.entity.Doctor;
import zyx.vaccine.service.DoctorService;
import zyx.vaccine.mapper.DoctorMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor>
    implements DoctorService{

    public Boolean addDoctor(Doctor doctor)
    {
        System.out.println(doctor);
        return  saveOrUpdate(doctor);
    }


    public Boolean delectDoctor(Doctor doctor)
    {
        return removeById(doctor.getDoctorId());
    }

    public Boolean updateDoctor(Doctor doctor)
    {
        return saveOrUpdate(doctor);
    }

   public IPage<Doctor> findPage(IPage<Doctor> page1, String doctorName,Long doctorId,Long hospitalId)
   {
       QueryWrapper<Doctor> queryWrapper =new QueryWrapper<>();
       if(doctorName != null && !"".equals(doctorName))
       {
           queryWrapper.like("doctor_name",doctorName);
       }
       if(doctorId != null && !"".equals(doctorId))
       {
           queryWrapper.like("doctor_id",doctorId);
       }
       if(hospitalId != null && !"".equals(hospitalId))
       {
           queryWrapper.like("hospital_id",hospitalId);
       }
       return page(page1,queryWrapper);
   }

    public Doctor login(String name,String password)
    {
        QueryWrapper<Doctor> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("doctor_username",name);
        queryWrapper.eq("doctor_password",password);
        Doctor s= getOne(queryWrapper);
        return s;
    }

}




