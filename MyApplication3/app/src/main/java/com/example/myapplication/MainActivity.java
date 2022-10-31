package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    ArrayList<FilmModel> FilmModel = new ArrayList<>();
    int[] FilmImage = {R.drawable.ironman1, R.drawable.ironman2, R.drawable.ironman3};
    Button firstFragmentbtn, secondFragmentbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.mRecycleView);
        setUpFilmModel();
        FM_RecyclerViewAdapter adapter = new FM_RecyclerViewAdapter(this, FilmModel, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        firstFragmentbtn = findViewById(R.id.fragment1btn);
        secondFragmentbtn = findViewById(R.id.fragment2btn);
        fragment2 f2 = new fragment2();
        firstFragmentbtn.setOnClickListener(view -> {
            Log.d("TAG", "onCreate: ");
            getSupportFragmentManager().beginTransaction().remove(f2).commit();

        });
        secondFragmentbtn.setOnClickListener(view -> replaceFragment(f2));

    }

    private void setUpFilmModel() {
        String[] FilmNames = getResources().getStringArray(R.array.film_name);
        String[] Types = getResources().getStringArray(R.array.film_types);
        String[] Price = getResources().getStringArray(R.array.film_price);
        String[] rating = getResources().getStringArray(R.array.film_rating);
        String[] description = getResources().getStringArray(R.array.film_description);
        String[] Link = getResources().getStringArray(R.array.film_url);

        for (int i = 0; i < FilmNames.length; i++) {
            FilmModel.add(new FilmModel(FilmNames[i],
                    Types[i],
                    Price[i],
                    FilmImage[i],
                    Float.parseFloat(rating[i]),
                    description[i],
                    Link[i]));
        }
        FilmModel.sort((a, b) -> Float.compare(a.getRating(), b.getRating()));
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);

        fragmentTransaction.commit();

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("Name", FilmModel.get(position).getFilmName());
        intent.putExtra("Types", FilmModel.get(position).getTypes());
        intent.putExtra("Price", FilmModel.get(position).getPrice());
        intent.putExtra("Image", FilmModel.get(position).getImage());
        intent.putExtra("Rating", FilmModel.get(position).getRating());
        intent.putExtra("Description", FilmModel.get(position).getDescription());
        intent.putExtra("Link",FilmModel.get(position).getLink());

        startActivity(intent);



    }

    public String array2string(ArrayList<FilmModel> cars) {
        String s = "";
        for (FilmModel i : cars) {
            s += "" + i;
        }
        return s;
    }
}


