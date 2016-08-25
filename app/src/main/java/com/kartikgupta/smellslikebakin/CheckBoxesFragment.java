package com.kartikgupta.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

/**
 * Created by kartik on 26/8/16.
 */
public abstract class CheckBoxesFragment extends Fragment{
    private static final String KEY_STATE_OF_CHECKBOXES ="state_of_checkboxes" ;
    CheckBox[] mCheckBoxes ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        View view = inflater.inflate(R.layout.fragment_checkboxes, container, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.contentLinearLayout);

        String[] contents =getContents(index);
        mCheckBoxes = new CheckBox[contents.length];
        boolean[] checkedBoxes = new boolean[mCheckBoxes.length];
        if(savedInstanceState!=null && savedInstanceState.getBooleanArray(KEY_STATE_OF_CHECKBOXES)!=null){
            checkedBoxes = savedInstanceState.getBooleanArray(KEY_STATE_OF_CHECKBOXES);
        }
        setUpCheckBoxes(contents,linearLayout,checkedBoxes);
        return view;
    }

    public abstract String[] getContents(int index);


    public void setUpCheckBoxes(String[] contents, ViewGroup container, boolean[] checkedBoxes){

        int i=0;
        for(String content:contents){
            mCheckBoxes[i] = new CheckBox(getActivity());
            mCheckBoxes[i].setPadding(8, 16, 8, 16);
            mCheckBoxes[i].setTextSize(20f);
            mCheckBoxes[i].setText(content);
            container.addView(mCheckBoxes[i]);
            if(checkedBoxes[i]){
                mCheckBoxes[i].toggle();
            }
            i++;
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        boolean[] stateOfCheckedBoxes=new boolean[mCheckBoxes.length];
        int i=0;
        for(CheckBox checkBox:mCheckBoxes){

            stateOfCheckedBoxes[i] = mCheckBoxes[i].isChecked();
            i++;
        }
        outState.putBooleanArray(KEY_STATE_OF_CHECKBOXES,stateOfCheckedBoxes);
        super.onSaveInstanceState(outState);
    }
}
