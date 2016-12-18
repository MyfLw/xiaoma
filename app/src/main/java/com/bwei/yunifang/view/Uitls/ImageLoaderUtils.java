package com.bwei.yunifang.view.Uitls;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.PauseOnScrollListener;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 *  * 作者：19084 on 2016/12/10 08:42
 *  * 邮箱：xjs250@163.com
 *  
 */
public class ImageLoaderUtils {
    private static ImageLoaderUtils instance;
    private static DisplayImageOptions options;
    private static ImageLoader imageloader;
    public static ImageLoaderUtils getInstance(){
        if(instance==null){
            synchronized (ImageLoaderUtils.class) {
                if(instance==null){
                    instance=new ImageLoaderUtils();
                }
            }
        }
        if(imageloader==null){
            imageloader=ImageLoader.getInstance();
        }
        return instance;
    }
    /**
     *图片下载监听接口
     */
    public interface LoadImageCallback{
        void LoadStart(String string,View view);
        void LoadFail(String string,View view,FailReason reason);
        void LoadComplete(String string, View view,Bitmap bitmap);
        void LoadCancel(String string,View view);
    }
    /**
     * Appliation 初始化imageloader
     * @param context  getApplicationContext()
     * @param cachename 缓存文件名
     */
    public void InitializeImageLoader(Context context, String cachename){
        // 获取本地缓存的目录，该目录在SDCard的根目录下
        File cacheDir = StorageUtils.getOwnCacheDirectory(context, cachename);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(480, 800) // max width, max height，即保存的每个缓存文件的最大长宽
                .diskCacheExtraOptions(480, 800, null)  // 本地缓存的详细信息(缓存的最大长宽)，最好不要设置这个
                .threadPoolSize(3) //线程池内加载的数量(推荐为1-5)
                .threadPriority(Thread.NORM_PRIORITY - 2)  // default 设置当前线程的优先级
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator()) //将保存的时候的URI名称用MD5 加密
                .memoryCache(new WeakMemoryCache()) // 你可以通过自己的内存缓存实现(为避免oom考虑这样做 或者不使用内存缓存)
                //  .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024)) // 你可以通过自己的内存缓存实现
                .memoryCacheSize(2 * 1024 * 1024) // 内存缓存的最大值
                .diskCacheSize(50 * 1024 * 1024)  // 50 Mb sd卡(本地)缓存的最大值
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                // 由原先的discCache -> diskCache
                .diskCache(new UnlimitedDiskCache(cacheDir))//自定义缓存路径
                //设定网络连接超时 timeout: 5s 读取网络连接超时read timeout: 30s
                .imageDownloader(new BaseImageDownloader(context, 5 * 1000, 30 * 1000))
                .writeDebugLogs() // Remove for release app
                .build();
        //全局初始化此配置
        ImageLoader.getInstance().init(config);
    }
    /**
     * 设置图片下载配置
     * @param loadingimage 设置图片在下载期间显示的图片
     * @param errorimage 设置图片Uri为空或是错误的时候显示的图片
     * @param failimage  设置图片加载/解码过程中错误时候显示的图片
     */
    public void SetImageConfiguration(int loadingimage,int errorimage,int failimage) {
        if(options==null){
            options = new DisplayImageOptions.Builder()
                    .showImageOnLoading(loadingimage) //设置图片在下载期间显示的图片
                    .showImageForEmptyUri(errorimage)//设置图片Uri为空或是错误的时候显示的图片
                    .showImageOnFail(failimage)  //设置图片加载/解码过程中错误时候显示的图片
                    .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                    .cacheOnDisk(true)//设置下载的图片是否缓存在SD卡中
                    .considerExifParams(true)  //是否考虑JPEG图像EXIF参数（旋转，翻转）
                    /*  EXACTLY :图像将完全按比例缩小的目标大小
              EXACTLY_STRETCHED:图片会缩放到目标大小完全
              IN_SAMPLE_INT:图像将被二次采样的整数倍
              IN_SAMPLE_POWER_OF_2:图片将降低2倍，直到下一减少步骤，使图像更小的目标大小
              NONE:图片不会调整*/
                    .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)//设置图片以如何的编码方式显示
                    //设置图片的解码类型,默认是ARGB_8888，使用RGB_565会比使用ARGB_8888少消耗2倍的内存
                    .bitmapConfig(Bitmap.Config.RGB_565)
                    //      .decodingOptions(BitmapFactory.Options decodingOptions)//设置图片的解码配置
                    .delayBeforeLoading(0)//int delayInMillis为你设置的下载前的延迟时间
                    //设置图片加入缓存前，对bitmap进行设置
                    //.preProcessor(BitmapProcessor preProcessor)
                    .resetViewBeforeLoading(true)//设置图片在下载前是否重置，复位
                    /* RoundedBitmapDisplayer（int roundPixels）设置圆角图片 不推荐   会创建新的ARGB_8888格式的Bitmap对象；
              FakeBitmapDisplayer（）这个类什么都没做
              FadeInBitmapDisplayer（int durationMillis）设置图片渐显的时间
　　　　　　　  SimpleBitmapDisplayer()正常显示一张图片　*/
                    .displayer(new FadeInBitmapDisplayer(1000))
                    .build();//构建完成
        }
    }
    /**
     * 加载图片不需要监听
     * @param url
     * <BR/>
     *  String imagePath = "/mnt/sdcard/phone_pregnancy/header.png";  <BR/>
    String imagefileUrl = Scheme.FILE.wrap(imagePath); <BR/>
    //图片来源于Content provider
    String contentprividerUrl = "content://media/external/audio/albumart/13";   <BR/>
    //图片来源于assets
    //  String assetsUrl = Scheme.ASSETS.wrap("image.png");  <BR/>
    String assetsUrl = "assets://fail_image.9.png";  <BR/>
    //图片来源于  drawable
    //  String drawableUrl = Scheme.DRAWABLE.wrap("R.drawable.ic_launcher.png");<BR/>
    String drawableUrl = "drawable://" + R.drawable.ic_add; <BR/>
    //图片来源于  网络
    String neturi = "http://ww2.sinaimg.cn/large/49aaa343jw1dgwd0qvb4pj.jpg";<BR/>
    <P>
     * @param imageView
     * @param defaultoptions  是否使用默认的 DisplayImageOptions (true :  use own options)
     */
    public void LoadImageWithoutLister(String url, ImageView imageView, boolean defaultoptions){
        if(defaultoptions && options!=null){
            imageloader.displayImage(url,imageView,options);
        }else{
            imageloader.displayImage(url,imageView);//使用默认options
        }
    }
    /**
     * 下载图片监听
     * @param url
     * @param imageView
     * @param callback
     */
    public void LoadImageWithLister(String url,ImageView imageView,final LoadImageCallback callback){
        imageloader.displayImage(url,imageView,new ImageLoadingListener() {

            @Override
            public void onLoadingStarted(String string, View view) {
                callback.LoadStart(string, view);
            }

            @Override
            public void onLoadingFailed(String string, View view, FailReason reason) {
                callback.LoadFail(string, view, reason);
            }

            @Override
            public void onLoadingComplete(String string, View view, Bitmap bitmap) {
                callback.LoadComplete(string, view, bitmap);
            }

            @Override
            public void onLoadingCancelled(String string, View view) {
                callback.LoadCancel(string, view);
            }
        });
    }
    /**
     * 设置listview滑动是否加载图片
     * @param LGView listview or gridview
     * @param scrollLoad  控制是否在滑动过程中暂停加载图片，如果需要暂停传true
     * @param fastscrollLoad  控制猛的滑动界面的时候图片是否加载
     */
    public void SetListViewScrollLoadImage(AbsListView LGView, boolean scrollLoad, boolean fastscrollLoad){
        //第一个参数就是我们的图片加载对象ImageLoader,
        //第二个是控制是否在滑动过程中暂停加载图片，如果需要暂停传true就行了，
        //第三个参数控制猛的滑动界面的时候图片是否加载
        LGView.setOnScrollListener(new PauseOnScrollListener(imageloader,scrollLoad,fastscrollLoad));
    }
    /**
     * 清空缓存
     */
    public void ClearCache(){
        imageloader.clearMemoryCache();//清空缓存
        imageloader.clearDiskCache();  // 清除SD卡中的缓存
    }
}
