package com.m23.gridboard.classes;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.m23.gridboard.adapters.GridBoardAdapter;
import com.m23.gridboard.interfaces.GridBoardInterface;

public class GridBoard {

    private Context context;
    private GridBoardInterface keyboardInterface;
    private RecyclerView recyclerView;
    private InputConnection inputConnection;

    public void setInputConnection(InputConnection inputConnection) {
        this.inputConnection = inputConnection;
    }

    public GridBoard(Context context, RecyclerView recyclerView) {
        this.context = context;
        this.recyclerView = recyclerView;

        this.recyclerView.setHasFixedSize(true);
        this.setupKeyboard();
    }

    private void setupKeyboard(){
        keyboardInterface = new GridBoardInterface() {
            @Override
            public void onInput(String input) {
                if(inputConnection != null){
                    if(input.equals("<")){
                        inputConnection.deleteSurroundingText(1, 0);
                    }else {
                        inputConnection.commitText(input, 1);
                    }
                }
            }
        };
        GridBoardAdapter keyboardAdapter = new GridBoardAdapter(context, keyboardInterface);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3){
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        this.recyclerView.setLayoutManager(gridLayoutManager);
        this.recyclerView.setAdapter(keyboardAdapter);
    }
}
