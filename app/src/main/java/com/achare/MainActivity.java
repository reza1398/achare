package com.achare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import fragments.Club;
import fragments.MyOrders;
import fragments.Order;
import fragments.Profile;
import fragments.ViewPagerAdapter;
import my_info.Info;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static ImageView i1,i2,i3,i4;
    public static TextView t1,t2,t3,t4;
    LinearLayout btnProfile,btnClub,btnMyOrders,btnOrder;
    BottomNavigationViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    Info info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = new Info(this);
        info.setMenuButtons();
        init();

        setFragments();
    }


    private void init(){
        viewPager = findViewById(R.id.viewPager);
        btnOrder = findViewById(R.id.btnOrder);
        btnMyOrders = findViewById(R.id.btnMyOrders);
        btnClub = findViewById(R.id.btnClub);
        btnProfile = findViewById(R.id.btnProfile);

        btnOrder.setOnClickListener(this);
        btnMyOrders.setOnClickListener(this);
        btnClub.setOnClickListener(this);
        btnProfile.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnOrder:
                info.activeTab(i1,t1,i2,i3,i4,t2,t3,t4);
                getFragment(0);
                break;
            case R.id.btnMyOrders:
                info.activeTab(i2,t2,i1,i3,i4,t1,t3,t4);
                getFragment(1);
                break;
            case R.id.btnClub:
                info.activeTab(i3,t3,i2,i1,i4,t2,t1,t4);
                getFragment(2);
                break;
            case R.id.btnProfile:
                info.activeTab(i4,t4,i2,i3,i1,t2,t3,t1);
                getFragment(3);
                break;
        }
    }



    private void setFragments() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new Order(), ""); // 0
        viewPagerAdapter.addFragments(new MyOrders(), ""); // 1
        viewPagerAdapter.addFragments(new Club(), ""); // 2
        viewPagerAdapter.addFragments(new Profile(), ""); // 3
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(5);
        viewPager.setCurrentItem(0, false);
    }


    private void getFragment(int index) {
        if (viewPager.getCurrentItem() != index) {
            viewPager.setCurrentItem(index, false);
            info.AnimFadeIn(this, R.id.viewPager);
        }
    }
}
