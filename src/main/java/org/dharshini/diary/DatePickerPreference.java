////////////////////////////////////////////////////////////////////////////////
//
//  Digital Diary - Personal digital diary for Android
//
//  Copyright (C) 2020	Dharshini Y
//
//
///////////////////////////////////////////////////////////////////////////////

package org.dharshini.diary;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.GregorianCalendar;

// DatePickerPreference
public class DatePickerPreference extends DialogPreference
{
    protected final static long DEFAULT_VALUE = 946684800000L;

    private long value = DEFAULT_VALUE;

    // Constructor
    public DatePickerPreference(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    // On create dialog view
    @Override
    protected View onCreateDialogView()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(value);

        DatePicker picker = new DatePicker(getContext());
        // onDateChanged
        picker.init(calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DATE),
                    (view, year, monthOfYear, dayOfMonth) ->
        {
            Calendar calendar1 = new
            GregorianCalendar(year, monthOfYear,
                              dayOfMonth);
            value = calendar1.getTimeInMillis();
        });
        return picker;
    }

    // On get default value
    @Override
    protected Object onGetDefaultValue(TypedArray a, int index)
    {
        return DEFAULT_VALUE;
    }

    // On set initial value
    @Override
    protected void onSetInitialValue(boolean restorePersistedValue,
                                     Object defaultValue)
    {
        if (restorePersistedValue)
        {
            // Restore existing state
            value = getPersistedLong(DEFAULT_VALUE);
        }
        else
        {
            // Set default state from the XML attribute
            value = (Long) defaultValue;
            persistLong(value);
        }
    }

    // On dialog closed
    @Override
    protected void onDialogClosed(boolean positiveResult)
    {
        // When the user selects "OK", persist the new value
        if (positiveResult)
        {
            persistLong(value);
        }
    }

    // Get value
    protected long getValue()
    {
        return value;
    }
}
