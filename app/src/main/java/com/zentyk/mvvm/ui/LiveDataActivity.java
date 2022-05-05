package com.zentyk.mvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.zentyk.mvvm.R;
import com.zentyk.mvvm.model.User;
import com.zentyk.mvvm.viewmodel.LiveDataViewModel;

import java.util.List;

public class LiveDataActivity extends AppCompatActivity {
    private TextView tvLiveData;
    private Button btn_SaveData;
    private int n = 0;
    private LiveDataViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        setupViews();
    }

    private void setupViews() {
        viewModel = ViewModelProviders.of(this).get(LiveDataViewModel.class);
        tvLiveData = findViewById(R.id.tv_LiveData);
        btn_SaveData = findViewById(R.id.btn_save);
        btn_SaveData.setOnClickListener(v -> {
            if(n == 0) {
                User user = new User();
                user.setName("Alberto");
                user.setAge("30");
                Log.d("TAG1","numero0");
                viewModel.addUser(user);
            }
            if(n == 1) {
                User user = new User();
                user.setName("Juan");
                user.setAge("30");
                Log.d("TAG1","numero1");
                viewModel.addUser(user);
            }
            if(n == 2) {
                User user = new User();
                user.setName("Pedro");
                user.setAge("30");
                Log.d("TAG1","numero2");
                viewModel.addUser(user);
            }
            n++;
        });

        final Observer<List<User>> listObserver = new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                String  text = "";
                for(int i = 0; i < users.size(); i++) {
                    text += users.get(i).getName() + " " + users.get(i).getAge() + "\n";
                }
                tvLiveData.setText(text);
            }
        };

        viewModel.getUserList().observe(this, listObserver);
    }
}