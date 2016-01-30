package com.andela.cakeoderingapp.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.andela.cakeoderingapp.R;
import com.andela.cakeoderingapp.adapter.ViewPagerAdapter;
import com.andela.cakeoderingapp.dal.CakeDatacollection;
import com.andela.cakeoderingapp.dal.DataCallback;
import com.andela.cakeoderingapp.fragment.CakeFragment;
import com.andela.cakeoderingapp.models.Cake;
import com.andela.cakeoderingapp.models.Category;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "SAVE The Cake";
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = LayoutInflater.from(this).inflate(R.layout.nav_header_main, null);

        navigationView.addHeaderView(header);

        TextView emailText = (TextView)header.findViewById(R.id.email_text);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        setUpViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        saveCakes();
    }
    private void setUpViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new CakeFragment(), "Categories");
        viewPagerAdapter.addFragment(new CakeFragment(), "Featured");
        viewPagerAdapter.addFragment(new CakeFragment(), "All");
        viewPager.setAdapter(viewPagerAdapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void saveCategories() {
        Category category = new Category("8", "Homestyle pies");
        category.setImageUrl("http://res.cloudinary.com/dzvxhhjz1/image/upload/v1454082911/Categories/homestyle_pies.jpg");
                category.setDescription("Celebrate with family, friends and Carousel Cakes...");
        CakeDatacollection<Category> col = new CakeDatacollection<>("categories", Category.class);
        col.save(category, new DataCallback<Category>() {
            @Override
            public void onSuccess(Category value) {

            }

            @Override
            public void onError(String error) {

            }
        });


    }

    public void saveCakes() {
        Cake cake1 = new Cake("007", "Brown Cheese");
        cake1.setPrice("N 5,000");
        cake1.setSnapshot("http://res.cloudinary.com/dzvxhhjz1/image/upload/c_scale,h_375,w_400/v1454064267/cakes/wed006.jpg");
        cake1.setCategory("Wedding cake");
        CakeDatacollection<Cake> col = new CakeDatacollection<>("cakes", Cake.class);
        col.save(cake1, new DataCallback<Cake>() {
            @Override
            public void onSuccess(Cake value) {
                Log.d(TAG, value.getSnapshot());
            }

            @Override
            public void onError(String error) {

            }
        });

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        if (id == R.id.nav_camara) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
