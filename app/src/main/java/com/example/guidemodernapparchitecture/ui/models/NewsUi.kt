package com.example.guidemodernapparchitecture.ui.models

import android.os.Parcel
import android.os.Parcelable
import com.example.guidemodernapparchitecture.data.models.apiresponsemodels.NewsApiResponse


data class NewsUi(
    var source: NewsSourceUi? = null,
    var author: String? = null,
    var title: String? = null,
    var description: String? = null,
    var url: String? = null,
    var urlToImage: String? = null,
    var publishedAt: String? = null,
    var content: String? = null
): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readParcelable(NewsSourceUi::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    fun getNewsFromNewsApi(newsApiResponse: NewsApiResponse): NewsUi {
        return NewsUi(NewsSourceUi().getNewsSourceFromNewsSourceApi(newsApiResponse.source), newsApiResponse.author, newsApiResponse.title, newsApiResponse.description, newsApiResponse.url,
        newsApiResponse.urlToImage, newsApiResponse.publishedAt, newsApiResponse.content)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(source, flags)
        parcel.writeString(author)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(url)
        parcel.writeString(urlToImage)
        parcel.writeString(publishedAt)
        parcel.writeString(content)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewsUi> {
        override fun createFromParcel(parcel: Parcel): NewsUi {
            return NewsUi(parcel)
        }

        override fun newArray(size: Int): Array<NewsUi?> {
            return arrayOfNulls(size)
        }
    }

}