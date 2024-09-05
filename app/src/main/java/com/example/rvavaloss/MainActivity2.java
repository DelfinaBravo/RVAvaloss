package com.example.rvavaloss;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity2 extends AppCompatActivity {
    ImageView img;
    TextView tv1, tv2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Enlazar vistas
        img = findViewById(R.id.img);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);

        // Obtener los datos pasados desde ModelRecyclerView
        Intent intent = getIntent();
        if (intent != null) {
            int imageResId = intent.getIntExtra("imagen", -1);
            String name = intent.getStringExtra("nombre");
            String description = intent.getStringExtra("descripcion");

            // Asignar los valores a las vistas
            if (imageResId != -1) {
                img.setImageResource(imageResId);
            }
            tv1.setText(name);
            tv2.setText(description);
        }
    }
}
