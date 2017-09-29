package com.saif.familytree.utils;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.CursorLoader;
import android.webkit.ValueCallback;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;

public class FileUtils {
	public static File createTemporaryFile(String part, String ext) throws Exception {
		File tempDir = Environment.getExternalStorageDirectory();
		tempDir = new File(tempDir.getAbsolutePath() + "/.temp/");
		if (!tempDir.exists()) {
			tempDir.mkdir();
		}
		return File.createTempFile(part, ext, tempDir);
	}
	
	/**
	 * read file from asset folder and return input stream
	 * @param filePath
	 */
	public static InputStream readFileFromAssetsWithInResult(Context context, String filePath) throws IOException {
		
		//read the content of asset file
		return context.getAssets().open(filePath);
	}
	
	
	/**
	 * read file from asset folder and return String
	 * @param filePath
	 */
	public static String readFileFromAssetsWithStringResult(Context context, String filePath) throws IOException {
		
		InputStream inputStream = readFileFromAssetsWithInResult(context, filePath);
		
		return getContent(inputStream);
		
	}
	

	
	/**
	 * read the content of inputstream
	 * @param inputStream
	 * @return
	 */
	public static String getContent(InputStream inputStream) throws IOException {
		
		//parse the response
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		
		while((line = reader.readLine()) != null){
			stringBuilder.append(line);
		}
		
		return stringBuilder.toString();
	}
	
	
	public static boolean copyFile(final File src, final File dst)
			throws IOException {
		if (src.getAbsolutePath().toString()
				.equals(dst.getAbsolutePath().toString()))
			return true;
		else {
			final InputStream is = new FileInputStream(src);
			copyFile(is, dst);
		}
		return true;
	}

	public static void copyFile(final InputStream is, final File dst)
			throws IOException {

		final OutputStream os = new FileOutputStream(dst);
		final byte[] buff = new byte[1024];
		int len;
		while ((len = is.read(buff)) > 0) {
			os.write(buff, 0, len);
		}
		is.close();
		os.close();

	}

	public static void deleteFile(File dir, String fileName) {
		File file = new File(dir, fileName);
		if (file.exists())
			file.delete();
	}

	public static void deleteFile(String path) {
		try {
			File file = new File(path);
			if (file.exists())
				file.delete();
		} catch (Exception e) {
		}
	}

	public static boolean fileIsExits(String filePath) {
		if (filePath != null) {
			File file = new File(filePath);
			if (file.exists())
				return true;
			else
				return false;
		} else {
			return false;
		}
	}

	public static void deleteFolder(final File folder) {
		final File[] files = folder.listFiles();
		if (files != null) { // some JVMs return null for empty dirs
			for (final File f : files) {
				if (f.isDirectory()) {
					deleteFolder(f);
				} else {
					f.delete();
				}
			}
		}
		folder.delete();
	}

	public static File getSDDir(Activity context) {

		return Environment.getExternalStorageDirectory();

	}


	/**
	 * Turn drawable resource into byte array.
	 *
	 * @param context parent context
	 * @param id      drawable resource id
	 * @return byte array
	 */
	public static byte[] getFileDataFromDrawable(Context context, int id) {
		Drawable drawable = ContextCompat.getDrawable(context, id);
		Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
		return byteArrayOutputStream.toByteArray();
	}

	/**
	 * Turn drawable into byte array.
	 *
	 * @param drawable data
	 * @return byte array
	 */
	public static byte[] getFileDataFromDrawable(Context context, Drawable drawable) {
		Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
		return byteArrayOutputStream.toByteArray();
	}

    public static byte[] getDataFromFile(String file) throws IOException {
        return getDataFromFile(new File(file));
    }

    public static byte[] getDataFromFile(File file) throws IOException {
        // Open file
        RandomAccessFile f = new RandomAccessFile(file, "r");
        try {
            // Get and check length
            long longlength = f.length();
            int length = (int) longlength;
            if (length != longlength)
                throw new IOException("File size >= 2 GB");
            // Read file and return data
            byte[] data = new byte[length];
            f.readFully(data);
            return data;
        } finally {
            f.close();
        }
    }

	public static String getRealPathFromURI(Uri contentUri,Context context) {
		String[] proj = { MediaStore.Images.Media.DATA };
		CursorLoader loader = new CursorLoader(context, contentUri, proj, null, null, null);
		Cursor cursor = loader.loadInBackground();
		int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		cursor.moveToFirst();
		String result = cursor.getString(column_index);
		cursor.close();
		return result;
	}

	public static Bitmap retrieveVideoFrameFromVideo(String videoPath) throws Throwable
	{
		Bitmap bitmap = null;
		MediaMetadataRetriever mediaMetadataRetriever = null;
		try
		{
			mediaMetadataRetriever = new MediaMetadataRetriever();
			if (Build.VERSION.SDK_INT >= 14)
				mediaMetadataRetriever.setDataSource(videoPath, new HashMap<String, String>());
			else
				mediaMetadataRetriever.setDataSource(videoPath);
			//   mediaMetadataRetriever.setDataSource(videoPath);
			bitmap = mediaMetadataRetriever.getFrameAtTime();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (mediaMetadataRetriever != null) {
				mediaMetadataRetriever.release();
			}
		}
		return bitmap;
	}


    public static class VideoThumbnailGenerator extends AsyncTask<Void, Integer, Bitmap> {

        private String mUrl;
        private ValueCallback<Bitmap> mCallback;

        public VideoThumbnailGenerator(String mUrl, ValueCallback<Bitmap> callback) {
            this.mUrl = mUrl;
            mCallback = callback;
        }




        @Override
        protected Bitmap doInBackground(Void... params) {
            try {
                return retrieveVideoFrameFromVideo(mUrl);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                return null;
            }
        }



        @Override
        protected void onPostExecute(Bitmap result) {
            mCallback.onReceiveValue(result);
        }
    }

}
