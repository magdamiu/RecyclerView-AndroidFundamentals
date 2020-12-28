package com.magdamiu.recyclerview_androidfundamentals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// default adapter = ArrayAdapter just like for Spinner implementation
// custom adapter = EmailAdapter defined based on our scenario
// step 6 = Extend RecyclerView.Adapter in a separated class
public class EmailAdapter extends RecyclerView.Adapter<EmailViewHolder> {
    private List<Email> emails;
    private Context context;

    public EmailAdapter(Context context, List<Email> emails) {
        this.emails = emails;
        this.context = context;
    }

    // creates the items and add them to the RecyclerView, just the layout
    @NonNull
    @Override
    public EmailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.email_item, parent, false);
        return new EmailViewHolder(itemView);
    }

    // binds (displays) the content from the list of emails for each item
    @Override
    public void onBindViewHolder(@NonNull EmailViewHolder holder, int position) {
        Email currentEmail = emails.get(position);
        holder.getTextViewFrom().setText(currentEmail.getFromName());
        holder.getTextViewSubject().setText(currentEmail.getSubject());
        holder.getTextViewBody().setText(currentEmail.getShortBody());

        // if position % 2 == 0 set a color for linear layout else set another one...
        // holder.getLinearLayoutEmail()
    }

    // we tell to the Recycler View how many items to display
    @Override
    public int getItemCount() {
        return emails.size();
    }
}
