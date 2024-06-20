package com.selfpro.realies.model

class NewsProvider {
    fun getProviderInfo(name: String): String {
        return Provider().findImageByName(name)
    }

    open class Provider {
        open var name = ""
        open var domain = ""
        open var image = ""
        private val instances = mutableListOf<Provider>()

        fun addInstance(instance: Provider) =instances.add(instance)

        fun findImageByName(name: String)=instances.find { it.name == name }?.image ?: Realies.image

        init {
            addInstance(this)
        }
    }

    data object Realies : Provider() {
        override var name: String = "Realies"
        override var domain: String = "realies.com"
        override var image: String = "realies.png"
    }

    data object Donga : Provider() {
        override var name: String = "Donga.com"
        override var domain: String = "donga.com"
        override var image: String = ""
    }

    data object Chosun : Provider() {
        override var name: String = "Chosun.com"
        override var domain: String = ""
        override var image: String = ""
    }

    data object Kormedi : Provider() {
        override var name: String = "Kormedi.com"
        override var domain: String = ""
        override var image: String = ""
    }

    data object Digitaltoday : Provider() {
        override var name: String = "Digitaltoday.co.kr"
        override var domain: String = ""
        override var image: String = ""
    }

    data object YouTube : Provider() {
        override var name: String = "YouTube"
        override var domain: String = "youtube.com"
        override var image: String = ""
    }

    data object Yonhapnewstv : Provider() {
        override var name: String = "Yonhapnewstv.co.kr"
        override var domain: String = ""
        override var image: String = ""
    }

    data object Imbc : Provider() {
        override var name: String = "Imbc.com"
        override var domain: String = ""
        override var image: String = ""
    }

    data object GoogleNews : Provider() {
        override var name: String = "Google News"
        override var domain: String = ""
        override var image: String = ""
    }

    data object Dementianews : Provider() {
        override var name: String = "Dementianews.co.kr"
        override var domain: String = ""
        override var image: String = ""
    }

    data object Hani : Provider() {
        override var name: String = "Hani.co.kr"
        override var domain: String = ""
        override var image: String = ""
    }

    data object Einfomax : Provider() {
        override var name: String = "Einfomax.co.kr"
        override var domain: String = ""
        override var image: String = ""
    }

    data object Munhwa : Provider() {
        override var name: String = "Munhwa.com"
        override var domain: String = ""
        override var image: String = ""
    }

    data object Seoul : Provider() {
        override var name: String = "Seoul.co.kr"
        override var domain: String = ""
        override var image: String = ""
    }

    data object Kbs : Provider() {
        override var name: String = "Kbs.co.kr"
        override var domain: String = ""
        override var image: String = ""
    }

    data object Visla : Provider() {
        override var name: String = "Visla.kr"
        override var domain: String = ""
        override var image: String = ""
    }

    data object Nate : Provider() {
        override var name: String = "Nate.com"
        override var domain: String = ""
        override var image: String = ""
    }

    data object Nintendo : Provider() {
        override var name: String = "Nintendo.co.kr"
        override var domain: String = ""
        override var image: String = ""
    }

    data object Sedaily : Provider() {
        override var name: String = "Sedaily.com"
        override var domain: String = ""
        override var image: String = ""
    }

    data object Hankyung : Provider() {
        override var name: String = "Hankyung.com"
        override var domain: String = ""
        override var image: String = ""
    }


}