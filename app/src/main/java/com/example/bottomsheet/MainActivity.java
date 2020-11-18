package com.example.bottomsheet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(view -> showBottomSheet());

    }

    private void showBottomSheet() {
        BottomSheetFragment bottomFragment = new BottomSheetFragment();
        bottomFragment.show(getSupportFragmentManager(), bottomFragment.getTag());
    }
}