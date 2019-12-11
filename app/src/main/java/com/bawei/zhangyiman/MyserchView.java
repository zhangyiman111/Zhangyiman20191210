package com.bawei.zhangyiman;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

/*
 *@auther:张奕漫
 *@Date: 2019/12/11
 *@Time:10:57
 *@Description:
 * */
public class MyserchView extends RelativeLayout {

    private EditText editText;
    private TextView textView;

    public MyserchView(Context context) {
        super(context);

    }

    public MyserchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.serlayout, this);
        editText = findViewById(R.id.et);
        textView = findViewById(R.id.tv);
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSerchlistener != null) {
                    String s = editText.getText().toString();
                    onSerchlistener.onSerch(s);
                }
            }
        });
    }

    onSerchlistener onSerchlistener;

    public void setOnSerchlistener(MyserchView.onSerchlistener onSerchlistener) {
        this.onSerchlistener = onSerchlistener;
    }

    public interface onSerchlistener {
        void onSerch(String serch);
    }
}
