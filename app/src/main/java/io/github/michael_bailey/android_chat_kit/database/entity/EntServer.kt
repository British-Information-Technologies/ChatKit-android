package io.github.michael_bailey.android_chat_kit.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.security.PublicKey
import java.time.LocalDateTime
import java.util.UUID

@Entity(
	tableName = "server",
	indices = []
)
data class EntServer(
	@PrimaryKey var uuid: UUID = UUID.randomUUID(),
	var createdTime: LocalDateTime = LocalDateTime.now(),
	
	var host: String,
	var port: Int,
	
	var name: String,
	var alias: String,
	var owner: String,
	
	var publicKey: PublicKey?
)