package com.elfefe.exinterface.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elfefe.exinterface.R;

public class MainFragment extends Fragment implements View.OnClickListener {

    private OnButtonClickedListener mCallback;

    public interface OnButtonClickedListener {
        void onButtonClicked(View v);
    }

    public MainFragment() { }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View result=inflater.inflate(R.layout.fragment_main, container, false);

        Toolbar toolbar = result.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        result.findViewById(R.id.main_button_up).setOnClickListener(this);
        result.findViewById(R.id.main_button_mid).setOnClickListener(this);
        result.findViewById(R.id.main_button_down).setOnClickListener(this);

        return result;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.createCallbackToParentActivity();
    }


    @Override

    public void onClick(View v) {

        mCallback.onButtonClicked(v);
    }


    private void createCallbackToParentActivity(){
        try {
            mCallback = (OnButtonClickedListener) getActivity();
        } catch (ClassCastException e) {

            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }

    }
}
