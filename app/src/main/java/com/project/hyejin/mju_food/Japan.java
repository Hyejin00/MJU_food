package com.project.hyejin.mju_food;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

public class Japan extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] myDataset;
    private Intent intent_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.japan);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        myDataset = new String[]{"유월의 살구나무","인라면","원펀멘","가타쯔무리","소소카레","스시하나에","홍대무라","나라비","브로콜리 식당"};

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                intent_url = new Intent(getApplicationContext(),Web.class);
                switch (position){
                    case 0:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?entry=plt&id=33452630&query=%EC%9C%A0%EC%9B%94%EC%9D%98%20%EC%82%B4%EA%B5%AC%EB%82%98%EB%AC%B4");
                        break;
                    case 1:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?entry=plt&id=34678368&query=%EC%9D%B8%EB%9D%BC%EB%A9%B4");
                        break;
                    case 2:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?id=1149275842");
                        break;
                    case 3:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?entry=plt&id=36351814&query=%EA%B0%80%ED%83%80%EC%AF%94%EB%AC%B4%EB%A6%AC");
                        break;
                    case 4:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?entry=plt&id=1306698918&query=%EC%86%8C%EC%86%8C%EC%B9%B4%EB%A0%88");
                        break;
                    case 5:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?entry=plt&id=38299775&query=%EC%8A%A4%EC%8B%9C%ED%95%98%EB%82%98%EC%97%90");
                        break;
                    case 6:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?entry=plt&id=38329482&query=%ED%99%8D%EB%8C%80%EB%AC%B4%EB%9D%BC");
                        break;
                    case 7:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?id=33876033");
                        break;
                    case 8:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?entry=plt&id=38009356&query=%EB%B8%8C%EB%A1%9C%EC%BD%9C%EB%A6%AC%EC%8B%9D%EB%8B%B9");
                        break;
                }
                startActivity(intent_url);

            }
        });

        // specify an adapter
        mAdapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);
    }
}
