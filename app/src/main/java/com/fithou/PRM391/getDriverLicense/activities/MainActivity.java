package com.fithou.PRM391.getDriverLicense.activities;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fithou.PRM391.getDriverLicense.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ẩn Actionbar
        getSupportActionBar().hide();
    }


    // Chứa dựng sự kiện click cho các thành phần trong layout
    public void onClick(View v){
        Intent intent=null;
        switch (v.getId()){
            case R.id.layout_Learning:
                // Click layout, button Học
                intent = new Intent(this,LearningActivity.class);
                break;
            case R.id.layout_Contest:
                // Click layout, button Thi
                intent = new Intent(this,ContestWelcome.class);
                break;
            case R.id.layout_SearchRule:
                // Click layout, button tra cứu luật
                break;
            case R.id.layout_AppInfo:
                // Click layout, button thông tin ứng dụng
                break;
            default:
                Toast.makeText(this, "Chức năng chưa được sử dụng", Toast.LENGTH_SHORT).show();
                break;
        }
        try{
            startActivity(intent);
        }catch (Exception e){}
    }

}
