package views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Reza on 01/10/2017.
 */

public class MyEditText extends EditText
{

    public MyEditText(Context context)
    {
        super(context);
        init(context);
    }

    public MyEditText(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init(context);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
    }

    public void init(Context context)
    {
        try {
            Typeface myFont = Typeface.createFromAsset(context.getAssets(), "font/IRANYekanMobileRegular.ttf");
            setTypeface(myFont ,Typeface.NORMAL);
        }
        catch (Exception e) {
        }
    }
}
