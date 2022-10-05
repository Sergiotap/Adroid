package com.example.ciclodevida;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Se ha llamado al método onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Se ha llamado al método onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Se ha llamado al método onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Se ha llamado al método onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Se ha llamado al método onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Se ha llamado al método onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Se ha llamado al método onDestroy");
    }
}