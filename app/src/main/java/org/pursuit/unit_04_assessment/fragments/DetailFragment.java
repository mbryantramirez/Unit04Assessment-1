package org.pursuit.unit_04_assessment.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.unit_04_assessment.R;
import org.pursuit.unit_04_assessment.model.Echinoderm;

public class DetailFragment extends Fragment {
    public static final String ANIMAL = "animal";
    public static final String IMAGE = "image";
    public static final String WIKI = "wiki";
    private OnFragmentInteractionListener fragListener;
    private String animalName;
    private String animalURL;
    private String animalWiki;
    private TextView fragTextView;
    private ImageView fragImageView;
    private Button fragButton;


    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(Echinoderm model) {
        Bundle args = new Bundle();
        args.putString(ANIMAL, model.getAnimal());
        args.putString(IMAGE, model.getImage());
        args.putString(WIKI, model.getWiki());
        return new DetailFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            fragListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            animalName = getArguments().getString(ANIMAL);
            animalURL = getArguments().getString(IMAGE);
            animalWiki = getArguments().getString(WIKI);

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragTextView = view.findViewById(R.id.frag_textView);
        fragImageView = view.findViewById(R.id.frag_imageView);
        fragButton = view.findViewById(R.id.frag_button);

        fragTextView.setText(animalName);
        Picasso.get().load(animalURL).into(fragImageView);

        fragButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragListener.onFragmentInteraction(animalWiki);
            }
        });
    }
}
