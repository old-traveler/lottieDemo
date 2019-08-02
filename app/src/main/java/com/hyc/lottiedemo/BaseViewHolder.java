package com.hyc.lottiedemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

  private T data;

  public BaseViewHolder(@NonNull View itemView) {
    super(itemView);
    initItemView(itemView);
  }

  public void onViewRecycled() {

  }

  protected void initItemView(View view){

  }

  public abstract void loadItemData(Context context, T data, int position);

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public void setOnClickListener(View.OnClickListener onClickListener) {
    itemView.setOnClickListener(onClickListener);
  }

}
