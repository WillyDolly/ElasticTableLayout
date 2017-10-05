package com.popland.pop.elastictablelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.wajahatkarim3.easyflipview.EasyFlipView;

public class MainActivity extends AppCompatActivity {
Button BTN;
    TableLayout TL;
    int Row = 1 , Column = 2 , level = 1;
    int[] rowArray = {3,7,13,21};
    int[] columnArray = {5,10,17};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BTN = (Button)findViewById(R.id.BTN);
        TL = (TableLayout)findViewById(R.id.TL);

        BTN.setText(level+"");
            BTN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    level++;
                    BTN.setText(level+"");
                    if(TL.getChildCount()>0){
                        TL.removeAllViews();
                    }
                    for(int row : rowArray){
                        if(level == row){
                            Row++;
                            break;
                        }
                    }
                    for(int column : columnArray){
                        if(level == column){
                            Column++;
                            break;
                        }
                    }
                    Toast.makeText(MainActivity.this,"row: "+Row+"- column: "+Column,Toast.LENGTH_SHORT).show();

                    for(int r=1;r<=Row;r++){
                        TableRow TR = new TableRow(MainActivity.this);
                        for(int c=1;c<=Column;c++){
                            int position = Column*(r-1) + (c-1);
                            if(position<level) {
                                ImageView IV = new ImageView(MainActivity.this);
                                IV.setImageResource(R.drawable.so11);
                                IV.setBackgroundResource(R.drawable.round);
                                IV.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                LayoutParams LP = new LayoutParams(200,200);

                                TR.addView(IV,LP);
                            }
                        }
                        TL.addView(TR);
                    }

                }
            });

    }
}
