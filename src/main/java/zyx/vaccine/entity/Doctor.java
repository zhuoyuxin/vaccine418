package zyx.vaccine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 
 * @TableName doctor
 */
@ApiModel(value="Doctor对象", description="医生实体类")
@TableName(value ="doctor")
@Data
public class Doctor implements Serializable {
    /**
     * 医生编号
     */
    @TableId(type = IdType.AUTO)
    private Long doctorId;

    /**
     * 医生用户名
     */
    private String doctorUsername;

    /**
     * 医生密码
     */
    private String doctorPassword;

    /**
     * 医生昵称
     */
    private String doctorNickname;

    /**
     * 医生所属医院编号
     */
    private Long doctorHospitalId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Doctor other = (Doctor) that;
        return (this.getDoctorId() == null ? other.getDoctorId() == null : this.getDoctorId().equals(other.getDoctorId()))
            && (this.getDoctorUsername() == null ? other.getDoctorUsername() == null : this.getDoctorUsername().equals(other.getDoctorUsername()))
            && (this.getDoctorPassword() == null ? other.getDoctorPassword() == null : this.getDoctorPassword().equals(other.getDoctorPassword()))
            && (this.getDoctorNickname() == null ? other.getDoctorNickname() == null : this.getDoctorNickname().equals(other.getDoctorNickname()))
            && (this.getDoctorHospitalId() == null ? other.getDoctorHospitalId() == null : this.getDoctorHospitalId().equals(other.getDoctorHospitalId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDoctorId() == null) ? 0 : getDoctorId().hashCode());
        result = prime * result + ((getDoctorUsername() == null) ? 0 : getDoctorUsername().hashCode());
        result = prime * result + ((getDoctorPassword() == null) ? 0 : getDoctorPassword().hashCode());
        result = prime * result + ((getDoctorNickname() == null) ? 0 : getDoctorNickname().hashCode());
        result = prime * result + ((getDoctorHospitalId() == null) ? 0 : getDoctorHospitalId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", doctorId=").append(doctorId);
        sb.append(", doctorUsername=").append(doctorUsername);
        sb.append(", doctorPassword=").append(doctorPassword);
        sb.append(", doctorNickname=").append(doctorNickname);
        sb.append(", doctorHospitalId=").append(doctorHospitalId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}