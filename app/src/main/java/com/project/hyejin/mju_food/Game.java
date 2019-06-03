package com.project.hyejin.mju_food;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Game extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> myDataset;
    private EditText item;
    private Button button, button_add;
    private View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        button = (Button)findViewById(R.id.btn_resultgame);
        button_add = (Button)findViewById(R.id.btn_add);

        myDataset = new ArrayList<>();

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = View.inflate(Game.this,R.layout.dialog,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(Game.this);
                dlg.setTitle("아이템 추가");
                dlg.setIcon(R.drawable.plus);
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        item = (EditText)dialogView.findViewById(R.id.item_name);
                        myDataset.add(item.getText().toString());
                    }
                });
                dlg.setNegativeButton("취소",null);
                dlg.show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Game.this);
                dlg.setTitle("결과");
                if(myDataset.size()==0){
                    dlg.setMessage("아이템을 넣어주세요!");
                }else{
                    int index = (int)(Math.random()*myDataset.size());
                    dlg.setMessage(myDataset.get(index));
                }
                dlg.setPositiveButton("확인",null);
                dlg.show();
            }
        });

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter
        mAdapter = new GameAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);
    }
}
