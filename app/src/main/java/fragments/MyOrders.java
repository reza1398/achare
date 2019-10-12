package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.achare.BottomNavigationViewPager;
import com.achare.R;
import my_info.Info;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyOrders extends Fragment implements View.OnClickListener{

    TextView btnCurrentOrders,btnPastOrders;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    Info info;

    public MyOrders() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_orders, container, false);
        info = new Info(getActivity());
        init(view);
        setFragments();

        return view;
    }


    private void init(View view){
        btnCurrentOrders = view.findViewById(R.id.btnCurrentOrders);
        btnPastOrders = view.findViewById(R.id.btnPastOrders);
        viewPager = view.findViewById(R.id.viewPager);

        btnCurrentOrders.setOnClickListener(this);
        btnPastOrders.setOnClickListener(this);
    }


    private void setFragments() {
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragments(new CurrentOrders(), "جاری"); // 0
        viewPagerAdapter.addFragments(new PastOrders(), "گذشته"); // 1
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setCurrentItem(0, false);
    }


    private void getFragment(int index) {
        if (viewPager.getCurrentItem() != index) {
            viewPager.setCurrentItem(index, false);
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCurrentOrders:
                info.activeTab(btnCurrentOrders, btnPastOrders);
                getFragment(0);
                break;
            case R.id.btnPastOrders:
                info.activeTab(btnPastOrders, btnCurrentOrders);
                getFragment(1);
                break;
        }
    }
}
