package com.example.androidappframe.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


public abstract class CommAdapter<T> extends BaseAdapter {

	protected LayoutInflater mInflater;
	protected Context mContext;
	protected List<T> mData = null;
	protected final int mItemLayoutId;

	public CommAdapter(Context mContext, List<T> mData, int itemLayoutId) {
		super();
		mInflater = LayoutInflater.from(mContext);
		this.mContext = mContext;
		this.mData = mData;
		this.mItemLayoutId = itemLayoutId;
	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public T getItem(int position) {
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		CommViewHolder viewHolder = CommViewHolder.get(mContext, convertView, parent, mItemLayoutId,position);
		
		convert(viewHolder, getItem(position));
		
		return viewHolder.getConvertView();
	}

	public abstract void convert(CommViewHolder holder, T item);

	

}
