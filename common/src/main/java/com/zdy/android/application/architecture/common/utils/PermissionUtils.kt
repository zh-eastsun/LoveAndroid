package com.zdy.android.application.architecture.common.utils

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

private const val NO_REQUEST_PERMISSION_CODE = 0x10000000
private const val REQUEST_CODE_WRITE_EXTERNAL_STORAGE = 0x10000001

val REQUEST_CODE_MAP = mapOf(
    Manifest.permission.WRITE_EXTERNAL_STORAGE to REQUEST_CODE_WRITE_EXTERNAL_STORAGE
)

fun requestPermissions(
    activity: Activity,
    permissions: Array<String>
) {
    for (permission in permissions) {
        if (ActivityCompat.checkSelfPermission(
                activity,
                permission
            ) != PackageManager.PERMISSION_GRANTED
        )
            ActivityCompat.requestPermissions(
                activity,
                arrayOf(permission),
                REQUEST_CODE_MAP[permission] ?: NO_REQUEST_PERMISSION_CODE
            )
    }
}

fun requestPermission(
    activity: Activity,
    permission: String
) {
    if (ActivityCompat.checkSelfPermission(
            activity,
            permission
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        ActivityCompat.requestPermissions(
            activity,
            arrayOf(permission),
            REQUEST_CODE_MAP[permission] ?: NO_REQUEST_PERMISSION_CODE
        )
    }
}