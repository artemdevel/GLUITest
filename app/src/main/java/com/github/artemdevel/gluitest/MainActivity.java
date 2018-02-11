package com.github.artemdevel.gluitest;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private View victimContainer;
    private View victim1;
    private View victim2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GLSurfaceView glSurfaceView = findViewById(R.id.glsurfaceview);
        glSurfaceView.setRenderer(new CubeRenderer(false));

        // Find the views whose visibility will change
        victimContainer = findViewById(R.id.hidecontainer);
        victim1 = findViewById(R.id.hideme1);
        victim1.setOnClickListener(new HideMeListener(victim1));
        victim2 = findViewById(R.id.hideme2);
        victim2.setOnClickListener(new HideMeListener(victim2));

        // Find our buttons
        Button visibleButton = findViewById(R.id.vis);
        Button invisibleButton = findViewById(R.id.invis);
        Button goneButton = findViewById(R.id.gone);

        // Wire each button to a click listener
        visibleButton.setOnClickListener(mVisibleListener);
        invisibleButton.setOnClickListener(mInvisibleListener);
        goneButton.setOnClickListener(mGoneListener);
    }

    @Override
    protected void onResume() {
        // Ideally a game should implement onResume() and onPause()
        // to take appropriate action when the activity looses focus
        super.onResume();
    }

    @Override
    protected void onPause() {
        // Ideally a game should implement onResume() and onPause()
        // to take appropriate action when the activity looses focus
        super.onPause();
    }

    private static class HideMeListener implements View.OnClickListener {

        final View mTarget;

        HideMeListener(View target) {
            mTarget = target;
        }

        public void onClick(View v) {
            mTarget.setVisibility(View.INVISIBLE);
        }

    }

    View.OnClickListener mVisibleListener = new View.OnClickListener() {

        public void onClick(View v) {
            victim1.setVisibility(View.VISIBLE);
            victim2.setVisibility(View.VISIBLE);
            victimContainer.setVisibility(View.VISIBLE);
        }

    };

    View.OnClickListener mInvisibleListener = new View.OnClickListener() {

        public void onClick(View v) {
            victim1.setVisibility(View.INVISIBLE);
            victim2.setVisibility(View.INVISIBLE);
            victimContainer.setVisibility(View.INVISIBLE);
        }

    };

    View.OnClickListener mGoneListener = new View.OnClickListener() {

        public void onClick(View v) {
            victim1.setVisibility(View.GONE);
            victim2.setVisibility(View.GONE);
            victimContainer.setVisibility(View.GONE);
        }

    };

}
