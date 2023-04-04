package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private List<Even> eventList;
    private Context context;

    public EventAdapter(Context context, List<Even> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView timeTBTextView;
        public TextView timeEvenTextView;
        public TextView textEvenTextView;
        public ImageButton editButton;
        public ImageButton deleteButton;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            timeTBTextView = itemView.findViewById(R.id.timeTBTextView);
            timeEvenTextView = itemView.findViewById(R.id.timeEvenTextView);
            textEvenTextView = itemView.findViewById(R.id.textEvenTextView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        viewHolder.editButton = itemView.findViewById(R.id.Sua);
        viewHolder.deleteButton = itemView.findViewById(R.id.Xoa);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Even event = eventList.get(position);
        holder.titleTextView.setText(event.getTitle1());
        holder.timeTBTextView.setText(event.getTimeTB());
        holder.timeEvenTextView.setText(event.getTimeEven());
        holder.textEvenTextView.setText(event.getTextEven());

        holder.editButton.setOnClickListener(v -> {
            if (eventListener != null) {
                eventListener.onEdit(position);
            }
        });

        holder.deleteButton.setOnClickListener(v -> {
            if (eventListener != null) {
                eventListener.onDelete(position);
            }
        });

    }
    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public interface EventListener {
        void onEdit(int position);
        void onDelete(int position);
    }

    private EventListener eventListener;

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
}
