package com.user.test.screens;

import com.user.test.data.component.NetComponent;
import com.user.test.util.CustomScope;

import dagger.Component;

/**
 * Created by yashthakur on 26/08/18.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = HomeModule.class)
public interface HomeComponent {
    void inject(HomeActivity activity);
}

