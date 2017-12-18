package hipo.prop.app.axel.com.proyecto;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by axel012 on 12/13/2017.
 */

public class MyPageAdapter extends FragmentPagerAdapter{

    ArrayList<Fragment> fragments=new ArrayList<>();
    public MyPageAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }
    @Override
    public int getCount() {
        return fragments.size();
    }
    //ADD PAGE
    public void addFragment(Fragment f)
    {
        fragments.add(f);
    }
    //set title
    @Override
    public CharSequence getPageTitle(int position) {
        String title=fragments.get(position).toString();
        return title.toString();
    }
}