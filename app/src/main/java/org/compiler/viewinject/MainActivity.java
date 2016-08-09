package org.compiler.viewinject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.annotation.BindView;
import com.annotation.OnClick;

import org.compiler.inject.ViewInject;
/**
 * Created by JokAr on 16/8/8.
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.button1)
    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewInject.inject(this);

    }

    @OnClick(R.id.textView)
    public void click() {
        Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
    }


}
