package com.example.danman.elementrd.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.danman.elementrd.App;
import com.example.danman.elementrd.R;
import com.example.danman.elementrd.model.SomeModel;
import com.example.danman.elementrd.ui.adapter.RecyclerViewAdapter;

import java.util.List;

/**
 * Created by DanMan on 11.12.2016.
 */
public class PageFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private List<SomeModel> models;
    private Context mContext;

    private static final String ARG_SECTION_NUMBER = "section_number";
    public static PageFragment newInstance(int sectionNumber) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.page_fragment, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText(getString(R.string.app_name, getArguments().getInt(ARG_SECTION_NUMBER)));
        return rootView;
    }
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.page_fragment, container);
////        models = App.getContentManager().getDataForFirst();
////        mContext = getActivity();
////        initRecycler(view, models);
//        return view;
//    }

//    private void initRecycler(View view, List<SomeModel> models) {
//        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_rv);
//        mRecyclerView.setAdapter(new RecyclerViewAdapter(models));
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//    }

}
