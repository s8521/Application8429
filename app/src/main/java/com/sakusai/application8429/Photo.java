package com.sakusai.application8429;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;

public class Photo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
    }
    public void getphoto(View v){
        Intent intent = new Intent();
        //開啟Pictures畫面Type設定為image
        intent.setType("image/*");
        //使用Intent.ACTION_GET_CONTENT這個Action                                            //會開啟選取圖檔視窗讓您選取手機內圖檔
        intent.setAction(Intent.ACTION_GET_CONTENT);
        //取得相片後返回本畫面
        startActivityForResult(intent, 1);
    }

    public void cameraphoto(View v){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //調用系統相機

        Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),"image.jpg"));
        //指定照片保存路徑（SD卡），image.jpg为一個臨時文件，每次拍照後這個圖片都會被替換
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);

        //直接使用，沒有縮小
        startActivityForResult(intent, 2);  //用戶點擊了從相機獲取
    }

    public void toPhotocomparison(View v){
        Intent intent = new Intent();
        intent.setClass(Photo.this, Photocomparison.class);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //當使用者按下確定後
        if ((requestCode == 1 || requestCode == 2 ) && data != null) {
            //取得圖檔的路徑位置
            Uri uri = data.getData();
            //寫log
            Log.e("uri", uri.toString());
            //抽象資料的接口
            ContentResolver cr = this.getContentResolver();
            try {
                //由抽象資料接口轉換圖檔路徑為Bitmap
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                //取得圖片控制項ImageView
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                // 將Bitmap設定到ImageView
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                Log.e("Exception", e.getMessage(),e);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
