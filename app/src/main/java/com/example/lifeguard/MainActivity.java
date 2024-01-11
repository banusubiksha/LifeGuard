package com.example.lifeguard;

import static android.os.Build.VERSION_CODES.R;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    AboutFragment firstFragment = new AboutFragment();
    HomeFragment secondFragment = new HomeFragment();
    NearbyFragment thirdFragment = new NearbyFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        // Replace R.id.about with the actual ID you assigned to the "about" menu item
        bottomNavigationView.setSelectedItemId(R.id.home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
            if(itemId==R.id.about) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.bottomNavigationView, firstFragment)
                        .commit();
                return true;
            }
        else if(itemId==R.id.home) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.bottomNavigationView, secondFragment)
                        .commit();
                return true;
            }

            else if(itemId==R.id.nearby) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.bottomNavigationView, thirdFragment)
                        .commit();
                return true;
            }

        return false;
    }
}

