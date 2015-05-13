package com.luct.minal.theportal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import com.luct.minal.theportal.Java2.Effects;

public class MainActivity extends Activity implements OnClickListener {
    private ImageButton button;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // init Effects class
        Effects.getInstance().init(this);
        button = (ImageButton)findViewById(R.id.imageButton);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Effects.getInstance().playSound(Effects.SOUND_1);
    }
}