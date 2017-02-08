package com.globalrunners.fpet.cloudrunnerandroid.singlepost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.globalrunners.fpet.cloudrunnerandroid.R;
import com.globalrunners.fpet.cloudrunnerandroid.model.Post;

public class SinglePostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_post);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        Post post = b.getParcelable("post");
        if(post != null) {
            TextView title = (TextView)findViewById(R.id.single_post_title);
            title.setText(post.getTitle());

            TextView text = (TextView) findViewById(R.id.single_post_text);
            text.setText(post.getText());
        }
    }
}
