package positive.on.techtrain2018_nestedintent_vulnapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TransferActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle autoTransfer = getIntent().getExtras();
        if(autoTransfer != null) {
            String to = autoTransfer.getString("to");
            String amount = autoTransfer.getString("amount");
            transfer(to, amount);
            finish();
        }

        findViewById(R.id.transferButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = ((TextView) findViewById(R.id.transferTo)).getText().toString();
                String amount = ((TextView) findViewById(R.id.transferAmount)).getText().toString();
                transfer(to, amount);
                finish();
            }
        });

    }

    private void transfer(String to, String amount) {
        Toast.makeText(this, "*** Vuln App ***\nTransfer succeeded: "+amount+"rubs to "+to, Toast.LENGTH_LONG).show();
    }
}
