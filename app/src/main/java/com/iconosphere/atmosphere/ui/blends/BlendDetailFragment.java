package com.iconosphere.atmosphere.ui.blends;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.iconosphere.atmosphere.R;

public class BlendDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "detail_name";
    private static final String ARG_PARAM2 = "detail_recipe";
    private static final String ARG_PARAM3 = "detail_furtherinfo";
    private static final String ARG_PARAM4 = "detail_didyouknow";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;
    private String mParam4;


    public BlendDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlendDetailFragment newInstance(String param1, String param2, String param3, String param4) {
        BlendDetailFragment fragment = new BlendDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        args.putString(ARG_PARAM4, param4);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
            mParam4 = getArguments().getString(ARG_PARAM4);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.blends_detail_fragment, container, false);
        TextView detail_name = rootView.findViewById(R.id.detail_name);
        TextView detail_recipe = rootView.findViewById(R.id.detail_recipe);
        TextView detail_furtherinfo = rootView.findViewById(R.id.detail_furtherinfo);
        TextView detail_didyouknow = rootView.findViewById(R.id.detail_didyouknow);
        detail_name.setText(mParam1);
        detail_recipe.setText(mParam2);
        detail_furtherinfo.setText(mParam3);
        detail_didyouknow.setText(mParam4);
        return rootView;
    }

}

