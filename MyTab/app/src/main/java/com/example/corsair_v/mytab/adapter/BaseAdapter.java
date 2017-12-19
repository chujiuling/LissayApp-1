package com.example.corsair_v.mytab.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public abstract class BaseAdapter {

    /**
     *  tab数量
     */
    public abstract int getCount();
    public abstract int hasMsgIndex();
    /**
     * tab text 数组
     */
    public abstract String[] getTextArray();

    /**
     * tab icon 数组
     */
    public abstract int[] getIconImageArray();

    /**
     * tab icon 选中 数组
     */
    public abstract int[] getSelectedIconImageArray();

    /**
     * fragment 数组
     */
    public abstract Fragment[] getFragmentArray();

    public abstract FragmentManager getFragmentManager();



}
