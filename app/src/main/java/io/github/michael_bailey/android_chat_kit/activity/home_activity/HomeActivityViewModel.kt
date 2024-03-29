package io.github.michael_bailey.android_chat_kit.activity.home_activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.michael_bailey.android_chat_kit.data_type.ServerInfoData
import io.github.michael_bailey.android_chat_kit.extension.any.log
import io.github.michael_bailey.android_chat_kit.extension.view_model.launch
import io.github.michael_bailey.android_chat_kit.interfaces.view_model.IProfileViewModel
import io.github.michael_bailey.android_chat_kit.interfaces.view_model.IServersViewModel
import io.github.michael_bailey.android_chat_kit.repository.LoginRepository
import io.github.michael_bailey.android_chat_kit.repository.ServerRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class HomeActivityViewModel @Inject constructor(
	private val loginRepository: LoginRepository,
	private val serverRepository: ServerRepository,
): ViewModel(), IProfileViewModel, IServersViewModel {
	
	override val uuid: LiveData<String> = loginRepository.uuid.map { it.toString() }.asLiveData()
	override val username: LiveData<String> = loginRepository.username.map { it ?: "" }.asLiveData()
	override val savedServers: LiveData<List<ServerInfoData>> = serverRepository.serverInfo.onEach {
		log(it.toString())
	}.asLiveData()
	
	fun addServer(hostname: String) = launch {
		serverRepository.addServer(hostname)
	}
	
	fun refetchDetails(hostname: String) = launch {
		serverRepository.refetch(hostname)
	}
}
