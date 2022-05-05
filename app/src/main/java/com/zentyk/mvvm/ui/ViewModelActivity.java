package com.zentyk.mvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.zentyk.mvvm.R;
import com.zentyk.mvvm.util.Sumar;
import com.zentyk.mvvm.viewmodel.SumarViewModel;

public class ViewModelActivity extends AppCompatActivity {

    private TextView tvSumar;
    private TextView tvSumarVModel;
    private Button btSumar;
    private int result;
    private SumarViewModel sumarViewModel;

    //#region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);
        Log.d("onCreate", "onCreate()");
        SetUpView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy", "onDestroy()");
    }
    //#endregion

    private void SetUpView() {
        sumarViewModel = ViewModelProviders.of(this).get(SumarViewModel.class);

        tvSumar = findViewById(R.id.tvSumar);
        tvSumarVModel = findViewById(R.id.tvSumarViewModel);
        btSumar = findViewById(R.id.btSumar);

        btSumar.setOnClickListener(v -> {
            result = Sumar.Sumar(result);
            tvSumar.setText(String.valueOf(result));

            sumarViewModel.SetResult(Sumar.Sumar(sumarViewModel.GetResult()));
            tvSumarVModel.setText(String.valueOf(sumarViewModel.GetResult()));
        });
    }
}