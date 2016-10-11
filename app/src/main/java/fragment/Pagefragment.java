package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xuwab.coordinatorlayout.R;

/**
 * Created by Administrator on 2016/10/11.
 */

public class Pagefragment extends Fragment {
    public static final String ARGS_PAGE="args_page";
    private int mPage;
    public static Pagefragment newInstance(int page){
        Bundle bundle=new Bundle();
        bundle.putInt(ARGS_PAGE,page);
        Pagefragment pagefragment=new Pagefragment();
        pagefragment.setArguments(bundle);
        return pagefragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage=getArguments().getInt(ARGS_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_page,container,false);
        TextView textView=(TextView)view.findViewById(R.id.tv_fragment);
        textView.setText("第"+mPage+"页");
        return view;
    }


}
