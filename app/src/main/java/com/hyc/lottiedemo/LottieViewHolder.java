package com.hyc.lottiedemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;

/**
 * @author: 贺宇成
 * @date: 2019-07-31 09:24
 * @desc:
 */
public class LottieViewHolder extends BaseViewHolder<String> {

  private LottieAnimationView lottieAnimationView;

  public LottieViewHolder(@NonNull View itemView) {
    super(itemView);
    lottieAnimationView = itemView.findViewById(R.id.lav);
  }

  @Override
  public void loadItemData(Context context, String data, int position) {
    lottieAnimationView.setAnimation("data.json");
    lottieAnimationView.setImageAssetsFolder("images/");
    lottieAnimationView.useHardwareAcceleration();
    if (!lottieAnimationView.isAnimating()){
      lottieAnimationView.playAnimation();
    }
  }
}
