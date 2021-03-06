package com.z2wenfa.permissionrequesterdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.z2wenfa.permissionrequestlibary.permission.PermissionRequest;
import com.z2wenfa.permissionrequestlibary.permission.Permissions;

public class MainActivity extends BaseActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        PermissionRequest.requestPermissionInOnCreateMethod(this, 2015, Permissions.CAMERA, Permissions.LOCATION);//在界面还未显示前进行权限请求
    }


    private void initView() {
        button = (Button) findViewById(R.id.btn1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermissionRequest.requestPermission(MainActivity.this, 2015, Permissions.CONTACTS, Permissions.SMS); //界面已经显示了进行权限的请求
            }
        });

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, new TestFragment());
        fragmentTransaction.commit();
    }


}
