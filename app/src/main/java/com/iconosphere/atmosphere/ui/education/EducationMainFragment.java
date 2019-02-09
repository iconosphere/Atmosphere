package com.iconosphere.atmosphere.ui.education;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.iconosphere.atmosphere.R;

public class EducationMainFragment extends Fragment {
    public EducationMainFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.education_main_fragment, container, false);

        Button button = rootView.findViewById(R.id.button_education_diffuser);
        button.setOnClickListener(view -> {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, new EducationViewPager()).addToBackStack(null).commit();
        });
        return rootView;
    }
}
