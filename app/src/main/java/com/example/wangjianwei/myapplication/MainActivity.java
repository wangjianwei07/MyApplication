package com.example.wangjianwei.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.wangjianwei.Bean.Tab;
import com.example.wangjianwei.Frgment.CartFragment;
import com.example.wangjianwei.Frgment.HomeFragment;
import com.example.wangjianwei.Frgment.HotFragment;
import com.example.wangjianwei.Frgment.MineFragment;
import com.example.wangjianwei.widget.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost mTabHost = null;
    private LayoutInflater mLayoutInflater = null;

    private List<Tab> mTabs = new ArrayList<>(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTab();
    }

    private void initTab() {
        mLayoutInflater = LayoutInflater.from(this);

        mTabHost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realTabContent);

        Tab tab_home = new Tab(R.drawable.selector_icon_home, R.string.home, HomeFragment.class);
        Tab tab_cart = new Tab(R.drawable.selector_icon_cart, R.string.cart, CartFragment.class);
        Tab tab_category = new Tab(R.drawable.selector_icon_category, R.string.catagory, CartFragment.class);
        Tab tab_hot = new Tab(R.drawable.selector_icon_hot, R.string.hot, HotFragment.class);
        Tab tab_mine = new Tab(R.drawable.selector_icon_mine, R.string.mine, MineFragment.class);
        mTabs.add(tab_home);
        mTabs.add(tab_cart);
        mTabs.add(tab_category);
        mTabs.add(tab_hot);
        mTabs.add(tab_mine);

        for (Tab tab : mTabs) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndicatorView(tab));
            mTabHost.addTab(tabSpec, tab.getFragment(), null);
        }

        mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        mTabHost.setCurrentTab(0);
    }

    private View buildIndicatorView(Tab tab) {
        View view = mLayoutInflater.inflate(R.layout.tab_indicator, null);

        ImageView img = (ImageView) view.findViewById(R.id.tab_image);
        TextView txt = (TextView) view.findViewById(R.id.tab_title);

        img.setBackgroundResource(tab.getIcon());
        txt.setText(getString(tab.getTitle()));

        return view;
    }
}
