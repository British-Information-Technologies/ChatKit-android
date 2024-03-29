package io.github.michael_bailey.android_chat_kit.interfaces.view_model

import androidx.lifecycle.LiveData
import io.github.michael_bailey.android_chat_kit.data_type.ServerInfoData

interface IServersViewModel {
	val savedServers: LiveData<List<ServerInfoData>>
	
	
}
