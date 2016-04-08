package zlz.by.com.baseactivity;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by mac on 16/4/8.
 */
public class ZlzRootActivity extends Activity{
    private   int barheight;
    private   LinearLayout ZLZNavgationll;
    private   LinearLayout.LayoutParams ZLZparams;
    private   int ZLZWindowWidth , ZLZWindowHight;
    private   SystemBarTintManager ZLZtintManager;

    //ZLZ1
    private  LinearLayout ZLZ1llleft, ZLZ1llcenter,ZLZ1llright ,ZLZ1llleftimgll;
    private  LinearLayout.LayoutParams ZLZ1leftparams,ZLZ1centerparams,ZLZ1rightparams,ZLZ1leftimgllparams
            ,ZLZ1lefttxtparams;
    private  ImageView    ZLZbackimg;
    private  TextView  ZLZtxtleft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          WindowManager wm = this.getWindowManager();
          ZLZWindowWidth  = wm.getDefaultDisplay().getWidth();
          ZLZWindowHight  = wm.getDefaultDisplay().getHeight();
          barheight = getStatusBarHeight();
          Log.e("zlz",barheight + "");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);//true 不透明
            ZLZtintManager = new SystemBarTintManager(this);
            ZLZtintManager.setStatusBarTintEnabled(true);
//            ZLZtintManager.setStatusBarTintResource(R.color.colorAccent);//通知栏所需颜色
        }


          ZLZNavgationll = new LinearLayout(this);
          ZLZparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT ,dip2px(this,45)+60 );
          ZLZNavgationll.setOrientation(LinearLayout.HORIZONTAL);
         Log.e("zlz",dip2px(this,45) + "");



      }
    protected  void setZLZ1Nagationll(Activity activity,int color){
          ZLZNavgationll.setBackgroundResource(color);
          activity.getWindow().addContentView(ZLZNavgationll, ZLZparams);
          ZLZtintManager.setStatusBarTintResource(color);

          //zlz1导航栏左边
          ZLZ1llleft = new LinearLayout(this);
          ZLZ1leftparams =  new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT,1 );
          ZLZ1llleft.setOrientation(LinearLayout.HORIZONTAL);
          ZLZNavgationll.addView(ZLZ1llleft, ZLZ1leftparams);

//          zlz1导航栏中间
          ZLZ1llcenter = new LinearLayout(this);
          ZLZ1centerparams =  new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT,1 );
          ZLZ1llcenter.setBackgroundResource(R.color.colorAccent);
          ZLZNavgationll.addView(ZLZ1llcenter, ZLZ1centerparams);

//           zlz1导航栏右边
          ZLZ1llright = new LinearLayout(this);
          ZLZ1rightparams =  new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT,1 );
          ZLZ1llright.setBackgroundResource(R.color.colorPrimary);
          ZLZNavgationll.addView(ZLZ1llright, ZLZ1rightparams);


//          zlz1左边backllimg
         ZLZ1llleftimgll = new LinearLayout(this);
         ZLZ1leftimgllparams =  new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT,1 );
         ZLZ1llleftimgll.setBackgroundResource(R.color.colorAccent);
         ZLZ1llleftimgll.setGravity(Gravity.CENTER);
         ZLZ1llleft.addView(ZLZ1llleftimgll, ZLZ1leftparams);

//        zlz1左边textview
        ZLZtxtleft = new TextView(this);
        ZLZ1lefttxtparams =  new LinearLayout.LayoutParams(0,90,2 );
        ZLZtxtleft.setBackgroundResource(R.color.colorPrimaryDark);
        ZLZ1lefttxtparams.gravity = Gravity.BOTTOM;
        ZLZtxtleft.setGravity(Gravity.TOP);
        ZLZtxtleft.setText("返回");
        ZLZ1llleft.addView(ZLZtxtleft, ZLZ1lefttxtparams);

//           zlz1左边ll中的控件
         ZLZbackimg = new ImageView(this);






    }
    //转像素
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    //转dp
    private  int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    //状态栏相关
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    //获取状态栏高度
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
