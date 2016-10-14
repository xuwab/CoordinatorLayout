package adater;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xuwab.coordinatorlayout.R;

import fragment.Pagefragment;

/**
 * Created by Administrator on 2016/10/11.
 */

public class MyPageAdater extends FragmentPagerAdapter {
    public final int count=5;
    private String[] titles=new String[]{"Tap1","Tap2","Tap3","Tap4","Tap5",};
    private Context context;
    public MyPageAdater(FragmentManager fm, Context context) {
        super(fm);
        this.context=context;
    }

    @Override
    public Fragment getItem(int position) {
        return Pagefragment.newInstance(position+1);
    }

    @Override
    public int getCount() {
        return count;
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        return titles[position];
//    }
    public View getTabView(int position){
        //首先为子tab布置一个布局
        View view=LayoutInflater.from(context).inflate(R.layout.tab_item,null);
        TextView tv = (TextView) view.findViewById(R.id.tv_tab);
        tv.setText(titles[position]);
        ImageView iv = (ImageView) view.findViewById(R.id.iv_tab);
        iv.setImageResource(R.drawable.ic_night);
        return view;
    }
}
