package cz.lhoracek.lifecyclepoc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cz.lhoracek.lifecyclepoc.databinding.DialogMyBinding;

/**
 *
 */

public class MyDialogFragment extends DialogFragment {
    private static final String TAG = MyDialogFragment.class.getSimpleName();

    private static final String[] ITEMS = {"One", "Two", "Three", "Four", "Six", "Seven", "Eight"};

    public MyDialogFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG,"onCreateView");
        DialogMyBinding binding = DialogMyBinding.inflate(inflater);
        binding.setListenerDismiss((view)-> dismiss());
  //      binding.listView.setAdapter( new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, ITEMS));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG,"onViewCreated");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG,"onSaveInstanceState");
    }
}
