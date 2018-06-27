package com.example.abhinav.agrifriend;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by abhin on 20-Nov-17.
 */


    public class CropAdapter extends ArrayAdapter<Crop>  {

        /** Resource ID for the background color for this list of crops */
        private int mColorResourceId;

        public CropAdapter(Context context, ArrayList<Crop> crops, int colorResourceId) {
            super(context, 0, crops);
            mColorResourceId = colorResourceId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if an existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_item, parent, false);
            }

            Crop currentCrop = getItem(position);

            TextView kannadaTextView = (TextView) listItemView.findViewById(R.id.kannada_text_view);

            kannadaTextView.setText(currentCrop.getmKannadaTranslation());

            TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

            defaultTextView.setText(currentCrop.getDefaultTranslation());

            ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

            if (currentCrop.hasImage()) {
                imageView.setImageResource(currentCrop.getImageResourceId());
                imageView.setVisibility(View.VISIBLE);
            } else {
                imageView.setVisibility(View.GONE);
            }

            View textContainer = listItemView.findViewById(R.id.text_container);

            int color = ContextCompat.getColor(getContext(), mColorResourceId);

            textContainer.setBackgroundColor(color);

            return listItemView;
        }
    }
