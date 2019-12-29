package com.wcc.diary.repository.dao;

import androidx.room.*;
import com.wcc.diary.repository.entity.DiaryItem;

@Dao
public interface DiaryDAO {
    @Insert
    public void  insert(DiaryItem... item);
    @Update
    public void update(DiaryItem... item);
    @Delete
    public void delete(DiaryItem... item);
    @Query("SELECT * FROM diaryitems where cdate = :pdate")
    public DiaryItem getDiaryItem(String pdate);

}
