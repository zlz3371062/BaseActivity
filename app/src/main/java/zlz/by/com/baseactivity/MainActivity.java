package zlz.by.com.baseactivity;

import android.os.Bundle;

public class MainActivity extends ZlzRootActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.setZLZ1Nagationll(this,R.color.colorWhite);

    }
}