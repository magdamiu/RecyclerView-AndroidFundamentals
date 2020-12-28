package com.magdamiu.recyclerview_androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
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

    private List<Email> emails;
    private EmailAdapter emailAdapter;
    private RecyclerView recyclerViewEmails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emails = new ArrayList<>();
        emailAdapter = new EmailAdapter(this, emails);
        recyclerViewEmails = findViewById(R.id.recyclerViewEmails);
        displayEmailsList();
    }

    private void displayEmailsList() {
        // data source - checked
        inbox();

        // layout manager - checked
        setEmailsLayoutManager();

        // adapter - checked
        setEmailsAdapter();

        setClickListener();

        setItemDecorator();
    }

    // get data source
    private void inbox() {
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
        recyclerViewEmails.setAdapter(emailAdapter);
    }

    // NOT OK
    void onNewEmailsArrivedNotRecommended(List<Email> newEmails) {
        emailAdapter.setEmails(newEmails);
        emailAdapter.notifyDataSetChanged();
    }

    // OK
    void onNewDataArrivedFastRendering(List<Email> newEmails) {
        List<Email> oldEmails = emailAdapter.getEmails();
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(new EmailDiffCallback(oldEmails, newEmails));
        emailAdapter.setEmails(newEmails);
        result.dispatchUpdatesTo(emailAdapter);
    }

    private void setItemDecorator() {
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerViewEmails.addItemDecoration(itemDecoration);
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