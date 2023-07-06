package zyx.vaccine.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import zyx.vaccine.entity.PatientInformation;
import zyx.vaccine.entity.UserRelationPatient;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Entity zyx.vaccine.entity.UserRelationPatient
 */
public interface UserRelationPatientMapper extends BaseMapper<UserRelationPatient> {
   Integer deleteByPatientIdAndUserId(Long patientId, Long userId);

   IPage<PatientInformation> findPage(IPage<UserRelationPatient> page , Long userID);
}




