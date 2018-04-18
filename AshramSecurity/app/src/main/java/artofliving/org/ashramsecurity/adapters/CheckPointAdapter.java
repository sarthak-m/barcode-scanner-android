package artofliving.org.ashramsecurity.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import artofliving.org.ashramsecurity.R;
import artofliving.org.ashramsecurity.models.CheckPoint;
import artofliving.org.ashramsecurity.services.DatabaseService;
import artofliving.org.ashramsecurity.utils.AlertDialogUtil;
import artofliving.org.ashramsecurity.utils.NavigationUtil;
import artofliving.org.ashramsecurity.utils.ServiceCallback;

/**
 * Created by sarthak-m on 13/03/18.
 */

public class CheckPointAdapter extends RecyclerView.Adapter {

    private Activity activity;
    private ArrayList<CheckPoint> checkpoints;

    public CheckPointAdapter(Activity activity, ArrayList<CheckPoint> checkpoints) {
        this.activity = activity;
        this.checkpoints = checkpoints;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.checkpoint_cell, parent, false);
        return new CheckPointViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        CheckPointViewHolder mViewHolder = (CheckPointViewHolder) holder;

        if (position == 0) {
            mViewHolder.name.setText("None");
            mViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DatabaseService.saveCheckPointId("");
                    DatabaseService.saveCheckPointName("None");
                    NavigationUtil.gotoScannerActivity(activity);

                }
            });
        } else {
            final String checkpointName = checkpoints.get(position - 1).name;
            mViewHolder.name.setText(checkpointName);
            mViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialogUtil.showDialogWithAction(activity, "Check Point selected:" + checkpointName, null, "CONFIRM", "CANCEL", new ServiceCallback<String>() {

                        @Override
                        public void run(String buttonText) {
                            if (buttonText.equalsIgnoreCase("CONFIRM")) {
                                DatabaseService.saveCheckPointId(checkpoints.get(position).id);
                                DatabaseService.saveCheckPointName(checkpointName);
                                NavigationUtil.gotoScannerActivity(activity);
                            }
                        }
                    });
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        if (checkpoints != null) {
            return checkpoints.size() + 1;
        } else {
            return 1;
        }
    }

    class CheckPointViewHolder extends RecyclerView.ViewHolder {

        protected TextView name;

        CheckPointViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.name);
        }
    }
}
