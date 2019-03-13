package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;

public class TripRouteLine extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //线路规划天数
    private Integer step;

    //英里数
    private Integer mileage;

    //驾车时间分钟
    private Integer driveHour;

    //标题
    private String title;

    //描述
    private String description;

    //总计天数
    private Integer dayNum;

    private static final long serialVersionUID = 1L;

    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getDriveHour() {
        return driveHour;
    }

    public void setDriveHour(Integer driveHour) {
        this.driveHour = driveHour;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDayNum() {
        return dayNum;
    }

    public void setDayNum(Integer dayNum) {
        this.dayNum = dayNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", step=").append(step);
        sb.append(", mileage=").append(mileage);
        sb.append(", driveHour=").append(driveHour);
        sb.append(", title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", dayNum=").append(dayNum);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        step("step"),
        mileage("mileage"),
        driveHour("drive_hour"),
        title("title"),
        description("description"),
        dayNum("day_num");

        private final String column;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        Column(String column) {
            this.column = column;
        }

        public String desc() {
            return this.column + " DESC";
        }

        public String asc() {
            return this.column + " ASC";
        }
    }
}