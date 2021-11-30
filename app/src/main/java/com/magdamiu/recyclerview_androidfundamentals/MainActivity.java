package com.magdamiu.recyclerview_androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String EMAIL_ID = "emailId";

    private List<Email> emails;
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

        // on item click and long click
        setRecyclerViewListener();
    }

    private void setRecyclerViewListener() {
        recyclerViewEmails.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerViewEmails, new EmailsClickListener() {
            @Override
            public void onClick(View view, final int position) {
                Toast.makeText(MainActivity.this, getString(R.string.single_click) + position,
                        Toast.LENGTH_SHORT).show();

                Email email = emails.get(position);
                Intent intent = new Intent(MainActivity.this, EmailDetailsActivity.class);
                intent.putExtra(EMAIL_ID, email.getId());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, getString(R.string.long_click) + position,
                        Toast.LENGTH_LONG).show();
            }
        }));
    }

}