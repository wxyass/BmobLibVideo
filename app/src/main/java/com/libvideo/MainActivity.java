package com.libvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.libvideo.domain.Person;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //第一：默认初始化
        Bmob.initialize(this, "4c1af865be4b31c8e2bae4e8f1f2b78c");
        addData();
        // getoneData();
        // updata();
        //deleteData();
    }

    // 添加数据
    private void addData() {
        Person p2 = new Person();
        p2.setName("lucky");
        p2.setAddress("北京海淀");
        p2.save(new SaveListener<String>() {
            @Override
            public void done(String objectId,BmobException e) {
                if(e==null){
                    Toast.makeText(MainActivity.this,"添加数据成功，返回objectId为："+objectId,Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"创建数据失败：" + e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
