package com.heady.explora.screens;

import com.heady.explora.screens.models.ResponseData;
import com.heady.explora.screens.userModels.ResponseResult;

import java.util.ArrayList;

/**
 * Created by yashthakur on 26/08/18.
 */

public interface HomeContract {

    interface View {
        void showCatalog(ResponseData catalogData);

        void showUsers(ArrayList<ResponseResult> users);

        void showError(String message);

        void showComplete();

        void showLoader();

        void hideLoader();


    }

    interface Presenter {
        void getCatalog();
    }
}

