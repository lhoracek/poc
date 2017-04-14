package cz.lhoracek.lifecyclepoc;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import cz.lhoracek.lifecyclepoc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private final ObservableBoolean visible = new ObservableBoolean(true);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setListenerActivity((view) -> startActivity(new Intent(this, ChildActivity.class)));
        binding.setListenerDialog((view) -> startDialog());
        binding.setListenerVisibility(view -> visible.set(!visible.get()));
        binding.setActivity(this);
        binding.setHours(12);
        binding.setMins(25);


        Log.d(TAG, getResources().getString(R.string.formatter, 12, 25));
        Log.d(TAG, "onCreate");

        Animator appearingAnimation = ObjectAnimator.ofFloat(null, "rotationY", 90, 0);
        appearingAnimation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator anim) {
                Log.d(TAG, "onAimationStart appearing");
                View view = (View) ((ObjectAnimator) anim).getTarget();
                view.setRotationY(90);
            }

            public void onAnimationEnd(Animator anim) {
                View view = (View) ((ObjectAnimator) anim).getTarget();
                view.setRotationY(0f);
            }
        });

        Animator disappearAnimation = ObjectAnimator.ofFloat(null, "rotationY", 360, 270);
        disappearAnimation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator anim) {
                Log.d(TAG, "onAimationStart disappearing");
                View view = (View) ((ObjectAnimator) anim).getTarget();
                view.setRotationY(360);
            }

            public void onAnimationEnd(Animator anim) {
                View view = (View) ((ObjectAnimator) anim).getTarget();
                view.setRotationY(270f);
            }
        });


        int duration = 300;

        LayoutTransition transitioner = new LayoutTransition();
        transitioner.setDuration(duration);
        transitioner.setStartDelay(LayoutTransition.APPEARING, duration);
        transitioner.setStartDelay(LayoutTransition.DISAPPEARING, 0);

        transitioner.setStagger(LayoutTransition.APPEARING, duration);
        transitioner.setStagger(LayoutTransition.DISAPPEARING, 0);

        transitioner.setAnimator(LayoutTransition.APPEARING, appearingAnimation);
        transitioner.setAnimator(LayoutTransition.DISAPPEARING, disappearAnimation);

        transitioner.addTransitionListener(new LayoutTransition.TransitionListener() {
            @Override
            public void startTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {

                Log.d(TAG, "onStartTransiton type " + transitionType +  " view " + view.toString());
            }

            @Override
            public void endTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {

            }
        });


        binding.frame.setLayoutTransition(transitioner);
    }

    private void startDialog() {
        MyDialogFragment newFragment = new MyDialogFragment();
        newFragment.show(getSupportFragmentManager(), "dialog");

    }

    public ObservableBoolean getVisible() {
        return visible;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
    }
}
