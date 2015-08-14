/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 drakeet (http://drakeet.me)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.example.androidappframe.customview;

import com.example.androidappframe.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by drakeet on 3/27/15.
 */
public class UIButton extends UIBaseButton {

    private Paint mPressedPaint;
    private Paint mDisabledPaint;
    private int mPressedColor;
    private int mDisabledColor;
    private boolean diasbledUIButton;//鍒ゆ柇鎸夐挳鏄惁琚姝簡disabled

    public UIButton(Context context) {
        super(context);
    }

    public UIButton(Context context, AttributeSet attrs) {
        super(context, attrs);
		init(context, attrs);
    }

    public UIButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
		init(context, attrs);
    }

    public UIButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
		init(context, attrs);
    }

    @Override
    protected void init(Context context, AttributeSet attrs) {
        super.init(context, attrs);
        final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.UIButton);
        mPressedColor = typedArray.getColor(R.styleable.UIButton_color_pressed, getResources().getColor(R.color.color_pressed));
        mDisabledColor = typedArray.getColor(R.styleable.UIButton_color_disabled, getResources().getColor(R.color.color_disabled));
        typedArray.recycle();

        mPressedPaint = new Paint();
        mPressedPaint.setStyle(Paint.Style.FILL);
        mPressedPaint.setColor(mPressedColor);
        mPressedPaint.setAlpha(0);//鐢荤瑪涓嶉?忔槑
        mPressedPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mShapeType == 0) {
            canvas.drawCircle(WIDTH/2, HEIGHT/2, WIDTH/2.1038f, diasbledUIButton==true?mDisabledPaint:mPressedPaint);
        } else {
            RectF rectF = new RectF();
            rectF.set(0, 0, WIDTH, HEIGHT);
            canvas.drawRoundRect(rectF, mRadius, mRadius, diasbledUIButton==true?mDisabledPaint:mPressedPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	if(diasbledUIButton)
    	{
    		return true;
    	}
    	else
    	{
    		switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPressedPaint.setAlpha(255);
                invalidate();
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                mPressedPaint.setAlpha(0);
                invalidate();
                break;
        }
        return super.onTouchEvent(event);
    	}
        
    }

    
    @Override
    public void setEnabled(boolean enabled) {
    	// TODO Auto-generated method stub
    	if(!enabled)
    	{
    		diasbledUIButton=true;
    		mDisabledPaint = new Paint();
    		mDisabledPaint.setStyle(Paint.Style.FILL);
    		mDisabledPaint.setColor(mDisabledColor);
    		mDisabledPaint.setAlpha(255);
    		mDisabledPaint.setAntiAlias(true);
    		invalidate();
    		Log.i("TAG", "enable_false");
    	}
    	else
    	{
    		diasbledUIButton=false;
    		mDisabledPaint.setAlpha(0);
    		invalidate();
    	}
    	super.setEnabled(enabled);
    }
   
}