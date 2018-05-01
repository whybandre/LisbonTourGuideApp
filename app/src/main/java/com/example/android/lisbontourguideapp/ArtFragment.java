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
public class ArtFragment extends Fragment implements ListView.OnItemClickListener {
    public ArtFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.guide_list, container, false);


        // Create a list of words
        final ArrayList<Guide> places = new ArrayList<Guide>();
        places.add(new Guide(R.string.art_casa_fernando_pessoa, R.string.neighborhood_campo_de_ourique,
                R.drawable.picture__casa_fernando_pessoa));
        places.add(new Guide(R.string.art_28_tram, R.string.neighborhood_campo_de_ourique,
                R.drawable.picture__tram_28));
        places.add(new Guide(R.string.art_ler_devagar, R.string.neighborhood_alcantara,
                R.drawable.picture__ler_devagar));
        places.add(new Guide(R.string.art_lx_factory, R.string.neighborhood_alcantara,
                R.drawable.picture__lx_factory));
        places.add(new Guide(R.string.art_village_underground, R.string.neighborhood_alcantara,
                R.drawable.picture__village_underground));
        places.add(new Guide(R.string.art_carpe_diem_art_and_research, R.string.neighborhood_bairro_alto,
                R.drawable.picture__carpe_diem_art_and_research));



        GuideAdapter adapter = new GuideAdapter(getActivity(), places, R.color.category_arts);

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
