package com.mumbi.notes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder> {

    private final Context mContext;
    private final List<NoteInfo> mNotes;
    private final LayoutInflater mLayoutInflator;

    public NoteRecyclerAdapter(Context mContext, List<NoteInfo> mNotes) {
        this.mContext = mContext;
        mLayoutInflator = LayoutInflater.from(mContext);
        this.mNotes = mNotes;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflator.inflate(R.layout.item_note_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         NoteInfo note = mNotes.get(position);
         holder.textCourse.setText(note.getCourse().getTitle());
         holder.textTitle.setText(note.getTitle());
         holder.mCurrentPosition = position;
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView textCourse;
        public final TextView textTitle;
        public int mCurrentPosition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textCourse = (TextView)itemView.findViewById(R.id.text_course);
            textTitle = (TextView) itemView.findViewById(R.id.text_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, MainActivity.class);
                    intent .putExtra(MainActivity.NOTE_POSITION, mCurrentPosition);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
