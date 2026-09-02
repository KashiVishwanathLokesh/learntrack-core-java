package com.airtribe.learntrack.notifypatrons;

import java.util.List;

public class EmailNotifier implements NotifyPatron{

    @Override
    public void notifyPatron(String bookTitle, String branchName) {
        System.out.println("Email Notification: The book '" + bookTitle + "' is now available at the branch '" + branchName + "'.");
    }


}
