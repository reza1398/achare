package my_info;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;


import com.achare.MainActivity;
import com.achare.R;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import static android.content.Context.CLIPBOARD_SERVICE;


public class Info {

    Context context;
    Typeface myFont;
    public Info(Context context){
        this.context = context;
        myFont = Typeface.createFromAsset(context.getAssets(), "font/IRANYekanMobileRegular.ttf");
    }


    // ---------------------------
    // Check Internet Connection
    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null) {
            // There are no active networks.
            return false;
        } else {
            return true;
        }
    }



    // ---------------------------
    // Animations
    public void AnimFadeIn(final Activity activity, final int id){
        YoYo.with(Techniques.FadeIn)
                .duration(200)
                .playOn(activity.findViewById(id));
    }

    public void AnimFadeOut(final Activity activity, final int id){
        YoYo.with(Techniques.FadeOut)
                .duration(200)
                .playOn(activity.findViewById(id));
    }

    public void AnimZoomIn(final Activity activity, final int id){
        YoYo.with(Techniques.ZoomIn)
                .duration(180)
                .playOn(activity.findViewById(id));
    }

    public void AnimZoomOut(final Activity activity, final int id){
        YoYo.with(Techniques.ZoomOut)
                .duration(180)
                .playOn(activity.findViewById(id));
    }



    // ---------------------------
    // Open/Close Menu
    public void openMenu(BottomSheetBehavior bottomSheetBehavior){
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    public void closeMenu(BottomSheetBehavior bottomSheetBehavior){
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }


    // ---------------------------

    public void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

    // ---------------------------

    public void share(String str) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "");
        sendIntent.putExtra(Intent.EXTRA_TEXT, str);
        sendIntent.setType("text/plain");
        context.startActivity(Intent.createChooser(sendIntent, "Share with ..."));
    }


    public void copy(String str_share){
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", str_share);
        clipboard.setPrimaryClip(clip);
    }

    // ---------------------------

    public void activeTab(ImageView img1,TextView txt1,ImageView img2,ImageView img3,ImageView img4,
                          TextView txt2,TextView txt3,TextView txt4){
        txt1.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
        img1.setColorFilter(context.getResources().getColor(R.color.colorPrimaryDark));
        txt2.setTextColor(context.getResources().getColor(R.color.grey_40));
        txt3.setTextColor(context.getResources().getColor(R.color.grey_40));
        txt4.setTextColor(context.getResources().getColor(R.color.grey_40));
        img2.setColorFilter(context.getResources().getColor(R.color.grey_40));
        img3.setColorFilter(context.getResources().getColor(R.color.grey_40));
        img4.setColorFilter(context.getResources().getColor(R.color.grey_40));
    }


    public void activeTab(TextView txt1, TextView txt2){
        txt1.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
        txt2.setTextColor(context.getResources().getColor(R.color.grey_40));
        txt1.setTypeface(myFont, Typeface.BOLD);
        txt2.setTypeface(myFont, Typeface.NORMAL);
    }



    public void setMenuButtons(){
        MainActivity.i1 = (ImageView)((Activity)context).findViewById(R.id.i1);
        MainActivity.i2 = (ImageView)((Activity)context).findViewById(R.id.i2);
        MainActivity.i3 = (ImageView)((Activity)context).findViewById(R.id.i3);
        MainActivity.i4 = (ImageView)((Activity)context).findViewById(R.id.i4);
        MainActivity.t1 = (TextView) ((Activity)context).findViewById(R.id.t1);
        MainActivity.t2 = (TextView)((Activity)context).findViewById(R.id.t2);
        MainActivity.t3 = (TextView)((Activity)context).findViewById(R.id.t3);
        MainActivity.t4 = (TextView)((Activity)context).findViewById(R.id.t4);
    }



    // ---------------------------
    // Check Permission
    public boolean checkIfAlreadyhavePermission() {
        int READ_EXTERNAL_STORAGE = ContextCompat.checkSelfPermission((Activity) context,
                Manifest.permission.READ_EXTERNAL_STORAGE);
        int WRITE_EXTERNAL_STORAGE = ContextCompat.checkSelfPermission((Activity) context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (READ_EXTERNAL_STORAGE == PackageManager.PERMISSION_GRANTED &&
                WRITE_EXTERNAL_STORAGE == PackageManager.PERMISSION_GRANTED ) {
            return true;
        } else {
            return false;
        }
    }

    public void requestForSpecificPermission() {
        ActivityCompat.requestPermissions((Activity) context, new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, 101);
    }


    public void checkPermission() {
        int MyVersion = Build.VERSION.SDK_INT;
        if (MyVersion >= Build.VERSION_CODES.LOLLIPOP) {
            if (!checkIfAlreadyhavePermission()) {
                requestForSpecificPermission();
            }
        }
    }
}
