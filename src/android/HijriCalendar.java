package com.bionworks.hirjicalendar;

import com.github.msarhan.ummalqura.calendar.UmmalquraCalendar;

import net.alhazmy13.hijridatepicker.date.hijri.HijriDatePickerDialog;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class HijriCalendar extends CordovaPlugin implements HijriDatePickerDialog.OnDateSetListener {
    private CallbackContext callbackContext;


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        this.callbackContext = callbackContext;
        if (action.equals("show")) {
            this.showCalendar();
            return true;
        }
        return false;
    }

    private void showCalendar() {
        UmmalquraCalendar now = new UmmalquraCalendar();
        HijriDatePickerDialog dpd = HijriDatePickerDialog.newInstance(
                this,
                now.get(UmmalquraCalendar.YEAR),
                now.get(UmmalquraCalendar.MONTH),
                now.get(UmmalquraCalendar.DAY_OF_MONTH));
        dpd.show(cordova.getActivity().getFragmentManager(), "HijriDatePickerDialog");
    }

    @Override
    public void onDateSet(HijriDatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        this.callbackContext.success(dayOfMonth + "/" + (++monthOfYear) + "/" + year);
    }
}
