package fr.inria.es.demoapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

class CustomView extends View {


    private final Paint mPaint;
    private final Path mPath;
    private final int[] colors = {Color.RED, Color.YELLOW};
    private final float[] pos = {0.0f, 1.0f};
    private final String mText = "Test - Test - Test - Test - Test - Test - Test";

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(100);
        mPath = new Path();
        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Shader linearGradient = new LinearGradient(
                0,
                0,
                0,
                h,
                colors,
                pos,
                Shader.TileMode.CLAMP
        );
        mPaint.setShader(linearGradient);
        mPath.rewind();
        mPath.moveTo(0, h);
        mPath.lineTo(w, 0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawTextOnPath(mText, mPath, 0, 0, mPaint);
    }
}
