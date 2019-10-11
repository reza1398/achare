package views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Reza on 09/10/2016.
 */
public class NumTextViewBold extends TextView {

    public NumTextViewBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public NumTextViewBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NumTextViewBold(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "font/IRANYekanMobileBold.ttf");
        setTypeface(tf ,Typeface.NORMAL);
    }
}
