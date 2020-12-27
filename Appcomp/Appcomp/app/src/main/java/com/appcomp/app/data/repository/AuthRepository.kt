package com.appcomp.app.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.appcomp.app.data.local.AuthPref
import com.appcomp.app.data.model.ActionState
import com.appcomp.app.data.model.AuthUser

class AuthRepository (val context: Context) {
    private val authpref: AuthPref by lazy { AuthPref(context) }

    val authUser = MutableLiveData<AuthUser>(authpref.authUser)
    val isLogin = MutableLiveData<Boolean>(authpref.isLogin)

    suspend fun login(email: String, password: String) : ActionState<AuthUser> {
        return authpref.login(email, password)
    }

    suspend fun register(user: AuthUser) : ActionState<AuthUser> {
        return authpref.register(user)
    }

    suspend fun logout() : ActionState<Boolean> {
        return authpref.logout()
    }
}