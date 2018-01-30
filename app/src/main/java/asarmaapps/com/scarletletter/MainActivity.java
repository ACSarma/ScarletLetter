package asarmaapps.com.scarletletter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button[] button =  new Button[5];
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        button[0] = findViewById(R.id.home);
        button[1] = findViewById(R.id.description);
        button[2] = findViewById(R.id.symbol);
        button[3] = findViewById(R.id.biographical);
        button[4] = findViewById(R.id.actions);

        GoSome(button[0]);
    }

    public void GoSome(View view){
        Fragment fragment;
        fragmentTransaction = fragmentManager.beginTransaction();
        Button b = (Button)view;
        switch (b.getText().toString()){
            case "Home Page": bColor(0);
                fragment = new Home();
                fragmentSet(fragmentTransaction, fragment);
                break;
            case "Description": bColor(1);
                fragment = new Description();
                fragmentSet(fragmentTransaction, fragment);
                break;
            case "  Symbols  ": bColor(2);
                fragment = new Symbols();
                fragmentSet(fragmentTransaction, fragment);
                break;
            case " Biography ": bColor(3);
                fragment = new Biography();
                fragmentSet(fragmentTransaction, fragment);
                break;
            case "  Actions  ": bColor(4);
                fragment = new Actions();
                fragmentSet(fragmentTransaction, fragment);
                break;
            default: bColor(4);
                break;
        }
    }

    public void bColor(int index){
        for(int i=0; i<5; i++){
            if(i != index) {
                button[i].setBackgroundColor(Color.parseColor("#bae7b2b4"));
            }else{
                button[i].setBackgroundColor(Color.parseColor("#FF9F3032"));
            }
        }
    }

    public void fragmentSet(FragmentTransaction fragmentTransaction, Fragment fragment){
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

}
