package com.mohit.androidcleanarchitectureboilerplate.data.remote.api

import com.mohit.androidcleanarchitectureboilerplate.data.remote.models.MessageResponse
import com.mohit.androidcleanarchitectureboilerplate.data.remote.models.responses.StorageConsumption
import com.mohit.androidcleanarchitectureboilerplate.data.remote.models.responses.file.FileListResponse
import com.mohit.androidcleanarchitectureboilerplate.data.remote.models.responses.folder.CreateFolderResponse
import com.mohit.androidcleanarchitectureboilerplate.data.remote.models.responses.folder.GetFolderResponse
import com.mohit.androidcleanarchitectureboilerplate.data.remote.models.requests.CreateFolderRequest
import com.mohit.androidcleanarchitectureboilerplate.data.remote.models.requests.GetFileRequest
import com.mohit.androidcleanarchitectureboilerplate.data.remote.models.requests.GetFolderRequest
import com.mohit.androidcleanarchitectureboilerplate.data.remote.models.requests.RenameFileRequest
import com.mohit.androidcleanarchitectureboilerplate.data.remote.models.requests.RenameFolderRequest
import com.mohit.androidcleanarchitectureboilerplate.data.remote.models.requests.RevokeFileRequest
import com.mohit.androidcleanarchitectureboilerplate.data.remote.models.requests.ShareFileRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface StorageService {

    @POST("documents/get-folders-in-folder")
    suspend fun getFolders(
        @Body body: GetFolderRequest,
        @Header("Authorization") token: String
    ): Response<GetFolderResponse>

    @POST("documents/get-files-in-folder")
    suspend fun getFiles(
        @Body body: GetFileRequest,
        @Header("Authorization") token: String
    ): Response<FileListResponse>

    @POST("documents/create-folder")
    suspend fun createFolder(
        @Body body: CreateFolderRequest,
        @Header("Authorization") token: String
    ): Response<CreateFolderResponse>

    @POST("documents/get-files-shared-to-me")
    suspend fun getFilesSharedToMe(
        @Header("Authorization") token: String
    ): Response<FileListResponse>

    @POST("documents/get-files-shared-by-me")
    suspend fun getFilesSharedByMe(
        @Header("Authorization") token: String
    ): Response<FileListResponse>

    @POST("documents/share-file")
    suspend fun shareFile(
        @Body body: ShareFileRequest,
        @Header("Authorization") token: String
    ): Response<MessageResponse>

    @POST("documents/revoke-file")
    suspend fun revokeFile(
        @Body body: RevokeFileRequest,
        @Header("Authorization") token: String
    ): Response<MessageResponse>

    @POST("documents/delete-file")
    suspend fun deleteFile(
        @Body body: Map<String, String>,
        @Header("Authorization") token: String
    ): Response<MessageResponse>

    @POST("documents/delete-folder")
    suspend fun deleteFolder(
        @Body body: Map<String, String>,
        @Header("Authorization") token: String
    ): Response<MessageResponse>

    @POST("documents/storage-consumption")
    suspend fun getStorageConsumption(
        @Header("Authorization") token: String
    ): Response<StorageConsumption>

    @POST("documents/search-file-name")
    suspend fun searchFilesByName(
        @Body body: Map<String, String>,
        @Header("Authorization") token: String
    ): Response<FileListResponse>

    @POST("documents/search-file-type")
    suspend fun searchFilesByType(
        @Body body: Map<String, String>,
        @Header("Authorization") token: String
    ): Response<FileListResponse>

    @POST("documents/rename-file")
    suspend fun renameFile(
        @Body body: RenameFileRequest,
        @Header("Authorization") token: String
    ): Response<MessageResponse>

    @POST("documents/rename-folder")
    suspend fun renameFolder(
        @Body body: RenameFolderRequest,
        @Header("Authorization") token: String
    ): Response<MessageResponse>
}
