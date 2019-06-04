package com.project.hyejin.mju_food;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class America extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] myDataset;
    private Intent intent_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.america);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        myDataset = new String[]{"WITH US","피자스쿨","미스터피자","주인백 파스타","은화수 식당","하늘 정원","차스쿡"};

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
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?id=1018893325");
                        break;
                    case 1:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?id=11839785");
                        break;
                    case 2:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?entry=plt&id=36936507&query=%EB%AF%B8%EC%8A%A4%ED%84%B0%ED%94%BC%EC%9E%90%20%EB%AA%85%EC%A7%80%EB%8C%80%EC%A0%90");
                        break;
                    case 3:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?entry=plt&id=31161270&query=%EC%A3%BC%EC%9D%B8%EB%B0%B1%ED%8C%8C%EC%8A%A4%ED%83%80");
                        break;
                    case 4:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?entry=plt&id=1899165929&query=%EC%9D%80%ED%99%94%EC%88%98%EC%8B%9D%EB%8B%B9%20%EB%AA%85%EC%A7%80%EB%8C%80%EC%A0%90");
                        break;
                    case 5:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?id=20886510");
                        break;
                    case 6:
                        intent_url.putExtra("Url","https://store.naver.com/restaurants/detail?entry=plt&id=36324274&query=%EC%B0%A8%EC%8A%A4%EC%BF%A1");
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
