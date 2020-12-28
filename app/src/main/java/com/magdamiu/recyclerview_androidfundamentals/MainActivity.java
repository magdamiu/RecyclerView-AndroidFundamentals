package com.magdamiu.recyclerview_androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.magdamiu.recyclerview_androidfundamentals.EmailAdapter;
import com.magdamiu.recyclerview_androidfundamentals.ItemClickListener;
import com.magdamiu.recyclerview_androidfundamentals.R;
import com.magdamiu.recyclerview_androidfundamentals.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List emails;
    private RecyclerView recyclerViewEmails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewEmails = findViewById(R.id.recyclerViewEmails);
        displayEmailsList();
    }

    // RecyclerView implementation
    // get data source
    private void inbox() {
        emails = new ArrayList<>();
        Email email = null;
        for (int i = 0; i < 25; i++) {
            email = new Email(0, "Magda " + i, "Hello Android " + i, "This is an intro about Android");
            emails.add(email);
        }
    }

    // step 4 = Define the LayoutManager in activity
    // set the layout manager, in our case LinearLayoutManager because it's a list of emails
    private void setEmailsLayoutManager() {
        recyclerViewEmails.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setEmailsAdapter() {
        recyclerViewEmails.setAdapter(new EmailAdapter(this, emails));
    }

    private void displayEmailsList() {
        // data source - checked
        inbox();

        // layout manager - checked
        setEmailsLayoutManager();

        // adapter - checked
        setEmailsAdapter();

        setClickListener();
    }

    private void setClickListener() {
        recyclerViewEmails.addOnItemTouchListener(new RecyclerTouchListener(MainActivity.this, recyclerViewEmails, new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(MainActivity.this, getString(R.string.single_click) + position,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, getString(R.string.long_click) + position,
                        Toast.LENGTH_LONG).show();
            }
        }));
    }
}