package com.example.administrator.arcloader;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.library.ArcConfiguration;
import com.example.library.SimpleArcDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final LinearLayout mRootView = (LinearLayout)findViewById(R.id.rootlayout);

        final SimpleArcDialog mDialog = new SimpleArcDialog(MainActivity.this);
        mDialog.setConfiguration(new ArcConfiguration(MainActivity.this));
        mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                mRootView.setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.loaderButtonRandom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRootView.setVisibility(View.INVISIBLE);
                mDialog.show();
            }
        });
    }
}
