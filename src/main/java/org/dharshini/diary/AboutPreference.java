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
import android.preference.DialogPreference;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;

// AboutPreference class
public class AboutPreference extends DialogPreference
{
    // Constructor
    public AboutPreference(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    // On bind dialog view
    @Override
    protected void onBindDialogView(View view)
    {
        super.onBindDialogView(view);

        // Get version text view
        TextView version = view.findViewById(R.id.about);

        // Set version in text view
        if (version != null)
        {
            SpannableStringBuilder builder =
                new SpannableStringBuilder(version.getText());
            int st = builder.toString().indexOf("%s");
            int en = builder.length();
            builder.replace(st, en, BuildConfig.VERSION_NAME);
            version.setText(builder);
            version.setMovementMethod(LinkMovementMethod.getInstance());
        }

        // Get built text view
        TextView built = view.findViewById(R.id.built);

        // Set built date in text view
        if (built != null)
        {
            String d = built.getText().toString();
            DateFormat dateFormat = DateFormat.getDateTimeInstance();
            String s =
                String.format(d, dateFormat.format(BuildConfig.BUILT));
            built.setText(s);
        }

        // Get copyright text view
        TextView copyright = view.findViewById(R.id.copyright);

        // Set movement method
        if (copyright != null)
            copyright.setMovementMethod(LinkMovementMethod.getInstance());

        // Get licence text view
        TextView licence = view.findViewById(R.id.licence);

        // Set movement method
        if (licence != null)
            licence.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
