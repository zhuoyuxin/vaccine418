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
 * @TableName hospital_information
 */
@ApiModel(value="医院基本信息对象", description="医院基本信息实体类")
@TableName(value ="hospital_information")
@Data
public class HospitalInformation implements Serializable {
    /**
     * 医院id
     */
    @TableId(type = IdType.AUTO)
    private Long hospitalId;

    /**
     * 医院名称
     */
    private String hospitalName;

    /**
     * 医院电话
     */
    private String hospitalPhone;

    /**
     * 医院简介
     */
    private String hospitalIntrodece;

    /**
     * 医院详细地址
     */
    private String address;

    /**
     * 是否有效，0无效，1有效
     */
    private Byte status;

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
        HospitalInformation other = (HospitalInformation) that;
        return (this.getHospitalId() == null ? other.getHospitalId() == null : this.getHospitalId().equals(other.getHospitalId()))
            && (this.getHospitalName() == null ? other.getHospitalName() == null : this.getHospitalName().equals(other.getHospitalName()))
            && (this.getHospitalPhone() == null ? other.getHospitalPhone() == null : this.getHospitalPhone().equals(other.getHospitalPhone()))
            && (this.getHospitalIntrodece() == null ? other.getHospitalIntrodece() == null : this.getHospitalIntrodece().equals(other.getHospitalIntrodece()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHospitalId() == null) ? 0 : getHospitalId().hashCode());
        result = prime * result + ((getHospitalName() == null) ? 0 : getHospitalName().hashCode());
        result = prime * result + ((getHospitalPhone() == null) ? 0 : getHospitalPhone().hashCode());
        result = prime * result + ((getHospitalIntrodece() == null) ? 0 : getHospitalIntrodece().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", hospitalId=").append(hospitalId);
        sb.append(", hospitalName=").append(hospitalName);
        sb.append(", hospitalPhone=").append(hospitalPhone);
        sb.append(", hospitalIntrodece=").append(hospitalIntrodece);
        sb.append(", address=").append(address);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}