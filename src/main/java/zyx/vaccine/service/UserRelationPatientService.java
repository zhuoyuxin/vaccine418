package zyx.vaccine.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.models.auth.In;
import zyx.vaccine.entity.PatientInformation;
import zyx.vaccine.entity.UserRelationPatient;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface UserRelationPatientService extends IService<UserRelationPatient> {

    /**
    增加亲属接种人信息
    */
    public boolean addRelation(UserRelationPatient userRelationPatient);
    /**
     * 删除亲属接种人信息
     */
    public Integer delectRelation(UserRelationPatient userRelationPatient);
    /**
     * 查询亲属接种人信息
     */
    public IPage<PatientInformation> findPage(IPage<UserRelationPatient> page, Long id);



}
