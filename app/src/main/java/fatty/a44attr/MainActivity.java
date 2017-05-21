package fatty.a44attr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ViewTopBar mTopbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTopbar = (ViewTopBar) findViewById(R.id.topBar);

        mTopbar.setOnTopbarClickListener(
            new ViewTopBar.topbarClickListener(){

                @Override
                public void rightClick(){
                    Toast.makeText(MainActivity.this,"right",Toast.LENGTH_SHORT).show();
                }
                @Override
                public void leftClick(){
                    Toast.makeText(MainActivity.this,"left",Toast.LENGTH_SHORT).show();
                }
            });

        // 控制topbar上组件的状态
/*            mTopbar.setButtonVisable(0, true);
            new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mTopbar.setButtonVisable(1, false);
            }
        }, 10000);*/

    }

}
