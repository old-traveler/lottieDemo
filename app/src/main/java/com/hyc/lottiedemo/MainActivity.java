package com.hyc.lottiedemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;

public class MainActivity extends AppCompatActivity {

  public static final String JSON_URL =
      "https://raw.githubusercontent.com/old-traveler/lottieDemo/master/app/src/main/assets/HappyBirthday.json";
  public static final String ZIP_URL =
      "https://raw.githubusercontent.com/old-traveler/lottieDemo/master/app/src/main/assets/vr.zip";

  private LottieAnimationView lottieAnimationView;
  private SeekBar seekBar;
  private ImageView ivPlay;
  private SeekBar sbSpeed;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initView();
    initListener();
    setAnimationFromAsset();
    startAnimation();
  }

  private void initView() {
    sbSpeed = findViewById(R.id.sb_speed);
    ivPlay = findViewById(R.id.iv_play);
    lottieAnimationView = findViewById(R.id.lav);
    lottieAnimationView.useHardwareAcceleration();
    seekBar = findViewById(R.id.seekbar);
  }

  /**
   * 无网络下会crash
   * 从网络获取json并加载动画
   */
  public void setAnimationFromUrl() {
    lottieAnimationView.setAnimationFromUrl(JSON_URL);
  }

  /**
   * 从网络中获取动画zip
   */
  public void setZipAnimationFromUrl() {
    lottieAnimationView.setAnimationFromUrl(ZIP_URL);
  }

  /**
   * 从Assets中获取动画json
   */
  public void setAnimationFromAsset() {
    lottieAnimationView.setAnimation("HappyBirthday.json");
  }

  /**
   * 从Raw文件中获取动画json
   */
  public void setAnimationFromRaw() {
    lottieAnimationView.setAnimation(R.raw.happybirthday);
  }

  /**
   * 加载动画并动态改变状态
   */
  public void setAnimationAndChange() {
    lottieAnimationView.setAnimation("HappyBirthday.json");
    lottieAnimationView.setRepeatMode(LottieDrawable.RESTART);
    lottieAnimationView.addValueCallback(new KeyPath("**"), LottieProperty.COLOR,
        new SimpleLottieValueCallback<Integer>() {
          @Override
          public Integer getValue(LottieFrameInfo<Integer> frameInfo) {
            if (frameInfo.getOverallProgress() > 0.5) {
              return getResources().getColor(R.color.colorAccent);
            }
            return getResources().getColor(R.color.colorPrimary);
          }
        });
  }

  private void startAnimation() {
    lottieAnimationView.playAnimation();
    ivPlay.setImageResource(R.mipmap.ic_stop);
  }

  private void pauseAnimation() {
    lottieAnimationView.pauseAnimation();
    ivPlay.setImageResource(R.mipmap.ic_play);
  }

  private void resumeAnimation() {
    lottieAnimationView.resumeAnimation();
    ivPlay.setImageResource(R.mipmap.ic_stop);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.item_0:
        setAnimationFromUrl();
        break;
      case R.id.item_1:
        setZipAnimationFromUrl();
        break;
      case R.id.item_2:
        setAnimationFromAsset();
        break;
      case R.id.item_3:
        setAnimationFromRaw();
        break;
      case R.id.item_4:
        startActivity(new Intent(this, ListActivity.class));
        return true;
      case R.id.item_5:
        setAnimationAndChange();
    }
    startAnimation();

    return super.onOptionsItemSelected(item);
  }

  private void initListener() {
    sbSpeed.setProgress(25);
    sbSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        lottieAnimationView.setSpeed(1.0f*progress/25);
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });


    lottieAnimationView.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        seekBar.setProgress((int) (lottieAnimationView.getProgress() * 100));
      }
    });
    ivPlay.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (lottieAnimationView.isAnimating()) {
          pauseAnimation();
        } else {
          resumeAnimation();
        }
      }
    });
    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
          pauseAnimation();
          lottieAnimationView.setProgress(progress * 1.0f / 100);
        }
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });
    lottieAnimationView.addAnimatorListener(new AnimatorListenerAdapter() {
      @Override
      public void onAnimationCancel(Animator animation) {
        super.onAnimationCancel(animation);
      }

      @Override
      public void onAnimationEnd(Animator animation) {
        super.onAnimationEnd(animation);
      }

      @Override
      public void onAnimationRepeat(Animator animation) {
        super.onAnimationRepeat(animation);
      }

      @Override
      public void onAnimationStart(Animator animation) {
        super.onAnimationStart(animation);
      }

      //无用
      @Override
      public void onAnimationPause(Animator animation) {
        super.onAnimationPause(animation);
      }

      //无用
      @Override
      public void onAnimationResume(Animator animation) {
        super.onAnimationResume(animation);
      }
    });
  }
}
