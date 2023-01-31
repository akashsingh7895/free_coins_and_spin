package com.avssolutiion.autoheadshot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.avssolutiion.autoheadshot.databinding.ActivityDailyPassBinding;

public class DailyPassActivity extends AppCompatActivity {

    ActivityDailyPassBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_pass);
        binding = ActivityDailyPassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.claimButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DailyPassActivity.this, "Insufficient Coins", Toast.LENGTH_LONG).show();
            }
        });

    }
}