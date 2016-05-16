package com.soti.builder.locationbuilder.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by FM on 5/16/2016.
 */
public class Background extends View {

    private int diameter;
    private int x;
    private int y;
    private Context ctx;
    private ShapeDrawable bubble;
    private int width; private int height;
    public Background(Context context) {
        super(context);
        createBubble();
    }

    public  void move(float f, float g) {
        x = (int) (x + f);
        y = (int) (y + g);
        bubble.setBounds(x, y, x + diameter, y + diameter);
    }
    private void createBubble() {
        ctx = this.getContext();
        /*x = 200;
        y = 300;
        diameter = 100;
        bubble = new ShapeDrawable(new OvalShape());
        bubble.setBounds(x, y, x + diameter, y + diameter);
        bubble.getPaint().setColor(0xff00cccc);*/
        WindowManager wm = (WindowManager)
                ctx.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = (size.x)/2;
        height = (size.y)/2;
        x = width;
        y = height;
        diameter = 100;
        bubble = new ShapeDrawable(new OvalShape());
        bubble.setBounds(x, y, x + diameter, y + diameter);
        bubble.getPaint().setColor(0xff74AC23);
    }
    protected void onDraw(Canvas c) {
        super.onDraw(c);
        bubble.draw(c);
    }


}
