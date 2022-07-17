package com.example.guidemodernapparchitecture.ui.models

import android.os.Parcel
import android.os.Parcelable
import com.example.guidemodernapparchitecture.data.models.apiresponsemodels.NewsSourceApiResponse

data class NewsSourceUi(
    var id: String? = null,
    var name: String? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewsSourceUi> {
        override fun createFromParcel(parcel: Parcel): NewsSourceUi {
            return NewsSourceUi(parcel)
        }

        override fun newArray(size: Int): Array<NewsSourceUi?> {
            return arrayOfNulls(size)
        }
    }

    fun getNewsSourceFromNewsSourceApi(newsSourceApiResponse: NewsSourceApiResponse?): NewsSourceUi {
        return NewsSourceUi(newsSourceApiResponse?.id, newsSourceApiResponse?.name)
    }

}