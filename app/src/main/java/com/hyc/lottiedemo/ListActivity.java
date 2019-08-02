package com.hyc.lottiedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.hyc.lottiedemo.adapter.BaseRecycleAdapter;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

  RecyclerView recyclerView;
  BaseRecycleAdapter<String,LottieViewHolder> adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list);
    recyclerView = findViewById(R.id.rv_list);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    List<String> data = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      data.add(MainActivity.ZIP_URL);
    }
    adapter = new BaseRecycleAdapter<>(data,R.layout.item,LottieViewHolder.class);
    recyclerView.setAdapter(adapter);
  }
}
