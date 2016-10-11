package com.robin.viewpagerfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        //实例化适配器
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        //设置Viewpager缓存Fragment的个数(最少缓存一个)
        pager.setOffscreenPageLimit(2);
    }

    private void initData() {
        //ViewPager滑动的是Fragment
        //初始化Fragment
        //添加到List<Fragment>list
        list = new ArrayList<>();
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }

}
