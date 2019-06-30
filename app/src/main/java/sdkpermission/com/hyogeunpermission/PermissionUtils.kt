package sdkpermission.com.hyogeunpermission


import android.Manifest
import android.app.Activity
import android.app.DownloadManager
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


inline fun Activity.HyoGeunCheckPermissions(requestCode: Int, onChecked: () -> Unit) {
    if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        != PackageManager.PERMISSION_GRANTED
    ) {
        HyoGeunPermissionsWithError(
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            requestCode
        )

        return
    }

    onChecked()
}

fun Activity.HyoGeunPermissionsWithError(
    HyoGeunPermission: Array<String>,
    HyoGeunrequestCode: Int
) {
    val RequestHyoGeunPermission = {
        ActivityCompat.requestPermissions(this, HyoGeunPermission, HyoGeunrequestCode)
    }

    if (HyoGeunPermission.any { ActivityCompat.shouldShowRequestPermissionRationale(this, it) }) {


    } else {
        RequestHyoGeunPermission.invoke()
    }
}

fun VerifyHyogeunPermission(grantResults: IntArray) =
    grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }