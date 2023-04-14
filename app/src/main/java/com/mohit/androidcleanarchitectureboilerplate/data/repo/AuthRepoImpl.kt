package com.mohit.androidcleanarchitectureboilerplate.data.repo

import com.mohit.androidcleanarchitectureboilerplate.data.mapper.toLocal
import com.mohit.androidcleanarchitectureboilerplate.data.remote.dataSources.AuthDataSource
import com.mohit.androidcleanarchitectureboilerplate.data.remote.models.UserDto
import com.mohit.androidcleanarchitectureboilerplate.domain.repo.AuthRepo
import com.mohit.androidcleanarchitectureboilerplate.domain.repo.PreferenceRepo
import com.mohit.androidcleanarchitectureboilerplate.util.Resource
import com.mohit.androidcleanarchitectureboilerplate.util.extensions.mapToUnit
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

// Repository for all authentication functions
class AuthRepoImpl @Inject constructor(
    private val authDataSource: AuthDataSource, // Class to login and signup user
    private val preferenceRepo: PreferenceRepo, // Repository that contains data store functions
): AuthRepo {

    override fun isUserLoggedIn() = preferenceRepo.isUserLoggedIn()

    override suspend fun loginUser(
        email: String,
        password: String
    ) = flow {
        // Use resource->Resource.Success to get resource state and resource.data to get resource data
        emit(Resource.Loading())
        val resource = authDataSource.loginUser(email, password)
        if (resource is Resource.Success)
            saveUserLocally(resource.data)
        emit(resource.mapToUnit())
    }

    override suspend fun registerUser(
        username: String,
        email: String,
        password: String
    ) = flow {
        emit(Resource.Loading())
        val resource = authDataSource.registerUser(username, email, password)
        if (resource is Resource.Success)
            saveUserLocally(resource.data)
        emit(resource.mapToUnit())
    }

    override suspend fun logoutUser() {
        preferenceRepo.removeUser()
    }

    private suspend fun saveUserLocally(userDto: UserDto?) {
        userDto?.let { preferenceRepo.saveUser(it.toLocal()) }
    }
}
