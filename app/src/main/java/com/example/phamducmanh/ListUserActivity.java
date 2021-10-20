package com.example.phamducmanh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListUserActivity extends AppCompatActivity {
    AppDatabase db;
    private RecyclerView recyclerView;
    private List<UserEntity> listUser = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        db= AppDatabase.getAppDatabase(this);
        listUser=db.userDAO().getAllUser();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        UserAdapter userAdapter = new UserAdapter(this, listUser);

        recyclerView = findViewById(R.id.rvList);
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}