package com.example.rvavaloss;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Model> arrayList = new ArrayList<>();
    ImageButton menuBtn;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuBtn = findViewById(R.id.menu_btn);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList.add(new Model(R.drawable.delfina,"Delfina","Estudiante, fan de los idiomas y amante del cielo (preferentemente en Europa\uD83C\uDF0D). \nTengo 19 años, detesto a los animales como mascota y me gusta cantar\uD83C\uDFA4\uD83C\uDFA7."));
        arrayList.add(new Model(R.drawable.lautii,"Lautaro","Lautaro, sex symbol, anti-gordas\uD83D\uDEAB. \nNací por mi mamá, moriré por la timba."));
        arrayList.add(new Model(R.drawable.laza,"Lazaro","Lazaro Perviu, 18 años. \nJugador de township , php devel, fan de abel pintos, semi skater.\nHago las pp en react native y uso Arch(Linux distro)."));
        arrayList.add(new Model(R.drawable.lean,"Leandro","Leandro Bertolotti ,18 años. \nGym rat, diseñador gráfico, programador, modelo, futuro ingeniero en sistemas. \nAnti gordas, fan de maria becerra."));
        arrayList.add(new Model(R.drawable.fer,"Fernanda","Fernanda, swiftie, tinista y chismosa oficial.\nPróxima publicista, viviendo la vida al máximo y sin filtros."));

        ModelRecyclerView modelRecyclerView = new ModelRecyclerView(this,arrayList);
        recyclerView.setAdapter(modelRecyclerView);


        menuBtn.setOnClickListener(v -> showMenu());
    }

    private void showMenu() {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, menuBtn);
        popupMenu.getMenu().add("Logout");
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                String title = item.getTitle().toString();
                if (title.equals("Logout")) {
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                    return true;
                } else{
                    return false;
                }

            }
        });

    }


}
