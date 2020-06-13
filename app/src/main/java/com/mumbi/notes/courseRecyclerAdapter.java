package com.mumbi.notes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class courseRecyclerAdapter extends RecyclerView.Adapter<courseRecyclerAdapter.ViewHolder> {

    private final Context mContext;
    private final List<CourseInfo> mCourses;
    private final LayoutInflater mLayoutInflator;

    public courseRecyclerAdapter(Context mContext, List<CourseInfo> mCourses) {
        this.mContext = mContext;
        mLayoutInflator = LayoutInflater.from(mContext);
        this.mCourses = mCourses;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflator.inflate(R.layout.item_course_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         CourseInfo course = mCourses.get(position);
         holder.textCourse.setText(course.getTitle());
         holder.mCurrentPosition = position;
    }

    @Override
    public int getItemCount() {
        return mCourses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView textCourse;
        public int mCurrentPosition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textCourse = (TextView)itemView.findViewById(R.id.text_course);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, mCourses.get(mCurrentPosition).getTitle(), Snackbar.LENGTH_LONG).show();
                }
            });
        }
    }
}
