package org.pursuit.unit_04_assessment.recyclerview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.unit_04_assessment.R;
import org.pursuit.unit_04_assessment.SecondActivity;
import org.pursuit.unit_04_assessment.model.Echinoderm;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;
    private ImageView imageView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.textView);
        imageView = itemView.findViewById(R.id.imageView);
    }

    public void onBind(final Echinoderm model){
        textView.setText(model.getAnimal());
        Picasso.get().load(model.getImage()).into(imageView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                intent.putExtra("animal", model.getAnimal());
                intent.putExtra("image", model.getImage());
                intent.putExtra("wiki", model.getWiki());
                v.getContext().startActivity(intent);
            }
        });



    }
}
