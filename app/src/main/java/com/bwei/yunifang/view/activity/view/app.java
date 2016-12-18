package com.bwei.yunifang.view.activity.view;

import android.app.Application;
import android.content.Context;

import com.bwei.yunifang.view.Not.HttpUtils;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.handler.UMQQSsoHandler;

import org.xutils.x;

/**
 *  * 作者：19084 on 2016/12/7 21:02
 *  * 邮箱：xjs250@163.com
 *  
 */
public class app extends Application {



    public static HttpUtils httpUtils;

    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }
    @Override
    public void onCreate() {
        super.onCreate();
       // UMShareAPI.get(this);
        Context context = getApplicationContext();
        httpUtils = HttpUtils.getHttpUtils(context);
       init();
        x.Ext.init(this);

    }
    private void init() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .memoryCacheExtraOptions(480, 800)
                // max width, max height拢卢录麓卤拢麓忙碌脛脙驴赂枚禄潞麓忙脦脛录镁碌脛脳卯麓贸鲁陇驴铆
                .threadPoolSize(3)
                // 脧脽鲁脤鲁脴脛脷录脫脭脴碌脛脢媒脕驴
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024))
                // 缂撳瓨涓€鑸細鐢ㄦ€绘€诲唴瀛樺痉1/8
                // You can pass your own memory cache
                // implementation/脛茫驴脡脪脭脥篓鹿媒脳脭录潞碌脛脛脷麓忙禄潞麓忙脢碌脧脰
                .memoryCacheSize(2 * 1024 * 1024)
                .discCacheSize(50 * 1024 * 1024)
                .discCacheFileNameGenerator(new Md5FileNameGenerator())
                // 陆芦卤拢麓忙碌脛脢卤潞貌碌脛URI脙没鲁脝脫脙MD5 录脫脙脺
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .discCacheFileCount(100) // 禄潞麓忙碌脛脦脛录镁脢媒脕驴
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                .imageDownloader(
                        new BaseImageDownloader(getApplicationContext(),
                                5 * 1000, 30 * 1000)) // connectTimeout (5 s),
                // readTimeout (30
                // s)鲁卢脢卤脢卤录盲
                .writeDebugLogs() // Remove for release app
                .build();
        ImageLoader.getInstance().init(config);// 脠芦戮脰

    }

}





