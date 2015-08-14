package com.example.androidappframe;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;



import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {
@ViewById
ImageView iv;
Context mContext;
String GIF_URL_TJN="http://pic.33.la/pcline/541_2_1920x1200.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=this;
    }
    
    @AfterViews
    public void setImage()
    {
    }
    
}
