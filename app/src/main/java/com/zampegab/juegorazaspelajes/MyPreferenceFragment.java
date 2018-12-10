package com.zampegab.juegorazaspelajes;

        import android.preference.PreferenceFragment;
        import android.os.Bundle;

public class MyPreferenceFragment extends PreferenceFragment {
    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
