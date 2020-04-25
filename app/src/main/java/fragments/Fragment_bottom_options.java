package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import activities.AddCar;
import activities.AddDriver;
import com.android.myapplication.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class Fragment_bottom_options extends BottomSheetDialogFragment{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
//
//    @Nullable @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_optiuni, container, false);
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  v = inflater.inflate(R.layout.fragment_optiuni, container, false);

        TextView adaugaDocumentNou = (TextView)v.findViewById(R.id.fragment_document_nou);
        TextView adaugaClient = (TextView)v.findViewById(R.id.fragment_adauga_client);
        TextView adaugaSofer = (TextView)v.findViewById(R.id.fragment_adauga_sofer);
        TextView adaugaMasina = (TextView)v.findViewById(R.id.fragment_adauga_masina);
        TextView uploadFactura = (TextView)v.findViewById(R.id.fragment_upload_factura);
        TextView uploadContract = (TextView)v.findViewById(R.id.fragment_upload_contract);

        adaugaSofer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AddDriver.class));
            }
        });

        adaugaMasina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AddCar.class));
            }
        });

        return v;
    }


}
