package zyx.vaccine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName user_relation_patient
 */
@TableName(value ="user_relation_patient")
@Data
public class UserRelationPatient implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long relationId;
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 接种人ID
     */
    private Long patientId;

    /**
     * 接种人姓名
     */
    private String patientName;

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
        UserRelationPatient other = (UserRelationPatient) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPatientId() == null ? other.getPatientId() == null : this.getPatientId().equals(other.getPatientId()))
            && (this.getPatientName() == null ? other.getPatientName() == null : this.getPatientName().equals(other.getPatientName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPatientId() == null) ? 0 : getPatientId().hashCode());
        result = prime * result + ((getPatientName() == null) ? 0 : getPatientName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", patientId=").append(patientId);
        sb.append(", patientName=").append(patientName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}