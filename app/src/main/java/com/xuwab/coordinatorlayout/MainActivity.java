package com.xuwab.coordinatorlayout;

import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xuwab.coordinatorlayout.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import adater.MyPageAdater;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private List<String> list;
    private MyPageAdater adater;
    public ActivityMainBinding binding;
    private View contentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setMain(this);
        setSupportActionBar(binding.toolbar);
//        rv=binding.rvText;
        initData();
        setFragmentPage();
//        rv.setLayoutManager(new LinearLayoutManager(this));
//        rv.setLayoutManager(new FullyLinearLayoutManager(this));
//        rv.setNestedScrollingEnabled(false);
//        rv.setAdapter(new HomeAdater());
        if (savedInstanceState == null) {
            // Set the local night mode to some value
            getDelegate().setLocalNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
            // 调用 recreate() 使设置生效
            recreate();
        }
    }

    private void setFragmentPage() {
        adater=new MyPageAdater(getSupportFragmentManager(),this);
        binding.vp.setAdapter(adater);
        binding.tabs.setupWithViewPager(binding.vp);
        for(int i=0;i<binding.tabs.getTabCount();i++){
            TabLayout.Tab tab=binding.tabs.getTabAt(i);
            if(tab!=null){
                tab.setCustomView(adater.getTabView(i));
            }
        }
    }

    private void initData() {
        list=new ArrayList<>();
        for(int i=0;i<30;i++){
            list.add("大智障");
        }
    }

    class HomeAdater extends RecyclerView.Adapter<HomeAdater.MyViewHolder>{
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder=new MyViewHolder(LayoutInflater.from(MainActivity.this)
                                                .inflate(R.layout.item1,parent,false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tvItem.setText(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView tvItem;
            public MyViewHolder(View itemView) {
                super(itemView);
                tvItem=(TextView) itemView.findViewById(R.id.tv_item);
            }
        }
    }

    public void testSnackBar(){
//        Snackbar.make(binding.fab2,"我是大智障，怎么了",Snackbar.LENGTH_LONG)
//                .setAction("cancel", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                    }
//                })
//                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_night:
                Toast.makeText(this,"点击了夜间模式",Toast.LENGTH_SHORT).show();
                int currentMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;

                switch (currentMode) {
                    case Configuration.UI_MODE_NIGHT_NO:
                        getDelegate().setLocalNightMode(
                                AppCompatDelegate.MODE_NIGHT_YES);
                        break;
                    case Configuration.UI_MODE_NIGHT_YES:
                        getDelegate().setLocalNightMode(
                                AppCompatDelegate.MODE_NIGHT_NO);
                        break;
                }
                recreate();
                break;
//            case R.id.action_item1:
//                Toast.makeText(this,"点击了扫描",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.action_item2:
//                Toast.makeText(this,"点击了扫描",Toast.LENGTH_SHORT).show();
//                break;
//            default:break;
        }
        return true;

    }
}
