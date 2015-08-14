package com.example.androidappframe.adapter;


import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/** 通用的ViewHolder写法 */
public class CommViewHolder {
	
	private final SparseArray<View> mViews;
	private  int mPosition;
	private View mConvertView;
	private Context mContext;
	private ImageLoader imageLoader;
	
	private CommViewHolder(Context context, ViewGroup parent, int layoutId,	int position ){
		this.mContext = context;
		this.mViews = new SparseArray<View>();  
		this.mPosition = position;
		imageLoader = ImageLoader.getInstance();
		mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);  
       
        //setTag  
        mConvertView.setTag(this); 
	}
	 /** 
     * 拿到一个ViewHolder对象 
     * @param context 
     * @param convertView 
     * @param parent 
     * @param layoutId 
     * @param position 
     * @return 
     */  
    public static CommViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position)  
    {  
        if (convertView == null)  
        {  
            return new CommViewHolder(context, parent, layoutId,position);  
        }  
        
        CommViewHolder vHolder = (CommViewHolder) convertView.getTag();
        vHolder.setPosition(position);
        return vHolder;  
    }  
  
  
    /** 
     * 通过控件的Id获取对于的控件，如果没有则加入views 
     * @param viewId 
     * @return 
     */  
    public <T extends View> T getView(int viewId)  
    {  
          
        View view = mViews.get(viewId);  
        if (view == null)  
        {  
            view = mConvertView.findViewById(viewId);  
            mViews.put(viewId, view);  
        }  
        return (T) view;  
    }  
  
    public View getConvertView()  
    {  
        return mConvertView;  
    }  
	
    /** 
     * 为TextView设置字符串 
     *  
     * @param viewId 
     * @param text 
     * @return 
     */  
    public CommViewHolder setText(int viewId, String text)  
    {  
        TextView view = getView(viewId);  
        view.setText(text);  
        return this;  
    }  
  
    /** 
     * 为ImageView设置图片 
     *  
     * @param viewId 
     * @param drawableId 
     * @return 
     */  
    public CommViewHolder setImageResource(int viewId, int drawableId)  
    {  
        ImageView view = getView(viewId);  
        view.setImageResource(drawableId);  
  
        return this;  
    }  
  
    /** 
     * 为ImageView设置图片 
     *  
     * @param viewId 
     * @param drawableId 
     * @return 
     */  
    public CommViewHolder setImageBitmap(int viewId, Bitmap bm)  
    {  
        ImageView view = getView(viewId);  
        view.setImageBitmap(bm);  
        return this;  
    }  
  
    /** 
     * 为ImageView设置图片 
     *  
     * @param viewId 
     * @param drawableId 
     * @return 
     */  
    public CommViewHolder setImageByUrl(int viewId, String url)  
    {  
        imageLoader.displayImage(url, (ImageView) getView(viewId));
        return this;  
    }  
    
    public void setPosition(int position){
		
    	mPosition = position;
    	
    }
    
    public int getPosition(){
		
    	return mPosition;
    	
    }
   
}
