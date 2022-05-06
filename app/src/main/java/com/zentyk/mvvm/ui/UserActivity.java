package com.zentyk.mvvm.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.zentyk.mvvm.R;
import com.zentyk.mvvm.model.User;
import com.zentyk.mvvm.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    private EditText edName;
    private EditText edAge;
    private Button btnSaveUser;
    private Button btnReadUser;
    private TextView tvUser;
    private TextView tvUserViewModel;

    private List<User> userList;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        setupView();
    }

    private void setupView() {
        userViewModel = new ViewModelProviders().of(this).get(UserViewModel.class);
        userList = new ArrayList<>();

        tvUser = findViewById(R.id.tv_user);
        tvUserViewModel = findViewById(R.id.tv_userViewModel);

        edName = findViewById(R.id.etUser_name);
        edAge = findViewById(R.id.etUser_age);

        btnSaveUser = findViewById(R.id.btn_save);
        btnSaveUser.setOnClickListener(v -> {
            User user = new User();
            user.setName(edName.getText().toString());
            user.setAge(edAge.getText().toString());
            userList.add(user);
            userViewModel.AddUser(user);
        });

        btnReadUser = findViewById(R.id.btn_read);
        btnReadUser.setOnClickListener(v -> {
            String text = "";
            for (int i = 0; i < userList.size(); i++) {
                text += userList.get(i).getName() + " " + userList.get(i).getAge() + "\n";
            }
            tvUser.setText(text);
            text = "";
            for (User user : userViewModel.getUsersList()) {
                text += user.getName() + " - " + user.getAge() + "\n";
            }
            tvUserViewModel.setText(text);
        });
    }
}