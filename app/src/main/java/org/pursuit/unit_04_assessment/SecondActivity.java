package org.pursuit.unit_04_assessment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.pursuit.unit_04_assessment.fragments.DetailFragment;
import org.pursuit.unit_04_assessment.fragments.OnFragmentInteractionListener;
import org.pursuit.unit_04_assessment.model.Echinoderm;

public class SecondActivity extends AppCompatActivity implements OnFragmentInteractionListener {
private Echinoderm model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        DetailFragment detailFragment = DetailFragment.newInstance(model);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.secondActivity_container, detailFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onFragmentInteraction(String website) {
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(model.getWiki()));
        startActivity(implicit);
    }
}
