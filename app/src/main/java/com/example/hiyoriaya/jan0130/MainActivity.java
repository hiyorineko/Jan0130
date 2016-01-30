package com.example.hiyoriaya.jan0130;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private SeekBar msb;
    private TextView mprogress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msb = (SeekBar)findViewById(R.id.sb);
        mprogress = (TextView)findViewById(R.id.ptx);

        mprogress.setText("（うずうず）");
        msb.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if(msb.getProgress()>255) {
                            mprogress.setText("あっあっぁっあっ");
                        }else{
                            mprogress.setText("んっ……");
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        mprogress.setText("んっ……");
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        if(msb.getProgress()==500) {
                            mprogress.setText("ひゃんっ！！");
                        }else if(msb.getProgress() < 100){
                            mprogress.setText("（うずうず）");
                        }else{
                            mprogress.setText("あぅんっ");
                        }
                    }
                }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
