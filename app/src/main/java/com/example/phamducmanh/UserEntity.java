package com.example.phamducmanh;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "mail")
    private String mail;
    @ColumnInfo(name = "gripe")
    private String gripe;
    @ColumnInfo(name = "des")
    private String des;

    public UserEntity() {
    }

    public UserEntity(String name, String mail, String gripe, String des) {
        this.name = name;
        this.mail = mail;
        this.gripe = gripe;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getGripe() {
        return gripe;
    }

    public void setGripe(String gripe) {
        this.gripe = gripe;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
