package zyx.vaccine.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import zyx.vaccine.entity.PatientInformation;
import zyx.vaccine.entity.UserRelationPatient;
import zyx.vaccine.service.UserRelationPatientService;
import zyx.vaccine.mapper.UserRelationPatientMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class UserRelationPatientServiceImpl extends ServiceImpl<UserRelationPatientMapper, UserRelationPatient>
    implements UserRelationPatientService{
    @Resource
    UserRelationPatientMapper userRelationPatientMapper;

    /**
     增加亲属接种人信息
     */
    public boolean addRelation(UserRelationPatient userRelationPatient)
    {
        return  saveOrUpdate(userRelationPatient);
    }
    /**
     * 删除亲属接种人信息
     */
    public Integer delectRelation(UserRelationPatient userRelationPatient){
        return userRelationPatientMapper.deleteByPatientIdAndUserId(userRelationPatient.getPatientId(),
                userRelationPatient.getUserId());
    }
    /**
     * 查询亲属接种人信息
     */
    public IPage<PatientInformation> findPage(IPage<UserRelationPatient> page, Long id){

          return userRelationPatientMapper.findPage(page,id);

    }

}




