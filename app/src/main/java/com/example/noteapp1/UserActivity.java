package com.example.noteapp1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.noteapp1.data.User;
import com.example.noteapp1.data.UserDatabase;

import java.util.List;


public class UserActivity extends AppCompatActivity {

    private UserDatabase userDatabase;
    private List<User> userList;
    private UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        RecyclerView recyclerView = findViewById(R.id.myrecycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userDatabase = Room.databaseBuilder(getApplicationContext(),
                UserDatabase.class, "user").build();

        userList = (List<User>) userDatabase.userDAO().getAll();

        userAdapter = new UserAdapter(userList);

        recyclerView.setAdapter(userAdapter);


    }
}