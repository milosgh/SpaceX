package com.example.spacexpastlaunches.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.spacexpastlaunches.R;
import com.example.spacexpastlaunches.data.remote.beans.Launch;

import java.util.List;

/**
 * Created by milospesic on 10/05/19.
 */
public class LaunchesAdapter extends RecyclerView.Adapter<LaunchesAdapter.LaunchViewHolder> {
    private List<Launch> mLaunches;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class LaunchViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvName;
        public ImageView imgLaunch;
        public ImageView imgStatus;

        public LaunchViewHolder(View convertView) {
            super(convertView);
            tvName = convertView.findViewById(R.id.tvName);
            imgLaunch = convertView.findViewById(R.id.ivPhoto);
            imgStatus = convertView.findViewById(R.id.ivStatus);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public LaunchesAdapter(List<Launch> myDataset) {
        mLaunches = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public LaunchViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {

        LaunchViewHolder launchViewHolder = new LaunchViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_launch, parent, false));
        return launchViewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(LaunchViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Launch launch = mLaunches.get(position);
        holder.tvName.setText(launch.getMissionName());
        Glide.with(holder.tvName.getContext())
                .load(launch.getLinks().getMissionPatch())
                .into(holder.imgLaunch);
        if (launch.isLaunchSuccess()) {
            holder.imgStatus.setImageResource(R.drawable.baseline_check_black_24);
        } else {
            holder.imgStatus.setImageResource(R.drawable.baseline_close_black_24);
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mLaunches.size();
    }

}