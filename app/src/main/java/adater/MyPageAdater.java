package adater;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

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

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
