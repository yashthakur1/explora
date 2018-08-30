package com.user.test.data;

import com.user.test.screens.userModels.DataResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by yashthakur on 26/08/18.
 */

public interface ApiService {

    @GET("/api/?results=10")
    Observable<DataResponse> getUsersData();

}
