package com.skappz.dynamiclayouts.resources.customSpinner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.skappz.dynamiclayouts.R;

import java.util.List;

public class CustomSpinnerArrayAdapter extends ArrayAdapter<String> {


    private LayoutInflater mInflater;
    private Context mContext;
    private List items;
    private  int mResourceLayout;

    public TextView valueTxt;
    /*public TextView cityCountryTxt;*/

    public int mSelectedIndex = 0;


    public CustomSpinnerArrayAdapter(Context context, int resource, List objects ) {
        super(context, resource, 0, objects);

        mContext = context;
        mInflater = LayoutInflater.from(context);
        items = objects;

        mResourceLayout = resource;

    }


    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {

        View view = createItemView(position, convertView, parent);

        TextView valueTxt = view.findViewById( R.id.valueTxt );
        /*TextView cityCountryTxt = view.findViewById(R.id.cityCountryTxt);*/

        /*valueTxt.setTextAppearance(R.style.TextStyle_Black11Regular);
        cityCountryTxt.setTextAppearance(R.style.TextStyle_Black9Regular);*/


        // If this item is selected item
        if(position == mSelectedIndex){


            /*addressTxt.setTextAppearance(R.style.TextStyle_DarkGreen11Bold);
            cityCountryTxt.setTextAppearance(R.style.TextStyle_DarkGreen9Bold);*/

        }


        return view;
    }

    @Override
    public @NonNull View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent){
        final View view = mInflater.inflate( mResourceLayout, parent, false);


        valueTxt = view.findViewById( R.id.valueTxt );
        /*cityCountryTxt = view.findViewById( R.id.cityCountryTxt );*/

        CustomSpinnerValues Data = (CustomSpinnerValues) items.get(position);

        valueTxt.setText(Data.getValue() );
        /*cityCountryTxt.setText(Data.getCity()+", "+Data.getCountry() );*/

        /*if( Data.getCity().isEmpty() ){
            cityCountryTxt.setVisibility( View.GONE );
        }else{
            cityCountryTxt.setVisibility( View.VISIBLE );
        }*/


        /*valueTxt.setTextAppearance(R.style.TextStyle_DarkGreen11Bold);
        cityCountryTxt.setTextAppearance(R.style.TextStyle_DarkGreen9Bold);*/


        return view;
    }




}
