package engeneering.digital.solution.projectpermissions;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import engeneering.digital.solution.permissionslibrary.utils.CheckRuntimePermissions;
import engeneering.digital.solution.permissionslibrary.utils.Constant;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckRuntimePermissions checkRuntimePermissions = new CheckRuntimePermissions();

    private Button btnPermStdActivity, btnPermCustomActivity, btnCallFragment;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPermStdActivity = (Button) findViewById(R.id.btnPermStdActivity);
        btnPermCustomActivity = (Button) findViewById(R.id.btnPermCustomActivity);
        btnCallFragment = (Button) findViewById(R.id.btnCallFragment);


        btnPermStdActivity.setOnClickListener(this);
        btnPermCustomActivity.setOnClickListener(this);
        btnCallFragment.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == btnPermStdActivity.getId()) {
            boolean checkPerms = checkRuntimePermissions.setPermissions(this, checkRuntimePermissions.CALENDAR, getApplicationContext().getPackageName(), null, null);
            if (checkPerms) {
                doSomethings();
            }

        } else if (v.getId() == btnPermCustomActivity.getId()) {

            List<String> permissions = new ArrayList<>();
            HashMap<String, String> texts = new HashMap<>();

            permissions.add("android.permission.CAMERA");
            permissions.add("android.permission.GET_ACCOUNTS");


            //THESE VALUES IS OPTIONAL - IF YOU DON'T SET, THE APP GET THE DEFAULT VALUE
            texts.put(Constant.TITLE_PERMISSION, "Title something");
            texts.put(Constant.TEXT_PERMISSION, "Text something");
            texts.put(Constant.TITLE_PERMISSION_DIALOG_SETTING, "Title something for settings");
            texts.put(Constant.TEXT_PERMISSION_DIALOG_SETTINGS, "Text something for settings");

            boolean checkPerms = checkRuntimePermissions.setPermissions(this, checkRuntimePermissions.CUSTOMREQUEST, getApplicationContext().getPackageName(), permissions, texts);

            if (checkPerms) {
                doSomethings();
            }

        } else if (v.getId() == btnCallFragment.getId()) {

            //HIDE ACTIVITY BUTTONS
            btnPermStdActivity.setVisibility(View.GONE);
            btnPermCustomActivity.setVisibility(View.GONE);
            btnCallFragment.setVisibility(View.GONE);

            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, BlankFragment.newInstance())
                    .commit();

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean result;
        switch (requestCode) {

            case Constant.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_CALENDAR:
                result = checkRuntimePermissions.permissionResults(requestCode, permissions, grantResults);
                if (result) {
                    doSomethings();
                } else {
                    Toast.makeText(this, "Permission ko!", Toast.LENGTH_SHORT).show();
                }
                break;
            case Constant.REQUEST_CODE_ASK_MULTIPLE_CUSTOM_PERMISSIONS:
                result = checkRuntimePermissions.permissionResults(requestCode, permissions, grantResults);
                if (result) {
                    doSomethings();
                } else {
                    Toast.makeText(this, "Permission ko!", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }


    private void doSomethings() {
        //ALL THAT YOU WANT TO DO WITH THE PERMISSION ACTIVE
        Toast.makeText(this, "DO SOMETHING", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        //SHOW ACTIVITY BUTTONS
        btnPermStdActivity.setVisibility(View.VISIBLE);
        btnPermCustomActivity.setVisibility(View.VISIBLE);
        btnCallFragment.setVisibility(View.VISIBLE);

    }
}
