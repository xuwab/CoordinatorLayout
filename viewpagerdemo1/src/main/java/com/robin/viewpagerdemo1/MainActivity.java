package com.robin.viewpagerdemo1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,View.OnClickListener{

//    private List<ImageView> list;
    private List<View> list;
    private List<String> titleList;

    private int[] images = {R.drawable.slide1,R.drawable.slide2,R.drawable.slide3};

    private List<ImageView> dotList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTitle();
        initData();

        initView();
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyPagerAdapter());
        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(1);//默认选中item=1的View
    }

    private void initTitle() {
        //通过PagerTabStrip设定标题
        titleList = new ArrayList<>();
        titleList.add("标题一");
        titleList.add("标题二");
        titleList.add("标题三");
    }

    private void initView() {
        //小圆点
        ImageView iv1 = (ImageView) findViewById(R.id.iv1);
        ImageView iv2 = (ImageView) findViewById(R.id.iv2);
        ImageView iv3 = (ImageView) findViewById(R.id.iv3);
        dotList = new ArrayList<>();
        dotList.add(iv1);
        dotList.add(iv2);
        dotList.add(iv3);
    }

    private void initData() {
        //滑动图片  List<ImageView> list
        //滑动layout   List<View> list
        list = new ArrayList<>();
//        for(int i = 0;i<images.length;i++){
//            ImageView imageView = new ImageView(MainActivity.this);
//            imageView.setBackgroundResource(images[i]);
//            if(i == images.length-1){
//                imageView.setOnClickListener(this);//让最后一张图片点击
//            }
//            list.add(imageView);
//        }
        LayoutInflater inflater = LayoutInflater.from(this);
        View view1 = inflater.inflate(R.layout.layout1, null);
        View view3 = inflater.inflate(R.layout.layout3,null);
        View view2 = inflater.inflate(R.layout.layout2,null);

        list.add(view1);
        list.add(view2);
        list.add(view3);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //监听当前ViewPager加载的View的索引
        Toast.makeText(MainActivity.this,"pos:"+position,Toast.LENGTH_SHORT).show();
        //根据position,更新对应ImageView的src
        ImageView curDot = dotList.get(position);
        for(int i=0;i<dotList.size();i++){
            if(dotList.get(i) == curDot){
                curDot.setImageResource(R.drawable.page_now);
            }else{
                dotList.get(i).setImageResource(R.drawable.page);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this,"点击进入主页面",Toast.LENGTH_SHORT).show();
    }

    //创建ViewPager的适配器
    class MyPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //根据position获取List中的ImageView
            //将ImageView添加到Viewpager中
            //返回当前的IamgeView
//            ImageView imageView = list.get(position);
//            container.addView(imageView);
            View view = list.get(position);
            container.addView(view);
            return list.get(position);

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //通过ViewPager的container移除View
            container.removeView(list.get(position));
//            super.destroyItem(container, position, object);
        }

        //显示ViewPager的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }

}
