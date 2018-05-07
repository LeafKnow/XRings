package com.yj.njh.action.ui;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.Toast;
import android.widget.VideoView;

import com.yj.njh.action.R;
import com.yj.njh.common.base.BaseFluxActivity;
import com.yj.njh.ret.http.bean.VoideClassTJBean;

import java.util.List;

import butterknife.BindView;

/**
 * 单独的视频播放页面
 * Created by shuyu on 2016/11/11.
 */
public class PlayEmptyControlActivity extends BaseFluxActivity {

    public final static String TRANSITION = "TRANSITION";


    @BindView(R.id.vv_player)
    VideoView vvPlayer;


    private boolean isTransition;

    List<String> dlBeanList;
    private VoideClassTJBean listBean;
    int page=0;
    String url;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void init() {

        dlBeanList=listBean.getPlayurls().get(0);
        if (dlBeanList.size()>0) {
             url = dlBeanList.get(page);
//            String url ="http://vod1.hmr12.net/vod2/78区永亮/行在神的引領中_區永亮.mp4";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
            vvPlayer.setVideoURI(Uri.parse(url));
            vvPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
//                mp.setLooping(true);//设置循环播放
                }
            });
            vvPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                @Override
                public boolean onInfo(MediaPlayer mediaPlayer, int i, int i1) {
                    if (i == MediaPlayer.MEDIA_INFO_BUFFERING_START) {

                    } else if (i == MediaPlayer.MEDIA_INFO_BUFFERING_END) {
                        if (vvPlayer.isPlaying()) {

                        } else {
                            vvPlayer.start();
                        }
                    }
                    return false;
                }
            });
            vvPlayer.start();//开始播放 e.printStackTrace();
            vvPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                 if (dlBeanList.size()>=page+1){
                     page= page+1;
                     url = dlBeanList.get(page);
                     vvPlayer.stopPlayback();
                     vvPlayer.setVideoURI(Uri.parse(url));
                     vvPlayer.start();
                 }else {
                     finish();
                 }
                }
            });
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        //释放所有
//        videoPlayer.setVideoAllCallBack(null);

        if (isTransition && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            super.onBackPressed();
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                    overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
                }
            }, 500);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void initData(Bundle savedInstanceState) {
        isTransition = getIntent().getBooleanExtra(TRANSITION, false);
         listBean = (VoideClassTJBean) getIntent().getSerializableExtra("listBean");
        init();
    }

    @Override
    public void setListener() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_play_empty_control;
    }

    // 第一次按下返回键的事件
    private long firstPressedTime;


    String TAG="playEmpty";
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {

            case KeyEvent.KEYCODE_ENTER:     //确定键OK
            case KeyEvent.KEYCODE_DPAD_CENTER:
                Log.d(TAG,"enter--->");
                if (vvPlayer.isPlaying()){
                    vvPlayer.pause();
                }else {
                    vvPlayer.start();
                }
                break;

            case KeyEvent.KEYCODE_BACK:    //返回键
                Log.d(TAG,"back--->");
                if (System.currentTimeMillis() - firstPressedTime < 2000) {
                    super.onBackPressed();
                } else {
                    Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                    firstPressedTime = System.currentTimeMillis();
                    return true;   //这里由于break会退出，所以我们自己要处理掉 不返回上一层
                }

            case KeyEvent.KEYCODE_SETTINGS: //设置键
                Log.d(TAG,"setting--->");

                break;

            case KeyEvent.KEYCODE_DPAD_DOWN:   //向下键

                /*    实际开发中有时候会触发两次，所以要判断一下按下时触发 ，松开按键时不触发
                 *    exp:KeyEvent.ACTION_UP
                 */
                if (event.getAction() == KeyEvent.ACTION_DOWN){

                    Log.d(TAG,"down--->");
                }

                break;

            case KeyEvent.KEYCODE_DPAD_UP:   //向上键
                Log.d(TAG,"up--->");

                break;

            case KeyEvent.KEYCODE_0:   //数字键0
                Log.d(TAG,"0--->");

                break;

            case KeyEvent.KEYCODE_DPAD_LEFT: //向左键

                Log.d(TAG,"left--->");
                int targetPos2 = vvPlayer.getDuration() *2;
                vvPlayer.seekTo(targetPos2);

                break;

            case KeyEvent.KEYCODE_DPAD_RIGHT:  //向右键
                int targetPos = vvPlayer.getDuration() / 2;
                vvPlayer.seekTo(targetPos);
                Log.d(TAG,"right--->");
                break;

            case KeyEvent.KEYCODE_INFO:    //info键
                Log.d(TAG,"info--->");

                break;

            case KeyEvent.KEYCODE_PAGE_DOWN:     //向上翻页键
            case KeyEvent.KEYCODE_MEDIA_NEXT:
                Log.d(TAG,"page down--->");

                break;
            case KeyEvent.KEYCODE_PAGE_UP:     //向下翻页键
            case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
                Log.d(TAG,"page up--->");

                break;
            case KeyEvent.KEYCODE_VOLUME_UP:   //调大声音键
                Log.d(TAG,"voice up--->");

                break;

            case KeyEvent.KEYCODE_VOLUME_DOWN: //降低声音键
                Log.d(TAG,"voice down--->");

                break;
            default:
                break;
        }

        return super.onKeyDown(keyCode, event);

    }

}
