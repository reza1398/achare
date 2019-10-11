package fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.achare.R;

import my_info.Info;
import my_info.database;

/**
 * A simple {@link Fragment} subclass.
 */
public class Order extends Fragment implements View.OnClickListener{

    database db;
    Info info;
    RecyclerView listCity,recyAllServices,recy1,recy2;
    LinearLayout Loading,btnChooseCity,searchBar;
    ImageView btnClose;
    public static TextView txtChoosedCity;

    LinearLayout bottom_sheet_city;
    public static BottomSheetBehavior bottomSheetCity;
    CoordinatorLayout clCity;

    public Order() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        db = new database(getActivity());
        info = new Info(getActivity());
        init(view);

        bottomSheetCity = BottomSheetBehavior.from(bottom_sheet_city);
        bottomSheetCity.setPeekHeight(0);
        bottomSheetCity.setHideable(true);

        bottomSheetCity.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                    searchBar.setVisibility(View.VISIBLE);
                else
                    searchBar.setVisibility(View.INVISIBLE);
            }@Override public void onSlide(@NonNull View view, float v) {}
        });

        return view;
    }


    private void init(View view){
        bottom_sheet_city = view.findViewById(R.id.bottom_sheet_city);
        btnClose = view.findViewById(R.id.btnClose);
        clCity = view.findViewById(R.id.clCity);
        Loading = view.findViewById(R.id.Loading);
        searchBar = view.findViewById(R.id.searchBar);
        btnChooseCity = view.findViewById(R.id.btnChooseCity);
        recyAllServices = view.findViewById(R.id.recyAllServices);
        listCity = view.findViewById(R.id.listCity);
        recy1 = view.findViewById(R.id.recy1);
        recy2 = view.findViewById(R.id.recy2);
        txtChoosedCity = view.findViewById(R.id.txtChoosedCity);

        btnChooseCity.setOnClickListener(this);
        btnClose.setOnClickListener(this);

        db.setDataLimitOrder(recy1,1);
        db.setDataLimitOrder(recy2, 2);
        db.setDataServices(recyAllServices);
        db.setDataCity(listCity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Loading.setVisibility(View.INVISIBLE);
            }
        },3000);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnChooseCity:
                clCity.setVisibility(View.VISIBLE);
                info.openMenu(bottomSheetCity);
                break;

            case R.id.btnClose:
                info.closeMenu(bottomSheetCity);
                break;
        }
    }
}
