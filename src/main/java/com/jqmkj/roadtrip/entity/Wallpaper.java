package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class Wallpaper extends BaseEntity implements Serializable {
    //主键ID
    private Long id;

    //特殊节假日
    private Date hollydayTime;

    //壁纸
    private String wallpaperPic;

    private static final long serialVersionUID = 1L;

    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getHollydayTime() {
        return hollydayTime;
    }

    public void setHollydayTime(Date hollydayTime) {
        this.hollydayTime = hollydayTime;
    }

    public String getWallpaperPic() {
        return wallpaperPic;
    }

    public void setWallpaperPic(String wallpaperPic) {
        this.wallpaperPic = wallpaperPic;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", hollydayTime=").append(hollydayTime);
        sb.append(", wallpaperPic=").append(wallpaperPic);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        hollydayTime("hollyday_time"),
        wallpaperPic("wallpaper_pic"),
        createId("create_id"),
        createTime("create_time"),
        updateId("update_id"),
        updateTime("update_time");

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