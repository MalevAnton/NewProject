package com.example.mydeaf;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mydeaf.adapter.AdapterAlphabet;
import com.example.mydeaf.adapter.AdapterNumber;
import com.example.mydeaf.models.Alphabet;
import com.example.mydeaf.models.Number;
import com.example.mydeaf.network.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NumberActivity extends AppCompatActivity {

    Connection connectionNum;
    List<Number> dataNum;
    ListView listViewNum;
    AdapterNumber pAdapterNum;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        GetDataFromSqlNum();
    }

    public void GetDataFromSqlNum() {
        dataNum = new ArrayList<Number>();
        listViewNum = findViewById(R.id.lvDataNum);
        pAdapterNum = new AdapterNumber(NumberActivity.this, dataNum);
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connectionNum = connectionHelper.connectionClass();
            if (connectionNum != null) {
                String query = "SELECT ID,NameNum,YearOsnovNum,LookLikeNum,CommentNum,ImageNum\n" +
                        "FROM Number\n" +
                        "LEFT JOIN LookLikeNum  on Number.ID_looknum = LookLikeNumber.ID_looknum\n" +
                        "LEFT JOIN CommentNum  on Number.ID_commentnum = CommentNumber.ID_commentnum";

                Statement statement = connectionNum.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    Number tempNumber = new Number
                            (   resultSet.getInt("ID"),
                                    resultSet.getString("NameNum"),
                                    resultSet.getString("LookLikeNum"),
                                    resultSet.getString("CommentNum"),
                                    resultSet.getString("ImageNum"),
                                    Integer.parseInt(resultSet.getString("YearOsnovNum"))
                            );
                    dataNum.add(tempNumber);
                }
                connectionNum.close();
            } else {
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        pAdapterNum.notifyDataSetInvalidated();
        listViewNum.setAdapter(pAdapterNum);

    }
}