package com.news.app.news.controller;

/*
  Created by USER on 8/27/2019.
 */

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Objects;

public class MyDatePickerFragment extends DialogFragment {


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(Objects.requireNonNull(getActivity()), dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        return datePickerDialog;
    }

    private final DatePickerDialog.OnDateSetListener dateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                public void onDateSet(DatePicker view, int year, int month, int day) {

                    assert getArguments() != null;
                    if (getArguments().getString("BundleTest") != null && "beginDate".equalsIgnoreCase(getArguments().getString("BundleTest"))) {

                        String beginDate = view.getYear() +
                                "/" + (view.getMonth() + 1) +
                                "/" + view.getDayOfMonth();
                        ((SearchActivity) Objects.requireNonNull(getActivity())).sendBeginDateValue(beginDate);

                    } else {

                        String endDate = view.getYear() +
                                "/" + (view.getMonth() + 1) +
                                "/" + view.getDayOfMonth();
                        ((SearchActivity) Objects.requireNonNull(getActivity())).sendEndDateValue(endDate);

                    }


                }
            };

}