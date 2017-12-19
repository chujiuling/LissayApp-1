package com.example.corsair_v.mytab;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    @Nullable
    private RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_tab_1,container,false);
//        mAdapter = new MyAdapter(getData());
//
//        mRecyclerView = (RecyclerView)view.findViewById(R.id.my_recycler_view);
//        // 设置布局管理器
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        // 设置adapter
//        mRecyclerView.setAdapter(mAdapter);
//       /* mRecyclerView.addItemDecoration(new MyDividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));*/
        return  view;

    }



    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        String temp = "听说是一个集读写收藏日记为主体，提供一个没有社交、没有赞，展现真实自我的平台。排除了好友，赞，社交等流行元素后，在这浮躁的年代，希望我们能听到自己内心最真实的声音。";
        String temp2="简洁的撰写界面，打开就写，随时随地记录生活的点滴。每一段文字，是一份触碰心灵的感受，更是对未来自己的留言。完全匿名及自由选 择开放评论的的形式，给你一个专属的私人空间。日记是岁月的保险柜，也是灵魂的密室，更是你忠实的朋友";

        for(int i = 0; i < 20; i++) {
            if(i%2 == 0)
            {
                data.add( temp);
            }
            else{
                data.add(temp2);
            }
        }

        return data;
    }

}