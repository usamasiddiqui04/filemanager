package com.fyp.sofittest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.fyp.sofittest.Adapters.OrderPagerAdpaters;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeActivity extends AppCompatActivity {



    NavigationView navigationView ;
    Toolbar toolbar ;
    DrawerLayout drawerLayout ;
    ActionBarDrawerToggle actionBarDrawerToggle ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.main);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this , drawerLayout , R.string.open , R.string.close);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(Color.WHITE);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        navigationView = findViewById(R.id.navview);
        ViewPager2 viewPager2 = findViewById(R.id.vp);
        viewPager2.setAdapter( new OrderPagerAdpaters(this));

        TabLayout tableLayout = findViewById(R.id.tablayout);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tableLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position)
                {
                    case 0 :
                        tab.setText("Photos");
                        break;

                    case 1 :
                        tab.setText("Music");
                        break;

                    case 2 :
                        tab.setText("Video");
                        break;

                    case 3 :
                        tab.setText("Documents");
                        break;
                }

            }
        }
        );
        tabLayoutMediator.attach();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.fav)
                {
                    Intent intent = new Intent(HomeActivity.this , Favourite.class);
                    startActivity(intent);
                    Toast.makeText(HomeActivity.this, "Click", Toast.LENGTH_SHORT).show();
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true ;

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
            return true ;
        return super.onOptionsItemSelected(item);
    }

}
