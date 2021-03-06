package com.project.hyejin.mju_food;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

public class Korea extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] myDataset;
    private Intent intent_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.korea);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        myDataset = new String[]{"생선구이와 돈가스", "우리식당","치즈밥있슈?","베가보쌈","제순식당","삼겹베네","남매네숙성고","오예!돈삼오","장수촌"};

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
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?id=154308881");
                        break;
                    case 1:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?id=1220114339");
                        break;
                    case 2:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?id=31222381");
                        break;
                    case 3:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?id=1102427977");
                        break;
                    case 4:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?id=1135410066");
                        break;
                    case 5:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?id=1244111561");
                        break;
                    case 6:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?id=930079065");
                        break;
                    case 7:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?id=20851938");
                        break;
                    case 8:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?id=20033096");
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
