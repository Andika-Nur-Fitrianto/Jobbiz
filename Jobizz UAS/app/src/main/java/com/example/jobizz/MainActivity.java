package com.example.jobizz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jobizz.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ActivityMainBinding binding;
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    SharedPreferences sharedPreferences;
    TextView tv_nama, tv_work, cek;
    String url, ex, ed, cv1jobrole, cv1office, cv1type, cv1time, cv1junior, cv1location, cv1salary,
            cv1jobdesc, cv1jobreq, cv1jobabout, cv1fileimage, cv1loc, cv1link,
            cv2jobrole, cv2office, cv2type, cv2time, cv2junior, cv2location, cv2salary,
            cv2jobdesc, cv2jobreq, cv2jobabout, cv2fileimage, cv2loc, cv2link,
            cv3jobrole, cv3office, cv3type, cv3time, cv3junior, cv3location, cv3salary,
            cv3jobdesc, cv3jobreq, cv3jobabout, cv3fileimage, cv3loc, cv3link,
            jp1jobrole, jp1office, jp1type, jp1time, jp1junior, jp1location, jp1salary,
            jp1jobdesc, jp1jobreq, jp1jobabout, jp1fileimage, jp1loc, jp1link,
            jp2jobrole, jp2office, jp2type, jp2time, jp2junior, jp2location, jp2salary,
            jp2jobdesc, jp2jobreq, jp2jobabout, jp2fileimage, jp2loc, jp2link;
    StringRequest stringRequest;
    NavigationView navigationView;
    View headerview;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("Jobizz App.", MODE_PRIVATE);
        if(sharedPreferences.getString("logged", "false").equals("false")){
            startActivity(new Intent(getApplicationContext(), login.class));
            finish();
        }

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        navigationView = findViewById(R.id.navigation_drawer);
        headerview = navigationView.getHeaderView(0);
        tv_nama = headerview.findViewById(R.id.tv_head_uname);
        tv_work = headerview.findViewById(R.id.tv_head_work);
        //tv_nama.setText(sharedPreferences.getString("nama",""));
        tv_nama.setText(sharedPreferences.getString("nama",""));
        tv_work.setText(sharedPreferences.getString("jr",""));

        queue = Volley.newRequestQueue(getApplicationContext());

        //get data personal info
        url ="https://jobizz123.000webhostapp.com/api_persinfo.php";
        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            ex = jsonObject.getString("ed");
                            ed = jsonObject.getString("ex");
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("ex",ex);
                            editor.putString("ed",ed);
                            editor.apply();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            protected Map<String, String> getParams(){
                Map<String, String> paramV = new HashMap<>();
                paramV.put("id", sharedPreferences.getString("id", ""));
                paramV.put("apikey", sharedPreferences.getString("apikey", ""));
                return paramV;
            }
        };
        queue.add(stringRequest);
        //get data personal info

        //get data featured & popular jobs
        url ="https://jobizz123.000webhostapp.com/api_featjobs.php";
        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            cv1jobrole = jsonObject.getString("cv1jobrole");
                            cv1office = jsonObject.getString("cv1office");
                            cv1type = jsonObject.getString("cv1type");
                            cv1time = jsonObject.getString("cv1time");
                            cv1junior = jsonObject.getString("cv1junior");
                            cv1location = jsonObject.getString("cv1location");
                            cv1salary = jsonObject.getString("cv1salary");
                            cv1jobdesc = jsonObject.getString("cv1jobdesc");
                            cv1jobreq = jsonObject.getString("cv1jobreq");
                            cv1jobabout = jsonObject.getString("cv1jobabout");
                            cv1fileimage = jsonObject.getString("cv1fileimage");
                            cv1loc = jsonObject.getString("cv1loc");
                            cv1link = jsonObject.getString("cv1link");
                            //cv2
                            cv2jobrole = jsonObject.getString("cv2jobrole");
                            cv2office = jsonObject.getString("cv2office");
                            cv2type = jsonObject.getString("cv2type");
                            cv2time = jsonObject.getString("cv2time");
                            cv2junior = jsonObject.getString("cv2junior");
                            cv2location = jsonObject.getString("cv2location");
                            cv2salary = jsonObject.getString("cv2salary");
                            cv2jobdesc = jsonObject.getString("cv2jobdesc");
                            cv2jobreq = jsonObject.getString("cv2jobreq");
                            cv2jobabout = jsonObject.getString("cv2jobabout");
                            cv2fileimage = jsonObject.getString("cv2fileimage");
                            cv2loc = jsonObject.getString("cv2loc");
                            cv2link = jsonObject.getString("cv2link");
                            //cv3
                            cv3jobrole = jsonObject.getString("cv3jobrole");
                            cv3office = jsonObject.getString("cv3office");
                            cv3type = jsonObject.getString("cv3type");
                            cv3time = jsonObject.getString("cv3time");
                            cv3junior = jsonObject.getString("cv3junior");
                            cv3location = jsonObject.getString("cv3location");
                            cv3salary = jsonObject.getString("cv3salary");
                            cv3jobdesc = jsonObject.getString("cv3jobdesc");
                            cv3jobreq = jsonObject.getString("cv3jobreq");
                            cv3jobabout = jsonObject.getString("cv3jobabout");
                            cv3fileimage = jsonObject.getString("cv3fileimage");
                            cv3loc = jsonObject.getString("cv3loc");
                            cv3link = jsonObject.getString("cv3link");
                            //jp1
                            jp1jobrole = jsonObject.getString("jp1jobrole");
                            jp1office = jsonObject.getString("jp1office");
                            jp1type = jsonObject.getString("jp1type");
                            jp1time = jsonObject.getString("jp1time");
                            jp1junior = jsonObject.getString("jp1junior");
                            jp1location = jsonObject.getString("jp1location");
                            jp1salary = jsonObject.getString("jp1salary");
                            jp1jobdesc = jsonObject.getString("jp1jobdesc");
                            jp1jobreq = jsonObject.getString("jp1jobreq");
                            jp1jobabout = jsonObject.getString("jp1jobabout");
                            jp1fileimage = jsonObject.getString("jp1fileimage");
                            jp1loc = jsonObject.getString("jp1loc");
                            jp1link = jsonObject.getString("jp1link");
                            //jp2
                            jp2jobrole = jsonObject.getString("jp2jobrole");
                            jp2office = jsonObject.getString("jp2office");
                            jp2type = jsonObject.getString("jp2type");
                            jp2time = jsonObject.getString("jp2time");
                            jp2junior = jsonObject.getString("jp2junior");
                            jp2location = jsonObject.getString("jp2location");
                            jp2salary = jsonObject.getString("jp2salary");
                            jp2jobdesc = jsonObject.getString("jp2jobdesc");
                            jp2jobreq = jsonObject.getString("jp2jobreq");
                            jp2jobabout = jsonObject.getString("jp2jobabout");
                            jp2fileimage = jsonObject.getString("jp2fileimage");
                            jp2loc = jsonObject.getString("jp2loc");
                            jp2link = jsonObject.getString("jp2link");
                            
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("cv1jobrole",cv1jobrole);
                            editor.putString("cv1office",cv1office);
                            editor.putString("cv1type",cv1type);
                            editor.putString("cv1time",cv1time);
                            editor.putString("cv1junior",cv1junior);
                            editor.putString("cv1location",cv1location);
                            editor.putString("cv1salary",cv1salary);
                            editor.putString("cv1jobdesc",cv1jobdesc);
                            editor.putString("cv1jobreq",cv1jobreq);
                            editor.putString("cv1jobabout",cv1jobabout);
                            editor.putString("cv1fileimage",cv1fileimage);
                            editor.putString("cv1loc",cv1loc);
                            editor.putString("cv1link",cv1link);
                            //cv2
                            editor.putString("cv2jobrole",cv2jobrole);
                            editor.putString("cv2office",cv2office);
                            editor.putString("cv2type",cv2type);
                            editor.putString("cv2time",cv2time);
                            editor.putString("cv2junior",cv2junior);
                            editor.putString("cv2location",cv2location);
                            editor.putString("cv2salary",cv2salary);
                            editor.putString("cv2jobdesc",cv2jobdesc);
                            editor.putString("cv2jobreq",cv2jobreq);
                            editor.putString("cv2jobabout",cv2jobabout);
                            editor.putString("cv2fileimage",cv2fileimage);
                            editor.putString("cv2loc",cv2loc);
                            editor.putString("cv2link",cv2link);
                            //cv3
                            editor.putString("cv3jobrole",cv3jobrole);
                            editor.putString("cv3office",cv3office);
                            editor.putString("cv3type",cv3type);
                            editor.putString("cv3time",cv3time);
                            editor.putString("cv3junior",cv3junior);
                            editor.putString("cv3location",cv3location);
                            editor.putString("cv3salary",cv3salary);
                            editor.putString("cv3jobdesc",cv3jobdesc);
                            editor.putString("cv3jobreq",cv3jobreq);
                            editor.putString("cv3jobabout",cv3jobabout);
                            editor.putString("cv3fileimage",cv3fileimage);
                            editor.putString("cv3loc",cv3loc);
                            editor.putString("cv3link",cv3link);
                            //jp1
                            editor.putString("jp1jobrole",jp1jobrole);
                            editor.putString("jp1office",jp1office);
                            editor.putString("jp1type",jp1type);
                            editor.putString("jp1time",jp1time);
                            editor.putString("jp1junior",jp1junior);
                            editor.putString("jp1location",jp1location);
                            editor.putString("jp1salary",jp1salary);
                            editor.putString("jp1jobdesc",jp1jobdesc);
                            editor.putString("jp1jobreq",jp1jobreq);
                            editor.putString("jp1jobabout",jp1jobabout);
                            editor.putString("jp1fileimage",jp1fileimage);
                            editor.putString("jp1loc",jp1loc);
                            editor.putString("jp1link",jp1link);
                            //jp2
                            editor.putString("jp2jobrole",jp2jobrole);
                            editor.putString("jp2office",jp2office);
                            editor.putString("jp2type",jp2type);
                            editor.putString("jp2time",jp2time);
                            editor.putString("jp2junior",jp2junior);
                            editor.putString("jp2location",jp2location);
                            editor.putString("jp2salary",jp2salary);
                            editor.putString("jp2jobdesc",jp2jobdesc);
                            editor.putString("jp2jobreq",jp2jobreq);
                            editor.putString("jp2jobabout",jp2jobabout);
                            editor.putString("jp2fileimage",jp2fileimage);
                            editor.putString("jp2loc",jp2loc);
                            editor.putString("jp2link",jp2link);
                            editor.apply();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            protected Map<String, String> getParams(){
                Map<String, String> paramV = new HashMap<>();
                paramV.put("id", sharedPreferences.getString("id", ""));
                paramV.put("apikey", sharedPreferences.getString("apikey", ""));
                return paramV;
            }
        };
        queue.add(stringRequest);
        //get data featured jobs

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer,
                R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_drawer);
        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView = findViewById(R.id.bottom_Navigation);
        bottomNavigationView.setBackground(null);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //                int itemId = item.getItemId();
//                if(itemId==R.id.Home) {
//                    openFragment(new HomeFragment());
//                    return true;
//                }
                switch (item.getItemId()) {
                    case R.id.Home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                        break;
                    case R.id.Message:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessagesFragment()).commit();
                        break;
                    case R.id.Bookmark:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BookmarkFragment()).commit();
                        break;
                    case R.id.category:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CategoryFragment()).commit();
                        break;
                }
                return true;
            }
        });

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.Home);
        }

        //tab layout viewpager
//        pagerAdapter = new ViewPager

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                break;
            case R.id.pers_info:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PersinfoFragment()).commit();
                break;
            case R.id.app:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AppsFragment()).commit();
                break;
            case R.id.prop:
                Mapsku Mapsku = new Mapsku();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, Mapsku).commit();
                break;
            case R.id.resume:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ResumeFragment()).commit();
                break;
            case R.id.portfolio:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PortfolioFragment()).commit();
                break;
            case R.id.coverlet:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CovlettFragment()).commit();
                break;
            case R.id.setting:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
                break;
            case R.id.logout:
                url ="http://localhost/192.168.100.5/jobizzphp/api_logout.php";
                //cek = findViewById(R.id.tv_cek);
                stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("sukses")) {
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("logged", "");
                                    editor.putString("nama", "");
                                    editor.putString("email", "");
                                    editor.putString("apikey", "");
                                    editor.putString("jr", "");
//                                    editor.putString("ed", "");
//                                    editor.putString("ex", "");
                                    editor.apply();
                                    //cek.setText(response);
                                    Toast.makeText(MainActivity.this, "Logout success", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), login.class));
                                    finish();
                                } else {
                                    Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                                    cek.setText(response);
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }) {
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("email", sharedPreferences.getString("email", ""));
                        paramV.put("apikey", sharedPreferences.getString("apikey", ""));
                        return paramV;
                    }
                };
                queue.add(stringRequest);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}