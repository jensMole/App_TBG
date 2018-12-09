package com.belgiumgames.tbg.app_tbg;

import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // gebruik de toolbar als actionbar.
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Voor het aanmaken van het toggle icoontje.
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        // Icoontje laten draaien.
        toggle.syncState();

        // Als je de app opstart toon dan het home scherm en duid het eerste item aan in het menu.
        // De if statement kijkt na als er iets aanpast aan het systeem zodat deze niet steeds
        // terug gaat naar home. bv. Bij het draaien van het scherm.
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }


    @Override
    public void onBackPressed() {

        // Als het open staat dan gaan we het sluiten als je op terug drukt.
        // anders gaan we super oproepen.
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    // Als je een item klikt in het menu gaan we deze openen en de drawer sluiten.
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            // Commit gaat er voor zorgen zodat het fragment in de container wordt geplaatst.
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;
            case R.id.nav_video:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new VideoFragment()).commit();
                break;
            case R.id.nav_aankondigingen:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AankondigingenFragment()).commit();
                break;
            case R.id.nav_contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ContactFragment()).commit();
                break;

        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
