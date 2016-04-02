package fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import actionbars.CustomActionBarLayout;
import notifications.ShowAlertDialog;
import xyz.mhuy.n.roidkeeper.R;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private View view;
    private Button btn;


    public HomeFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        btn = (Button) this.view.findViewById(R.id.btnHomeFragment);
        btn.setOnClickListener(this);




        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnHomeFragment:
                Toast.makeText(getContext().getApplicationContext(), "jhsfhsfsf", Toast.LENGTH_SHORT).show();
                ShowAlertDialog.showAlertDialog(getContext(), "Title", "Message");
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
