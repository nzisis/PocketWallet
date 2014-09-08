package myexpenses.ng2.com.myexpenses.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Nikos on 7/31/2014.
 * This class is to manage data that are stored in the Shared Preferences file
 * these data are relative to the user profile details
 */
public class SharedPrefsManager {

    //the Shared Preferences file name
    private static final String SHARED_PREFS = "UserDetailSharedPrefs";

    //Shared Preferences attributes
    private static final String PREFS_IS_PROFILE = "isProfile";
    private static final String PREFS_USERNAME = "username";
    private static final String PREFS_SALARY = "salary";
    private static final String PREFS_BALANCE = "balance";
    private static final String PREFS_ON_SALARY = "onSalary";
    private static final String PREFS_BONUS = "bonus";
    private static final String PREFS_SAVINGS = "savings";
    private static final String PREFS_SAL_FREQ = "salFreq";
    private static final String PREFS_NPD = "nextPaymentDate";

    //the SharedPreferences and Editor objects
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    //constructor
    public SharedPrefsManager(Context context) {
        prefs = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
    }

    //commit all changes done to the editor
    public void commit() {
        editor.commit();
    }

    //open the editor object for commiting changes
    public void startEditing() {
        editor = prefs.edit();
    }

    /**
     * Below are the setter and getter for each attribute
     */

    public boolean getPrefsIsProfile() {
        return prefs.getBoolean(PREFS_IS_PROFILE, false);
    }

    public String getPrefsUsername() {
        return prefs.getString(PREFS_USERNAME, "User");
    }

    public float getPrefsSavings() {
        return prefs.getFloat(PREFS_SAVINGS, 0);
    }

    public boolean getPrefsBonus() {
        return prefs.getBoolean(PREFS_BONUS, false);
    }

    public float getPrefsSalary() {
        return prefs.getFloat(PREFS_SALARY, 0);
    }

    public boolean getPrefsOnSalary() {
        return prefs.getBoolean(PREFS_ON_SALARY, false);
    }

    public float getPrefsBalance() {
        return prefs.getFloat(PREFS_BALANCE, 0);
    }

    public String getPrefsSalFreq() {
        return prefs.getString(PREFS_SAL_FREQ, "monthly");
    }

    public String getPrefsNpd() {
        return prefs.getString(PREFS_NPD, "01-01-2014");
    }


    public void setPrefsIsProfile(boolean isProfile) {
        editor.putBoolean(PREFS_IS_PROFILE, isProfile);
    }

    public void setPrefsUsername(String username) {
        editor.putString(PREFS_USERNAME, username);
    }

    public void setPrefsSavings(float savings) {
        editor.putFloat(PREFS_SAVINGS, savings);
    }

    public void setPrefsBalance(float balance) {
        editor.putFloat(PREFS_BALANCE, balance);
    }

    public void setPrefsBonus(boolean bonus) {
        editor.putBoolean(PREFS_BONUS, bonus);
    }

    public void setPrefsOnSalary(boolean onSalary) {
        editor.putBoolean(PREFS_ON_SALARY, onSalary);
    }

    public void setPrefsSalary(float salary) {
        editor.putFloat(PREFS_SALARY, salary);
    }

    public void setPrefsSalFreq(String salFreq) {
        editor.putString(PREFS_SAL_FREQ, salFreq);
    }

    public void setPrefsNpd(String npd) {
        editor.putString(PREFS_NPD, npd);
    }

}