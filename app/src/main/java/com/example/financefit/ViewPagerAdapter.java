package com.example.financefit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    int[] sliderAllImages = {R.drawable.credit_card_1, R.drawable.budget, R.drawable.organize};
    int[] sliderAllTitles = {R.string.slider_text_1, R.string.slider_text_2, R.string.slider_text_3};
    int[] sliderAllDesc = {R.string.slider_desc_1, R.string.slider_desc_2, R.string.slider_desc_3};

    public ViewPagerAdapter(Context context)
    {
        this.context=context;
    }


    @Override
    public int getCount() {
        return sliderAllTitles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout,container,false);

        ImageView slideTitleImage = (ImageView) view.findViewById(R.id.titleImage);
        TextView slideHeading = (TextView) view.findViewById(R.id.textTitle);
        TextView slideDescription = (TextView) view.findViewById(R.id.textDesc);

        slideTitleImage.setImageResource(sliderAllImages[position]);
        slideHeading.setText(sliderAllTitles[position]);
        slideDescription.setText(sliderAllDesc[position]);

        container.addView(view);

        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout) object);
    }
}
