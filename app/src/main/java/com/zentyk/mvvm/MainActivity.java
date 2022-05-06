package com.zentyk.mvvm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.zentyk.mvvm.ui.DataBindingActivity;
import com.zentyk.mvvm.ui.LiveDataActivity;
import com.zentyk.mvvm.ui.LiveDataBinding;
import com.zentyk.mvvm.ui.UserActivity;
import com.zentyk.mvvm.ui.ViewModelActivity;

public class MainActivity extends AppCompatActivity {

    private Button btViewModel;
    private Button btUserViewModel;
    private Button btLiveData;
    private Button btDataBinding;
    private Button btDBLABinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        SetupViews();
    }

    private void SetupViews() {
        btViewModel = findViewById(R.id.btViewModel);
        btUserViewModel = findViewById(R.id.btUserViewModel);
        btLiveData = findViewById(R.id.btLiveData);
        btDataBinding = findViewById(R.id.btDataBinding);
        btDBLABinding = findViewById(R.id.btDBLABinding);

        btViewModel.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), ViewModelActivity.class));
        });
        btUserViewModel.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), UserActivity.class));
        });
        btLiveData.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), LiveDataActivity.class));
        });
        btDataBinding.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), DataBindingActivity.class));
        });
        btDBLABinding.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), LiveDataBinding.class));
        });
    }
}