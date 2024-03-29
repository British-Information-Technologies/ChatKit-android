package io.github.michael_bailey.android_chat_kit.database.edge

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(
	tableName = "chat_thread_to_message"
)
data class EdgeChatThreadToMessage(
	@PrimaryKey val uuid: UUID = UUID.randomUUID(),
	val chatThread: UUID,
	val message: UUID,
)
