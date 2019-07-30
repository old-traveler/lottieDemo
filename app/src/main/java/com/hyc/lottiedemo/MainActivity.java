package com.hyc.lottiedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

  private LottieAnimationView lottieAnimationView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    lottieAnimationView = findViewById(R.id.lav);
    //lottieAnimationView.setAnimationFromUrl();
  }
}
