package adapters;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.achare.R;
import com.bumptech.glide.Glide;

import java.util.List;

import Models.OrderModel;
import fragments.Order;
import my_info.Info;

/**
 * Created by Reza on 06/10/2016.
 */
public class AdapterCity extends RecyclerView.Adapter<AdapterCity.ViewHolder> {

    private Activity context;
    private List<OrderModel> list;
    private LayoutInflater layoutInflater;
    Info info;

    public AdapterCity(Activity context, List<OrderModel> list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
        info = new Info(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.row_city, parent, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final OrderModel model = list.get(position);
        holder.txtCity.setText(model.getTitle());

        holder.Row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.closeMenu(Order.bottomSheetCity);
                Order.txtChoosedCity.setText(model.getTitle());
            }
        });
    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout Row;
        TextView txtCity;

        public ViewHolder(View itemView) {
            super(itemView);

            Row = (RelativeLayout) itemView.findViewById(R.id.Row);
            txtCity = (TextView) itemView.findViewById(R.id.txtCity);
        }
    }

}
