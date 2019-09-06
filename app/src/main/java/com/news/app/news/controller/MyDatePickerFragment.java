package com.news.app.news.controller;

/**
 * Created by USER on 8/27/2019.
 */

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

public class MyDatePickerFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), dateSetListener, year, month, day);

        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

        return datePickerDialog;
    }

    private DatePickerDialog.OnDateSetListener dateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int month, int day) {


                    if (getArguments().getString("BundleTest") != null && "beginDate".equalsIgnoreCase(getArguments().getString("BundleTest"))) {

                        String beginDate = view.getYear() +
                                "/" + (view.getMonth() + 1) +
                                "/" + view.getDayOfMonth();

                        ((SearchActivity) getActivity()).sendBeginDateValue(beginDate);

                    } else {

                        String endDate = view.getYear() +
                                "/" + (view.getMonth() + 1) +
                                "/" + view.getDayOfMonth();


                        ((SearchActivity) getActivity()).sendEndDateValue(endDate);

                    }


                }
            };

}