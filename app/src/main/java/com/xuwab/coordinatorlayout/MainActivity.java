package com.xuwab.coordinatorlayout;

import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xuwab.coordinatorlayout.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private List<String> list;
    public ActivityMainBinding binding;
    private View contentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setMain(this);
//        rv=binding.rvText;
//        initData();
//        rv.setLayoutManager(new LinearLayoutManager(this));
//        rv.setAdapter(new HomeAdater());
//        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Snackbar.make(view,"FAB",Snackbar.LENGTH_LONG)
//                        .setAction("cancel", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                //这里的单击事件代表点击消除Action后的响应事件
//
//                            }
//                        })
//                        .show();
//            }
//        });
    }

    private void initData() {
        list=new ArrayList<>();
        for(int i=0;i<30;i++){
            list.add("test"+i);
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

    public void btn(){
        Toast.makeText(this,"btn",Toast.LENGTH_LONG).show();
    }
    public void testSnackBar(){
        Snackbar.make(binding.fab2,"Hello Word",Snackbar.LENGTH_LONG)
                .setAction("cancel", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .show();
        Toast.makeText(this,"ss",Toast.LENGTH_LONG).show();
//        Snackbar.make(binding.fab,"FAB",Snackbar.LENGTH_LONG)
//                        .setAction("cancel", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                //这里的单击事件代表点击消除Action后的响应事件
//
//                            }
//                        })
//                        .show();
//        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Snackbar.make(view,"FAB2",Snackbar.LENGTH_LONG)
//                        .setAction("cancel", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                //这里的单击事件代表点击消除Action后的响应事件
//
//                            }
//                        })
//                        .show();
//            }
//        });
    }
}
