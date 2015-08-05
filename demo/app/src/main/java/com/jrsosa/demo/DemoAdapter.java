package com.jrsosa.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Joel Roman Sosa  on 8/4/2015.
 * A simple item adapter using classic ViewHolder pattern for re-usage
 * <p/>
 * For job demo purposes only, in production code we should use something like a RecyclerView.ViewHolder
 * and integrate a reflection library for easy of binding.
 */
public class DemoAdapter extends ArrayAdapter<DemoModel> {

    public DemoAdapter(Context context, int resource, List<DemoModel> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {

        ViewHolder viewHolder;

        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.view_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.businessImageView = (ImageView) v.findViewById(R.id.business_image_view);
            viewHolder.nameTextView = (TextView) v.findViewById(R.id.name_text_view);
            viewHolder.addressTextView = (TextView) v.findViewById(R.id.address_text_view);
            v.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) v.getTag(); /** next item will reuse this layout, no need for another call to findViewById */
        }

        //Get object
        DemoModel track = getItem(position);

        //populate
        if (track != null) {
            viewHolder.nameTextView.setText(track.getTrackName());
            Picasso.with(getContext()).load(track.getTrackCoverImage()).fit().into(viewHolder.businessImageView);

        }

        return v;
    }

    static class ViewHolder {
        ImageView businessImageView;
        TextView nameTextView, addressTextView;

    }
}
