package com.example.phamducmanh;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert()
    void insertUser(UserEntity userEntity);
    @Update()
    void updateUser(UserEntity userEntity);
    @Query("SELECT * FROM user")
    List<UserEntity> getAllUser();
    @Query(("SELECT * FROM user WHERE id =:id"))
    UserEntity getUser(int id);
    @Query("DELETE  FROM user")
    void deleteAll();
    @Delete()
    void deleteUser(UserEntity userEntity);
}
