package com.example.springbugtracker.util;

import com.example.springbugtracker.constant.AppConstant;

public final class AppUtils {
    public static String giveAvatarUrl(String token) {
        return AppConstant.AVATAR_URL + token + AppConstant.AVATAR_URL_QUERIES;
    }
}
