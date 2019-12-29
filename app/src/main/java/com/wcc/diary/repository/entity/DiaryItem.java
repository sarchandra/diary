package com.wcc.diary.repository.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.wcc.diary.util.Utils;

@Entity(tableName = "diaryitems")
public class DiaryItem {
    @PrimaryKey
    @NonNull  private String cdate;
    private String desc;
    private String imgurl;

    @NonNull
    public String getCdate() {
        return cdate;
    }

    public void setCdate(@NonNull String cdate) {
        this.cdate = cdate;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }



    public DiaryItem(){
        this.cdate = Utils.GetDateNow();
        this.desc="";
        this.imgurl="";
    }

    public DiaryItem(String date,String desc,String imgurl){
        this.cdate =date;
        this.desc = desc;
        this.imgurl=imgurl;
    }
}
