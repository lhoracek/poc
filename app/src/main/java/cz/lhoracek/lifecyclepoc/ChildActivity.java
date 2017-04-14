package cz.lhoracek.lifecyclepoc;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import cz.lhoracek.lifecyclepoc.databinding.ActivityChildBinding;

public class ChildActivity extends AppCompatActivity {
    private static final String TAG = ChildActivity.class.getSimpleName();

    ActivityChildBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_child);
        binding.button.setOnClickListener(v -> binding.textView.setText("Hello setText with <b>bold</b> element"));
        Log.d(TAG, "onCreate");
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
}
