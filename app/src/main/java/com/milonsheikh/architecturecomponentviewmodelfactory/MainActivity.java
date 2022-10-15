package com.milonsheikh.architecturecomponentviewmodelfactory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MainViewModel viewModel;
    TextView tvScoreA, tvScoreB;
    Button btnPlayerA, btnPlayerB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


        /**
         * initialized ViewModel
         */

        MainViewModelFactory factory = new MainViewModelFactory(5,15);
        viewModel = new ViewModelProvider(this,factory).get(MainViewModel.class);

        /**
         * set initial counter from view model
         */

        tvScoreA.setText(String.valueOf(viewModel.getInitialCountA()));
        tvScoreB.setText(String.valueOf(viewModel.getInitialCountB()));
    }

    private void initView() {
        // initialized all views here
        tvScoreA = findViewById(R.id.tvScorePlayerA);
        tvScoreB = findViewById(R.id.tvScorePlayerB);
        btnPlayerA = findViewById(R.id.btnPlayerA);
        btnPlayerB = findViewById(R.id.btnPlayerB);
        btnPlayerA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvScoreA.setText(String.valueOf(viewModel.getCurrentCountA()));
            }
        });
        btnPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvScoreB.setText(String.valueOf(viewModel.getCurrentCountB()));
            }
        });
    }
}