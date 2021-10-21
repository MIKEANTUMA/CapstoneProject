package com.example.capstoneproject;

import static androidx.room.OnConflictStrategy.IGNORE;

import java.util.List;

import androidx.room.*;

@Dao
interface UserOrgDAO {

    @Query("Select * From Users")
    List<UserOrgRoom> getAll();

    @Query("Select * from Users Where uid in (:userIds)")
    List<UserOrgRoom> LoadAllByIds(int[] userIds);

    @Query("Select * from users where User_name like :username")
    UserOrgRoom findByUsername(String username);

    @Insert(onConflict = IGNORE)
    void insertAll(UserOrgRoom... users);

    @Insert(onConflict = IGNORE)
    void insert(UserOrgRoom user);

    @Delete
    void delete(UserOrgRoom user);

    @Update
    void update(UserOrgRoom user);
}
