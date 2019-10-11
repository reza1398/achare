package my_info;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import Models.OrderModel;
import adapters.AdapterCity;
import adapters.AdapterOrder;
import adapters.AdapterServices;

public class database {

    Context context;
    String [] TitleOrder,ImgOrder ,TitleWash,ImgWash, TitleServices,ImgServices, City;
    int[] IdOrder,IdWash;

    public database(Context context) {
        this.context = context;
    }


    private void getOrder(){
        TitleOrder = new String[]{"نظافت راه پله","نظافت منزل","نظافت محل کار"};
        ImgOrder = new String[]{"https://blog.cobal.ir/wp-content/uploads/2018/08/%D9%86%D8%B8%D8%A7%D9%81%D8%AA-%D8%B1%D8%A7%D9%87-%D9%BE%D9%84%D9%87.jpg",
                "https://ariapak.com/wp-content/uploads/2018/05/%D8%AA%D9%86%D8%B8%D9%8A%D9%81.jpg",
                "https://homeservize.com/blog1/wp-content/uploads/2019/06/cleaning-workplace.jpg"};
        IdOrder = new int[]{1,2,3};
    }


    private void getWash(){
        TitleWash = new String[]{"قالیشویی","مبل شویی"};
        ImgWash = new String[]{"https://espard.com/mag/wp-content/uploads/2018/09/carpet-cleaning-crew-810x473.jpg",
                "https://espard.com/mag/wp-content/uploads/2018/08/sofa-cleaning-services-810x473.jpg"};
        IdWash = new int[]{1,2};
    }


    private void getServices(){
        TitleServices = new String[]{"نظافت و پذیرایی","شستشو","سرمایش و گرمایش","دکوراسیون و بازسازی",
                "لوله کشی","لوازم خانگی","برقکاری","کارواش","باربری و جابجایی"};
        ImgServices = new String[]{"a1","a2","a3","a4","a5","a6","a7","a8","a9"};
    }


    private void getCity(){
        City = new String[]{"تهران","اصفهان","مشهد","کرج","تبریز","شیراز","قزوین","کرمانشاه",
                "ساری","قم","یزد","کیش","ارومیه","شهرکرد","همدان","ایلام","سنندج","اهواز","خرم آباد"
                ,"رشت","بیرجند","بنجورد","زاهدان","بوشهر","کرمان","سمنان"};
    }


    public List<OrderModel> getDataOrder() {
        getOrder();
        List<OrderModel> list = new ArrayList<>();
        for (int i=0; i<TitleOrder.length; i++){
            OrderModel model = new OrderModel();
            model.setTitle(TitleOrder[i]);
            model.setImg(ImgOrder[i]);
            model.setId(IdOrder[i]);
            list.add(model);
        }
        return list;
    }


    public List<OrderModel> getDataWash() {
        getWash();
        List<OrderModel> list = new ArrayList<>();
        for (int i=0; i<TitleWash.length; i++){
            OrderModel model = new OrderModel();
            model.setTitle(TitleWash[i]);
            model.setImg(ImgWash[i]);
            model.setId(IdWash[i]);
            list.add(model);
        }
        return list;
    }


    public List<OrderModel> getDataServices() {
        getServices();
        List<OrderModel> list = new ArrayList<>();
        for (int i=0; i<TitleServices.length; i++){
            OrderModel model = new OrderModel();
            model.setTitle(TitleServices[i]);
            model.setImg(ImgServices[i]);
            list.add(model);
        }
        return list;
    }


    public List<OrderModel> getDataCity() {
        getCity();
        List<OrderModel> list = new ArrayList<>();
        for (int i=0; i<City.length; i++){
            OrderModel model = new OrderModel();
            model.setTitle(City[i]);
            list.add(model);
        }
        return list;
    }


    public void setDataLimitOrder(RecyclerView recyclerView, int rowNum){
        ArrayList arrayList = new ArrayList<>();
        AdapterOrder adapterOrder = new AdapterOrder((Activity) context, arrayList);
        LinearLayoutManager llm = new LinearLayoutManager((Activity) context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapterOrder);
        llm.setReverseLayout(true);

        switch (rowNum){
            case 1:
                arrayList.addAll(getDataOrder());
                break;
            case 2:
                arrayList.addAll(getDataWash());
                break;
        }
        adapterOrder.notifyDataSetChanged();
    }


    public void setDataCity(RecyclerView recyclerView){
        ArrayList arrayList = new ArrayList<>();
        AdapterCity adapterCity = new AdapterCity((Activity) context, arrayList);
        LinearLayoutManager llm = new LinearLayoutManager((Activity) context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapterCity);
        arrayList.addAll(getDataCity());
        adapterCity.notifyDataSetChanged();
    }


    public void setDataServices(RecyclerView recyclerView){
        ArrayList arrayList = new ArrayList<>();
        AdapterServices adapterServices = new AdapterServices((Activity) context, arrayList);
        GridLayoutManager layoutManager = new GridLayoutManager(context, GridLayoutManager.VERTICAL);
        layoutManager.setSpanCount(3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterServices);

        arrayList.addAll(getDataServices());
        adapterServices.notifyDataSetChanged();
    }
}
