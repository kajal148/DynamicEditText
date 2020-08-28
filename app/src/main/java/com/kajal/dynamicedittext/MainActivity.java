package com.kajal.dynamicedittext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Dialog mDialog;
    EditText mEditService;
    String add_service;
    private List<AddList> mServicesList= new ArrayList<>();
    private ListAdapterClass mListAdapter;
    RecyclerView mServiceRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDialog = new Dialog(this);

        // RECYCLE VIEW

        mServiceRecyclerView = findViewById(R.id.services_list);

        //for saving all the images
        mServicesList = new ArrayList<>();
        mServicesList.add(new AddList("Kajal"));

        //use setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager manager_services= new LinearLayoutManager(this);
        manager_services.setOrientation(LinearLayoutManager.HORIZONTAL);
        mServiceRecyclerView.setLayoutManager(manager_services);

        ListAdapterClass services_adapter = new ListAdapterClass(this,mServicesList);
        mServiceRecyclerView.setAdapter(services_adapter);


    }

    public void popUp(View v){
        final Button mButton;
        mDialog.setContentView(R.layout.popup_text);
        mButton = mDialog.findViewById(R.id.btn_submit);
        mEditService = mDialog.findViewById(R.id.edit_services);
        mEditService.setText("");
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_service = mEditService.getText().toString();
                mServicesList.add(new AddList(add_service));
                //Toast.makeText(getApplicationContext(), add_service, Toast.LENGTH_SHORT).show();
                mDialog.dismiss();
            }
        });
        mDialog.show();
    }
}
