package com.example.thirdhomework.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.thirdhomework.entity.UsageData;

import java.util.List;
@Dao
public interface UsageDao {

    @Query("SELECT * FROM UsageData")
    List<UsageData> getAll();

    @Query("SELECT * FROM UsageData WHERE id IN (:userIds)")
    List<UsageData> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM UsageData WHERE app_chinese_name LIKE '%' || :name || '%'")
    List<UsageData> findByName(String name);

    @Insert
    void insertAll(UsageData... users);

    @Delete
    void delete(UsageData user);
    @Query("DELETE FROM UsageData")
    void deleteAll();
    @Query("DELETE FROM UsageData WHERE app_chinese_name LIKE '%' || :name || '%'")
    void deleteByName(String name);
    @Query("SELECT * FROM UsageData WHERE app_name LIKE '%' || :name || '%'")
    List<UsageData> findByUniqueName(String name);
}
