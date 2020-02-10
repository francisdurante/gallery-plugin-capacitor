package com.gallery.plugin;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.gallery.plugin.galleryplugin.R;

public class GalleryMainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {
  private static final int REQUEST_WRITE_PERMISSION = 411;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gallery);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        requestPermission();
    }
  @Override
  public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    if (requestCode == REQUEST_WRITE_PERMISSION && grantResults[0] == PackageManager.PERMISSION_GRANTED
      && requestCode == REQUEST_WRITE_PERMISSION && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
      loadFragment(new PictureFragment());
    }
  }
  private void requestPermission() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA}, REQUEST_WRITE_PERMISSION);
    } else {
      loadFragment(new PictureFragment());
    }
  }


  private boolean loadFragment(Fragment fragment) {
    if (fragment != null) {
      getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.main_frame, fragment)
        .commit();
      return true;
    }
    return false;
  }

  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
      Fragment fragment = null;
      switch (menuItem.getTitle().toString()) {

        case "Pictures":
          fragment = new PictureFragment();
          break;
        case "Videos":
          fragment = new VideosFragment();
          break;
      }

      return loadFragment(fragment);
    }
  };
}
