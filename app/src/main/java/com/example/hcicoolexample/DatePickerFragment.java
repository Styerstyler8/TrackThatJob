package com.example.hcicoolexample;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;


public class DatePickerFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
    }
}
