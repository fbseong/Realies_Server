package com.selfpro.realies.entity

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "authorities")  // MongoDB의 컬렉션 지정
data class Authority(
    var id: String? = null,
    var authorityName: String
)