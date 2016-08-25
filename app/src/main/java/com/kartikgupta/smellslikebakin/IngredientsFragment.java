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
 * Created by kartik on 25/8/16.
 */
public class IngredientsFragment extends CheckBoxesFragment {

    @Override
    public String[] getContents(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
