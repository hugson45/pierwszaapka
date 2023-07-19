package com.example.a2_apka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkbox1,checkbox2,checkbox3;
    private RadioGroup rgGlowny;
    private ProgressBar progressBar,progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkbox1 = findViewById(R.id.FirstCheckbox);
        checkbox2 = findViewById(R.id.SecondCheckBox);
        checkbox3 = findViewById(R.id.ThirdCheckbox);

        rgGlowny = findViewById(R.id.rgGlowny);
        int checkedbutton = rgGlowny.getCheckedRadioButtonId();

        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);
        progressBar2 = findViewById(R.id.progressbar2);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    progressBar2.incrementProgressBy((10));
                    SystemClock.sleep(500);
                }
            }
        });



        if (checkedbutton == R.id.rbMarried)
        {
            Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
        }
        if(checkedbutton == R.id.rbSingle)
        {
            Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();
        }
        if (checkedbutton == R.id.rbRelationship)
        {
            Toast.makeText(MainActivity.this, "In Relationship", Toast.LENGTH_SHORT).show();
        }

        rgGlowny.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.rbMarried)
                {
                    Toast.makeText(MainActivity.this, "Ładowanie w pętli", Toast.LENGTH_SHORT).show();

                    thread.start();

                }
                if(i == R.id.rbSingle)
                {
                    Toast.makeText(MainActivity.this, "Wyłącz Ładowanie", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.VISIBLE);
                }
                if (i == R.id.rbRelationship)
                {
                    Toast.makeText(MainActivity.this, "Pokaz Ładowanie", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(MainActivity.this, "Okno Zaznaczone", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MainActivity.this, "Okno Odznaczone", Toast.LENGTH_SHORT).show();
        }
}
    });
    }
}