package com.cookie.commonadapter.ui.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.cookie.commonadapter.R;
import com.cookie.commonadapter.ui.adapter.CommonAdapter;
import com.cookie.commonadapter.ui.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.listviewContent)
    ListView listviewContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init(){
        listviewContent.setAdapter(new CommonAdapter<String>(getData(),this,R.layout.item_layout) {
            @Override
            public void getConvert(ViewHolder viewHolder, String data) {
                viewHolder.setText(R.id.textTitle,data);
                viewHolder.setImageViewBG(R.id.imageView,Color.BLUE);
            }
        });
    }

    private List<String> getData(){
        List<String> list = new ArrayList<String>();
        for(int i=0;i<10;i++){
            list.add("a"+i);
        }
        return list;
    }
}
