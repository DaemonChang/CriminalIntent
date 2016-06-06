package com.daemon.android.criminalintent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.util.Log;

/**
 * Created by Chang on 06/03/16.
 */
public class PictureUtils {
    /**
     * 获取activity的大小
     * @param path
     * @param activity
     * @return
     */
    public static Bitmap getScaledBitmap(String path, Activity activity){
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);
        Log.d("@@PictureUtils:","destWidth: "+size.x + ",destHeight:"+size.y);//720,1184
        return getScaledBitmap(path, size.x, size.y);
    }

    public static Bitmap getScaledBitmap(String path, int destWidth, int destHeight){
        //Read in the dimensions of the image on disk
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path,options);

        float srcWidth = options.outWidth;//640
        float srcHeight = options.outHeight;//480

        //Figure out how much to scale down by
        int inSampleSize = 1;
        if(srcWidth > destWidth || srcHeight > destHeight){
            if(srcWidth > srcHeight){
                inSampleSize = Math.round(srcHeight / destHeight);
            }else{
                inSampleSize = Math.round(srcWidth / destWidth);
            }
        }

        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;
        Log.d("@@PictureUtils:","srcWidth: "+srcWidth + ",srcHeight:"+srcHeight+",inSampleSize:"+inSampleSize);
        //Read in and create final bitmap
        return BitmapFactory.decodeFile(path,options);
    }

}
