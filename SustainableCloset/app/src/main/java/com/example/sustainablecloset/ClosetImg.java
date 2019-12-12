package com.example.sustainablecloset;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import android.content.ClipData;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ClosetImg extends Activity {

    Button rateBtn = null;
    Button galleryBtn = null;
    final int CAMERA_CAPTURE = 1;
    private int GALLERY = 1;
    private Uri picUri;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private GridView grid;
    private List<String> listOfImagesPath;
    private GalleryAdapter galleryAdapter;
    public static final String GridViewDemo_ImagePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ClosetView/";
    String imageEncoded;
    List<String> imagesEncodedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closet);

        //Rate button
        rateBtn = (Button) findViewById(R.id.seeRate_btn1);


        grid = (GridView) findViewById(R.id.gridviewimg);

        listOfImagesPath = null;
        listOfImagesPath = RetriveCapturedImagePath();
        if (listOfImagesPath != null) {
            grid.setAdapter(new ImageListAdapter(this, listOfImagesPath));
        }
    }
//
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

//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//
//        if (resultCode == RESULT_OK) {
////user is returning from capturing an image using the camera
//            if (requestCode == CAMERA_CAPTURE) {
//                Bundle extras = data.getExtras();
//                Bitmap thePic = extras.getParcelable("data");
//                String imgcurTime = dateFormat.format(new Date());
//                File imageDirectory = new File(GridViewDemo_ImagePath);
//                imageDirectory.mkdirs();
//                String _path = GridViewDemo_ImagePath + imgcurTime + ".jpg";
//                try {
//                    FileOutputStream out = new FileOutputStream(_path);
//                    thePic.compress(Bitmap.CompressFormat.JPEG, 90, out);
//                    out.close();
//                } catch (FileNotFoundException e) {
//                    e.getMessage();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                listOfImagesPath = null;
//                listOfImagesPath = RetriveCapturedImagePath();
//                if (listOfImagesPath != null) {
//                    grid.setAdapter(new ImageListAdapter(this, listOfImagesPath));
//                }
//            }
//        }
////
////        //gALLERY
////        // When an Image is picked (Single image)
////        if (requestCode == GALLERY && resultCode == RESULT_OK
////                && null != data) {
////
////            File imageDirectory = new File(GridViewDemo_ImagePath);
////            String[] filePathColumn = { MediaStore.Images.Media.DATA };
////            imagesEncodedList = new ArrayList<String>();
////            if(data.getData()!=null){
////
////                Uri mImageUri=data.getData();
////
////                // Get the cursor
////                Cursor cursor = getContentResolver().query(mImageUri,
////                        filePathColumn, null, null, null);
////                // Move to first row
////                cursor.moveToFirst();
////
////                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
////                imageEncoded  = cursor.getString(columnIndex);
////                cursor.close();
////
////                ArrayList<Uri> mArrayUri = new ArrayList<Uri>();
////                mArrayUri.add(mImageUri);
////                galleryAdapter = new GalleryAdapter(getApplicationContext(),mArrayUri);
////                grid.setAdapter(galleryAdapter);
////                grid.setVerticalSpacing(grid.getHorizontalSpacing());
////                ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) grid
////                        .getLayoutParams();
////                mlp.setMargins(0, grid.getHorizontalSpacing(), 0, 0);
////
////            } else {    //if user selects multiple images
////                if (data.getClipData() != null) {
////                    ClipData mClipData = data.getClipData();
////                    ArrayList<Uri> mArrayUri = new ArrayList<Uri>();
////                    for (int i = 0; i < mClipData.getItemCount(); i++) {
////
////                        ClipData.Item item = mClipData.getItemAt(i);
////                        Uri uri = item.getUri();
////                        mArrayUri.add(uri);
////                        // Get the cursor
////                        Cursor cursor = getContentResolver().query(uri, filePathColumn, null, null, null);
////                        // Move to first row
////                        cursor.moveToFirst();
////
////                        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
////                        imageEncoded  = cursor.getString(columnIndex);
////                        imagesEncodedList.add(imageEncoded);
////                        cursor.close();
////
////                        galleryAdapter = new GalleryAdapter(getApplicationContext(),mArrayUri);
////                        grid.setAdapter(galleryAdapter);
////                        grid.setVerticalSpacing(grid.getHorizontalSpacing());
////                        ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) grid
////                                .getLayoutParams();
////                        mlp.setMargins(0, grid.getHorizontalSpacing(), 0, 0);
////
////                    }
////                    Log.v("LOG_TAG", "Selected Images" + mArrayUri.size());
////                }
////            }
////        } else {
////            Toast.makeText(this, "You haven't picked Image",
////                    Toast.LENGTH_LONG).show();
////        }
//
//
//    }
//