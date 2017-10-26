package com.example.harsh.materialdesigndemo;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

//INCOMPLETE

/**
 * Created by harsh on 9/17/17.
 */

public class ActivitViewHolder extends RecyclerView.ViewHolder{

    TextView activityDescription;
    TextView activityMisc;
    Activity activity;
    public ActivitViewHolder(View itemView) {
        super(itemView);
        activityDescription=(TextView) itemView.findViewById(R.id.activityDescription);
        activityMisc=(TextView) itemView.findViewById(R.id.activityMisc);
    }

    public void SetActivityItem(Activity activityItem){
        activity=activityItem;
    }
}
