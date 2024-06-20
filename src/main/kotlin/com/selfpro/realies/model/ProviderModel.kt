package com.selfpro.realies.model

class ProviderModel {
    fun getProviderInfo(providerName: String): String {
        return when (providerName) {
            realies() -> "realies.png"
            donga() -> "donga.png"
            chosun() -> "chosun.png"
            kormedi() -> ""
            digitaltoday() -> ""
            youtube() -> ""
            yonhapnewstv() -> ""
            imbc() -> ""
            googleNews() -> ""
            dementianews() -> ""
            hani() -> ""
            einfomax() -> ""
            munhwa() -> ""
            seoul() -> ""
            kbs() -> ""
            visla() -> ""
            nate() -> ""
            nintendo() -> ""
            sedaily() -> ""
            hankyung() -> ""

            else -> "realies.png"
        }
    }

    fun realies() = "Realies.com"
    fun donga() = "Donga.com"
    fun chosun() = "Chosun.com"
    fun kormedi() = "Kormedi.com"
    fun digitaltoday() = "Digitaltoday.co.kr"
    fun youtube() = "YouTube"
    fun yonhapnewstv() = "Yonhapnewstv.co.kr"
    fun imbc() = "Imbc.com"
    fun googleNews() = "Google News"
    fun dementianews() = "Dementianews.co.kr"
    fun hani() = "Hani.co.kr"
    fun einfomax() = "Einfomax.co.kr"
    fun munhwa() = "Munhwa.com"
    fun seoul() = "Seoul.co.kr"
    fun kbs() = "Kbs.co.kr"
    fun visla() = "Visla.kr"
    fun nate() = "Nate.com"
    fun nintendo() = "Nintendo.co.kr"
    fun sedaily() = "Sedaily.com"
    fun hankyung() = "Hankyung.com"
}