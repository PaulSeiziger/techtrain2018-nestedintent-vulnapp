package positive.on.techtrain2018_nestedintent_vulnapp;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DispatcherActivity extends AppCompatActivity {

    // positive.on.techtrain2018_nestedintent_vulnapp.ProfileActivity
    static String profilePage = ProfileActivity.class.getName();
    // positive.on.techtrain2018_nestedintent_vulnapp.TransferActivity
    static String transferPage = TransferActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatcher);

        dispatchIntent(getIntent());

        findViewById(R.id.goToProfile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePage(DispatcherActivity.profilePage);
            }
        });

        findViewById(R.id.goToTransfer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePage(DispatcherActivity.transferPage);
            }
        });
    }

    public void changePage(String pageName) {
        Intent intent = new Intent(this, DispatcherActivity.class);
        Intent nextIntent = new Intent();
        intent.putExtra("next", nextIntent);
        intent.putExtra("target",pageName);
        startActivity(intent);
    }

    private void dispatchIntent(Intent incoming) {
        Bundle extras = incoming.getExtras();
        if(extras != null && extras.containsKey("next")) {
            Intent intent = (Intent) extras.getParcelable("next");
            String targetActivity = extras.getString("target");
            intent.setComponent(new ComponentName(this,targetActivity));
            startActivity(intent);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        dispatchIntent(intent);
    }
}






























/* HELP

make static field with random IPC token:
    static String IPCToken = makeIPCToken();



generate IPC token:
    public static String makeIPCToken() {
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int length = 32;
        char tempChar;
        for (int i = 0; i < length; i++){
            tempChar = (char) (generator.nextInt(96) + 32);
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }



check if page is private:
    public static boolean isPrivatePage(String pageName) {
        if(pageName.equals(DispatcherActivity.transferPage)) {
            return true;
        }
        return false;
    }




check token:
            if(isPrivatePage(targetActivity)) {
                String token = extras.getString("token");
                if(!token.equals(DispatcherActivity.IPCToken)) {
                    finish();
                    return;
                }
            }

put token to dispatcher:
        intent.putExtra("token",DispatcherActivity.IPCToken);
 */