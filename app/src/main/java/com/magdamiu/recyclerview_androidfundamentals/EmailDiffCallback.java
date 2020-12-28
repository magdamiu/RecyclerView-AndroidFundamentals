package com.magdamiu.recyclerview_androidfundamentals;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class EmailDiffCallback extends DiffUtil.Callback {

    private List<Email> oldList;
    private List<Email> newList;

    public EmailDiffCallback(List<Email> oldList, List<Email> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        // add a unique ID property on Email and expose a getId() method
        return oldList.get(oldItemPosition).getId() == newList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Email oldEmail = oldList.get(oldItemPosition);
        Email newEmail = newList.get(newItemPosition);

        if (oldEmail.getFromName() == newEmail.getFromName() && oldEmail.getSubject() == newEmail.getSubject() && oldEmail.getShortBody() == newEmail.getShortBody()) {
            return true;
        }
        return false;
    }
}