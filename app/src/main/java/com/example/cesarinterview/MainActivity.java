package com.example.cesarinterview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ListView searchItemsList;
    ArrayAdapter<String> searchItems;
    EditText searchInput;

    // Options avaliable to search on list

    String[] items = {"apple", "building", "despite", "house", "home", "jungle",
                      "moon", "misspellings", "now", "nowhere", "opacity",
                      "pale", "probably", "rising", "rolling", "search", "you"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchItemsList = findViewById(R.id.listViewSearchItems);
        searchItems = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        searchItems.addAll(items);

        searchItemsList.setAdapter(searchItems);

        //Set SearchInput events

        searchInput = findViewById(R.id.searchInput);
        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                FilterList();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Run examples of questions

        Question1 q1 = new Question1();
        Question2 q2 = new Question2();
        Question3 q3 = new Question3();
        Question5 q5 = new Question5();
        Question7 q7 = new Question7();

        q1.RunQuestion1Example();
        q2.RunQuestion2Example();
        q3.RunQuestion3Example();
        q5.RunQuestion5example();
        q7.RunQuestion7Example();

        RunQuestion6Example();
    }

    //Apply algorithms to filter list

    private void FilterList() {

        String searchValue = searchInput.getText().toString();

        if(!searchValue.equals("")){
            searchItems.clear();

            Question2 q2 = new Question2();
            Question3 q3 = new Question3();

            for (String item : items) {
                if (q2.isJumbledLetters(searchValue, item)) {
                    searchItems.add(item);
                } else {
                    if (q3.CheckWordTypo(searchValue, item)) {
                        searchItems.add(item);
                    }
                }
            }

        }else{
            searchItems.clear();
            searchItems.addAll(items);
        }

        searchItems.notifyDataSetChanged();

    }

    private void RunQuestion6Example(){
        EmailMessage thread = new EmailMessage("email message 0");

        thread.next = new EmailMessage("email message 2");
        thread.next.next = new EmailMessage("email message 1");
        thread.next.next.next = new EmailMessage("email message 1");
        thread.next.next.next.next = new EmailMessage("email message 2");
        thread.next.next.next.next.next = new EmailMessage("email message 1");
        thread.next.next.next.next.next.next = new EmailMessage("email message 0");

        Intent intent = new Intent();
        intent.putExtra("emailThread", thread);
        Question6.enqueueWork(this, Question6.class, 1000, intent);

    }

}