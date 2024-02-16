package com.example.t01_bucketlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.t01_bucketlist.model.BucketItem;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.Random;

public class Add_Bucket extends BaseActivity {
    private static final int IMAGE_REQUEST = 1;
    private TextView selectedDateTV;

    ImageView imageView;
    FirebaseDatabase database;
    DatabaseReference myRef;
    FirebaseStorage storage;
    StorageReference storageRef;
    Button submitbtn;
    EditText edName, edDesc, edAmt;
    Spinner category;


    String[] categoryList = {"Travel", "Food", "Work", "Learning", "Health", "Love"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bucket);

        submitbtn = findViewById(R.id.submit_btn);
        selectedDateTV = findViewById(R.id.select_time);
        imageView = findViewById(R.id.img_back);
        edName = findViewById(R.id.ed_bucketname);
        edDesc = findViewById(R.id.ed_bucketdescription);
        edAmt = findViewById(R.id.ed_amount);
        category = findViewById(R.id.spin_category);
        category = findViewById(R.id.spin_category);

        ArrayAdapter spinAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, categoryList);
        category.setPrompt("Select Quantity..");
        category.setGravity(Gravity.CENTER);
        category.setAdapter(spinAdapter);

        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();
        myRef = database.getReference("BucketItem").push();
        storageRef = storage.getReference();

        String key = database.getReference("BucketItem").push().getKey();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImage();
            }
        });


        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showProgress();
                int num1 = new Random().nextInt();
                int num2 = new Random().nextInt();
                String imgName = Math.abs(num1) + Math.abs(num2) + ".jpg";
                StorageReference mountainsRef = storageRef.child(imgName);
                StorageReference imgRef = storageRef.child("images/" + imgName);

                imageView.setDrawingCacheEnabled(true);
                imageView.buildDrawingCache();
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] data = baos.toByteArray();

                UploadTask uploadTask = imgRef.putBytes(data);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Log.e("====", "123");
                        // Handle unsuccessful uploads
                        hideProgress(); // Move hideProgress inside onFailure
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Log.e("====", taskSnapshot.toString());
                        imgRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                Log.e("====", uri.toString());
                                String imgPath = uri.toString();
                                String name = edName.getText().toString();
                                String desc = edDesc.getText().toString();
                                String amt = edAmt.getText().toString();
                                String date = selectedDateTV.getText().toString();
                                String cat = category.getSelectedItem().toString();

                                BucketItem bti = new BucketItem(
                                        key,
                                        imgPath,
                                        name,
                                        desc,
                                        amt,
                                        date,
                                        cat);

                                writeNewBucket(bti);
                                hideProgress(); // Move hideProgress inside onSuccess
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception exception) {
                                Log.e("====", exception.toString());
                                // Handle any errors
                                hideProgress(); // Move hideProgress inside onFailure
                            }
                        });
                    }
                });
            }
        });


        selectedDateTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // the instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Add_Bucket.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our text view.
                                selectedDateTV.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                            }
                        },
                        year, month, day);

                datePickerDialog.show();
            }
        });
    }

    void writeNewBucket(BucketItem bt) {
        myRef.setValue(bt).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                displayToast("Bucket Added");
                finish();
            }
        });
    }

    private void openImage() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            String imageUri = data.getData().toString();
            imageView.setImageURI(Uri.parse(imageUri));

        }
    }

}