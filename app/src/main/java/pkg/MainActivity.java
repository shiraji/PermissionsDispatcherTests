package pkg;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.shiraji.myapplication.R;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    @NeedsPermission(Manifest.permission.CAMERA)
//    void showCamera() {
//        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, 1, null);
//    }

    @OnShowRationale(Manifest.permission.CAMERA)
    void onShowRationale(PermissionRequest request) {
    }

    @NeedsPermission({Manifest.permission.CAMERA, Manifest.permission.BATTERY_STATS})
    void showCamera2() {
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, 1, null);
    }
//
//    @OnShowRationale({Manifest.permission.CAMERA, Manifest.permission.BATTERY_STATS})
//    void onShowRationale2(PermissionRequest request) {
//    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
}
