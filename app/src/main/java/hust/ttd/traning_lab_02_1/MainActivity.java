package hust.ttd.traning_lab_02_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnSend;
    EditText editMessage;
    String LIFE_CYCLE = "LIFE CYCLE";


    TextView txtView;
    public static final String EXTRA_MESSAGE = "message key";
    public static final Integer TEXT_REQUEST = 1;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        txtView = findViewById(R.id.replyMessage);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    String strReplyMessage = data.getStringExtra(SecondActivity.REPLY_MESSAGE);
                    txtView.setText(strReplyMessage);
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LIFE_CYCLE, "On created");
        setContentView(R.layout.activity_main);

        btnSend = findViewById(R.id.btnSend);
        editMessage = findViewById(R.id.editMessage);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                // MainActivity.this not this
                String strMessage = editMessage.getText().toString();
                myIntent.putExtra(EXTRA_MESSAGE, strMessage);
                startActivityForResult(myIntent, TEXT_REQUEST);
            }
        });
    }
}