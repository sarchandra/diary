////////////////////////////////////////////////////////////////////////////////
//
//  Digital Diary - Personal digital diary for Android
//
//  Copyright (C) 2020	Dharshini Y
//
//
///////////////////////////////////////////////////////////////////////////////

package org.dharshini.diary;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;

import java.text.DateFormat;
import java.util.Date;

// SettingsFragment class
@SuppressWarnings("deprecation")
public class SettingsFragment extends android.preference.PreferenceFragment
    implements SharedPreferences.OnSharedPreferenceChangeListener
{
    // On create
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);

        SharedPreferences preferences =
            PreferenceManager.getDefaultSharedPreferences(getActivity());

        // Get folder summary
        EditTextPreference folder =
            (EditTextPreference) findPreference(Settings.PREF_FOLDER);

        // Set folder in text view
        folder.setSummary(preferences.getString(Settings.PREF_FOLDER,
                                                Diary.DIARY));
        // Get index preference
        DatePickerPreference entry =
            (DatePickerPreference) findPreference(Settings.PREF_INDEX_PAGE);

        // Get value
        long value = preferences.getLong(Settings.PREF_INDEX_PAGE,
                                         DatePickerPreference.DEFAULT_VALUE);
        Date date = new Date(value);

        // Set summary
        DateFormat format = DateFormat.getDateInstance();
        String s = format.format(date);
        entry.setSummary(s);

        // Get template preference
        entry =
            (DatePickerPreference) findPreference(Settings.PREF_TEMPLATE_PAGE);

        // Get value
        value = preferences.getLong(Settings.PREF_TEMPLATE_PAGE,
                                    DatePickerPreference.DEFAULT_VALUE);
        date = new Date(value);

        // Set summary
        s = format.format(date);
        entry.setSummary(s);

        // Get about summary
        Preference about = findPreference(Settings.PREF_ABOUT);
        String sum = about.getSummary().toString();

        // Set version in text view
        s = String.format(sum, BuildConfig.VERSION_NAME);
        about.setSummary(s);
    }

    // on Resume
    @Override
    public void onResume()
    {
        super.onResume();
        getPreferenceScreen().getSharedPreferences()
            .registerOnSharedPreferenceChangeListener(this);
    }

    // on Pause
    @Override
    public void onPause()
    {
        super.onPause();
        getPreferenceScreen().getSharedPreferences()
            .unregisterOnSharedPreferenceChangeListener(this);
    }

    // On preference tree click
    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
                                         Preference preference)
    {
        boolean result =
            super.onPreferenceTreeClick(preferenceScreen, preference);

        // Set home as up
        if (preference instanceof PreferenceScreen)
        {
            Dialog dialog = ((PreferenceScreen) preference).getDialog();
            ActionBar actionBar = dialog.getActionBar();
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        return result;
    }

    // On shared preference changed
    @Override
    public void onSharedPreferenceChanged(SharedPreferences preferences,
                                          String key)
    {
        if (key.equals(Settings.PREF_FOLDER))
        {
            // Get folder summary
            EditTextPreference folder =
                (EditTextPreference) findPreference(key);

            // Set folder in text view
            folder.setSummary(preferences.getString(key, Diary.DIARY));
        }

        if (key.equals(Settings.PREF_INDEX_PAGE))
        {
            // Get index preference
            DatePickerPreference entry =
                (DatePickerPreference) findPreference(key);

            // Get value
            long value =
                preferences.getLong(key, DatePickerPreference.DEFAULT_VALUE);
            Date date = new Date(value);

            // Set summary
            DateFormat format = DateFormat.getDateInstance();
            String s = format.format(date);
            entry.setSummary(s);
        }

        if (key.equals(Settings.PREF_TEMPLATE_PAGE))
        {
            // Get template preference
            DatePickerPreference entry =
                (DatePickerPreference) findPreference(key);

            // Get value
            long value =
                preferences.getLong(key, DatePickerPreference.DEFAULT_VALUE);
            Date date = new Date(value);

            // Set summary
            DateFormat format = DateFormat.getDateInstance();
            String s = format.format(date);
            entry.setSummary(s);
        }

        if (key.equals(Settings.PREF_DARK_THEME))
        {
            if (Build.VERSION.SDK_INT != Build.VERSION_CODES.M)
                getActivity().recreate();
        }
    }
}
