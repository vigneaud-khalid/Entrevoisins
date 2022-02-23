package com.openclassrooms.entrevoisins;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.model.Neighbour;

public class Details2Activity extends AppCompatActivity {

    private ImageView mAvatarUrl;
    private FloatingActionButton mFavoriteStar;
    private FloatingActionButton mBackArrow;
    private TextView mNameOnImage;
    private TextView mName;
    private TextView mAddress;
    private TextView mPhoneNumber;
    private TextView mContact;
    private TextView mAboutMe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Neighbour neighbour = (Neighbour) getIntent().getExtras().getSerializable("Neighbour");
        Log.d("llll",neighbour.getName());
        mAvatarUrl = findViewById(R.id.details_imageview_avatar);

        mBackArrow = findViewById(R.id.details_back_arrow);

        mFavoriteStar = findViewById(R.id.details_favorite);

        mNameOnImage = findViewById(R.id.details_textview_nameOnImage);
        mNameOnImage.setText(neighbour.getName());
        mName = findViewById(R.id.details_textview_descriptionName);
        mName.setText(neighbour.getName());
        mAddress = findViewById(R.id.details_textview_address);
        mAddress.setText(neighbour.getAddress());
        mPhoneNumber = findViewById(R.id.details_textview_phone);
        mPhoneNumber.setText(neighbour.getPhoneNumber());
        mContact = findViewById(R.id.details_textview_contact);
        mContact.append(neighbour.getName().toLowerCase());
        mAboutMe = findViewById(R.id.details_textview_about);
        mAboutMe.setText(neighbour.getAboutMe());


        mBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDestroy();
            }
        });

    }
}