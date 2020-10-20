package com.example.memoriesproject.base

import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class BaseActivity:AppCompatActivity() {

public fun requestPermission(activity: AppCompatActivity,context: Context,permissionString:String,permissionsArray:Array<String>
                             ,permissionCode:Int,dialogTitle:String,dialogMessage:String,posButton:String,negButton:String
                             ,posClick:DialogInterface.OnClickListener,negClick:DialogInterface.OnClickListener):Boolean{
    var condition:Boolean =false
        if(ContextCompat.checkSelfPermission(context,permissionString)== PackageManager.PERMISSION_GRANTED){
            condition = true
            Toast.makeText(context,"Permissions already granted",Toast.LENGTH_SHORT).show()
        }else{
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,permissionString)){

                val alertDialog = AlertDialog.Builder(context)
                alertDialog.setTitle(dialogTitle).setMessage(dialogMessage)
                    .setPositiveButton(posButton,DialogInterface.OnClickListener { dialogInterface: DialogInterface, i: Int ->
                        ActivityCompat.requestPermissions(activity,permissionsArray,permissionCode)
                    }).setNegativeButton(negButton,DialogInterface.OnClickListener { dialog, which ->
                        condition = false
                        Toast.makeText(context,"Permissions denied",Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }).create().show()

            }else{
                ActivityCompat.requestPermissions(activity,permissionsArray,permissionCode)
            }
        }
    return condition
}


}