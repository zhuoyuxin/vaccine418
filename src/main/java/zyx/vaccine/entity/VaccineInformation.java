package zyx.vaccine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName vaccine_information
 */
@TableName(value ="vaccine_information")
@Data
public class VaccineInformation implements Serializable {
    /**
     * 疫苗id
     */
    @TableId(type = IdType.AUTO)
    private Long vaccineId;

    /**
     * 疫苗名称
     */
    private String vaccineName;


    /**
     * 接种对象
     */
    private String vaccineObject;

    /**
     * 最小接种年龄
     */
    private Byte ageMin;

    /**
     * 最大接种年龄
     */
    private Byte ageMax;

    /**
     * 疫苗介绍
     */
    private String introduction;


    /**
     * 不良反应
     */
    private String adverseReaction;

    /**
     * 疫苗禁忌
     */
    private String vaccineTaboo;


    /**
     * 生产厂商名称
     */
    private String vaccineProdecerName;

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
        VaccineInformation other = (VaccineInformation) that;
        return (this.getVaccineId() == null ? other.getVaccineId() == null : this.getVaccineId().equals(other.getVaccineId()))
            && (this.getVaccineName() == null ? other.getVaccineName() == null : this.getVaccineName().equals(other.getVaccineName()))
            && (this.getVaccineObject() == null ? other.getVaccineObject() == null : this.getVaccineObject().equals(other.getVaccineObject()))
            && (this.getAgeMin() == null ? other.getAgeMin() == null : this.getAgeMin().equals(other.getAgeMin()))
            && (this.getAgeMax() == null ? other.getAgeMax() == null : this.getAgeMax().equals(other.getAgeMax()))
            && (this.getIntroduction() == null ? other.getIntroduction() == null : this.getIntroduction().equals(other.getIntroduction())) && (this.getAdverseReaction() == null ? other.getAdverseReaction() == null : this.getAdverseReaction().equals(other.getAdverseReaction()))
            && (this.getVaccineTaboo() == null ? other.getVaccineTaboo() == null : this.getVaccineTaboo().equals(other.getVaccineTaboo()))
            && (this.getVaccineProdecerName() == null ? other.getVaccineProdecerName() == null : this.getVaccineProdecerName().equals(other.getVaccineProdecerName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVaccineId() == null) ? 0 : getVaccineId().hashCode());
        result = prime * result + ((getVaccineName() == null) ? 0 : getVaccineName().hashCode());
        result = prime * result + ((getVaccineObject() == null) ? 0 : getVaccineObject().hashCode());
        result = prime * result + ((getAgeMin() == null) ? 0 : getAgeMin().hashCode());
        result = prime * result + ((getAgeMax() == null) ? 0 : getAgeMax().hashCode());
        result = prime * result + ((getIntroduction() == null) ? 0 : getIntroduction().hashCode());
        result = prime * result + ((getAdverseReaction() == null) ? 0 : getAdverseReaction().hashCode());
        result = prime * result + ((getVaccineTaboo() == null) ? 0 : getVaccineTaboo().hashCode());
        result = prime * result + ((getVaccineProdecerName() == null) ? 0 : getVaccineProdecerName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", vaccineId=").append(vaccineId);
        sb.append(", vaccineName=").append(vaccineName);
        sb.append(", vaccineObject=").append(vaccineObject);
        sb.append(", ageMin=").append(ageMin);
        sb.append(", ageMax=").append(ageMax);
        sb.append(", introduction=").append(introduction);
        sb.append(", adverseReaction=").append(adverseReaction);
        sb.append(", vaccineTaboo=").append(vaccineTaboo);
        sb.append(", vaccineProdecerName=").append(vaccineProdecerName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}