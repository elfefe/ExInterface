package com.elfefe.exinterface.controller.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elfefe.exinterface.R;

public class PageFragment extends Fragment {

    private static final String KEY_POSITION="position";
    private static final String KEY_COLOR="color";

    public PageFragment(){ }

    public static PageFragment newInstance(int position, int color){
        PageFragment frag = new PageFragment();

        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        args.putInt(KEY_COLOR, color);
        frag.setArguments(args);

        return frag;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View result = inflater.inflate(R.layout.fragment_page, container, false);

        @SuppressLint("CutPasteId") ConstraintLayout rootView = (ConstraintLayout) result.findViewById(R.id.fragment_page_rootview);
        @SuppressLint("CutPasteId") TextView textView= (TextView) result.findViewById(R.id.fragment_page_title);

        int position = 0;
        int color = 0;
        if (getArguments() != null) {
            position = getArguments().getInt(KEY_POSITION, -1);
            color = getArguments().getInt(KEY_COLOR, -1);
        }

        rootView.setBackgroundColor(color);
        textView.setText("Page : "+ position);

        return result;
    }
}
