package com.example.luxr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    private ArrayList<String> FilePathStrings;
    private ArrayList<String> FileNameStrings;
    private File[] listFile;
    GridView grid;
    GalleryGridAdapter adapter;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        if (FileHand.getMyDir() != null) {
            file = FileHand.getMyDir();
            System.out.println("Gallery Source: " + file.getAbsolutePath());
            FilePathStrings = FileHand.getFilePathStrings();
            FileNameStrings = FileHand.getFileNameStrings();
            for (String a : FileNameStrings) {
                System.out.println(a);
            }
            listFile = file.listFiles();

            grid = (GridView) findViewById(R.id.galleryGrid);
            adapter = new GalleryGridAdapter(this, FilePathStrings, FileNameStrings);
            grid.setAdapter(adapter);

            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(GalleryActivity.this, "Photo Selected", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(GalleryActivity.this, "You have no photos :(", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
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
        if (id == R.id.action_account) {
            accountClicked();
            return true;
        } else if (id == R.id.action_upload) {
            uploadClicked();
            return true;
        } else if (id == R.id.action_home) {
            homeClicked();
            return true;
        } else if (id == R.id.action_gallery){
            galleryClicked();
            return true;
        } else if (id == R.id.action_style){
            styleClicked();
            return true;
        }else if (id == R.id.action_favs){
            favsClicked();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void favsClicked() {
        View v = new View(this);
        Intent intent = new Intent(v.getContext(), FavsActivity.class);
        startActivity(intent);
    }

    public void styleClicked(){
        View v = new View(this);
        Intent intent = new Intent(v.getContext(), StyleActivity.class);
        startActivity(intent);
    }

    public void galleryClicked(){
        View v = new View(this);
        Intent intent = new Intent(v.getContext(), GalleryActivity.class);
        startActivity(intent);
    }

    public void homeClicked() {
        View v = new View(this);
        Intent intent = new Intent(v.getContext(), MainActivity.class);
        startActivity(intent);
    }

    public void accountClicked() {
        View v = new View(this);
        Intent intent = new Intent(v.getContext(), AccountActivity.class);
        startActivity(intent);
    }

    public void uploadClicked() {
        View v = new View(this);
        Intent intent = new Intent(v.getContext(), CameraActivity.class);
        startActivity(intent);
    }

}
