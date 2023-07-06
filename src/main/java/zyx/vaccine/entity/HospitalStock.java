package zyx.vaccine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName hospital_stock
 */
@TableName(value ="hospital_stock")
@Data
public class HospitalStock implements Serializable {

    /**
     * 库存id
     */
    @TableId(type = IdType.AUTO)
    private  Long stockId;
    /**
     * 医院id
     */

    private Long hospitalId;

    /**
     * 疫苗id
     */

    private Long vaccineId;

    /**
     * 医院名称
     */
    private String hospitalName;

    /**
     * 疫苗库存
     */
    private Integer vaccineNum;

    /**
     * 疫苗名称
     */
    private String vaccineName;

    /**
     * 生产时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date produceTime;

    /**
     * 过期时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date deadtime;

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
        HospitalStock other = (HospitalStock) that;
        return (this.getHospitalId() == null ? other.getHospitalId() == null : this.getHospitalId().equals(other.getHospitalId()))
            && (this.getVaccineId() == null ? other.getVaccineId() == null : this.getVaccineId().equals(other.getVaccineId()))
            && (this.getHospitalName() == null ? other.getHospitalName() == null : this.getHospitalName().equals(other.getHospitalName()))
            && (this.getVaccineNum() == null ? other.getVaccineNum() == null : this.getVaccineNum().equals(other.getVaccineNum()))
            && (this.getVaccineName() == null ? other.getVaccineName() == null : this.getVaccineName().equals(other.getVaccineName()))
            && (this.getProduceTime() == null ? other.getProduceTime() == null : this.getProduceTime().equals(other.getProduceTime()))
            && (this.getDeadtime() == null ? other.getDeadtime() == null : this.getDeadtime().equals(other.getDeadtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHospitalId() == null) ? 0 : getHospitalId().hashCode());
        result = prime * result + ((getVaccineId() == null) ? 0 : getVaccineId().hashCode());
        result = prime * result + ((getHospitalName() == null) ? 0 : getHospitalName().hashCode());
        result = prime * result + ((getVaccineNum() == null) ? 0 : getVaccineNum().hashCode());
        result = prime * result + ((getVaccineName() == null) ? 0 : getVaccineName().hashCode());
        result = prime * result + ((getProduceTime() == null) ? 0 : getProduceTime().hashCode());
        result = prime * result + ((getDeadtime() == null) ? 0 : getDeadtime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stockId=").append(stockId);
        sb.append(", hospitalId=").append(hospitalId);
        sb.append(", vaccineId=").append(vaccineId);
        sb.append(", hospitalName=").append(hospitalName);
        sb.append(", vaccineNum=").append(vaccineNum);
        sb.append(", vaccineName=").append(vaccineName);
        sb.append(", produceTime=").append(produceTime);
        sb.append(", deadtime=").append(deadtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}