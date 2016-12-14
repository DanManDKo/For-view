package com.example.danman.testapp.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.danman.testapp.R;
import com.example.danman.testapp.ui.activity.MainActivity;
import com.example.danman.testapp.ui.adapter.RecyclerViewAdapter;
import com.example.danman.testapp.model.SomeModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by DanMan on 12.12.2016.
 */
public class PageFragment extends Fragment implements MainActivity.OnTextChangedCallback, RecyclerViewAdapter.OnItemClickCallBack {
    private RecyclerView mRecyclerView;
    private Context mContext;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private static final String ARGUMENTS = "arguments";
    private ArrayList<SomeModel> mSomeModels;
    private CardView mCardView;

    public static PageFragment newInstance(ArrayList<SomeModel> models) {
        PageFragment pageFragment = new PageFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(ARGUMENTS, models);
        pageFragment.setArguments(bundle);
        return pageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_fragment, container, false);
        mCardView = (CardView) view.findViewById(R.id.fragment_card_view);
        Bundle bundle = getArguments();
        mSomeModels = bundle.getParcelableArrayList(ARGUMENTS);
        mContext = getActivity();
        initRecycler(view);
        return view;
    }

    private void initRecycler(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.card_rv);
        mRecyclerViewAdapter = new RecyclerViewAdapter(mSomeModels);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerViewAdapter.setOnItemClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    public void onTextChange(String query) {
        List<SomeModel> filteredList = new ArrayList<>();
        for (SomeModel sm : mSomeModels) {
            if (sm.getTextOne().contains(query))
                filteredList.add(sm);
        }
        mRecyclerViewAdapter.setFilter(filteredList);
    }

    @Override
    public void onItemClick(SomeModel someModel) {
        String message = mContext.getResources().getString(R.string.item_clicked) + " "+ someModel.getTextOne();
        Snackbar.make(mCardView, message, Snackbar.LENGTH_SHORT).show();
    }
}
