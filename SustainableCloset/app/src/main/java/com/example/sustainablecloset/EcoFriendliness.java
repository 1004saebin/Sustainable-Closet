package com.example.sustainablecloset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EcoFriendliness extends AppCompatActivity {
    private GridView grid;
    private List<String> listOfImagesPath;
    private GalleryAdapter galleryAdapter;
    public static final String GridViewDemo_ImagePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ClosetPict/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eco_friendliness);

        grid = (GridView) findViewById(R.id.gridviewimg);

        listOfImagesPath = null;
        listOfImagesPath = RetriveCapturedImagePath();
        if (listOfImagesPath != null) {
            grid.setAdapter(new ImageListAdapter(this, listOfImagesPath));
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_image_capture, menu);
        getMenuInflater().inflate(R.menu.addtitlebar, menu);
        return true;
    }

    public void goToLandingPage(MenuItem menuItem){


        Intent intent = new Intent(getApplicationContext(), LandingActivity.class);
        startActivity(intent);

    }
    public void goToUpload(MenuItem menuItem){


        Intent intent = new Intent(getApplicationContext(), AddImagesActivity.class);
        startActivity(intent);

    }
    public void goToRate(MenuItem menuItem){


        Intent intent = new Intent(getApplicationContext(), EcoFriendliness.class);
        startActivity(intent);

    }

    private List<String> RetriveCapturedImagePath() {
        List<String> tFileList = new ArrayList<String>();
        File f = new File(GridViewDemo_ImagePath);
        if (f.exists()) {
            File[] files = f.listFiles();
            Arrays.sort(files);

            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                if (file.isDirectory())
                    continue;
                tFileList.add(file.getPath());
            }
        }
        return tFileList;
    }
    //
    public class ImageListAdapter extends BaseAdapter {
        private Context context;
        private List<String> imgPic;

        public ImageListAdapter(Context c, List<String> thePic) {
            context = c;
            imgPic = thePic;
        }

        public int getCount() {
            if (imgPic != null)
                return imgPic.size();
            else
                return 0;
        }

        //—returns the ID of an item—
        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        //—returns an ImageView view—
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            BitmapFactory.Options bfOptions = new BitmapFactory.Options();
            bfOptions.inDither = false;                     //Disable Dithering mode
            bfOptions.inPurgeable = true;                   //Tell to gc that whether it needs free memory, the Bitmap can be cleared
            bfOptions.inInputShareable = true;              //Which kind of reference will be used to recover the Bitmap data after being clear, when it will be used in the future
            bfOptions.inTempStorage = new byte[32 * 1024];
            if (convertView == null) {
                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                imageView.setPadding(0, 0, 0, 0);
            } else {
                imageView = (ImageView) convertView;
            }
            FileInputStream fs = null;
            Bitmap bm;
            try {
                fs = new FileInputStream(new File(imgPic.get(position).toString()));

                if (fs != null) {
                    bm = BitmapFactory.decodeFileDescriptor(fs.getFD(), null, bfOptions);
                    imageView.setImageBitmap(bm);
                    imageView.setId(position);
                    imageView.setLayoutParams(new GridView.LayoutParams(200, 160));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fs != null) {
                    try {
                        fs.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return imageView;
        }
    }

}
