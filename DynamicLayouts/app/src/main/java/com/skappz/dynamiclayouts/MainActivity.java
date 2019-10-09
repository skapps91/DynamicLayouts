package com.skappz.dynamiclayouts;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.skappz.dynamiclayouts.resources.customSpinner.CustomSpinnerArrayAdapter;
import com.skappz.dynamiclayouts.resources.customSpinner.CustomSpinnerValues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Activity act;
    String selectedID = "0";

    Spinner spinner;
    LinearLayout dynamicLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        act = MainActivity.this;

        spinner = findViewById( R.id.spinner );

        dynamicLayout = findViewById( R.id.dynamicLayout );

        PopulateSemesterDropDownList( spinner );

    }


    public static String KEY_ID = "ID";
    public static String KEY_VALUE = "VALUE";

    private void PopulateSemesterDropDownList( Spinner dropDown ) {

        /*ArrayList<HashMap<String, String>> dbData = dba.getmUserContact(  );*/


        ArrayList<HashMap<String,String>> arr = new ArrayList<>();

        for( int i=1; i<9; i++ ){

            HashMap map = new HashMap();

            map.put( KEY_ID, i );
            map.put( KEY_VALUE, "Semester "+i );

            arr.add( map );
        }

        final List<CustomSpinnerValues> Data = new ArrayList<>();



        for( HashMap mapData : arr ){

            Data.add( new CustomSpinnerValues(  mapData.get( KEY_ID ).toString(), mapData.get( KEY_VALUE ).toString() ) );

        }


        final CustomSpinnerArrayAdapter adapter = new CustomSpinnerArrayAdapter( act, R.layout.row_spinner, Data );

        dropDown.setAdapter( adapter );


        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                adapter.mSelectedIndex = position;

                selectedID= Data.get(position).getId();

                dynamicLayout.removeAllViews();

                ArrayList<HashMap<String,String>> arr = new ArrayList<>();

                for( int i=0; i<6; i++ ){

                    HashMap map = new HashMap();

                    if( i == 0 ){

                        map.put( KEY_ID, i );
                        map.put( KEY_VALUE, "Grade A" );

                    }

                    if( i == 1 ){

                        map.put( KEY_ID, i );
                        map.put( KEY_VALUE, "Grade B" );

                    }

                    if( i == 2 ){

                        map.put( KEY_ID, i );
                        map.put( KEY_VALUE, "Grade C" );

                    }

                    if( i == 3 ){

                        map.put( KEY_ID, i );
                        map.put( KEY_VALUE, "Grade D" );

                    }

                    if( i == 4 ){

                        map.put( KEY_ID, i );
                        map.put( KEY_VALUE, "Grade E" );

                    }

                    if( i == 5 ){

                        map.put( KEY_ID, i );
                        map.put( KEY_VALUE, "Grade F" );

                    }

                    arr.add( map );
                }


                int selectedIDInt = 1;
                try{
                    selectedIDInt = Integer.parseInt( selectedID );
                }catch (Exception e){
                    selectedIDInt = 1;
                }

                for( int i=0; i<selectedIDInt; i++ ){

                    populateDynamicLayout( dynamicLayout, "Subject "+selectedIDInt, arr );

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void PopulateGradeDropDownList( Spinner dropDown, ArrayList<HashMap<String,String>> values ) {

        final List<CustomSpinnerValues> Data = new ArrayList<>();


        for( HashMap mapData : values ){

            Data.add( new CustomSpinnerValues(  mapData.get( KEY_ID ).toString(), mapData.get( KEY_VALUE ).toString() ) );

        }


        final CustomSpinnerArrayAdapter adapter = new CustomSpinnerArrayAdapter( act, R.layout.row_spinner, Data );

        dropDown.setAdapter( adapter );


        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                adapter.mSelectedIndex = position;

                /*selectedID= Data.get(position).getId();*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    private void populateDynamicLayout(final LinearLayout rootLayout, String value, ArrayList<HashMap<String,String>> gradeValues ) {

        final View LayoutTagLayout = act.getLayoutInflater()
                .inflate(R.layout.layout_dynamic, rootLayout, false);

        TextView subjectTxt = LayoutTagLayout.findViewById(R.id.subjectTxt);
        Spinner gradeSpinner = LayoutTagLayout.findViewById(R.id.gradeSpinner);

        subjectTxt.setText( value );

        PopulateGradeDropDownList( gradeSpinner, gradeValues );

        rootLayout.addView(LayoutTagLayout);




/*
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rootLayout.setVisibility( View.GONE );
                rootLayout.removeView( LayoutTagLayout );

                SelectedProspectLocationCityID = "0";
            }
        });
*/


    }


}
