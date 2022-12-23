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
import com.example.mydeaf.models.Number;

import java.util.List;

public class AdapterNumber extends BaseAdapter {

    private Context nContext;
    List<Number> numberList;

    public AdapterNumber(Context nContext, List<Number> maskList) {
        this.nContext = nContext;
        this.numberList = maskList;
    }

    @Override
    public int getCount() {
        return numberList.size();
    }

    @Override
    public Object getItem(int position) {
        return numberList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return numberList.get(position).getID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = View.inflate(nContext, R.layout.item_number, null);

        TextView NameNum = view.findViewById(R.id.txtNameNum);
        TextView LookLikeNum = view.findViewById(R.id.txtLookNum);
        TextView CommentNum = view.findViewById(R.id.txtCommentNum);
        TextView YearOsnovNum = view.findViewById(R.id.txtYearOsnovNum);
        ImageView imageView = view.findViewById(R.id.imageViewNum);
        Number number = numberList.get(position);
        NameNum.setText(number.getNameNum());
        LookLikeNum.setText(number.getLookLikeNum());
        CommentNum.setText(number.getCommentNum());
        YearOsnovNum.setText(Integer.toString(number.getYearOsnovNum()));
        imageView.setImageBitmap(getUserImageNum(number.getImageNum()));

        return view;
    }

    private Bitmap getUserImageNum(String encodedImg)
    {
        if (encodedImg!=null&& !encodedImg.equals("null")) {
            byte[] bytes = Base64.decode(encodedImg, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }
        else return  BitmapFactory.decodeResource(nContext.getResources(),R.drawable.ic_alphabet);
    }
}
