package com.iconosphere.atmosphere.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.iconosphere.atmosphere.R;

public class MainFragment extends Fragment {

    public MainFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.home_screen, container, false);

        ImageView buttonEducation = rootView.findViewById(R.id.home_screen_education_image);
        buttonEducation.setOnClickListener(view -> {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, new EducationFragment()).addToBackStack(null).commit();
        });

        return rootView;
    }


}
