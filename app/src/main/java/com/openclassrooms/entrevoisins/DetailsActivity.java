package com.openclassrooms.entrevoisins;

import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

public class DetailsActivity extends AppCompatActivity {

    private ImageView mAvatar;
    private FloatingActionButton mFavoriteStar;
    private ImageButton mBackArrow;
    private TextView mNameOnImage;
    private TextView mName;
    private TextView mAddress;
    private TextView mPhoneNumber;
    private TextView mContact;
    private TextView mAboutMe;

    private Uri mURL;

    private NeighbourApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiService = DI.getNeighbourApiService();
        setContentView(R.layout.activity_details);
        Neighbour neighbour = (Neighbour) getIntent().getExtras().getSerializable("Neighbour");
        mAvatar = findViewById(R.id.details_imageview_avatar);
        Glide.with(mAvatar.getContext())
                .load(neighbour.getAvatarUrl())
                .into(mAvatar);

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

        mBackArrow = findViewById(R.id.details_back_arrow);
        mBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mFavoriteStar = findViewById(R.id.details_favorite);
        mFavoriteStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // neighbour.setFavorite(true);
                mApiService.addFavorite(neighbour);
            }
        });
    }
}