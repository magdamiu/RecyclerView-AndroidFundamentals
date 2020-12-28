package com.magdamiu.recyclerview_androidfundamentals;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// step 5 = Extend RecyclerView.ViewHolder in a separated class
// wrapper for email_item.xml views (translate the views in Java objects)
// 1:1 relation between each view from item and each field from Java class EmailViewHolder
public class EmailViewHolder extends RecyclerView.ViewHolder{

    private final TextView textViewFrom, textViewSubject, textViewBody;
    private final LinearLayout linearLayoutEmail;

    public EmailViewHolder(@NonNull View itemView) {
        super(itemView);

        textViewFrom = itemView.findViewById(R.id.textViewFrom);
        textViewSubject = itemView.findViewById(R.id.textViewSubject);
        textViewBody = itemView.findViewById(R.id.textViewBody);
        linearLayoutEmail = itemView.findViewById(R.id.linearLayoutEmail);
    }

    public TextView getTextViewFrom() {
        return textViewFrom;
    }

    public TextView getTextViewSubject() {
        return textViewSubject;
    }

    public TextView getTextViewBody() {
        return textViewBody;
    }

    public LinearLayout getLinearLayoutEmail() {
        return linearLayoutEmail;
    }
}
