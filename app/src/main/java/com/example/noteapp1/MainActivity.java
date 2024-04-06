package com.example.noteapp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.noteapp1.data.User;
import com.example.noteapp1.data.UserDAO;
import com.example.noteapp1.data.UserDatabase;

public class MainActivity extends AppCompatActivity {

    private Button createBtn;
    private EditText emailTxt;
    private EditText passwordTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_layout);
        //handlers threads
        setUI();

    }

    public void openUser() {
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }

    public void createUser(View view) {
       new Thread(new Runnable() {
           @Override
           public void run() {
               UserDatabase db = Room.databaseBuilder(getApplicationContext(),
                       UserDatabase.class, "user").build();
               UserDAO userDAO = db.userDAO();

               String email = emailTxt.getText().toString();
               String password = passwordTxt.getText().toString();
               User user = new User(email, password);
               userDAO.insert(user);

           }
       }).start();
    }

//    new Thread(new Runnable() throws {
//        @Override
//        public void run() {
//            UserDatabase db = Room.databaseBuilder(getApplicationContext(),
//                    UserDatabase.class, "user").build();
//
//            UserDAO userDAO = db.userDAO();
//
//            createBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    String email = emailTxt.getText().toString();
//                    String password = passwordTxt.getText().toString();
//
//                    User user = new User(email, password);
//
//                    userDAO.insert(user);
//                }
//            });
//        }
//    }).start();

    private void setUI(){
        createBtn = findViewById(R.id.createBtn);
        emailTxt = findViewById(R.id.emailTxt);
        passwordTxt = findViewById(R.id.passwordTxt);
    }
}