package com.balajianoopgupta.mytodoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    EditText etNewItem;
    String positionRecieved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        Intent i = getIntent();
        String valueReceived = i.getExtras().getString("value");
        positionRecieved = i.getExtras().getString("position");
        Log.i("Activity2","valueReceived: "+valueReceived);
        Log.i("Activity2","positionRecieved: "+positionRecieved);

        etNewItem = (EditText) findViewById(R.id.itemValueText);
        etNewItem.setText(valueReceived);

    }

    public void updateListValue(View v) {
        String newText = etNewItem.getText().toString();
        Intent data = new Intent();
        data.putExtra("newValue", etNewItem.getText().toString());
        data.putExtra("position",positionRecieved);
        setResult(RESULT_OK, data);
        finish();
    }
}
