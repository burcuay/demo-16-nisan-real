package com.segunfamisa.sample.bottomnav;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.segunfamisa.sample.bottomnav.grap.GrapFragment;


/**
 * Fragment class for each nav menu item
 */
public class MenuFragmentGnn extends Fragment {
    private static final String ARG_TEXT = "arg_text";
    private static final String ARG_COLOR = "arg_color";

    private String mText;
    private int mColor;

    private View mContent;
    private TextView mTextView;

    public static Fragment newInstance(String text, int color) {
        Fragment frag = new MenuFragmentGnn();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        args.putInt(ARG_COLOR, color);
        frag.setArguments(args);

        return frag;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gnn, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // retrieve text and color from bundle or savedInstanceState
        if (savedInstanceState == null) {
            Bundle args = getArguments();
            mText = args.getString(ARG_TEXT);
            mColor = args.getInt(ARG_COLOR);
        } else {
            mText = savedInstanceState.getString(ARG_TEXT);
            mColor = savedInstanceState.getInt(ARG_COLOR);
        }

        // initialize views
        mContent = view.findViewById(R.id.fragment_content);
        mTextView = (TextView) view.findViewById(R.id.text);

        // set text and background color
        mTextView.setText(mText);
        mContent.setBackgroundColor(mColor);

        openActivity();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(ARG_TEXT, mText);
        outState.putInt(ARG_COLOR, mColor);
        super.onSaveInstanceState(outState);
    }
    private String package_name="com.segunfamisa.sample.bottomnav.grap";
    private String class_name="com.segunfamisa.sample.bottomnav.grap.GrapFragment";
    public void openActivity() {

        Intent in = new Intent(getActivity(), GrapFragment.class);
        startActivity(in);
//        int a = 5;
//        int b = 10;
//        final Intent dummy= new Intent(Intent.ACTION_MAIN,null);
//
//        dummy.addCategory(Intent.CATEGORY_LAUNCHER);
//
//        final ComponentName lol = new ComponentName(package_name,class_name);
//
//        dummy.setComponent(lol);
//
//        dummy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//        startActivity(dummy);
    }
}
