# HyoGeunPermission BetaTest For External Storage

## For The SDK 29
In Google I/O Google Said Permission Changed At Android Q
so I want Use Permssion Easy

## How To Use

CheckPermissions:
```
HyoGeunCheckPermissions(REQUEST_CODE_STORE) {
                storeTestFile()
}
```


Request Permission:
```
when (requestCode) {
            REQUEST_CODE_STORE -> {
                if (VerifyHyogeunPermission(grantResults)) {
                    storeTestFile()

                } else {
                    Toast.makeText(this, "permissions not granted", Toast.LENGTH_SHORT).show()
                }
            }

            else -> super.onHyogeunRequestPermissionsResult(requestCode, permissions, grantResults)
}
   ```

CheckRequestPermission:
 ```
 val RequestHyoGeunPermission = {
        ActivityCompat.requestPermissions(this, HyoGeunPermission, HyoGeunrequestCode)
    }

    if (HyoGeunPermission.any { ActivityCompat.shouldShowRequestPermissionRationale(this, it) }) {


    } else {
        RequestHyoGeunPermission.invoke()
    }
 ```

VerifyPermission:
 ```
fun VerifyHyogeunPermission(grantResults: IntArray) =
    grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }
 ```


  Thx For Senpai Akat32
