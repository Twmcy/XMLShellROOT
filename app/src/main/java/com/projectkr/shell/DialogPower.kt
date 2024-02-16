package com.projectkr.shell

import android.app.Activity
import android.content.DialogInterface
import android.view.View
import com.omarea.common.shell.KeepShellPublic
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DialogPower(var context: Activity) {
    private fun showConfirmationDialog(cmdResId: Int, onConfirmed: () -> Unit) {
        val cmd = context.getString(cmdResId)
        val confirmationMessage = "Are you sure you want to execute: $cmd ?"

        MaterialAlertDialogBuilder(context)
            .setTitle("Confirmation")
            .setMessage(confirmationMessage)
            .setPositiveButton("Yes") { _: DialogInterface, _: Int ->
                onConfirmed()
            }
            .setNegativeButton("Cancel") { dialog: DialogInterface, _: Int ->
                dialog.dismiss()
            }
            .show()
    }

    fun showPowerMenu() {
        val view = context.layoutInflater.inflate(R.layout.dialog_power_operation, null)

        MaterialAlertDialogBuilder(context)
            .setView(view)
            .show()
            .apply {
                view.findViewById<View>(R.id.power_shutdown).setOnClickListener {
                    dismiss()
                    showConfirmationDialog(R.string.power_shutdown_cmd) {
                        KeepShellPublic.doCmdSync(context.getString(R.string.power_shutdown_cmd))
                    }
                }

                view.findViewById<View>(R.id.power_reboot).setOnClickListener {
                    dismiss()
                    showConfirmationDialog(R.string.power_reboot_cmd) {
                        KeepShellPublic.doCmdSync(context.getString(R.string.power_reboot_cmd))
                    }
                }

                view.findViewById<View>(R.id.power_hot_reboot).setOnClickListener {
                    dismiss()
                    showConfirmationDialog(R.string.power_hot_reboot_cmd) {
                        KeepShellPublic.doCmdSync(context.getString(R.string.power_hot_reboot_cmd))
                    }
                }

                view.findViewById<View>(R.id.power_recovery).setOnClickListener {
                    dismiss()
                    showConfirmationDialog(R.string.power_recovery_cmd) {
                        KeepShellPublic.doCmdSync(context.getString(R.string.power_recovery_cmd))
                    }
                }

                view.findViewById<View>(R.id.power_fastboot).setOnClickListener {
                    dismiss()
                    showConfirmationDialog(R.string.power_fastboot_cmd) {
                        KeepShellPublic.doCmdSync(context.getString(R.string.power_fastboot_cmd))
                    }
                }

                view.findViewById<View>(R.id.power_emergency).setOnClickListener {
                    dismiss()
                    showConfirmationDialog(R.string.power_emergency_cmd) {
                        KeepShellPublic.doCmdSync(context.getString(R.string.power_emergency_cmd))
                    }
                }
            }
    }
}
