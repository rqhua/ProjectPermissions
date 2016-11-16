package engeneering.digital.solution.projectpermissions;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import engeneering.digital.solution.permissionslibrary.utils.CheckRuntimePermissions;
import engeneering.digital.solution.permissionslibrary.utils.Constant;


public class BlankFragment extends Fragment {


    private CheckRuntimePermissions checkRuntimePermissions = new CheckRuntimePermissions();
    private Button btnPermStdFragment;


    public BlankFragment() {
        // Required empty public constructor
    }


    public static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_blank, container, false);

        btnPermStdFragment = (Button) root.findViewById(R.id.btnPermStdFragment);

        btnPermStdFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean checkPerms = checkRuntimePermissions.setPermissions(BlankFragment.this, getActivity(), checkRuntimePermissions.CAMERA, getActivity().getApplicationContext().getPackageName(), null, null);
                if (checkPerms) {
                    doSomethings();
                }
            }
        });


        return root;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        boolean result;
        switch (requestCode) {

            case Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_CAMERA:
                result = checkRuntimePermissions.permissionResults(requestCode, permissions, grantResults);
                if (result) {
                    doSomethings();
                } else {
                    Toast.makeText(getActivity(), "Permission ko!", Toast.LENGTH_SHORT).show();
                }
                break;

        }

    }

    private void doSomethings() {
        //ALL THAT YOU WANT TO DO WITH THE PERMISSION ACTIVE
        Toast.makeText(getActivity(), "DO SOMETHING IN FRAGMENT", Toast.LENGTH_SHORT).show();
    }
}
