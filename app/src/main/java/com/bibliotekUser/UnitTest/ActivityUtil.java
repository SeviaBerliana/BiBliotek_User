package com.bibliotekUser.UnitTest;

import android.content.Context;
import android.content.Intent;

import com.bibliotekUser.ui.LoginRegister.LoginActivity;

public class ActivityUtil {

    private Context context;

    public ActivityUtil(Context context) {
        this.context = context;
    }

    public void startLoginActivity() {
        context.startActivity(new Intent(context, LoginActivity.class));
    }

}
