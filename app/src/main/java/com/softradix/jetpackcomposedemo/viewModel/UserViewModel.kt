package com.softradix.jetpackcomposedemo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softradix.jetpackcomposedemo.database.entity.*
import com.softradix.jetpackcomposedemo.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _readAllData = MutableLiveData<List<UserWithPlaylistAndSongs>>()
    var readUserData: LiveData<List<UserWithPlaylistAndSongs>> = _readAllData


    fun getUser(userId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _readAllData.postValue(userRepository.getUserWithPlaylistAndSongs(userId))

        }
    }

    fun addUser(user: List<User>) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.addUser(user)
        }

    }

    fun addPlaylist(playlist: List<Playlist>) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.addPlaylist(playlist)
        }

    }

    fun addSong(song: List<Song>) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.addSong(song)
        }

    }

    fun addPlaylistSongCrossRef(item: List<PlaylistSongCrossRef>) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.addPlaylistSongCrossRef(item)
        }

    }
}