package com.example.lixue.openglesdemo;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


class MyGLRenderer implements GLSurfaceView.Renderer{

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
     //   gl.glClearColor(0.1f,0.4f,0.6f,1.0f);
        Native.InitOpenGL();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
       // gl.glViewport(0,0,width, height);
        Native.OnViewportChanged(width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
      //  gl.glClear(gl.GL_COLOR_BUFFER_BIT);
        Native.RenderOneFrame();
    }
}
class MyGLSurface extends  GLSurfaceView{
    MyGLRenderer myGLRenderer;
    public MyGLSurface(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        myGLRenderer = new MyGLRenderer();
        setRenderer(myGLRenderer);
    }
}
public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
//    static {
//        System.loadLibrary("native-lib");
//    }
    MyGLSurface glSurface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Native.InitAssetManager(getAssets()); //传入资源读取器
        glSurface = new MyGLSurface(getApplicationContext());
        setContentView(glSurface);

        // Example of a call to a native method
//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

}
