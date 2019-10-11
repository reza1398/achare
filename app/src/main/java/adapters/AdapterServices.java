package adapters;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.achare.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import Models.OrderModel;
import my_info.Info;

/**
 * Created by Reza on 06/10/2016.
 */
public class AdapterServices extends RecyclerView.Adapter<AdapterServices.ViewHolder> {

    private Activity context;
    private List<OrderModel> list;
    private LayoutInflater layoutInflater;
    Info info;

    public AdapterServices(Activity context, List<OrderModel> list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
        info = new Info(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.row_services, parent, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final OrderModel model = list.get(position);
        holder.txtService.setText(model.getTitle());

        try {
            InputStream ims = context.getAssets().open("images/" + model.getImg() + ".png");
            Drawable d = Drawable.createFromStream(ims, null);
            holder.imgService.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout Row;
        ImageView imgService;
        TextView txtService;

        public ViewHolder(View itemView) {
            super(itemView);

            Row = (LinearLayout) itemView.findViewById(R.id.Row);
            imgService = (ImageView) itemView.findViewById(R.id.imgService);
            txtService = (TextView) itemView.findViewById(R.id.txtService);
        }
    }

}
