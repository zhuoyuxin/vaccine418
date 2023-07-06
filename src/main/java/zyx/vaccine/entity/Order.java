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
 * @TableName order
 */
@TableName(value ="`order`")
@Data
public class Order implements Serializable {
    /**
     * 订单id
     */
    @TableId(type = IdType.AUTO)
    private Integer orderId;

    /**
     * 接种人ID
     */
    private Long patientId;

    /**
     * 接种人姓名
     */
    private String patientName;
    /**
     * 接种点id
     */
    private Long hospitalId;
    /**
     * 接种点名称
     */
    private String hospitalName;
    /**
     * 预约疫苗ID
     */
    private Long vaccineId;

    /**
     * 预约疫苗名称
     */
    private String vaccineName;

    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date appointTime;

    /**
     * 下单时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date makeOrderTime;
    private Integer statue;


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
        Order other = (Order) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getPatientId() == null ? other.getPatientId() == null : this.getPatientId().equals(other.getPatientId()))
            && (this.getPatientName() == null ? other.getPatientName() == null : this.getPatientName().equals(other.getPatientName()))
            && (this.getVaccineId() == null ? other.getVaccineId() == null : this.getVaccineId().equals(other.getVaccineId()))
            && (this.getVaccineName() == null ? other.getVaccineName() == null : this.getVaccineName().equals(other.getVaccineName()))
            && (this.getAppointTime() == null ? other.getAppointTime() == null : this.getAppointTime().equals(other.getAppointTime()))
            && (this.getMakeOrderTime() == null ? other.getMakeOrderTime() == null : this.getMakeOrderTime().equals(other.getMakeOrderTime()));
               }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getPatientId() == null) ? 0 : getPatientId().hashCode());
        result = prime * result + ((getPatientName() == null) ? 0 : getPatientName().hashCode());
        result = prime * result + ((getVaccineId() == null) ? 0 : getVaccineId().hashCode());
        result = prime * result + ((getVaccineName() == null) ? 0 : getVaccineName().hashCode());
        result = prime * result + ((getAppointTime() == null) ? 0 : getAppointTime().hashCode());
        result = prime * result + ((getMakeOrderTime() == null) ? 0 : getMakeOrderTime().hashCode());
            return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", patientId=").append(patientId);
        sb.append(", patientName=").append(patientName);
        sb.append(",  hospitalId=").append( hospitalId);
        sb.append(",  hospitalName=").append(hospitalName);
        sb.append(", vaccineId=").append(vaccineId);
        sb.append(", vaccineName=").append(vaccineName);
        sb.append(", appointTime=").append(appointTime);
        sb.append(", makeOrderTime=").append(makeOrderTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}