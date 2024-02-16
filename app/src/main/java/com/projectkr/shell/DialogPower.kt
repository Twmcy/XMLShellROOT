package com.projectkr.shell

import android.app.Activity
import android.view.View
import com.omarea.common.shell.KeepShellPublic
import com.omarea.common.ui.DialogHelper

class DialogPower(var context: Activity) {
    private fun showConfirmationDialog(cmdResId: Int, onConfirmed: () -> Unit) {
        val cmd = context.getString(cmdResId)
        val confirmationMessage = "Are you sure you want to execute: $cmd ?"

        DialogHelper.showConfirmationDialog(
            context,
            "Confirmation",
            confirmationMessage,
            positiveText = "Yes",
            negativeText = "Cancel",
            onPositiveClick = onConfirmed
        )
    }

    fun showPowerMenu() {
        val view = context.layoutInflater.inflate(R.layout.dialog_power_operation, null)
        val dialog = DialogHelper.customDialog(context, view)

        view.findViewById<View>(R.id.power_shutdown).setOnClickListener {
            dialog.dismiss()
            showConfirmationDialog(R.string.power_shutdown_cmd) {
                KeepShellPublic.doCmdSync(context.getString(R.string.power_shutdown_cmd))
            }
        }

        view.findViewById<View>(R.id.power_reboot).setOnClickListener {
            dialog.dismiss()
            showConfirmationDialog(R.string.power_reboot_cmd) {
                KeepShellPublic.doCmdSync(context.getString(R.string.power_reboot_cmd))
            }
        }

        view.findViewById<View>(R.id.power_hot_reboot).setOnClickListener {
            dialog.dismiss()
            showConfirmationDialog(R.string.power_hot_reboot_cmd) {
                KeepShellPublic.doCmdSync(context.getString(R.string.power_hot_reboot_cmd))
            }
        }

        view.findViewById<View>(R.id.power_recovery).setOnClickListener {
            dialog.dismiss()
            showConfirmationDialog(R.string.power_recovery_cmd) {
                KeepShellPublic.doCmdSync(context.getString(R.string.power_recovery_cmd))
            }
        }

        view.findViewById<View>(R.id.power_fastboot).setOnClickListener {
            dialog.dismiss()
            showConfirmationDialog(R.string.power_fastboot_cmd) {
                KeepShellPublic.doCmdSync(context.getString(R.string.power_fastboot_cmd))
            }
        }

        view.findViewById<View>(R.id.power_emergency).setOnClickListener {
            dialog.dismiss()
            showConfirmationDialog(R.string.power_emergency_cmd) {
                KeepShellPublic.doCmdSync(context.getString(R.string.power_emergency_cmd))
            }
        }
    }
}
