package io.github.michael_bailey.android_chat_kit.database.entity

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.github.michael_bailey.android_chat_kit.database.embed.ServerInfo
import kotlinx.parcelize.Parcelize
import java.security.PublicKey
import java.time.LocalDateTime
import java.util.UUID

@Entity(
	tableName = "server",
	indices = []
)
@Parcelize
data class EntServer(
	@PrimaryKey var uuid: UUID = UUID.randomUUID(),
	var createdTime: LocalDateTime = LocalDateTime.now(),
	
	var host: String,
	var port: Int,
	
	@Embedded
	var serverInfo: ServerInfo? = null,
	
	var publicKey: PublicKey? = null
): Parcelable
