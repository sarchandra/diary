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
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;

// Settings
public class Settings extends Activity
{
    public final static String PREF_ABOUT = "pref_about";
    public final static String PREF_CUSTOM = "pref_custom";
    public final static String PREF_FOLDER = "pref_folder";
    public final static String PREF_EXTERNAL = "pref_external";
    public final static String PREF_MARKDOWN = "pref_markdown";
    public final static String PREF_USE_INDEX = "pref_use_index";
    public final static String PREF_INDEX_PAGE = "pref_index_page";
    public final static String PREF_USE_TEMPLATE = "pref_use_template";
    public final static String PREF_TEMPLATE_PAGE = "pref_template_page";
    public final static String PREF_COPY_MEDIA = "pref_copy_media";
    public final static String PREF_DARK_THEME = "pref_dark_theme";

    // onCreate
    @Override
    @SuppressWarnings("deprecation")
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Get preferences
        SharedPreferences preferences =
            PreferenceManager.getDefaultSharedPreferences(this);

        boolean darkTheme =
            preferences.getBoolean(PREF_DARK_THEME, false);

        if (darkTheme)
            setTheme(R.style.AppDarkTheme);

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
            .replace(android.R.id.content, new SettingsFragment())
            .commit();

        // Enable back navigation on action bar
        ActionBar actionBar = getActionBar();
        if (actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.settings);
        }
    }

    // onOptionsItemSelected
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Home, finish
        if (item.getItemId() == android.R.id.home)
        {
            finish();
            return true;
        }

        return false;
    }
}
