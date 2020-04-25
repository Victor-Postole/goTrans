package fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.myapplication.R;

public class Fragment_notification_cars extends Fragment {
    @Nullable
    @Override
       public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  v = inflater.inflate(R.layout.fragment_cars, container, false);
        ImageView takeAction = (ImageView)v.findViewById(R.id.driverGetChanges);

        takeAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_notification_changes bottomSheetFragment = new Fragment_notification_changes();
            }
        });

        return v;
    }
}
