package com.zhcw.analysisdata.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.zhcw.analysisdata.view.ui.MainActivity;

/**
 * Created by YangChun .
 * on 2017/3/6.
 */

public abstract class BaseFragment extends Fragment {
    public MainActivity activity;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        activity = (MainActivity) getActivity();

        super.onActivityCreated(savedInstanceState);
    }


}
