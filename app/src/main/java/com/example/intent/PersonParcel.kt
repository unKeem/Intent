package com.example.intent

import android.os.Parcel
import android.os.Parcelable

class PersonParcel(val id: String, val pw: String): Parcelable {

    //parcel내용을 읽기 위해 정의(소포 열기)
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
        //뜯어서 볼 내용
    }

    //parcel 쓰기위한 정의(소포에 담기)
    override fun writeToParcel(parcle: Parcel, flags: Int) {
        parcle.writeString(id)
        parcle.writeString(pw)
    }
    //파일 file_descriptor,  그 이외의 것은 0
    override fun describeContents(): Int {
       return 0
    }
    //CREATE parselable
    companion object CREATOR : Parcelable.Creator<PersonParcel> {
        override fun createFromParcel(parcel: Parcel): PersonParcel {
            return PersonParcel(parcel)
        }

        override fun newArray(size: Int): Array<PersonParcel?> {
            return arrayOfNulls(size)
        }
    }
}