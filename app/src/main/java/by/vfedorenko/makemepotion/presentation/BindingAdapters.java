package by.vfedorenko.makemepotion.presentation;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.30.2016
 */
public class BindingAdapters {

    @BindingAdapter("android:adapter")
    public static void setAdapter(RecyclerView recyclerView, RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("android:isVisible")
    public static void setVisible(View view, boolean isVisible) {
        if (isVisible) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }
}
