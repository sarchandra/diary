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

    public DiaryItem(){
        this.cdate = Utils.GetDateNow();
        this.desc="";
        this.imgurl="";
    }

    public DiaryItem(String pdate,String pdesc,String pimgurl){
        this.cdate =pdate;
        this.desc = pdesc;
        this.imgurl=pimgurl;
    }
}
