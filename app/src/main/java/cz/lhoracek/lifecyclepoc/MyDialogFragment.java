package cz.lhoracek.lifecyclepoc;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cz.lhoracek.lifecyclepoc.databinding.DialogMyBinding;

/**
 *
 */

public class MyDialogFragment extends DialogFragment {
    private static final String TAG = MyDialogFragment.class.getSimpleName();

    private static final String[] ITEMS = {"One", "Two", "Three", "Four", "Six", "Seven", "Eight"};


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    private DialogMyBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
         binding = DialogMyBinding.inflate(inflater);
        binding.setListenerDismiss((view) -> dismiss());
        binding.setListenerNext((view)-> binding.viewSwitcher.showNext());
        binding.recycler.setAdapter(new CustomAdapter(getActivity(), ITEMS));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");

    }

    public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

        private LayoutInflater inflater;
        private Context context;
        private String[] items;


        public CustomAdapter(Context context,String[] items) {
            inflater = LayoutInflater.from(context);
            this.context = context;
            this.items=items;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.text.setText(items[position]);
        }

        @Override
        public int getItemCount() {
            return items.length;
        }

        class MyViewHolder extends RecyclerView.ViewHolder
        {
            TextView text;

            public MyViewHolder(View itemView) {
                super(itemView);
                text = (TextView)itemView.findViewById(android.R.id.text1);
            }
        }
    }
}
