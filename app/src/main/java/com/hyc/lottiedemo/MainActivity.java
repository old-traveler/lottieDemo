package com.hyc.lottiedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.model.KeyPath;

public class MainActivity extends AppCompatActivity {

  public static final String JSON_URL = "https://raw.githubusercontent.com/old-traveler/lottieDemo/master/app/src/main/assets/HappyBirthday.json";
  public static final String ZIP_URL = "https://raw.githubusercontent.com/old-traveler/lottieDemo/master/app/src/main/assets/vr.zip";

  private LottieAnimationView lottieAnimationView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    lottieAnimationView = findViewById(R.id.lav);
  }

  /**
   * 从网络获取json并加载动画
   */
  public void setAnimationFromUrl(){
    lottieAnimationView.setAnimationFromUrl(JSON_URL);
    lottieAnimationView.playAnimation();
  }

  /**
   * 从网络中获取动画zip
   */
  public void setZipAnimationFromUrl(){
    lottieAnimationView.setAnimationFromUrl(JSON_URL);
    lottieAnimationView.playAnimation();
  }

  /**
   * 从Assets中获取动画json
   */
  public void setAnimationFromAsset(){
    lottieAnimationView.setAnimation("HappyBirthday.json");
    lottieAnimationView.playAnimation();
  }

  /**
   * 从Raw文件中获取动画json
   */
  public void setAnimationFromRaw(){
    lottieAnimationView.setAnimation(R.raw.HappyBirthday);
    lottieAnimationView.playAnimation();
  }

  /**
   * 加载动画并动态改变状态
   */
  public void setAnimationAndChange(){
    lottieAnimationView.setAnimation("data.json");
    lottieAnimationView.playAnimation();
    //lottieAnimationView.resolveKeyPath()
  }




}
