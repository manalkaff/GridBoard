package com.m23.gridboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.m23.gridboard.R;
import com.m23.gridboard.interfaces.GridBoardInterface;

public class GridBoardAdapter extends RecyclerView.Adapter<GridBoardAdapter.ViewHolder> {

    private Context context;
    private final static String[] inputs = {
            "1","2","3","4","5","6","7","8","9","","0","<",
    };
    private GridBoardInterface listener;

    public GridBoardAdapter(Context context, GridBoardInterface listener) {
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_board_btn, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.setIsRecyclable(false);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.keyboardBtn.setText(String.valueOf(inputs[position]));

    }

    @Override
    public int getItemCount() {
        return inputs.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Button keyboardBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            keyboardBtn = itemView.findViewById(R.id.keyboard_btn);

            keyboardBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onInput(String.valueOf(inputs[position]));
                        }
                    }
                }
            });
        }
    }
}
