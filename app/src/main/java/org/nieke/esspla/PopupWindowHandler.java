package org.nieke.esspla;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Michael on 22.12.2015.
 */
public class PopupWindowHandler implements View.OnClickListener {


    private EditText textField;
    private PopupMealListener listener;
    private String oldMeal;
    private Button buttonCancel;
    private Button buttonOk;


    public PopupWindowHandler(EditText textField, Button buttonOk, Button buttonCancel, PopupMealListener listener, String oldMeal) {
        this.textField = textField;
        this.listener = listener;
        this.oldMeal = oldMeal;
        this.buttonCancel = buttonCancel;
        this.buttonOk = buttonOk;


        buttonCancel.setOnClickListener(this);
        buttonOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonCancel) {
            listener.mealSelectionCanceled();
        } else if(v == buttonOk) {

            String meal = textField.getText().toString();

            if(meal.equals(oldMeal)) {
                listener.mealSelectionCanceled();
            } else {
                listener.mealSelected(meal);
            }
        }
    }
}
