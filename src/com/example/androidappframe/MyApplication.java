package com.example.androidappframe;

import java.io.File;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;

public class MyApplication extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		initImageLoader(getApplicationContext());
	}

	private void initImageLoader(Context applicationContext) {
		// TODO Auto-generated method stub
		//图片显示配置
		DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
		.imageScaleType(ImageScaleType.EXACTLY)
		.bitmapConfig(Bitmap.Config.RGB_565)
		.showImageForEmptyUri(R.drawable.ic_empty)//链接为""时显示的图片
		.showImageOnFail(R.drawable.ic_error)//链接错误时显示的图片
		.showImageOnLoading(R.drawable.loading).delayBeforeLoading(0)//加载时显示的图片
		.resetViewBeforeLoading(true).cacheInMemory(true)
		.cacheOnDisc(true).displayer(new SimpleBitmapDisplayer())
		.build();
		
		
		/*File casheDir = StorageUtils.getOwnCacheDirectory(
		getApplicationContext(), ConfigConsants.IMA_CACHE_PATH);*/ //缓存路径
		
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				getApplicationContext())
				//.discCache(new UnlimitedDiscCache(casheDir))//自定义缓存路径,如果不定义,默认在Android/data/包名下的cache文件夹中
				//这样就可以在卸载时删除所有的缓存文件
				.discCacheFileNameGenerator(new Md5FileNameGenerator())
				.imageDownloader(
						new BaseImageDownloader(getApplicationContext(),
								5 * 1000, 20 * 1000))
				.defaultDisplayImageOptions(defaultOptions).threadPoolSize(3)
				.build();
		
		ImageLoader.getInstance().init(config);
	}

	
}
