package com.selfpro.realies.model

class ProviderModel {
    fun getProviderInfo(providerName: String): String {
        return when (providerName) {
            realies() -> "realies.png"
            donga() -> "donga.png"
            chosun() -> "chosun.png"



            else -> "realies.png"
        }
    }

    fun realies() = "Realies.com"
    fun donga() = "Donga.com"
    fun chosun() = "Chosun.com"
    fun kormedi() = "Kormedi.com"
    fun digitaltoday() = "Digitaltoday.co.kr"
    fun youtube() = "YouTube"

}