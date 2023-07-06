package zyx.vaccine.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import zyx.vaccine.entity.Doctor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface DoctorService extends IService<Doctor> {

    Boolean addDoctor(Doctor doctor);


    Boolean delectDoctor(Doctor doctor);

    Boolean updateDoctor(Doctor doctor);

    IPage<Doctor> findPage(IPage<Doctor> page1, String doctorName,Long doctorId,Long hospitalId);

    Doctor login(String name,String password);

}
