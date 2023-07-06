package zyx.vaccine.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import zyx.vaccine.entity.PatientInformation;
import com.baomidou.mybatisplus.extension.service.IService;
import zyx.vaccine.entity.User;

import java.util.List;

/**
 *
 */
public interface PatientInformationService extends IService<PatientInformation> {

     boolean  savePatient(PatientInformation patientInformation);

    //根据名称查找接种人信息
     PatientInformation getPatientByUsername(String username);

    //根据patientID查询接种人信息
     PatientInformation getPatientByPatientID(Long patientID);
    //查询所有Patient
    IPage<PatientInformation> finaPatientpage(IPage<PatientInformation> pagelist,
                                              Long patientId,String patientName,String idCard);
    // 删除patientID
     boolean delectPatientByID(PatientInformation patientInformation);
    //分页查询
    //Page<User> findPage(Page<User> objectPage, String username, String age, String nickname);

}
