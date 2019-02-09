package com.iconosphere.atmosphere.ui.blends;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iconosphere.atmosphere.R;
import com.iconosphere.atmosphere.adapter.BlendAdapter;
import com.iconosphere.atmosphere.data.Blend;
import com.iconosphere.atmosphere.view_models.BlendViewModel;

import java.util.List;

public class BlendFragment extends Fragment {

    public BlendFragment() {

    }
    // Member variables.
    private BlendViewModel mBlendViewModel;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.blends_main, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        final BlendAdapter adapter = new BlendAdapter(getActivity(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mBlendViewModel = ViewModelProviders.of(this).get(BlendViewModel.class);

        mBlendViewModel.getAllBlends().observe(this, new Observer<List<Blend>>() {
            @Override
            public void onChanged(@Nullable final List<Blend> blends) {
                // Update the cached copy of the words in the adapter.
                adapter.setBlends(blends);
            }
        });
        return rootView;
    }
}