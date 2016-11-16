package engeneering.digital.solution.permissionslibrary.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import engeneering.digital.solution.permissionslibrary.R;
import engeneering.digital.solution.permissionslibrary.sharePrefs.SharedPreferencesUtils;


/**
 * Created by alessio on 03/03/16.
 */
public class CheckRuntimePermissions {


    private int checkPermissionDenied = 0;
    private List<String> checkPerms = new ArrayList<>();
    private final List<String> permissionsList = new ArrayList<String>();
    private Context mContext;
    private Fragment mFragment;
    public static String CALENDAR = "calendar";
    public static String GPS = "gps";
    public static String CONTACTS = "contacts";
    public static String PHONECALL = "phonecall";
    public static String WRITESTORAGE = "writestorage";
    public static String CAMERA = "camera";
    public static String GETACCOUNT = "getaccount";
    public static String SENDSMS = "sendsms";
    public static String RECEIVESMS = "receivesms";
    public static String READSMS = "readsms";
    public static String CUSTOMREQUEST = "customerequest";


    public boolean setPermissions(Fragment fragment, Context context, String typePermissions, String packageName, @Nullable List<String> permissions, @Nullable HashMap<String, String> tvStrings) {

        mFragment = fragment;
        mContext = context;

        List<String> permissionsNeeded = new ArrayList<String>();
        permissionsList.clear();


        if (typePermissions.equals(CONTACTS)) {
            if (!addPermission(permissionsList, "android.permission.WRITE_CONTACTS"))
                permissionsNeeded.add("WRITE_CONTACTS");
            if (!addPermission(permissionsList, "android.permission.READ_CONTACTS"))
                permissionsNeeded.add("READ_CONTACTS");

            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_contacts);
                        message = context.getResources().getString(R.string.text_permission_contacts);
                        titleForSettings = context.getResources().getString(R.string.title_permission_contacts_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_contacts_dialog_settings);
                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowContacts(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowContacts(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {

                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_CONTACTS);
                return false;
            }


        } else if (typePermissions.equals(CALENDAR)) {
            if (!addPermission(permissionsList, "android.permission.READ_CALENDAR"))
                permissionsNeeded.add("READ_CALENDAR");
            if (!addPermission(permissionsList, "android.permission.WRITE_CALENDAR"))
                permissionsNeeded.add("WRITE_CALENDAR");

            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_calendar);
                        message = context.getResources().getString(R.string.text_permission_calendar);
                        titleForSettings = context.getResources().getString(R.string.title_permission_calendar_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_calendar_dialog_settings);

                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowCalendar(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowCalendar(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {

                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_CALENDAR);
                return false;
            }


        } else if (typePermissions.equals(PHONECALL)) {
            if (!addPermission(permissionsList, "android.permission.CALL_PHONE"))
                permissionsNeeded.add("CALL_PHONE");
            if (!addPermission(permissionsList, "android.permission.READ_PHONE_STATE"))
                permissionsNeeded.add("READ_PHONE_STATE");


            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_phone);
                        message = context.getResources().getString(R.string.text_permission_phone);
                        titleForSettings = context.getResources().getString(R.string.title_permission_phone_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_phone_dialog_settings);

                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowPhoneCall(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowPhoneCall(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {

                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_PHONE);
                return false;
            }


        } else if (typePermissions.equals(GPS)) {
            if (!addPermission(permissionsList, "android.permission.ACCESS_FINE_LOCATION"))
                permissionsNeeded.add("ACCESS_FINE_LOCATION");
            if (!addPermission(permissionsList, "android.permission.ACCESS_COARSE_LOCATION"))
                permissionsNeeded.add("ACCESS_FINE_LOCATION");

            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_gps);
                        message = context.getResources().getString(R.string.text_permission_gps);
                        titleForSettings = context.getResources().getString(R.string.title_permission_gps_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_gps_dialog_settings);

                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowGps(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowGps(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {

                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_GPS);
                return false;
            }

        } else if (typePermissions.equals(WRITESTORAGE)) {
            if (!addPermission(permissionsList, "android.permission.READ_EXTERNAL_STORAGE"))
                permissionsNeeded.add("READ_EXTERNAL_STORAGE");
            if (!addPermission(permissionsList, "android.permission.WRITE_EXTERNAL_STORAGE"))
                permissionsNeeded.add("WRITE_EXTERNAL_STORAGE");

            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_storage);
                        message = context.getResources().getString(R.string.text_permission_storage);
                        titleForSettings = context.getResources().getString(R.string.title_permission_storage_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_storage_dialog_settings);

                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowWriteStorage(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowWriteStorage(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {

                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_STORAGE);
                return false;
            }

        } else if (typePermissions.equals(CAMERA)) {
            if (!addPermission(permissionsList, "android.permission.CAMERA"))
                permissionsNeeded.add("CAMERA");

            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_camera);
                        message = context.getResources().getString(R.string.text_permission_camera);
                        titleForSettings = context.getResources().getString(R.string.title_permission_camera_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_camera_dialog_settings);

                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowCamera(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowCamera(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {

                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_CAMERA);
                return false;
            }

        } else if (typePermissions.equals(GETACCOUNT)) {
            if (!addPermission(permissionsList, "android.permission.GET_ACCOUNTS"))
                permissionsNeeded.add("GET_ACCOUNTS");

            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_account);
                        message = context.getResources().getString(R.string.text_permission_account);
                        titleForSettings = context.getResources().getString(R.string.title_permission_account_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_account_dialog_settings);

                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowAccount(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowAccount(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {

                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_ACCOUNTS);
                return false;
            }

        } else if (typePermissions.equals(SENDSMS)) {
            if (!addPermission(permissionsList, "android.permission.SEND_SMS"))
                permissionsNeeded.add("SEND_SMS");

            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_sms);
                        message = context.getResources().getString(R.string.text_permission_sms);
                        titleForSettings = context.getResources().getString(R.string.title_permission_sms_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_sms_dialog_settings);

                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowSmsSend(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowSmsSend(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {

                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_SEND_SMS);
                return false;
            }

        } else if (typePermissions.equals(RECEIVESMS)) {
            if (!addPermission(permissionsList, "android.permission.RECEIVE_SMS"))
                permissionsNeeded.add("RECEIVE_SMS");

            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_sms);
                        message = context.getResources().getString(R.string.text_permission_sms);
                        titleForSettings = context.getResources().getString(R.string.title_permission_sms_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_sms_dialog_settings);

                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowSmsReceive(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowSmsReceive(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {

                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_RECEIVE_SMS);
                return false;
            }

        } else if (typePermissions.equals(READSMS)) {
            if (!addPermission(permissionsList, "android.permission.READ_SMS"))
                permissionsNeeded.add("READ_SMS");

            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_sms);
                        message = context.getResources().getString(R.string.text_permission_sms);
                        titleForSettings = context.getResources().getString(R.string.title_permission_sms_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_sms_dialog_settings);

                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowSmsRead(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowSmsRead(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {

                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_READ_SMS);
                return false;
            }

        } else if (typePermissions.equals(CUSTOMREQUEST)) {

            for (String perm : permissions) {
                if (!addPermission(permissionsList, perm))
                    permissionsNeeded.add(perm);
            }


            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_custom);
                        message = context.getResources().getString(R.string.text_permission_custom);
                        titleForSettings = context.getResources().getString(R.string.title_permission_custom_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_custom_dialog_settings);

                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowCustom(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowCustom(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {

                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_MULTIPLE_CUSTOM_PERMISSIONS);
                return false;
            }

        }


        return true;

    }


    public boolean setPermissions(Context context, String typePermissions, String packageName, @Nullable List<String> permissions, @Nullable HashMap<String, String> tvStrings) {

        mContext = context;

        SharedPreferencesUtils.setSharedPrefsFileName(packageName);

        List<String> permissionsNeeded = new ArrayList<String>();
        permissionsList.clear();


        if (typePermissions.equals(CONTACTS)) {
            if (!addPermission(permissionsList, "android.permission.WRITE_CONTACTS"))
                permissionsNeeded.add("WRITE_CONTACTS");
            if (!addPermission(permissionsList, "android.permission.READ_CONTACTS"))
                permissionsNeeded.add("READ_CONTACTS");

            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_contacts);
                        message = context.getResources().getString(R.string.text_permission_contacts);
                        titleForSettings = context.getResources().getString(R.string.title_permission_contacts_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_contacts_dialog_settings);
                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowContacts(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowContacts(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {
                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_CONTACTS);
                return false;
            }


        } else if (typePermissions.equals(CALENDAR)) {
            if (!addPermission(permissionsList, "android.permission.READ_CALENDAR"))
                permissionsNeeded.add("READ_CALENDAR");
            if (!addPermission(permissionsList, "android.permission.WRITE_CALENDAR"))
                permissionsNeeded.add("WRITE_CALENDAR");

            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_calendar);
                        message = context.getResources().getString(R.string.text_permission_calendar);
                        titleForSettings = context.getResources().getString(R.string.title_permission_calendar_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_calendar_dialog_settings);
                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowCalendar(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowCalendar(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {
                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_CALENDAR);
                return false;
            }


        } else if (typePermissions.equals(PHONECALL)) {
            if (!addPermission(permissionsList, "android.permission.CALL_PHONE"))
                permissionsNeeded.add("CALL_PHONE");
            if (!addPermission(permissionsList, "android.permission.READ_PHONE_STATE"))
                permissionsNeeded.add("READ_PHONE_STATE");


            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_phone);
                        message = context.getResources().getString(R.string.text_permission_phone);
                        titleForSettings = context.getResources().getString(R.string.title_permission_phone_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_phone_dialog_settings);
                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowPhoneCall(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowPhoneCall(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {
                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_PHONE);
                return false;
            }


        } else if (typePermissions.equals(GPS)) {
            if (!addPermission(permissionsList, "android.permission.ACCESS_FINE_LOCATION"))
                permissionsNeeded.add("ACCESS_FINE_LOCATION");
            if (!addPermission(permissionsList, "android.permission.ACCESS_COARSE_LOCATION"))
                permissionsNeeded.add("ACCESS_FINE_LOCATION");

            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_gps);
                        message = context.getResources().getString(R.string.text_permission_gps);
                        titleForSettings = context.getResources().getString(R.string.title_permission_gps_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_gps_dialog_settings);
                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowGps(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowGps(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {

                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_GPS);
                return false;
            }

        } else if (typePermissions.equals(WRITESTORAGE)) {
            if (!addPermission(permissionsList, "android.permission.READ_EXTERNAL_STORAGE"))
                permissionsNeeded.add("READ_EXTERNAL_STORAGE");
            if (!addPermission(permissionsList, "android.permission.WRITE_EXTERNAL_STORAGE"))
                permissionsNeeded.add("WRITE_EXTERNAL_STORAGE");

            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_storage);
                        message = context.getResources().getString(R.string.text_permission_storage);
                        titleForSettings = context.getResources().getString(R.string.title_permission_storage_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_storage_dialog_settings);
                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowWriteStorage(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowWriteStorage(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {

                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_STORAGE);
                return false;
            }

        } else if (typePermissions.equals(CAMERA)) {
            if (!addPermission(permissionsList, "android.permission.CAMERA"))
                permissionsNeeded.add("CAMERA");

            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_camera);
                        message = context.getResources().getString(R.string.text_permission_camera);
                        titleForSettings = context.getResources().getString(R.string.title_permission_camera_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_camera_dialog_settings);
                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowCamera(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowCamera(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {

                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_CAMERA);
                return false;
            }

        } else if (typePermissions.equals(GETACCOUNT)) {
            if (!addPermission(permissionsList, "android.permission.GET_ACCOUNTS"))
                permissionsNeeded.add("GET_ACCOUNTS");

            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_account);
                        message = context.getResources().getString(R.string.text_permission_account);
                        titleForSettings = context.getResources().getString(R.string.title_permission_account_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_account_dialog_settings);

                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowAccount(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowAccount(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {

                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_ACCOUNTS);
                return false;
            }

        } else if (typePermissions.equals(SENDSMS)) {
            if (!addPermission(permissionsList, "android.permission.SEND_SMS"))
                permissionsNeeded.add("SEND_SMS");

            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_sms);
                        message = context.getResources().getString(R.string.text_permission_sms);
                        titleForSettings = context.getResources().getString(R.string.title_permission_sms_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_sms_dialog_settings);

                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowSmsSend(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowSmsSend(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {

                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_SEND_SMS);
                return false;
            }

        } else if (typePermissions.equals(RECEIVESMS)) {
            if (!addPermission(permissionsList, "android.permission.RECEIVE_SMS"))
                permissionsNeeded.add("RECEIVE_SMS");

            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_sms);
                        message = context.getResources().getString(R.string.text_permission_sms);
                        titleForSettings = context.getResources().getString(R.string.title_permission_sms_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_sms_dialog_settings);

                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowSmsReceive(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowSmsReceive(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {

                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_RECEIVE_SMS);
                return false;
            }

        } else if (typePermissions.equals(READSMS)) {
            if (!addPermission(permissionsList, "android.permission.READ_SMS"))
                permissionsNeeded.add("READ_SMS");

            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_sms);
                        message = context.getResources().getString(R.string.text_permission_sms);
                        titleForSettings = context.getResources().getString(R.string.title_permission_sms_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_sms_dialog_settings);

                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowSmsRead(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowSmsRead(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {

                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }
                ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_READ_SMS);
                return false;
            }

        } else if (typePermissions.equals(CUSTOMREQUEST)) {

            for (String perm : permissions) {
                if (!addPermission(permissionsList, perm))
                    permissionsNeeded.add(perm);
            }


            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    String title = "";
                    String message = "";
                    String titleForSettings = "";
                    String messageForSettings = "";

                    if (tvStrings != null) {
                        title = tvStrings.get(Constant.TITLE_PERMISSION);
                        message = tvStrings.get(Constant.TEXT_PERMISSION);
                        titleForSettings = tvStrings.get(Constant.TITLE_PERMISSION_DIALOG_SETTING);
                        messageForSettings = tvStrings.get(Constant.TEXT_PERMISSION_DIALOG_SETTINGS);
                    } else {
                        title = context.getResources().getString(R.string.title_permission_custom);
                        message = context.getResources().getString(R.string.text_permission_custom);
                        titleForSettings = context.getResources().getString(R.string.title_permission_custom_dialog_settings);
                        messageForSettings = context.getResources().getString(R.string.text_permission_custom_dialog_settings);

                    }
                    if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowCustom(mContext) == 0) {
                        showMessageOKCancel(title, message, typePermissions);
                        return false;
                    } else if (SharedPreferencesUtils.loadCheckForMessageSecurityMarshmallowCustom(mContext) > 0 && permissionsNeeded.size() == permissionsList.size()) {

                        showMessageForSettings(titleForSettings, messageForSettings, typePermissions);
                        return false;
                    }
                }

                ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                        Constant.REQUEST_CODE_ASK_MULTIPLE_CUSTOM_PERMISSIONS);
                return false;
            }

        }

        return true;

    }


    private void showMessageOKCancel(String title, String message, final String typePermissions) {


        final Dialog dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.title_dialog_for_runtime_permission);
        dialog.setCancelable(false);
        TextView mTitle = (TextView) dialog.findViewById(R.id.tvTitleDialog);
        TextView mText = (TextView) dialog.findViewById(R.id.tvTextDialog);
        Button btnDeny = (Button) dialog.findViewById(R.id.btnDeny);
        Button btnAllow = (Button) dialog.findViewById(R.id.btnAllow);
        mTitle.setText(title);
        mText.setText(message);

        dialog.show();

        btnDeny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String msgKo = mContext.getResources().getString(R.string.msg_ko_perms);
                String msgKoCustom = mContext.getResources().getString(R.string.msg_ko_custom_perms);

                if (typePermissions.equals(CONTACTS)) {
                    Toast.makeText(mContext, msgKo, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else if (typePermissions.equals(CALENDAR)) {
                    Toast.makeText(mContext, msgKo, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else if (typePermissions.equals(PHONECALL)) {
                    Toast.makeText(mContext, msgKo, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else if (typePermissions.equals(GPS)) {
                    Toast.makeText(mContext, msgKo, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    //ADD THIS LINE IF YOU WANT TO EMULATE BACKPRESS
                    //((Activity) mContext).onBackPressed();
                } else if (typePermissions.equals(WRITESTORAGE)) {
                    Toast.makeText(mContext, msgKo, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else if (typePermissions.equals(CAMERA)) {
                    Toast.makeText(mContext, msgKo, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else if (typePermissions.equals(GETACCOUNT)) {
                    Toast.makeText(mContext, msgKo, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else if (typePermissions.equals(SENDSMS)) {
                    Toast.makeText(mContext, msgKo, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else if (typePermissions.equals(RECEIVESMS)) {
                    Toast.makeText(mContext, msgKo, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else if (typePermissions.equals(READSMS)) {
                    Toast.makeText(mContext, msgKo, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else if (typePermissions.equals(CUSTOMREQUEST)) {
                    Toast.makeText(mContext, msgKoCustom, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });

        btnAllow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                if (typePermissions.equals(CONTACTS)) {
                    checkPermissionDenied++;
                    SharedPreferencesUtils.saveCheckForMessageSecurityMarshmallowContacts(mContext, checkPermissionDenied);
                    //CHECK IF THE PERMISSION IS REQUEST FROM ACTIVITY OR FRAGMENT
                    if (mFragment != null) {
                        mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_CONTACTS);
                    } else {
                        ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_CONTACTS);
                    }
                } else if (typePermissions.equals(PHONECALL)) {
                    checkPermissionDenied++;
                    SharedPreferencesUtils.saveCheckForMessageSecurityMarshmallowPhoneCall(mContext, checkPermissionDenied);
                    //CHECK IF THE PERMISSION IS REQUEST FROM ACTIVITY OR FRAGMENT
                    if (mFragment != null) {
                        mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_PHONE);
                    } else {
                        ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_PHONE);
                    }
                } else if (typePermissions.equals(CALENDAR)) {
                    checkPermissionDenied++;
                    SharedPreferencesUtils.saveCheckForMessageSecurityMarshmallowCalendar(mContext, checkPermissionDenied);
                    //CHECK IF THE PERMISSION IS REQUEST FROM ACTIVITY OR FRAGMENT
                    if (mFragment != null) {
                        mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_CALENDAR);
                    } else {
                        ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_CALENDAR);
                    }
                } else if (typePermissions.equals(GPS)) {
                    checkPermissionDenied++;
                    SharedPreferencesUtils.saveCheckForMessageSecurityMarshmallowGps(mContext, checkPermissionDenied);
                    //CHECK IF THE PERMISSION IS REQUEST FROM ACTIVITY OR FRAGMENT
                    if (mFragment != null) {
                        mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_GPS);
                    } else {
                        ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_GPS);
                    }
                } else if (typePermissions.equals(WRITESTORAGE)) {
                    checkPermissionDenied++;
                    SharedPreferencesUtils.saveCheckForMessageSecurityMarshmallowWriteStorage(mContext, checkPermissionDenied);
                    //CHECK IF THE PERMISSION IS REQUEST FROM ACTIVITY OR FRAGMENT
                    if (mFragment != null) {
                        mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_STORAGE);
                    } else {
                        ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_STORAGE);
                    }
                } else if (typePermissions.equals(CAMERA)) {
                    checkPermissionDenied++;
                    SharedPreferencesUtils.saveCheckForMessageSecurityMarshmallowCamera(mContext, checkPermissionDenied);
                    //CHECK IF THE PERMISSION IS REQUEST FROM ACTIVITY OR FRAGMENT
                    if (mFragment != null) {
                        mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_CAMERA);
                    } else {
                        ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_CAMERA);
                    }
                } else if (typePermissions.equals(GETACCOUNT)) {
                    checkPermissionDenied++;
                    SharedPreferencesUtils.saveCheckForMessageSecurityMarshmallowAccount(mContext, checkPermissionDenied);
                    //CHECK IF THE PERMISSION IS REQUEST FROM ACTIVITY OR FRAGMENT
                    if (mFragment != null) {
                        mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_CAMERA);
                    } else {
                        ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_CAMERA);
                    }
                } else if (typePermissions.equals(SENDSMS)) {
                    checkPermissionDenied++;
                    SharedPreferencesUtils.saveCheckForMessageSecurityMarshmallowSmsSend(mContext, checkPermissionDenied);
                    //CHECK IF THE PERMISSION IS REQUEST FROM ACTIVITY OR FRAGMENT
                    if (mFragment != null) {
                        mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_SEND_SMS);
                    } else {
                        ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_SEND_SMS);
                    }
                } else if (typePermissions.equals(RECEIVESMS)) {
                    checkPermissionDenied++;
                    SharedPreferencesUtils.saveCheckForMessageSecurityMarshmallowSmsReceive(mContext, checkPermissionDenied);
                    //CHECK IF THE PERMISSION IS REQUEST FROM ACTIVITY OR FRAGMENT
                    if (mFragment != null) {
                        mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_RECEIVE_SMS);
                    } else {
                        ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_RECEIVE_SMS);
                    }
                } else if (typePermissions.equals(READSMS)) {
                    checkPermissionDenied++;
                    SharedPreferencesUtils.saveCheckForMessageSecurityMarshmallowSmsRead(mContext, checkPermissionDenied);
                    //CHECK IF THE PERMISSION IS REQUEST FROM ACTIVITY OR FRAGMENT
                    if (mFragment != null) {
                        mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_READ_SMS);
                    } else {
                        ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_READ_SMS);
                    }
                } else if (typePermissions.equals(CUSTOMREQUEST)) {
                    checkPermissionDenied++;
                    SharedPreferencesUtils.saveCheckForMessageSecurityMarshmallowCustom(mContext, checkPermissionDenied);
                    //CHECK IF THE PERMISSION IS REQUEST FROM ACTIVITY OR FRAGMENT
                    if (mFragment != null) {
                        mFragment.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_MULTIPLE_CUSTOM_PERMISSIONS);
                    } else {
                        ActivityCompat.requestPermissions((Activity) mContext, permissionsList.toArray(new String[permissionsList.size()]),
                                Constant.REQUEST_CODE_ASK_MULTIPLE_CUSTOM_PERMISSIONS);
                    }
                }

            }
        });

    }


    private void showMessageForSettings(String title, String message, final String typePermissions) {


        final Dialog dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.title_dialog_for_runtime_permission);
        dialog.setCancelable(false);
        TextView mTitle = (TextView) dialog.findViewById(R.id.tvTitleDialog);
        TextView mText = (TextView) dialog.findViewById(R.id.tvTextDialog);
        Button btnDeny = (Button) dialog.findViewById(R.id.btnDeny);
        Button btnAllow = (Button) dialog.findViewById(R.id.btnAllow);
        mTitle.setText(title);
        mText.setText(message);
        btnDeny.setText(mContext.getResources().getString(R.string.btn_deny_settings));
        btnAllow.setText(mContext.getResources().getString(R.string.btn_allow_settings));

        dialog.show();

        btnDeny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String msgKo = mContext.getResources().getString(R.string.msg_ko_perms);
                String msgKoCustom = mContext.getResources().getString(R.string.msg_ko_custom_perms);

                if (typePermissions.equals(CONTACTS)) {
                    Toast.makeText(mContext, msgKo, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else if (typePermissions.equals(CALENDAR)) {
                    Toast.makeText(mContext, msgKo, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else if (typePermissions.equals(PHONECALL)) {
                    Toast.makeText(mContext, msgKo, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else if (typePermissions.equals(GPS)) {
                    Toast.makeText(mContext, msgKo, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    //ADD THIS LINE IF YOU WANT TO EMULATE BACKPRESS
                    //((Activity) mContext).onBackPressed();
                } else if (typePermissions.equals(WRITESTORAGE)) {
                    Toast.makeText(mContext, msgKo, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else if (typePermissions.equals(CAMERA)) {
                    Toast.makeText(mContext, msgKo, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else if (typePermissions.equals(GETACCOUNT)) {
                    Toast.makeText(mContext, msgKo, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else if (typePermissions.equals(SENDSMS)) {
                    Toast.makeText(mContext, msgKo, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else if (typePermissions.equals(RECEIVESMS)) {
                    Toast.makeText(mContext, msgKo, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else if (typePermissions.equals(READSMS)) {
                    Toast.makeText(mContext, msgKo, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else if (typePermissions.equals(CUSTOMREQUEST)) {
                    Toast.makeText(mContext, msgKoCustom, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });

        btnAllow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                try {
                    //Open the specific App Info page:
                    Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    intent.setData(Uri.parse("package:" + mContext.getApplicationContext().getPackageName()));
                    mContext.startActivity(intent);

                } catch (ActivityNotFoundException e) {
                    //e.printStackTrace();

                    //Open the generic Apps page:
                    Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS);
                    mContext.startActivity(intent);


                }
            }
        });


    }

    private boolean addPermission(List<String> permissionsList, String permission) {
        if (ContextCompat.checkSelfPermission(mContext, permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
            // Check for Rationale Option
            if (!ActivityCompat.shouldShowRequestPermissionRationale((Activity) mContext, permission))
                return false;
        }
        return true;
    }


    public boolean permissionResults(int requestCode, String[] permissions, int[] grantResults) {


        Map<String, Integer> perms = new HashMap<String, Integer>();
        checkPerms.clear();

        // Fill with results
        for (int i = 0; i < permissions.length; i++) {
            perms.put(permissions[i], grantResults[i]);
            checkPerms.add("false");
        }


        for (int x = 0; x < perms.size(); x++) {
            if (perms.get(permissions[x]) == PackageManager.PERMISSION_GRANTED) {
                checkPerms.set(x, "true");

            }
        }

        for (int x = 0; x < checkPerms.size(); x++) {
            if (checkPerms.get(x).equals("false")) {
                return false;

            }
        }

        permissionsList.clear();
        return true;

    }

}
