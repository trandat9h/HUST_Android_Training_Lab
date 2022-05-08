package hust.ttd.traning_lab_02_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String REPLY_MESSAGE = "reply message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView txtView = findViewById(R.id.showMessage);
        Intent callerIntent = getIntent();
        String message = callerIntent.getStringExtra(hust.ttd.traning_lab_02_1.MainActivity.EXTRA_MESSAGE);
        if (message != null) {
            txtView.setText(message);
        }

        Button replyButton = findViewById(R.id.replyBtn);
        replyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent replyIntent = new Intent();
                EditText replyMessage = findViewById(R.id.editReplyMessage);
                String replyMessageInString = replyMessage.getText().toString();
                replyIntent.putExtra(REPLY_MESSAGE, replyMessageInString);
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });


    }
}
