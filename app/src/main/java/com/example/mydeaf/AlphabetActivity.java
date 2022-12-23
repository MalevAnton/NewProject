package com.example.mydeaf;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mydeaf.adapter.AdapterAlphabet;
import com.example.mydeaf.models.Alphabet;
import com.example.mydeaf.network.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlphabetActivity extends AppCompatActivity {

    Connection connection;
    List<Alphabet> data;
    ListView listView;
    AdapterAlphabet pAdapter;
    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        GetDataFromSql();
    }

    public void GetDataFromSql() {
        data = new ArrayList<Alphabet>();
        listView = findViewById(R.id.lvData);
        pAdapter = new AdapterAlphabet(AlphabetActivity.this, data);
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();
            if (connection != null) {
                String query = "SELECT ID,Name,YearOsnov,LookLike,Comment,Image\n" +
                        "FROM Information\n" +
                        "LEFT JOIN LookLike  on Information.ID_look = LookLike.ID_look\n" +
                        "LEFT JOIN Comment  on Information.ID_comment = Comment.ID_comment";

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    Alphabet tempAlphabet = new Alphabet
                            (   resultSet.getInt("ID"),
                                    resultSet.getString("Name"),
                                    resultSet.getString("LookLike"),
                                    resultSet.getString("Comment"),
                                    resultSet.getString("Image"),
                                    Integer.parseInt(resultSet.getString("YearOsnov"))
                            );
                    data.add(tempAlphabet);
                }
                connection.close();
            } else {
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        pAdapter.notifyDataSetInvalidated();
        listView.setAdapter(pAdapter);

    }
}