package com.example.cricbuzzz.Controler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.example.cricbuzzz.R;

public class Camera extends AppCompatActivity {
    public static final int CAMERA_REQUEST= 9999;
ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        imageview = findViewById(R.id.imageView4);
    }
public void OpenCamera(View view)
{
    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    startActivityForResult(intent,CAMERA_REQUEST);

}

@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
{
    super.onActivityResult(requestCode,resultCode,data);
    if(requestCode== CAMERA_REQUEST)
    {
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        imageview.setImageBitmap(bitmap);
    }
}
}
