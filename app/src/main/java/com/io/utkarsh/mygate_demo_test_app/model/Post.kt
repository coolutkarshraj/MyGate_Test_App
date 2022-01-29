package com.io.utkarsh.mygate_demo_test_app.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
public data class Post(var title :String,
                var body: String):Parcelable
