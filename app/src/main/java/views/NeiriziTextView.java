package views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Reza on 09/10/2016.
 */
public class NeiriziTextView extends TextView {

    public NeiriziTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public NeiriziTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NeiriziTextView(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "font/Neirizi.ttf");
        setTypeface(tf ,Typeface.NORMAL);
    }
}
