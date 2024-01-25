package com.projectkr.shell

import android.Manifest
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.PermissionChecker
import com.drakeet.about.*


class AboutActivity : AbsAboutActivity() {
    override fun onCreateHeader(icon: ImageView, slogan: TextView, version: TextView) {
        icon.setImageResource(R.mipmap.ic_launcher)
        slogan.setText(R.string.app_name)
        version.text = "v" + BuildConfig.VERSION_NAME
    }

    override fun onItemsCreated(items: MutableList<Any>) {
        items.add(Category("About"))
        items.add(Card(getString(R.string.card_content)))
        items.add(Category("示范文件"))
        items.add(Category("示范文件"))
        items.add(Category("wearos 管家"))
        items.add(Category("示范文件"))
        items.add(Category("示范文件"))
        items.add(Category("示范文件"))
        items.add(Category("示范文件"))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        // TransparentUI
        val transparent = menu.findItem(R.id.transparent_ui)
        val themeConfig = ThemeConfig(this)
        transparent.isChecked = themeConfig.getAllowTransparentUI()
        // App Center Status
        val appcenter = menu.findItem(R.id.appcenter_switch)
        val appcenterStatus = AppCenterStatus(this)
        appcenter.isChecked = appcenterStatus.getAppCenterStatus()
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.transparent_ui -> {
                val themeConfig = ThemeConfig(this)
                if (menuItem.isChecked) {
                    themeConfig.setAllowTransparentUI(false)
                    val intent = Intent()
                    intent.setClass(this, MainActivity::class.java).flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                } else {
                    fun checkPermission(permission: String): Boolean = PermissionChecker.checkSelfPermission(this, permission) == PermissionChecker.PERMISSION_GRANTED
                    if (menuItem.isChecked && !checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                        themeConfig.setAllowTransparentUI(false)
                        Toast.makeText(this@AboutActivity, R.string.kr_write_external_storage, Toast.LENGTH_SHORT).show()
                    } else {
                        themeConfig.setAllowTransparentUI(true)
                        val intent = Intent()
                        intent.setClass(this, MainActivity::class.java).flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    }
                }
                return true
            }
            R.id.appcenter_switch -> {
                val appcenterStatus = AppCenterStatus(this)
                if (menuItem.isChecked) {
                    appcenterStatus.setAppCenterStatus(false)
                    invalidateOptionsMenu()
                } else {
                    appcenterStatus.setAppCenterStatus(true)
                    invalidateOptionsMenu()
                }
                return true
            }
            else -> super.onOptionsItemSelected(menuItem)
        }
    }
}
