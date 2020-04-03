package com.atzara.app_larva;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Fragment lz = new Lz_Activity();
    private Fragment hp = new Hp_Activity();
    private Fragment qt = new Qt_Activity();
    private Fragment wd = new Wd_Activity();

    private LinearLayout main_lz;
    private LinearLayout main_hp;
    private LinearLayout main_qt;
    private LinearLayout main_wd;
    private ImageButton ibt_main_lz;
    private ImageButton ibt_main_hp;
    private ImageButton ibt_main_qt;
    private ImageButton ibt_main_wd;
    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
        initFragment();
        selectfragment(0);
    }

    private void initFragment(){
        fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.fm_main_content,lz);
        transaction.add(R.id.fm_main_content,hp);
        transaction.add(R.id.fm_main_content,qt);
        transaction.add(R.id.fm_main_content,wd);
        transaction.commit();

    }

    private void initView(){
        main_lz = (LinearLayout) findViewById(R.id.main_lz);
        main_hp = (LinearLayout) findViewById(R.id.main_hp);
        main_qt =(LinearLayout) findViewById(R.id.main_qt);
        main_wd =(LinearLayout) findViewById(R.id.main_wd);

        ibt_main_lz =(ImageButton)findViewById(R.id.ibt_main_lz);
        ibt_main_hp =(ImageButton)findViewById(R.id.ibt_main_hp);
        ibt_main_qt =(ImageButton)findViewById(R.id.ibt_main_qt);
        ibt_main_wd = (ImageButton)findViewById(R.id.ibt_main_wd);

    }
    private void selectfragment(int i){
        FragmentTransaction transaction=fm.beginTransaction();
        hidefragment(transaction);
        switch(i){
            case 0:
                transaction.show(lz);
                ibt_main_lz.setImageResource(R.drawable.index7);
                break;
            case 1:
                transaction.show(hp);
                ibt_main_hp.setImageResource(R.drawable.index3);
                break;
            case 2:
                transaction.show(qt);
                ibt_main_qt.setImageResource(R.drawable.index1);
                break;
            case 3:
                transaction.show(wd);
                ibt_main_wd.setImageResource(R.drawable.index5);
                break;
            default:break;
        }
        transaction.commit();
    }

    //隐藏所有页面
    private void hidefragment(FragmentTransaction transaction){
        transaction.hide(lz);
        transaction.hide(hp);
        transaction.hide(qt);
        transaction.hide(wd);
    }


    //判断应该显示的页面，为显示函数传参
    @Override
    public void onClick(View v){
        resetimg();
        switch(v.getId()){
            case R.id.ibt_main_lz:
                selectfragment(0);
                break;
            case R.id.ibt_main_hp:
                selectfragment(1);
                break;
            case R.id.ibt_main_qt:
                selectfragment(2);
                break;
            case R.id.ibt_main_wd:
                selectfragment(3);
                break;
            default:
                break;
        }
    }

    //点击时将所有图标变灰
    public void resetimg(){
        ibt_main_lz.setImageResource(R.drawable.index6);
        ibt_main_hp.setImageResource(R.drawable.index2);
        ibt_main_qt.setImageResource(R.drawable.index);
        ibt_main_wd.setImageResource(R.drawable.index4);
    }

    //实现监听
    private void initEvent(){
        main_lz.setOnClickListener(this);
        main_hp.setOnClickListener(this);
        main_qt.setOnClickListener(this);
        main_wd.setOnClickListener(this);
    }
}
