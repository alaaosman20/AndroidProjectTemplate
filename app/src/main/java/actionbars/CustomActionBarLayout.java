package actionbars;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import notifications.ShowAlertDialog;
import xyz.mhuy.n.roidkeeper.R;

/**
 * Created by admin on 4/2/2016.
 */
public class CustomActionBarLayout extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_action_bar_activity);
        ActionBar localActionBar = getActionBar();
        assert (localActionBar != null);
        localActionBar.setDisplayShowHomeEnabled(false);
        localActionBar.setDisplayShowTitleEnabled(false);
        View localView = LayoutInflater.from(this).inflate(R.layout.custom_action_bar, null);
        ((TextView) localView.findViewById(R.id.tvActionBar)).setText("My Own Title");
        ShowAlertDialog.showAlertDialog(this, "ActionBar is deprecated, this feature may or may not work properly. Use ToolBar instead.", "Oh nooo");
        ((ImageButton) localView.findViewById(R.id.imgbtnActionBar)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                Toast.makeText(CustomActionBarLayout.this.getApplicationContext(), "Refresh Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        localActionBar.setCustomView(localView);
        localActionBar.setDisplayShowCustomEnabled(true);
    }
}
