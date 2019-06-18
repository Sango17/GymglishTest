package com.alexandreseneviratne.gymglishtest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Alexandre SENEVIRATNE on 6/18/2019.
 */
sealed class LoginState(
    val authorizationStatus: Boolean,
    val errorMessage: String = ""
)

object LoginSuccess: LoginState(true)
object LoginFailure: LoginState(false, "Wrong username/password, please try again !")

class LoginViewModel: ViewModel() {
    private val state =  MutableLiveData<LoginState>()

    fun getState(): LiveData<LoginState> = state

    fun login(username: String, password: String) {
        if (username == "root" && password == "root") {
            state.value = LoginSuccess
        } else {
            state.value = LoginFailure
        }
    }

}