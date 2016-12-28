package com.open.leo.dailycaorie.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.open.leo.dailycaorie.R;

public class CalculatorFragment extends Fragment
{
    // 静态参数
    private static final String ARG_PARAM1 = "param1";

    // 动态参数
    private String mParam1;

    // 交互接口
    private OnFragmentInteractionListener mListener;

    // 必需存在一个空构造函数
    public CalculatorFragment() {}

    /**
     * 使用此方法创建一个此类fragment实例
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return 新的此类fragment实例
     */
    public static CalculatorFragment newInstance(String param1, String param2)
    {
        CalculatorFragment fragment = new CalculatorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        Log.d("TAG", "OnCreateView");
        // 加载布局文件
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }

    //
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener)
        {
            mListener = (OnFragmentInteractionListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    /**
     * 与Activity关联的接口
     */
    public interface OnFragmentInteractionListener
    {
        void onFragmentInteraction(Uri uri);
    }
}
