package com.iconosphere.atmosphere.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.iconosphere.atmosphere.R;
import com.iconosphere.atmosphere.ui.blends.BlendDetailFragment;
import com.iconosphere.atmosphere.ui.blends.BlendFragment;
import com.iconosphere.atmosphere.ui.education.EducationMainFragment;

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
            fragmentManager.beginTransaction().replace(R.id.fragment_container, new EducationMainFragment()).addToBackStack(null).commit();
        });

        ImageView buttonBlends = rootView.findViewById(R.id.home_screen_blends_image);
        buttonBlends.setOnClickListener(view -> {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, new BlendFragment()).addToBackStack(null).commit();
        });

        ImageView buttonMyCollection = rootView.findViewById(R.id.home_screen_my_collection_image);
        buttonMyCollection.setOnClickListener(view -> {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, BlendDetailFragment.newInstance("Name of a Blend", "Recipe", "Loads of text", "Even more text.")).addToBackStack(null).commit();
        });

        return rootView;
    }


}
