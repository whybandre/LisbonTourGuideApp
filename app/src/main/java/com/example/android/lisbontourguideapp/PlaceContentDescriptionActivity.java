package com.example.android.lisbontourguideapp;




import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceContentDescriptionActivity extends AppCompatActivity {




    // UI Components
    private TextView mTextNeighborhood;
    private TextView mTextPlace;
    private ImageView mImageArtwork;
    private TextView mTextContent;


    // Various identifiers
    private String mIntentMessage;
    private String mNeighborhood;
    private String mPlace;
    private String mPictureResource;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] intentMsgArray = new String[3];

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Bundle bundle = getIntent().getExtras();
        mIntentMessage = bundle.getString("message");

        // Splits intent message received into activity_category_song_list, singer, and activity_category_song_list category
        intentMsgArray = mIntentMessage.split("\\|");
        mNeighborhood = intentMsgArray[0];
        mPlace = intentMsgArray[1];

        // Initialize UI Components
        mTextNeighborhood = (TextView) findViewById(R.id.text_neighborhood);
        mTextPlace = (TextView) findViewById(R.id.text_place);
        mImageArtwork = (ImageView) findViewById(R.id.image_picture);
        mTextContent = (TextView) findViewById(R.id.text_content);


        // Get artwork resource name
        getPictureResource();

        // Display Media Details and Image
        displayMediaDetails();


    }

    /**
     * This method gets artwork drawable name of the place selected
     */
    public void getPictureResource() {

        //eg Estrela Garden -> picture__estrela_garden

        mPictureResource = "picture__";
        mPictureResource += mPlace.replace("'", "").toLowerCase();
        mPictureResource = mPictureResource.replaceAll(" ", "_");
    }



    /**
     * This method displays Guide details - name, neighborhood name, picture and detail information
     */
    public void displayMediaDetails() {

        mTextNeighborhood.setText(mNeighborhood);
        mTextPlace.setText(mPlace);


        //
        int resId = getResources().getIdentifier(mPictureResource, "drawable", getPackageName());
        mImageArtwork.setImageResource(resId);

        //Get specific String to display guide information
        //it get it by replace spaces for _ and putting all letters in lower case
        //Eg Estrela Garden -> estrela_garden -> R.string.estrela_garden
        int contentResource = getResources().getIdentifier(mPlace.replaceAll(" ", "_").replace("'", "").toLowerCase(),"string", getPackageName());
        mTextContent.setText(contentResource);

    }


}
