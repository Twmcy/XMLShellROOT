package com.projectkr.shell

import android.app.Activity
import android.app.AlertDialog
import android.view.View
import com.omarea.common.shell.KeepShellPublic
import com.omarea.common.ui.DialogHelper

class DialogPower(var context: Activity) {
    fun showPowerMenu() {
        val view = context.layoutInflater.inflate(R.layout.dialog_power_operation, null)
        
        val builder = AlertDialog.Builder(context)
        builder.setView(view)
        val dialog = builder.create()

        view.findViewById<View>(R.id.power_shutdown).setOnClickListener {
            dialog.dismiss()
            showConfirmationDialog(context.getString(R.string.power_shutdown_cmd))
        }
        view.findViewById<View>(R.id.power_reboot).setOnClickListener {
            dialog.dismiss()
            showConfirmationDialog(context.getString(R.string.power_reboot_cmd))
        }
        view.findViewById<View>(R.id.power_hot_reboot).setOnClickListener {
            dialog.dismiss()
            showConfirmationDialog(context.getString(R.string.power_hot_reboot_cmd))
        }
        view.findViewById<View>(R.id.power_recovery).setOnClickListener {
            dialog.dismiss()
            showConfirmationDialog(context.getString(R.string.power_recovery_cmd))
        }
        view.findViewById<View>(R.id.power_fastboot).setOnClickListener {
            dialog.dismiss()
            showConfirmationDialog(context.getString(R.string.power_fastboot_cmd))
        }
        view.findViewById<View>(R.id.power_emergency).setOnClickListener {
            dialog.dismiss()
            showConfirmationDialog(context.getString(R.string.power_emergency_cmd))
        }
    }

    private fun showConfirmationDialog(cmd: String) {
        AlertDialog.Builder(context)
            .setTitle("确认操作")
            .setMessage("确定要执行该操作吗？")
            .setPositiveButton("是") { _, _ ->
                KeepShellPublic.doCmdSync(cmd)
            }
            .setNegativeButton("否") { _, _ -> }
            .show()
    }
}