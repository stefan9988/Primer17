package com.ftninformatika.cas017;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


public class MasterFragment extends Fragment {


    private ListView lvNames;
    private List<String>names;
    private OnNameClickListener listener;

    public MasterFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_master, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvNames=view.findViewById(R.id.lvNames);
        setupList();
    }
    private void setupList(){
        names=NamesProvaider.getAllNames();
        ArrayAdapter<String>adapter=new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                names);
        lvNames.setAdapter(adapter);
        lvNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (listener!=null) {
                    listener.onNameClicked(i);
                }
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnNameClickListener){
            listener=(OnNameClickListener)context;
        }
        else {
            Toast.makeText(getContext(), "Morate implementirati interface", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }

    interface OnNameClickListener {
        void onNameClicked(int id);

    }
}