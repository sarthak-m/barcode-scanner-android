package artofliving.org.ashramsecurity.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import artofliving.org.ashramsecurity.R;
import artofliving.org.ashramsecurity.adapters.CheckPointAdapter;
import artofliving.org.ashramsecurity.models.CheckPointResponse;
import artofliving.org.ashramsecurity.services.AshramService;
import artofliving.org.ashramsecurity.services.DatabaseService;
import artofliving.org.ashramsecurity.utils.ServiceCallback;

/**
 * Created by sarthak-m on 12/03/18.
 */

public class SelectCheckpointActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CheckPointResponse checkPointResponse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_select_checkpoint);

        mRecyclerView = findViewById(R.id.checkpoints_recycler_view);
        TextView selectedCheckpoint = findViewById(R.id.selected_checkpoint);
        String checkpointName = DatabaseService.getCheckPointName();
        selectedCheckpoint.setText(checkpointName.equalsIgnoreCase("") ? "None" : checkpointName);

        AshramService.getCheckpoints(SelectCheckpointActivity.this, "0101", new ServiceCallback<CheckPointResponse>() {

            @Override
            public void run(CheckPointResponse response) {
                checkPointResponse = response;
                updateUI();
            }
        });

    }

    private void updateUI() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        CheckPointAdapter mCheckPointAdapter = new CheckPointAdapter(this, checkPointResponse.checkpoints);
        mRecyclerView.setAdapter(mCheckPointAdapter);
    }
}
