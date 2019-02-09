package com.iconosphere.atmosphere.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iconosphere.atmosphere.R;
import com.iconosphere.atmosphere.data.Blend;
import com.iconosphere.atmosphere.ui.blends.BlendDetailFragment;
import com.iconosphere.atmosphere.ui.blends.BlendFragment;

import java.util.List;

public class BlendAdapter extends RecyclerView.Adapter<BlendAdapter.ViewHolder> {

    // Member variables.
    private List<Blend> mBlendList; // Cached copy of Blends.
    private Context mContext;
    private BlendFragment fragment;

    public BlendAdapter(Context context, BlendFragment fragment) {
        mContext = context;
        this.fragment = fragment;
    }

    @Override
    public BlendAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.blends_detail, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // Get current Blend.
        Blend currentBlend = mBlendList.get(position);

        // Populate the TextViews with data.
        holder.mNameText.setText(currentBlend.getName());
        holder.mRecipeText.setText(currentBlend.getRecipe());

    }

    public void setBlends(List<Blend> blends) {
        mBlendList = blends;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mBlendList != null)
            return mBlendList.size();
        else return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        // Member variables for the TextViews.
        private TextView mNameText;
        private TextView mRecipeText;

        ViewHolder(View itemView) {
            super(itemView);

            // Initialise the views.
            mNameText = itemView.findViewById(R.id.name);
            mRecipeText = itemView.findViewById(R.id.recipe);
            itemView.setOnClickListener(view -> {
                FragmentManager fragmentManager = fragment.getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, BlendDetailFragment.newInstance("One", "Two", "Three", "Four")).addToBackStack(null).commit();
            });
        }
    }
}