package com.example.mydeaf.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mydeaf.R;
import com.example.mydeaf.models.Alphabet;

import java.util.List;

public class AdapterAlphabet extends BaseAdapter {

    private Context mContext;
    List<Alphabet> alphabetList;

    public AdapterAlphabet(Context mContext, List<Alphabet> maskList) {
        this.mContext = mContext;
        this.alphabetList = maskList;
    }

    @Override
    public int getCount() {
        return alphabetList.size();
    }

    @Override
    public Object getItem(int position) {
        return alphabetList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alphabetList.get(position).getID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = View.inflate(mContext, R.layout.item_alphabet, null);

        TextView Name = view.findViewById(R.id.txtNameAlphabet);
        TextView LookLike = view.findViewById(R.id.txtLookAlphabet);
        TextView Comment = view.findViewById(R.id.txtComment);
        TextView YearOsnov = view.findViewById(R.id.txtYearOsnov);
        ImageView imageView = view.findViewById(R.id.imageView);
        Alphabet movie = alphabetList.get(position);
        Name.setText(movie.getName());
        LookLike.setText(movie.getLookLike());
        Comment.setText(movie.getComment());
        YearOsnov.setText(Integer.toString(movie.getYearOsnov()));
        imageView.setImageBitmap(getUserImage(movie.getImage()));

        return view;
    }
    private Bitmap getUserImage(String encodedImg)
    {
        if (encodedImg!=null&& !encodedImg.equals("NULL")) {
            byte[] bytes = Base64.decode(encodedImg, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }
        else return  BitmapFactory.decodeResource(mContext.getResources(),R.drawable.ic_alphabet);
    }
}
