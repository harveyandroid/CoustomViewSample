package com.harvey.coustomviewsample;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/**
 * 圆形ImageView，可设置最多两个宽度不同且颜色不同的圆形边框。 设置颜色在xml布局文件中由自定义属性配置参数指定
 */
public class RoundFrameImageView extends android.support.v7.widget.AppCompatImageView {
    private int mBorderThickness = 0;
    private Context mContext;
    private int defaultColor = 0xFFFFFFFF;
    private int mBorderColor = 0;
    private int defaultWidth = 0;
    private int defaultHeight = 0;

    public RoundFrameImageView(Context context) {
        super(context);
        mContext = context;
    }

    public RoundFrameImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        setCustomAttributes(attrs);
    }

    public RoundFrameImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        setCustomAttributes(attrs);
    }

    private void setCustomAttributes(AttributeSet attrs) {
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.rounded_frame);
        mBorderThickness = a.getDimensionPixelSize(R.styleable.rounded_frame_border_thickness, 0);
        mBorderColor = a.getColor(R.styleable.rounded_frame_border_color, defaultColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onDraw(canvas);
        } else {
            defaultWidth = getWidth();
            defaultHeight = getHeight();
            final int radius = (defaultWidth < defaultHeight ? defaultWidth : defaultHeight) / 2 - mBorderThickness;
            final int x = mBorderThickness;
            final int y = mBorderThickness;
            drawable.setBounds(x, y, x + 2 * radius, y + 2 * radius);
            super.onDraw(canvas);
            drawCircleBorder(canvas, radius, mBorderColor);
        }
    }


    /**
     * 边缘画圆
     */
    private void drawCircleBorder(Canvas canvas, int radius, int color) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(mBorderThickness);
        canvas.drawCircle(defaultWidth / 2, defaultHeight / 2, radius + mBorderThickness / 2, paint);
    }

}