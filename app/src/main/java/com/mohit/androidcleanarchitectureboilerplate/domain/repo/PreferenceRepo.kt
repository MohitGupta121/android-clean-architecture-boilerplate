package com.mohit.androidcleanarchitectureboilerplate.domain.repo

import com.mohit.androidcleanarchitectureboilerplate.data.local.models.User
import kotlinx.coroutines.flow.Flow

interface PreferenceRepo {

    fun saveUser(user: User)

    fun getUser(): User?

    fun removeUser()

    fun observeUser(): Flow<User>

    fun isUserLoggedIn(): Boolean

    fun getUserToken(): String?

    fun isOnBoardingComplete(): Boolean

    fun setOnBoardingComplete()

}