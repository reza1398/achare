package views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Reza on 09/10/2016.
 */
public class NumTextView_Light extends TextView {

    public NumTextView_Light(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public NumTextView_Light(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NumTextView_Light(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "font/IRANYekanMobileLight.ttf");
        setTypeface(tf ,Typeface.NORMAL);
    }
}
