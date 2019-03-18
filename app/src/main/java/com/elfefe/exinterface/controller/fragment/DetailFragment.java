package com.elfefe.exinterface.controller.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.elfefe.exinterface.R;

public class DetailFragment extends Fragment implements View.OnClickListener {


    private DetailFragment.OnButtonClickedListener mCallback;

    private static final String KEY_BUTTONTAG = "key_buttontag";
    Button button;
    private int buttonTag;

    public interface OnButtonClickedListener {
        void onButtonClicked(View v);
    }

    public DetailFragment() { }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View result = inflater.inflate(R.layout.fragment_detail, container, false);
        button = (Button) result.findViewById(R.id.detail_button);
        button.setOnClickListener(this);

        Toolbar toolbar = result.findViewById(R.id.toolbar);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        return result;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            int buttonTagRestored = savedInstanceState.getInt(KEY_BUTTONTAG, 0);
            this.updateTextView(buttonTagRestored);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_BUTTONTAG, buttonTag);
    }

    public void updateTextView(int tag) {

        this.buttonTag = tag;
        switch (tag){
            case 10:
                this.button.setText("You're up");
                break;
            case 20:
                this.button.setText("You're middle");
                break;
            case 30:
                this.button.setText("You're down");
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.createCallbackToParentActivity();
    }

    @Override
    public void onClick(View view) {
        mCallback.onButtonClicked(view);
    }


    private void createCallbackToParentActivity(){
        try {
            mCallback = (DetailFragment.OnButtonClickedListener) getActivity();
        } catch (ClassCastException e) {

            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }

    }
}
