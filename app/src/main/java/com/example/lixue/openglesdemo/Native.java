package com.example.lixue.openglesdemo;

import android.content.res.AssetManager;

/**
 * 作者:lixue
 * 邮箱:lixue326@163.com
 * 时间:2019/3/22 11:22
 * 描述:创建Nativeclass类  传入c++中
 */


public class Native {
    static{
        System.loadLibrary("mygles");
    }


    /**
     * 传入AssetManager
     * @param am
     */
    public static native void InitAssetManager(AssetManager am);

    /**
     * 初始化OPenGL
     */
    public static native  void InitOpenGL();

    /**
     * 画布变化
     * @param width
     * @param height
     */
    public static native  void OnViewportChanged(float width, float height);

    /**
     * 渲染器
     */
    public static  native  void RenderOneFrame();
}
