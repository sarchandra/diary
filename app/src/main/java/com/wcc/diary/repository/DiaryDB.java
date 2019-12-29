package com.wcc.diary.repository;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.wcc.diary.repository.dao.DiaryDAO;
import com.wcc.diary.repository.entity.DiaryItem;

@Database(entities = {DiaryItem.class},version = 1)
public abstract class DiaryDB extends RoomDatabase {
    public abstract DiaryDAO getDiaryDAO();
}
