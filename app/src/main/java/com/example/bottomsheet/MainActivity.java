package com.example.bottomsheet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    Button btn;

    LinearLayout bottom_sheet_layout;
    RelativeLayout bottom_sheet_header;
    BottomSheetBehavior<LinearLayout> sheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(view -> showFragmentBottomSheet());





        setMainActivityBottomSheet();




    }



    private void showFragmentBottomSheet() {
        BottomSheetFragment bottomFragment = new BottomSheetFragment();
        bottomFragment.show(getSupportFragmentManager(), bottomFragment.getTag());
    }



    private void setMainActivityBottomSheet() {
        bottom_sheet_layout = findViewById(R.id.bottom_sheet_layout);
        bottom_sheet_header = findViewById(R.id.bottom_sheet_header);
        sheetBehavior = BottomSheetBehavior.from(bottom_sheet_layout);



        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {
            if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            } else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        }, 1000);



        handler.postDelayed(() -> {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            if (sheetBehavior.getState() != BottomSheetBehavior.STATE_COLLAPSED) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            } else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        }, 4000);



        bottom_sheet_header.setOnClickListener(v -> {
            if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            } else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });



//        sheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
//            @Override
//            public void onStateChanged(@NonNull View bottomSheet, int newState) {}
//            @Override
//            public void onSlide(@NonNull View bottomSheet, float slideOffset) {}
//        });



    }
}