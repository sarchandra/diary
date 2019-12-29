package com.wcc.diary.repository;

import android.content.Context;
import androidx.room.Room;
import com.wcc.diary.repository.dao.DiaryDAO;

public class DiaryDBImp {
    private static DiaryDB instance=null;
    public static DiaryDB getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context, DiaryDB.class, "mydiary")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
