package com.dream.user_center.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String password;

    /**
     * 0- 女,1-男
     */
    private Integer sex;

    /**
     * 
     */
    private Integer phone;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String handurl;

    /**
     * 0-普通用户,1-管理员
     */
    private Integer userrule;

    /**
     * 0-未删除,1-删除
     */
    private Integer isdelect;

    /**
     * 
     */
    private Date createtiem;

    /**
     * 
     */
    private Date updatetime;



//    @Override
//    public boolean equals(Object that) {
//        if (this == that) {
//            return true;
//        }
//        if (that == null) {
//            return false;
//        }
//        if (getClass() != that.getClass()) {
//            return false;
//        }
//        User other = (User) that;
//        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
//            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
//            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
//            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
//            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
//            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
//            && (this.getHandurl() == null ? other.getHandurl() == null : this.getHandurl().equals(other.getHandurl()))
//            && (this.getUserrule() == null ? other.getUserrule() == null : this.getUserrule().equals(other.getUserrule()))
//            && (this.getIsdelect() == null ? other.getIsdelect() == null : this.getIsdelect().equals(other.getIsdelect()))
//            && (this.getCreatetiem() == null ? other.getCreatetiem() == null : this.getCreatetiem().equals(other.getCreatetiem()))
//            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()));
//    }
//
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
//        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
//        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
//        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
//        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
//        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
//        result = prime * result + ((getHandurl() == null) ? 0 : getHandurl().hashCode());
//        result = prime * result + ((getUserrule() == null) ? 0 : getUserrule().hashCode());
//        result = prime * result + ((getIsdelect() == null) ? 0 : getIsdelect().hashCode());
//        result = prime * result + ((getCreatetiem() == null) ? 0 : getCreatetiem().hashCode());
//        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(getClass().getSimpleName());
//        sb.append(" [");
//        sb.append("Hash = ").append(hashCode());
//        sb.append(", id=").append(id);
//        sb.append(", username=").append(username);
//        sb.append(", password=").append(password);
//        sb.append(", sex=").append(sex);
//        sb.append(", phone=").append(phone);
//        sb.append(", email=").append(email);
//        sb.append(", handurl=").append(handurl);
//        sb.append(", userrule=").append(userrule);
//        sb.append(", isdelect=").append(isdelect);
//        sb.append(", createtiem=").append(createtiem);
//        sb.append(", updatetime=").append(updatetime);
//        sb.append(", serialVersionUID=").append(serialVersionUID);
//        sb.append("]");
//        return sb.toString();
//    }
}