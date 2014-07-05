package com.flour.launcher3;
import android.os.Bundle;
import android.content.Context;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.Preference.OnPreferenceChangeListener;

import com.flour.launcher3.R;

public class FlourSettings extends PreferenceActivity implements OnPreferenceChangeListener
{
	private Preference mboot;
	private CheckBoxPreference mEnableDrawer;
	
	@Override
	     public void onCreate(Bundle savedInstanceState) {
	         super.onCreate(savedInstanceState);
	         addPreferencesFromResource(R.xml.settings);
	         // Initialize the preferences
	         mboot = findPreference(SettingsProvider.KEY_SETTINGS_BOOT);
	         mboot.setOnPreferenceChangeListener(this);
	         
	         mEnableDrawer = (CheckBoxPreference) findPreference(SettingsProvider.KEY_INTERFACE_HOMESCREEN_DRAWER_ENABLE_DRAWER);
	         mEnableDrawer.setChecked(SettingsProvider.getBoolean(this, SettingsProvider.KEY_INTERFACE_HOMESCREEN_DRAWER_ENABLE_DRAWER, false));
	         mEnableDrawer.setOnPreferenceChangeListener(this);
	         
	         }
	     
	     public boolean onPreferenceChange(Preference preference, Object newValue)
	         {
	             boolean ret = false;
                 boolean needsRestart = false;
                
                 if (preference == mEnableDrawer) 
			     {
	                 boolean enable = (Boolean) newValue;
	                 mEnableDrawer.setChecked(enable);
	                 SettingsProvider.putBoolean(this,
	                     SettingsProvider.KEY_INTERFACE_HOMESCREEN_DRAWER_ENABLE_DRAWER,
	                     enable);
	                 ret = true;
	                 needsRestart = true;
	             }

	             if (preference == mboot)
					 {
	                 // I am Launcher, so I will restart after killing
	                 System.exit(0);
	                 return true;
	                 } 
					 else {
	                 return false;
	             }
	             
	         }
}
