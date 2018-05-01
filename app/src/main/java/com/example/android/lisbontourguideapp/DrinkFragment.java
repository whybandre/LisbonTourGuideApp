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
public class DrinkFragment extends Fragment implements ListView.OnItemClickListener {
    public DrinkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.guide_list, container, false);


        // Create a list of words
        final ArrayList<Guide> places = new ArrayList<Guide>();
        places.add(new Guide(R.string.drink_majong, R.string.neighborhood_bairro_alto,
                R.drawable.picture__majong));
        places.add(new Guide(R.string.drink_clube_royale, R.string.neighborhood_bairro_alto,
                R.drawable.picture__clube_royale));
        places.add(new Guide(R.string.drink_casa_independente, R.string.neighborhood_intendente_anjos,
                R.drawable.picture__casa_independente));
        places.add(new Guide(R.string.drink_damas, R.string.neighborhood_graça,
                R.drawable.picture__damas));
        places.add(new Guide(R.string.drink_aquele_lugar_em_alcantara, R.string.neighborhood_alcantara,
                R.drawable.picture__aquele_lugar_em_alcantara));
        places.add(new Guide(R.string.drink_mob, R.string.neighborhood_intendente_anjos,
                R.drawable.picture__mob));



        GuideAdapter adapter = new GuideAdapter(getActivity(), places, R.color.category_drink);

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
