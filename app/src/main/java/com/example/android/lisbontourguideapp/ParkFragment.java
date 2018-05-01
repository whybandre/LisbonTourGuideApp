package com.example.android.lisbontourguideapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * {@link Fragment} that displays a list of color vocabulary words.
 */
public class ParkFragment extends Fragment implements ListView.OnItemClickListener {
    public ParkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.guide_list, container, false);


        // Create a list of words
        final ArrayList<Guide> places = new ArrayList<Guide>();
        places.add(new Guide(R.string.park_jardim_da_estrela, R.string.neighborhood_campo_de_ourique,
                R.drawable.picture__jardim_da_estrela));
        places.add(new Guide(R.string.park_feira_popular, R.string.neighborhood_alcantara,
                R.drawable.picture__feira_popular));
        places.add(new Guide(R.string.park_miradouro_graça, R.string.neighborhood_graça,
                R.drawable.picture__miradouro_sophia_de_mello_breyner_andresen));
        places.add(new Guide(R.string.park_miradouro_senhora_do_monte, R.string.neighborhood_graça,
                R.drawable.picture__miradouro_senhora_do_monte));
        places.add(new Guide(R.string.park_jardim_do_torel, R.string.neighborhood_intendente_anjos,
                R.drawable.picture__jardim_do_torel));
        places.add(new Guide(R.string.park_martires_da_patria, R.string.neighborhood_intendente_anjos,
                R.drawable.picture__campo_martires_da_patria    ));


        GuideAdapter adapter = new GuideAdapter(getActivity(), places, R.color.category_parks);


        ListView listView = (ListView) rootView.findViewById(R.id.list);


        listView.setAdapter(adapter);

        // Set OnClickListener on ListView to identify the item on ListView clicked by user
        // Text on the ListView item clicked is passed on to PlaceContentDescriptionActivity
        listView.setOnItemClickListener(this);

        return rootView;
    }

    /**
     * Method to identify ListView item clicked and launch MediaPlayerActivity
     *
     * @param adapterView
     * @param view
     * @param position
     * @param id
     */
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        final Context context = getActivity();
        String intentExtra = "";

        TextView textViewSong = (TextView) view.findViewById(R.id.neighborhood_text_view);
        String song = textViewSong.getText().toString();

        TextView textViewSinger = (TextView) view.findViewById(R.id.place_text_view);
        String singer = textViewSinger.getText().toString();

        intentExtra = song + "|" + singer + "|";
        Intent intent = new Intent(context, PlaceContentDescriptionActivity.class);
        intent.putExtra("message", intentExtra);
        startActivity(intent);
    }


}
